package org.example.webbprojektspringboot26.books;

import org.example.webbprojektspringboot26.dtos.BookViewDTO;
import org.example.webbprojektspringboot26.dtos.CreateBookDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BookController.class)
class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private BookService bookService;

    @Test
    void whenLookingForBookList_ThenShouldReturnAllBooks() throws Exception {
        BookViewDTO dto = new BookViewDTO();
        dto.setTitle("Test");
        dto.setAuthor("Author");
        dto.setDescription("description");
        dto.setPublishDate(LocalDate.of(2020,1,1));


        when(bookService.getAllBooks()).thenReturn(List.of(dto));

        mockMvc.perform(get("/books"))
                .andExpect(status().isOk())
                .andExpect(view().name("books/list"))
                .andExpect(model().attributeExists("books"))
                .andExpect(model().attribute("books", List.of(dto)));

    }
    @Test
    void whenGoingToCreateForm_ThenShouldReturnForm() throws Exception {

        mockMvc.perform(get("/books/create"))
                .andExpect(status().isOk())
                .andExpect(view().name("books/create"))
                .andExpect(model().attributeExists("today"))
                .andExpect(model().attributeExists("book"))
                .andExpect(model().attribute("book", new CreateBookDTO()));

    }
    @Test
    void postMapping_shouldCreateBookAndRedirect() throws Exception {

        mockMvc.perform(post("/books")
                        .param("title", "Test")
                        .param("author", "Author")
                        .param("description", "A book")
                        .param("publishDate", "2020-01-01")
                )
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/books"));

        // Verifiera att servicen anropades
        verify(bookService).createBook(any(CreateBookDTO.class));
    }
    @Test
    void shouldReturnToFormWhenValidationFails() throws Exception {

        mockMvc.perform(post("/books")
                        .param("title", "") // ogiltigt
                        .param("author", "Author")
                        .param("description", "A book")
                        .param("publishDate", "2020-01-01")
                )
                .andExpect(status().isOk())
                .andExpect(view().name("books/create"))
                .andExpect(model().attributeExists("today"))
                .andExpect(model().attributeExists("errors"))
                .andExpect(model().attributeExists("book"));

        // Service ska INTE anropas
        verify(bookService, never()).createBook(any());
    }
    @Test
    void shouldReturnValidationErrorWhenIsbnIsDuplicate() throws Exception {

        // Arrange: mocka så att servicen kastar dubblett-fel
        doThrow(new DuplicateIsbnException("ISBN finns redan"))
                .when(bookService).createBook(any(CreateBookDTO.class));

        // Act + Assert
        mockMvc.perform(post("/books")
                        .param("title", "Testbok")
                        .param("author", "Författare")
                        .param("description", "Beskrivning")
                        .param("publishDate", "2020-01-01")
                        .param("isbn", "1234567890123")
                )
                .andExpect(status().isOk())
                .andExpect(view().name("books/create"))
                .andExpect(model().attributeExists("today"))
                .andExpect(model().attributeExists("errors"))
                .andExpect(model().attributeExists("book"))
                .andExpect(model().attributeHasFieldErrors("book", "isbn"));

        // Service ska ha anropats, men kastat exception
        verify(bookService).createBook(any(CreateBookDTO.class));
    }


}

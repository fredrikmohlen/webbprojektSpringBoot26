package org.example.webbprojektspringboot26.books;

import jakarta.persistence.EntityNotFoundException;
import org.example.webbprojektspringboot26.dtos.BookViewDTO;
import org.example.webbprojektspringboot26.dtos.CreateBookDTO;
import org.example.webbprojektspringboot26.dtos.UpdateBookDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataIntegrityViolationException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @Test
    void createBook() {
        //Arrange
        CreateBookDTO dto = new CreateBookDTO();
        dto.setTitle("New Title");
        dto.setAuthor("New Author");
        dto.setDescription("Test Description");
        dto.setPublishDate(LocalDate.of(2000, 1, 1));
        dto.setIsbn("1234567890123");

        Book savedBook = new Book();
        savedBook.setTitle("New Title");
        savedBook.setAuthor("New Author");
        savedBook.setDescription("Test Description");
        savedBook.setPublishDate(LocalDate.of(2000, 1, 1));
        savedBook.setIsbn("1234567890123");

        when(bookRepository.save(any(Book.class))).thenReturn(savedBook);
        //Act
        BookViewDTO result = bookService.createBook(dto);
        //Assert
        assertEquals(dto.getTitle(), result.getTitle());
        assertEquals(dto.getAuthor(), result.getAuthor());
        assertEquals(dto.getDescription(), result.getDescription());
    }

    @Test
    void getBookById_ShouldReturnBookViewDTO_WhenBookExists() {
        //Arrange
        Book book = new Book();
        book.setId(1L);
        book.setTitle("Test Title");
        book.setAuthor("Test Author");
        book.setDescription("Test Description");
        book.setPublishDate(LocalDate.of(2000, 1, 1));
        book.setIsbn("1234567890123");

        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));
        //Act
        BookViewDTO bookViewDTO = bookService.getBookById(1L);
        //Assert
        assertEquals("Test Title", bookViewDTO.getTitle());
        assertEquals("Test Author", bookViewDTO.getAuthor());
    }

    @Test
    void getBookById_throwsException_WhenBookNotFound() {
        when(bookRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> bookService.getBookById(1L));
    }
    @Test
    void getAllBooks() {
        //Arrange
        Book book1 = new Book();
        book1.setId(1L);
        book1.setTitle("Book 1");
        book1.setAuthor("Author 1");

        Book book2 = new Book();
        book2.setId(2L);
        book2.setTitle("Book 2");
        book2.setAuthor("Author 2");

        when(bookRepository.findAll()).thenReturn(List.of(book1, book2));
        //Act
        List<BookViewDTO> result = bookService.getAllBooks();
        //Assert
        assertEquals(2, result.size());
        assertEquals("Book 1", result.get(0).getTitle());
        assertEquals("Book 2",result.get(1).getTitle());
    }

    @Test
    void updateBook_updatesAndReturnsDTO() {
        // Arrange
        Book existing = new Book();
        existing.setId(1L);
        existing.setTitle("Old Title");

        UpdateBookDTO dto = new UpdateBookDTO();
        dto.setTitle("New Title");

        when(bookRepository.findById(1L)).thenReturn(Optional.of(existing));
        when(bookRepository.save(existing)).thenReturn(existing);

        // Act
        BookViewDTO result = bookService.updateBook(1L, dto);

        // Assert
        assertEquals("New Title", result.getTitle());
    }

    @Test
    void deleteBook_deletesExistingBook() {
        Book book = new Book();
        book.setId(1L);

        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));

        bookService.deleteBook(1L);

        verify(bookRepository).delete(book);
    }
    @Test
    void shouldThrowDuplicateIsbnExceptionWhenRepositoryThrowsConstraintError() {
        // Arrange
        when(bookRepository.save(any()))
                .thenThrow(new DataIntegrityViolationException("duplicate"));

        CreateBookDTO dto = new CreateBookDTO();
        dto.setIsbn("1234567890123");

        // Act + Assert
        assertThrows(DuplicateIsbnException.class, () -> bookService.createBook(dto));

        verify(bookRepository).save(any());
    }

}

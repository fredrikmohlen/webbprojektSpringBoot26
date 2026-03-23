package org.example.webbprojektspringboot26.books;

import org.example.webbprojektspringboot26.dtos.BookViewDTO;
import org.example.webbprojektspringboot26.dtos.CreateBookDTO;
import org.example.webbprojektspringboot26.dtos.UpdateBookDTO;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BookMapperTest {

    @Test
    void toEntity_ShouldMapCreateBookDTO_ToBook() {
        // Arrange
        CreateBookDTO dto = new CreateBookDTO();
        dto.setTitle("Test Title");
        dto.setAuthor("Test Author");
        dto.setDescription("Test Description");
        dto.setPublishDate(LocalDate.of(2000, 1, 1));
        dto.setIsbn("1234567890123");

        // Act
        Book book = BookMapper.toEntity(dto);

        // Assert
        assertEquals("Test Title", book.getTitle());
        assertEquals("Test Author", book.getAuthor());
        assertEquals("Test Description", book.getDescription());
        assertEquals(LocalDate.of(2000, 1, 1), book.getPublishDate());
        assertEquals("1234567890123", book.getIsbn());
    }

    @Test
    void toViewDTO_ShouldMapBook_ToBookViewDTO() {
        // Arrange
        Book book = new Book();
        book.setId(1L);
        book.setTitle("Mapped Title");
        book.setAuthor("Mapped Author");
        book.setDescription("Mapped Description");
        book.setPublishDate(LocalDate.of(1999, 12, 31));
        book.setIsbn("9876543210987");

        // Act
        BookViewDTO dto = BookMapper.toViewDTO(book);

        // Assert
        assertEquals(1L, dto.getId());
        assertEquals("Mapped Title", dto.getTitle());
        assertEquals("Mapped Author", dto.getAuthor());
        assertEquals("Mapped Description", dto.getDescription());
        assertEquals(LocalDate.of(1999, 12, 31), dto.getPublishDate());
    }

    @Test
    void updateEntity_ShouldUpdateBookFields() {
        // Arrange
        Book book = new Book();
        book.setId(1L);
        book.setTitle("Old Title");
        book.setAuthor("Old Author");
        book.setDescription("Old Desc");
        book.setPublishDate(LocalDate.of(1990, 1, 1));
        book.setIsbn("1234567890123");


        UpdateBookDTO dto = new UpdateBookDTO();
        dto.setTitle("New Title");
        dto.setAuthor("New Author");
        dto.setDescription("New Desc");
        dto.setPublishDate(LocalDate.of(2020, 5, 20));


        // Act
        BookMapper.updateEntity(book, dto);

        // Assert
        assertEquals("New Title", book.getTitle());
        assertEquals("New Author", book.getAuthor());
        assertEquals("New Desc", book.getDescription());
        assertEquals(LocalDate.of(2020, 5, 20), book.getPublishDate());
        assertEquals(1L, book.getId());
        assertEquals("1234567890123", book.getIsbn());
    }
}

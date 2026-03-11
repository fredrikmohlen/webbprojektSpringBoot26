package org.example.webbprojektspringboot26.books;

import org.example.webbprojektspringboot26.dtos.BookViewDTO;
import org.example.webbprojektspringboot26.dtos.CreateBookDTO;
import org.example.webbprojektspringboot26.dtos.UpdateBookDTO;

public class BookMapper {

    private BookMapper() {}

    public static Book toEntity(CreateBookDTO dto) {
        Book book = new Book();
        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setDescription(dto.getDescription());
        book.setPublishDate(dto.getPublishDate());
        book.setIsbn(dto.getIsbn());
        return book;
    }

    public static BookViewDTO toViewDTO(Book book) {
        BookViewDTO dto = new BookViewDTO();
        dto.setId(book.getId());
        dto.setTitle(book.getTitle());
        dto.setAuthor(book.getAuthor());
        dto.setDescription(book.getDescription());
        dto.setPublishDate(book.getPublishDate());
        return dto;
    }

    public static void updateEntity(Book book, UpdateBookDTO dto) {
        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setDescription(dto.getDescription());
        book.setPublishDate(dto.getPublishDate());
    }
}

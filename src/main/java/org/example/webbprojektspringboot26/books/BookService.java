package org.example.webbprojektspringboot26.books;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookViewDTO createBook(CreateBookDTO createBookDTO) {
        Book book = BookMapper.toEntity(createBookDTO);
        Book savedBook = bookRepository.save(book);
        return BookMapper.toViewDTO(savedBook);
    }

    public BookViewDTO getBookById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return BookMapper.toViewDTO(book);
    }
}

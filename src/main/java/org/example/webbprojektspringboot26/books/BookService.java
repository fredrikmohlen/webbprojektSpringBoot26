package org.example.webbprojektspringboot26.books;

import jakarta.persistence.EntityNotFoundException;
import org.example.webbprojektspringboot26.dtos.BookViewDTO;
import org.example.webbprojektspringboot26.dtos.CreateBookDTO;
import org.example.webbprojektspringboot26.dtos.UpdateBookDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    //Todo: add @Transactional, where it is needed
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

    public List<BookViewDTO> getAllBooks() {

        List<Book> books = bookRepository.findAll();
        final List<BookViewDTO> bookViewDTOs = new ArrayList<>();

        for (Book book : books) {
            bookViewDTOs.add(BookMapper.toViewDTO(book));
        }
        return bookViewDTOs;
    }

    public BookViewDTO updateBook(Long id, UpdateBookDTO updateBookDTO) {
        Book bookToUpdate = bookRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        BookMapper.updateEntity(bookToUpdate, updateBookDTO);
        return BookMapper.toViewDTO(bookRepository.save(bookToUpdate));
    }

    public void deleteBook(Long id) {
        Book bookToDelete = bookRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        bookRepository.delete(bookToDelete);
    }
}

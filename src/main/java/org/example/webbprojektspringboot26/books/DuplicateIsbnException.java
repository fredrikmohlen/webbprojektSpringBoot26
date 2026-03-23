package org.example.webbprojektspringboot26.books;

public class DuplicateIsbnException extends RuntimeException {
    public DuplicateIsbnException(String message) {
        super(message);
    }
}

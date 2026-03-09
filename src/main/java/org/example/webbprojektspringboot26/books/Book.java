package org.example.webbprojektspringboot26.books;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title cannot be empty")
    private String title;

    @NotBlank(message = "Author cannot be empty")
    private String author;

    @Size(max = 500, message = "Description cannot exceed 500 characters")
    private String description;

    @Past(message = "Publish date must be in the past")
    private LocalDate publishDate;

    @Column(unique = true)
    @Pattern(regexp = "\\d{13}", message = "ISBN must be a 13-digit number")
    private String isbn;

    public Book() {
    }

    public Book(String title, String author, String description, LocalDate publishDate, String isbn) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.publishDate = publishDate;
        this.isbn = isbn;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}

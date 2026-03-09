package org.example.webbprojektspringboot26.books;

import jakarta.validation.constraints.*;


import java.time.LocalDate;

public class CreateBookDTO {

    @NotBlank
    private String title;

    @NotBlank
    private String author;

    @Size(max = 500)
    private String description;

    @Past
    private LocalDate publishDate;

    @Pattern(regexp = "\\d{13}")
    private String isbn;

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

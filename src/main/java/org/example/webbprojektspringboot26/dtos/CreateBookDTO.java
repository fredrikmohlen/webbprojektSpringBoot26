package org.example.webbprojektspringboot26.dtos;

import jakarta.validation.constraints.*;


import java.time.LocalDate;
import java.util.Objects;

public class CreateBookDTO {

    @NotBlank(message = "Du måste ange en titel")
    private String title;

    @NotBlank (message = "Du måste ange en författare")
    private String author;

    @Size(max = 300, message = "Beskrivningen får max vara 300 tecken")
    private String description;

    @Past (message = "Datumet måste vara i dåtid")
    private LocalDate publishDate;

    @Pattern(regexp = "\\d{13}", message = "Måste ange 13 siffror")
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

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof CreateBookDTO that)) return false;
        return Objects.equals(title, that.title) && Objects.equals(author, that.author) && Objects.equals(description, that.description) && Objects.equals(publishDate, that.publishDate) && Objects.equals(isbn, that.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, description, publishDate, isbn);
    }
}

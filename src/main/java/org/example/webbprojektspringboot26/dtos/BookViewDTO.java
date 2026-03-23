package org.example.webbprojektspringboot26.dtos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BookViewDTO {

    private Long id;
    private String title;
    private String author;
    private String description;
    private LocalDate publishDate;

    public BookViewDTO() {} // used for testing

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    public String getPublishDateFormatted() {
        return publishDate != null
                ? publishDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
                : "";
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

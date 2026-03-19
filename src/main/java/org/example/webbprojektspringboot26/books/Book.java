package org.example.webbprojektspringboot26.books;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.proxy.HibernateProxy;

import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "Title cannot be empty")
    private String title;

    @Column(nullable = false)
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

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Book book = (Book) o;
        return getId() != null && Objects.equals(getId(), book.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "title = " + title + ", " +
                "author = " + author + ", " +
                "description = " + description + ", " +
                "publishDate = " + publishDate + ", " +
                "isbn = " + isbn + ")";
    }
}

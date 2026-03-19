package org.example.webbprojektspringboot26.data;

import org.example.webbprojektspringboot26.books.Book;
import org.example.webbprojektspringboot26.books.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataInitializer implements CommandLineRunner {

    private final BookRepository bookRepository;

    public DataInitializer(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (bookRepository.count() == 0) {

            bookRepository.save(new Book(
                    "Jack Reacher: Killing Floor",
                    "Lee Child",
                   "Jack Reacher arrives in Margrave, Georgia, and is arrested for murder.",
                    LocalDate.of(1997, 3, 17),
                    "9780515153651"
            ));

            bookRepository.save(new Book(
                    "Jack Reacher: Die Trying",
                    "Lee Child",
                    "Reacher is kidnapped alongside an FBI agent and must uncover a militia plot.",
                    LocalDate.of(1998, 7, 1),
                    "9780515153668"
            ));

            bookRepository.save(new Book(
                    "Jack Reacher: Tripwire",
                    "Lee Child",
                    "Reacher investigates a missing Vietnam veteran and uncovers a dangerous conspiracy.",
                    LocalDate.of(1999, 6, 28),
                    "9780515153675"
            ));

            bookRepository.save(new Book(
                    "Jack Reacher: Running Blind",
                    "Lee Child",
                    "Reacher is drawn into an FBI investigation involving murdered women.",
                    LocalDate.of(2000, 4, 10),
                    "9780515153682"
            ));

            bookRepository.save(new Book(
                    "Jack Reacher: Echo Burning",
                    "Lee Child",
                    "Reacher helps a woman trapped in an abusive marriage in rural Texas.",
                    LocalDate.of(2001, 6, 25),
                    "9780515153699"
            ));
        }
    }
}

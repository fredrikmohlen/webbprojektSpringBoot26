package org.example.webbprojektspringboot26.books;

import jakarta.validation.Valid;
import org.example.webbprojektspringboot26.dtos.CreateBookDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;

@Controller
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public String listBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "books/list";
    }

    @GetMapping("/books/create")
    public String createBookForm(Model model){
        String today = LocalDate.now().minusDays(1).toString();
        model.addAttribute("today", today);
        model.addAttribute("book", new CreateBookDTO());
        return "books/create";
    }

    @PostMapping("/books")
    public String createBook(
            @Valid @ModelAttribute("book") CreateBookDTO book,
            BindingResult bindingResult, Model model
    ){
        if(bindingResult.hasErrors()){
            model.addAttribute("today", LocalDate.now().minusDays(1).toString());
            model.addAttribute("errors", bindingResult);
            return "books/create";
        }
        try {
            bookService.createBook(book);
        } catch (DuplicateIsbnException e) {
            bindingResult.rejectValue("isbn", "duplicate", "ISBN finns redan");
            model.addAttribute("errors", bindingResult);
            return "books/create";
        }

        return "redirect:/books";
    }
}

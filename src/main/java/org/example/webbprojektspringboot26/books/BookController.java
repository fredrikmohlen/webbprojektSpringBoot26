package org.example.webbprojektspringboot26.books;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {

    @GetMapping("/books")
    public String listBooks(){
        return "books/list";
    }

    @GetMapping("/books/create")
    public String createBookForm(){
        return "books/create";
    }
}

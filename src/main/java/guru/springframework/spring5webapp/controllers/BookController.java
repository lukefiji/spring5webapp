package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// Indicates that it is a Spring bean
@Controller
public class BookController {

    private BookRepository bookRepository;

    // Becomes auto-wired by Spring; will automatically get an instance
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // When a '/books' request comes in
    @RequestMapping("/books")
    public String getBooks(Model model){

        // Tell Spring Data JPA to go out and get a list of books from db
        // Spring MVC will associate list and pass on into view
        model.addAttribute("books", bookRepository.findAll());

        // Associate with a Thymeleaf view
        return "books";
    }
}

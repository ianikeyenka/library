package com.library.controller;

import com.library.dto.BookDTO;
import com.library.dto.BookUsersDTO;
import com.library.service.BookService;
import com.library.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/library/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private UserService userService;

    @GetMapping()
    public String getAllBooks(Model model) {
        model.addAttribute("books", bookService.getBooks());
        return "book/index";
    }

    @GetMapping("/add-book")
    public String addNewBook(Model model) {
        model.addAttribute("book", new BookDTO());
        return "book/new";
    }

    @PostMapping("/save-book")
    public String saveBook(@ModelAttribute("book") @Valid BookDTO bookDTO,
                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "book/new";
        }
        bookService.saveBook(bookDTO);
        return "redirect:/library/books";
    }

    @GetMapping("/{id}")
    public String getBook(@PathVariable Long id, Model model) {
        model.addAttribute("book", new BookUsersDTO(bookService.getBookById(id),
                userService.getUsersBorrowedBook(id)));
        return "book/show";
    }

    @GetMapping("/{id}/edit")
    public String editBook(@PathVariable Long id, Model model) {
        model.addAttribute("book", bookService.getBookById(id));
        return "book/edit";
    }

    @RequestMapping("/{id}")
    public String updateBook(@ModelAttribute("book") @Valid BookDTO bookDTO,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "book/edit";
        }
        bookService.saveBook(bookDTO);
        return "redirect:/library/books";
    }
}

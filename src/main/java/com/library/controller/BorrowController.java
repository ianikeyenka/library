package com.library.controller;

import com.library.dto.BorrowDTO;
import com.library.service.BookService;
import com.library.service.BorrowService;
import com.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/library/history")
public class BorrowController {
    @Autowired
    private BorrowService borrowService;

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;


    @GetMapping()
    private String getHistory(Model model) {
        model.addAttribute("allBorrow", borrowService.getAllHistory());
        return "borrow/index";
    }

    @GetMapping("/add-borrow")
    public String addNewBook(Model model) {
        model.addAttribute("users", userService.getUsers());
        model.addAttribute("books", bookService.getBooks());
        return "borrow/new";
    }

    @PostMapping("/save-borrow")
    public String saveBorrow(@RequestParam("userId") Long userId,
                             @RequestParam("bookId") Long bookId) {
        BorrowDTO borrowDTO = new BorrowDTO();
        borrowDTO.setUser(userService.getUserById(userId));
        borrowDTO.setBook(bookService.getBookById(bookId));
        borrowService.saveBorrow(borrowDTO);
        return "redirect:/library/history";
    }

    @GetMapping("/{id}/edit")
    public String editBook(@PathVariable Long id, Model model) {
        model.addAttribute("borrow", borrowService.getBorrowById(id));
        return "borrow/edit";
    }

    @RequestMapping("/{id}")
    public String updateBook(@PathVariable Long id,
                             @ModelAttribute("returned") boolean returnedValue) {
        BorrowDTO borrowDTO = borrowService.getBorrowById(id);
        borrowDTO.setReturned(returnedValue);
        borrowService.saveBorrow(borrowDTO);
        return "redirect:/library/history";
    }
}

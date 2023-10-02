package com.library.controller;

import com.library.entities.Book;
import com.library.entities.Borrow;
import com.library.entities.User;
import com.library.services.BookService;
import com.library.services.BorrowService;
import com.library.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LibraryController {

    @Autowired
    private BookService bookService;

    @Autowired
    private UserService userService;

    @Autowired
    private BorrowService borrowService;

    @GetMapping("/users")
    public List<User> showAllUsers() {
        return userService.getUsers();
    }

    @GetMapping("/books")
    public List<Book> showAllBooks() {
        return bookService.getBooks();
    }

    @GetMapping("/history")
    private List<Borrow> showAllHistory() {
        return borrowService.getAllHistory();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable int id) {
        return userService.getUser(id);
    }

    @GetMapping("/books/{id}")
    public Book showBook(@PathVariable int id) {
        return bookService.getBook(id);
    }

    @GetMapping("/history/{id}")
    public Borrow showBorrow(@PathVariable int id) {
        return borrowService.getHistorySlice(id);
    }

    @PostMapping("/books/add")
    public Book addBook(@RequestBody Book book) {
        bookService.saveBook(book);
        return book;
    }

    @PostMapping("/users/add")
    public User addUser(@RequestBody User user) {
        userService.saveUser(user);
        return user;
    }

    @PostMapping("/history/add")
    public Borrow addBorrow(@RequestBody Borrow borrow) {
        borrowService.saveHistory(borrow);
        return null;
    }
}

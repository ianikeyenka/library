package com.library.controller;

import com.library.dto.BookDTO;
import com.library.dto.BookUsersDTO;
import com.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library/books")
@CrossOrigin
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("")
    public List<BookDTO> getAllBooks() {
        return bookService.getBooks();
    }

    @GetMapping("/{id}")
    public BookUsersDTO getBook(@PathVariable Long id) {
        return new BookUsersDTO(bookService.getBookById(id), bookService.getBookBorrowedUsers(id));
    }

    @PutMapping("/{id}")
    public BookDTO updateBook(@PathVariable Long id, @RequestBody BookDTO bookDTO) {
        bookDTO.setId(id);
        bookService.saveBook(bookDTO);
        return bookDTO;
    }

    @PostMapping()
    public BookDTO addBook(@RequestBody BookDTO bookDTO) {
        bookService.saveBook(bookDTO);
        return bookDTO;
    }
}

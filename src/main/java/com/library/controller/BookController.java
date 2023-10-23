package com.library.controller;

import com.library.dto.BookDTO;
import com.library.dto.BookUsersDTO;
import com.library.service.BookService;
import com.library.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private UserService userService;

    @GetMapping("/books")
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        return new ResponseEntity<>(bookService.getBooks(), HttpStatus.OK);
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<BookUsersDTO> getBook(@PathVariable Long id) {
        return new ResponseEntity<>(new BookUsersDTO(bookService.getBookById(id),
                userService.getUsersBorrowedBook(id)), HttpStatus.OK);
    }

    @PostMapping("/books")
    public ResponseEntity<BookDTO> saveBook(@Valid @RequestBody BookDTO bookDTO) {
        bookDTO.setId(0L);
        bookService.saveBook(bookDTO);
        return new ResponseEntity<>(bookDTO, HttpStatus.OK);
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<BookDTO> updateBook(@PathVariable Long id, @Valid @RequestBody BookDTO bookDTO) {
        bookDTO.setId(id);
        bookService.saveBook(bookDTO);
        return new ResponseEntity<>(bookDTO, HttpStatus.OK);
    }
}

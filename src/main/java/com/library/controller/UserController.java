package com.library.controller;

import com.library.dto.UserBooksDTO;
import com.library.dto.UserDTO;
import com.library.service.BookService;
import com.library.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final BookService bookService;

    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserBooksDTO> getUser(@PathVariable Long id) {
        return new ResponseEntity<>(new UserBooksDTO(userService.getUserById(id),
                bookService.getBooksBorrowedUser(id)), HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<UserDTO> saveBook(@Valid @RequestBody UserDTO userDTO) {
        userDTO.setId(0L);
        userService.saveUser(userDTO);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }


    @PutMapping("/users/{id}")
    public ResponseEntity<UserDTO> updateBook(@PathVariable Long id, @Valid @RequestBody UserDTO userDTO) {
        userDTO.setId(id);
        userService.saveUser(userDTO);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }
}

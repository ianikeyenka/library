package com.library.controller;

import com.library.dto.UserBooksDTO;
import com.library.dto.UserDTO;
import com.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library/users")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public List<UserDTO> getAllUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public UserBooksDTO getUser(@PathVariable Long id) {
        UserBooksDTO userBooksDTO = new UserBooksDTO(userService.getUserById(id), userService.getUserBorrowedBooks(id));
        return userBooksDTO;
    }

    @PutMapping("/{id}")
    public UserDTO updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        userDTO.setId(id);
        userService.saveUser(userDTO);
        return userDTO;
    }

    @PostMapping()
    public UserDTO addUser(@RequestBody UserDTO userDTO) {
        userService.saveUser(userDTO);
        return userDTO;
    }
}

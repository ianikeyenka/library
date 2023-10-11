package com.library.controller;

import com.library.dto.UserBooksDTO;
import com.library.dto.UserDTO;
import com.library.service.BookService;
import com.library.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/library/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    @GetMapping()
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getUsers());
        return "user/index";
    }

    @GetMapping("/{id}")
    public String getUser(@PathVariable Long id, Model model) {
        model.addAttribute("user",
                new UserBooksDTO(userService.getUserById(id), bookService.getBooksBorrowedUser(id)));
        return "user/show";
    }

    @GetMapping("/add-user")
    public String addNewBook(Model model) {
        model.addAttribute("user", new UserDTO());
        return "user/new";
    }

    @PostMapping("/save-user")
    public String saveBook(@ModelAttribute("user") @Valid UserDTO userDTO,
                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user/new";
        }
        userService.saveUser(userDTO);
        return "redirect:/library/users";
    }

    @GetMapping("/{id}/edit")
    public String editBook(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "user/edit";
    }

    @RequestMapping("/{id}")
    public String updateBook(@ModelAttribute("user") @Valid UserDTO userDTO,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user/edit";
        }
        userService.saveUser(userDTO);
        return "redirect:/library/users";
    }
}

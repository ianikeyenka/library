package com.library.service;

import com.library.dto.UserDTO;

import java.util.List;

public interface UserService {

    public List<UserDTO> getUsers();

    public UserDTO getUserById(Long id);

    public List<UserDTO> getUsersBorrowedBook(Long id);

    public void saveUser(UserDTO userDTO);
}

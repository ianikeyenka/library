package com.library.services;

import com.library.entities.User;

import java.util.List;

public interface UserService {

    public List<User> getUsers();

    public User getUser(int id);

    public void saveUser(User user);
}

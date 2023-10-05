package com.library.dto;

import java.util.ArrayList;
import java.util.List;

public class BookUsersDTO {
    private BookDTO book;

    private List<UserDTO> users;

    public BookUsersDTO() {
    }

    public BookUsersDTO(BookDTO book, List<UserDTO> users) {
        this.book = book;
        this.users = users;
    }

    public BookDTO getBook() {
        return book;
    }

    public void setBook(BookDTO book) {
        this.book = book;
    }

    public List<UserDTO> getUsers() {
        return new ArrayList<>(users);
    }

    public void setUsers(List<UserDTO> users) {
        this.users = users;
    }
}

package com.library.dto;

import java.util.List;

public class UserBooksDTO {
    private UserDTO user;
    private List<BookDTO> books;

    public UserBooksDTO() {
    }

    public UserBooksDTO(UserDTO user, List<BookDTO> books) {
        this.user = user;
        this.books = books;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public List<BookDTO> getBooks() {
        return books;
    }

    public void setBooks(List<BookDTO> books) {
        this.books = books;
    }
}

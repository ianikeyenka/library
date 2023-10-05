package com.library.dto;

public class BorrowDTO {
    private Long id;

    private UserDTO user;

    private BookDTO book;

    private boolean returned;

    public BorrowDTO() {
    }

    public BorrowDTO(Long id, UserDTO user, BookDTO book, boolean returned) {
        this.id = id;
        this.user = user;
        this.book = book;
        this.returned = returned;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public BookDTO getBook() {
        return book;
    }

    public void setBook(BookDTO book) {
        this.book = book;
    }

    public boolean isReturned() {
        return returned;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }
}

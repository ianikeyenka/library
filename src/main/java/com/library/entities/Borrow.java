package com.library.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "borrow_history")
public class Borrow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(cascade = {CascadeType.PERSIST,
            CascadeType.DETACH, CascadeType.REFRESH,
            CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = {CascadeType.PERSIST,
            CascadeType.DETACH, CascadeType.REFRESH,
            CascadeType.MERGE})
    @JoinColumn(name = "book_id")
    private Book book;

    @Column(name = "returned")
    private boolean returned;

    public Borrow() {
    }

    public Borrow(boolean returned) {
        this.returned = returned;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public boolean isReturned() {
        return returned;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }
}

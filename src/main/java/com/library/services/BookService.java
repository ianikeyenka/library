package com.library.services;

import com.library.entities.Book;

import java.util.List;

public interface BookService {
    public List<Book> getBooks();

    public void saveBook(Book book);

    public Book getBook(int id);
}

package com.library.service;

import com.library.dto.BookDTO;

import java.util.List;

public interface BookService {
    List<BookDTO> getBooks();
    BookDTO getBookById(Long id);
    List<BookDTO> getBooksBorrowedUser(Long id);
    void saveBook(BookDTO bookDTO);
}

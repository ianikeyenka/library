package com.library.service;

import com.library.dto.BookDTO;
import com.library.dto.UserDTO;

import java.util.List;

public interface BookService {
    public List<BookDTO> getBooks();

    public BookDTO getBookById(Long id);

    public List<UserDTO> getBookBorrowedUsers(Long id);

    public void saveBook(BookDTO bookDTO);


}

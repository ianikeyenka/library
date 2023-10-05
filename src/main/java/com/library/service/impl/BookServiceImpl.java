package com.library.service.impl;

import com.library.dto.BookDTO;
import com.library.dto.UserDTO;
import com.library.entity.Book;
import com.library.entity.Borrow;
import com.library.mapper.BookMapper;
import com.library.mapper.UserMapper;
import com.library.repository.BookRepository;
import com.library.repository.BorrowRepository;
import com.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BorrowRepository borrowRepository;

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional
    public List<BookDTO> getBooks() {
        return bookRepository
                .findAll()
                .stream()
                .map(bookMapper::bookToBookDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public BookDTO getBookById(Long id) {
        Book book = null;
        Optional<Book> optional = bookRepository.findById(id);
        if (optional.isPresent()) {
            book = optional.get();
        }
        return bookMapper.bookToBookDto(book);
    }

    @Override
    @Transactional
    public List<UserDTO> getBookBorrowedUsers(Long id) {
        List<Borrow> borrows = borrowRepository.findByBookId(id);
        List<UserDTO> users = borrows.stream()
                .map(borrow -> userMapper.userToUserDto(borrow.getUser()))
                .collect(Collectors.toList());
        return users;
    }

    @Override
    @Transactional
    public void saveBook(BookDTO bookDTO) {
        bookRepository.save(bookMapper.bookDtoToBook(bookDTO));
    }
}

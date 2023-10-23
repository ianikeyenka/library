package com.library.service.impl;

import com.library.dto.BookDTO;
import com.library.entity.BookEntity;
import com.library.entity.BorrowEntity;
import com.library.exception.ResourceNotFoundException;
import com.library.mapper.BookMapper;
import com.library.repository.BookRepository;
import com.library.repository.BorrowRepository;
import com.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BorrowRepository borrowRepository;
    @Autowired
    private BookMapper bookMapper;

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
    public BookDTO getBookById(Long id) {
        BookEntity book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book with id - " + id + " not found"));
        return bookMapper.bookToBookDto(book);
    }

    @Override
    @Transactional
    public List<BookDTO> getBooksBorrowedUser(Long id) {
        List<BorrowEntity> borrows = borrowRepository.findAllByUserId(id);
        return borrows.stream()
                .map(borrow -> bookMapper.bookToBookDto(borrow.getBook()))
                .collect(Collectors.toList());
    }

    @Override
    public void saveBook(BookDTO bookDTO) {
        bookRepository.save(bookMapper.bookDtoToBook(bookDTO));
    }
}

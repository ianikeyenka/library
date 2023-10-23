package com.library.service.impl;

import com.library.dto.BookDTO;
import com.library.entity.BookEntity;
import com.library.entity.BorrowEntity;
import com.library.exception.ResourceNotFoundException;
import com.library.mapper.BookMapper;
import com.library.repository.BookRepository;
import com.library.repository.BorrowRepository;
import com.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BorrowRepository borrowRepository;
    private final BookMapper bookMapper;

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

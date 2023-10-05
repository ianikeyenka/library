package com.library.mapper;

import com.library.dto.BookDTO;
import com.library.entity.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {
    public BookDTO bookToBookDto(Book book) {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(book.getId());
        bookDTO.setTitle(book.getTitle());
        bookDTO.setAuthor(book.getAuthor());
        return bookDTO;
    }

    public Book bookDtoToBook(BookDTO bookDTO) {
        Book book = new Book();
        book.setId(bookDTO.getId());
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        return book;
    }
}

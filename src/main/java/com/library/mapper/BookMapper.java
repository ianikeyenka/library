package com.library.mapper;

import com.library.dto.BookDTO;
import com.library.entity.Book;
import org.mapstruct.Mapper;

@Mapper
public interface BookMapper {
    BookDTO bookToBookDto(Book book);

    Book bookDtoToBook(BookDTO bookDTO);
}

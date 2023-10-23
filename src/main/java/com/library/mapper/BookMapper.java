package com.library.mapper;

import com.library.dto.BookDTO;
import com.library.entity.BookEntity;
import org.mapstruct.Mapper;

@Mapper
public interface BookMapper {
    BookDTO bookToBookDto(BookEntity book);

    BookEntity bookDtoToBook(BookDTO bookDTO);
}

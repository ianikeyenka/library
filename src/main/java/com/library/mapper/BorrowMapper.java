package com.library.mapper;

import com.library.dto.BorrowDTO;
import com.library.entity.Borrow;
import org.mapstruct.Mapper;


@Mapper
public interface BorrowMapper {
    BorrowDTO borrowToBorrowDto(Borrow borrow);

    Borrow borrowDtoToBorrow(BorrowDTO borrowDTO);
}

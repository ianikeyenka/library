package com.library.mapper;

import com.library.dto.BorrowDTO;
import com.library.entity.BorrowEntity;
import org.mapstruct.Mapper;

@Mapper
public interface BorrowMapper {
    BorrowDTO borrowToBorrowDto(BorrowEntity borrow);

    BorrowEntity borrowDtoToBorrow(BorrowDTO borrowDTO);
}

package com.library.mapper;

import com.library.dto.BookDTO;
import com.library.dto.BorrowDTO;
import com.library.dto.UserDTO;
import com.library.entity.Book;
import com.library.entity.Borrow;
import com.library.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class BorrowMapper {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BookMapper bookMapper;

    public BorrowDTO borrowToBorrowDto(Borrow borrow) {
        BorrowDTO borrowDTO = new BorrowDTO();
        UserDTO userDTO = userMapper.userToUserDto(borrow.getUser());
        BookDTO bookDTO = bookMapper.bookToBookDto(borrow.getBook());
        borrowDTO.setId(borrow.getId());
        borrowDTO.setUser(userDTO);
        borrowDTO.setBook(bookDTO);
        borrowDTO.setReturned(borrow.isReturned());
        return borrowDTO;
    }

    public Borrow borrowDtoToBorrow(BorrowDTO borrowDTO) {
        Borrow borrow = new Borrow();
        User user = userMapper.userDtoToUser(borrowDTO.getUser());
        Book book = bookMapper.bookDtoToBook(borrowDTO.getBook());
        borrow.setId(borrowDTO.getId());
        borrow.setUser(user);
        borrow.setBook(book);
        borrow.setReturned(borrowDTO.isReturned());
        return borrow;
    }
}

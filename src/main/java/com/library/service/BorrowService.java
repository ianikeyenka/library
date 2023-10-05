package com.library.service;

import com.library.dto.BorrowDTO;
import com.library.entity.Borrow;

import java.util.List;

public interface BorrowService {

    public List<BorrowDTO> getAllHistory();

    public Borrow saveBorrow(BorrowDTO borrow);
}

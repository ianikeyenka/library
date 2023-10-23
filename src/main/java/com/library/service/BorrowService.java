package com.library.service;

import com.library.dto.BorrowDTO;

import java.util.List;

public interface BorrowService {
    public List<BorrowDTO> getAllHistory();

    public BorrowDTO getBorrowById(Long id);

    public void saveBorrow(BorrowDTO borrow);
}

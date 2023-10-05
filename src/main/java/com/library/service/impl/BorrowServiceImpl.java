package com.library.service.impl;

import com.library.dto.BorrowDTO;
import com.library.entity.Borrow;
import com.library.mapper.BorrowMapper;
import com.library.repository.BorrowRepository;
import com.library.service.BorrowService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BorrowServiceImpl implements BorrowService {
    @Autowired
    private BorrowRepository borrowRepository;

    @Autowired
    private BorrowMapper borrowMapper;

    @Override
    @Transactional
    public List<BorrowDTO> getAllHistory() {
        return borrowRepository
                .findAll()
                .stream()
                .map(borrowMapper::borrowToBorrowDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public Borrow saveBorrow(BorrowDTO borrow) {
        return borrowRepository.save(borrowMapper.borrowDtoToBorrow(borrow));
    }
}

package com.library.service.impl;

import com.library.dto.BorrowDTO;
import com.library.entity.BorrowEntity;
import com.library.exception.ResourceNotFoundException;
import com.library.mapper.BorrowMapper;
import com.library.repository.BorrowRepository;
import com.library.service.BorrowService;
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

    public List<BorrowDTO> getAllHistory() {
        return borrowRepository
                .findAll()
                .stream()
                .map(borrowMapper::borrowToBorrowDto)
                .collect(Collectors.toList());
    }

    @Override
    public BorrowDTO getBorrowById(Long id) {
        BorrowEntity borrow = borrowRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Borrow with id - " + id + " not found"));
        return borrowMapper.borrowToBorrowDto(borrow);
    }

    @Override
    public void saveBorrow(BorrowDTO borrowDTO) {
        borrowRepository.save(borrowMapper.borrowDtoToBorrow(borrowDTO));
    }
}

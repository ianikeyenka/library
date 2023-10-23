package com.library.service.impl;

import com.library.dto.BorrowDTO;
import com.library.entity.BorrowEntity;
import com.library.exception.ResourceNotFoundException;
import com.library.mapper.BorrowMapper;
import com.library.repository.BorrowRepository;
import com.library.service.BorrowService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BorrowServiceImpl implements BorrowService {
    private final BorrowRepository borrowRepository;
    private final BorrowMapper borrowMapper;

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
    public BorrowDTO getBorrowById(Long id) {
        BorrowEntity borrow = borrowRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Borrow with id - " + id + " not found"));
        return borrowMapper.borrowToBorrowDto(borrow);
    }

    @Override
    @Transactional
    public void saveBorrow(BorrowDTO borrowDTO) {
        borrowRepository.save(borrowMapper.borrowDtoToBorrow(borrowDTO));
    }
}

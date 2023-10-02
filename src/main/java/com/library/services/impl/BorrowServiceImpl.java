package com.library.services.impl;

import com.library.entities.Borrow;
import com.library.entities.User;
import com.library.repositories.BorrowRepository;
import com.library.services.BorrowService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BorrowServiceImpl implements BorrowService {

    @Autowired
    private BorrowRepository borrowRepository;

    @Override
    @Transactional
    public List<Borrow> getAllHistory() {
        return borrowRepository.findAll();
    }

    @Override
    public Borrow getHistorySlice(int id) {
        Borrow borrow = null;
        Optional<Borrow> optional = borrowRepository.findById(id);
        if (optional.isPresent()) {
            borrow = optional.get();
        }
        return borrow;
    }

    @Override
    @Transactional
    public Borrow saveHistory(Borrow borrow) {
        return borrowRepository.save(borrow);
    }
}

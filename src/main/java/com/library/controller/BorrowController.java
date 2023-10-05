package com.library.controller;

import com.library.dto.BorrowDTO;
import com.library.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library/history")
@CrossOrigin
public class BorrowController {
    @Autowired
    private BorrowService borrowService;

    @GetMapping("")
    private List<BorrowDTO> getHistory() {
        return borrowService.getAllHistory();
    }

    @PutMapping("/{id}")
    public BorrowDTO updateBorrow(@PathVariable Long id, @RequestBody BorrowDTO borrowDTO) {
        borrowDTO.setId(id);
        borrowService.saveBorrow(borrowDTO);
        return borrowDTO;
    }

    @PostMapping()
    public BorrowDTO addBorrow(@RequestBody BorrowDTO borrowDTO) {
        borrowService.saveBorrow(borrowDTO);
        return borrowDTO;
    }
}

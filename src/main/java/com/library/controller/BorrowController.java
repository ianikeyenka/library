package com.library.controller;

import com.library.dto.BorrowDTO;
import com.library.service.BorrowService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BorrowController {
    @Autowired
    private BorrowService borrowService;

    @GetMapping("/history")
    public ResponseEntity<List<BorrowDTO>> getHistory() {
        return new ResponseEntity<>(borrowService.getAllHistory(), HttpStatus.OK);
    }

    @GetMapping("/history/{id}")
    public ResponseEntity<BorrowDTO> getBorrow(@PathVariable Long id) {
        return new ResponseEntity<>(borrowService.getBorrowById(id), HttpStatus.OK);
    }

    @PostMapping("/history")
    public ResponseEntity<BorrowDTO> saveBorrow(@Valid @RequestBody BorrowDTO borrowDTO) {
        borrowDTO.setId(0L);
        borrowService.saveBorrow(borrowDTO);
        return new ResponseEntity<>(borrowDTO, HttpStatus.OK);
    }

    @PutMapping("/history/{id}")
    public ResponseEntity<BorrowDTO> updateBook(@PathVariable Long id, @Valid @RequestBody BorrowDTO borrowDTO) {
        borrowDTO.setId(id);
        borrowService.saveBorrow(borrowDTO);
        return new ResponseEntity<>(borrowDTO, HttpStatus.OK);
    }
}

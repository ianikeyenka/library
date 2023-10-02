package com.library.services;

import com.library.entities.Borrow;

import java.util.List;

public interface BorrowService {

    public List<Borrow> getAllHistory();

    public Borrow getHistorySlice(int id);

    public Borrow saveHistory(Borrow borrow);
}

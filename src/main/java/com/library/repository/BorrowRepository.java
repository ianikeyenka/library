package com.library.repository;

import com.library.entity.BorrowEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BorrowRepository extends JpaRepository<BorrowEntity, Long> {
    List<BorrowEntity> findAllByUserId(Long id);

    List<BorrowEntity> findAllByBookId(Long id);
}

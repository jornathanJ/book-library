package com.jornathan.booklibrary.dao.hibernate;

import com.jornathan.booklibrary.model.hibernate.CheckOutHistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CheckOutHistoryRepository extends JpaRepository<CheckOutHistory, String> {
  List<CheckOutHistory> findByBookId(String bookId);

  List<CheckOutHistory> findByUserId(String userId);
}

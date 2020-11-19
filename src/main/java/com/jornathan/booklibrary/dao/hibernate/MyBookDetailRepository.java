package com.jornathan.booklibrary.dao.hibernate;

import com.jornathan.booklibrary.model.hibernate.MybookDetail;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyBookDetailRepository extends JpaRepository<MybookDetail, String> {
}

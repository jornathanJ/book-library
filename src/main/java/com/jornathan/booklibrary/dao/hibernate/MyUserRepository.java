package com.jornathan.booklibrary.dao.hibernate;

import com.jornathan.booklibrary.model.hibernate.MyUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyUserRepository extends JpaRepository<MyUser, String> {
}

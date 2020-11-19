package com.jornathan.booklibrary.service.hibernate;

import com.jornathan.booklibrary.model.hibernate.MyBook;
import com.jornathan.booklibrary.model.hibernate.MyBookProjections;

import java.util.List;

public interface MyBookService {
    //public List<MyBook> findAll();

    public List<MyBookProjections.BookList> findAllByOrderByTagAsc();
}

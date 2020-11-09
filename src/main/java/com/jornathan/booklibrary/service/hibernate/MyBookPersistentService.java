package com.jornathan.booklibrary.service.hibernate;

import com.jornathan.booklibrary.model.hibernate.MyBookVO;

import java.util.List;


public interface MyBookPersistentService {


    public List<MyBookVO> findAll();
    public List<MyBookVO> findAllByOrderByTagAsc();

}

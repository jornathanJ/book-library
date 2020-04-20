package com.jornathan.booklibrary.service;

import com.jornathan.booklibrary.dao.MyBookRepository;
import com.jornathan.booklibrary.model.MyBook;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class MyBookServiceImpl implements MyBookService {

    @Autowired
    private MyBookRepository myBookRepository;

    public List<MyBook> getAllBooks(){
        return this.myBookRepository.getAllBooks();
    }

    public MyBook getBook(String bookName){
        return this.myBookRepository.getBook(bookName);
    }


    public List<MyBook> searchBooks(String keyword){
        return this.myBookRepository.searchBooks(keyword);
    }

    public void updateBook(List<MyBook> myBookList){
        this.myBookRepository.updateBook(myBookList);
    }

    public void createBook(MyBook newBook){
        this.myBookRepository.createBook(newBook);
    }

    public Map<String, Object> deleteBook(String tag){
        return this.myBookRepository.deleteBook(tag);
    }



}

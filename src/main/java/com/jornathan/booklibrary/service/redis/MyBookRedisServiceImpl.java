package com.jornathan.booklibrary.service.redis;

import com.jornathan.booklibrary.dao.MyBookRepositoryTemp;
import com.jornathan.booklibrary.model.redis.MyBookRedis;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyBookRedisServiceImpl implements MyBookRedisService {

    @Autowired
    private MyBookRepositoryTemp myBookRepository;

    public List<MyBookRedis> getAllBooks(){
        return this.myBookRepository.getAllBooks();
    }

    public MyBookRedis getBook(String bookName){
        return this.myBookRepository.getBook(bookName);
    }


    public List<MyBookRedis> searchBooks(String keyword){
        return this.myBookRepository.searchBooks(keyword);
    }

    public void updateBook(List<MyBookRedis> myBookRedisList){
        this.myBookRepository.updateBook(myBookRedisList);
    }

    public void createBook(MyBookRedis newBook){
        this.myBookRepository.createBook(newBook);
    }

    public Map<String, Object> deleteBook(String tag){
        return this.myBookRepository.deleteBook(tag);
    }
}

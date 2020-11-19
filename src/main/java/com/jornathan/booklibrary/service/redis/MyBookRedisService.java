package com.jornathan.booklibrary.service.redis;

import com.jornathan.booklibrary.model.redis.MyBookRedis;

import java.util.List;
import java.util.Map;

/**
 * Redis 를 사용하기 위한 Service
 */
public interface MyBookRedisService {
    public List<MyBookRedis> getAllBooks();

    public MyBookRedis getBook(String bookName);


    public List<MyBookRedis> searchBooks(String keyword);

    public void updateBook(List<MyBookRedis> myBookRedisList);

    public void createBook(MyBookRedis newBook);

    public Map<String, Object> deleteBook(String tag);
}

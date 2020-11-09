package com.jornathan.booklibrary.service.redis;

import com.jornathan.booklibrary.model.redis.MyBook;

import java.util.List;
import java.util.Map;

public interface MyBookService {
    public List<MyBook> getAllBooks();

    public MyBook getBook(String bookName);


    public List<MyBook> searchBooks(String keyword);

    public void updateBook(List<MyBook> myBookList);

    public void createBook(MyBook newBook);

    public Map<String, Object> deleteBook(String tag);
}

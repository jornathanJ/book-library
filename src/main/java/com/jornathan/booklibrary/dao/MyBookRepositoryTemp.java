package com.jornathan.booklibrary.dao;

import com.jornathan.booklibrary.model.hibernate.MyBook;
import com.jornathan.booklibrary.model.redis.MyBookRedis;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class MyBookRepositoryTemp {

  public static List<MyBookRedis> myBookRedis;

  static {


    myBookRedis = new ArrayList<>();
    myBookRedis.add(new MyBookRedis("A-001", "A 001 books"));
    myBookRedis.add(new MyBookRedis("A-002", "A 002 books"));
    myBookRedis.add(new MyBookRedis("A-003", "A 003 books"));
    myBookRedis.add(new MyBookRedis("A-004", "A 004 books"));
    myBookRedis.add(new MyBookRedis("A-005", "A 005 books"));
    myBookRedis.add(new MyBookRedis("B-001", "B 001 books"));
    myBookRedis.add(new MyBookRedis("B-002", "B 002 books"));
    myBookRedis.add(new MyBookRedis("B-003", "B 003 books"));
    myBookRedis.add(new MyBookRedis("C-001", "C 001 books"));
    myBookRedis.add(new MyBookRedis("C-002", "C 002 books"));
    myBookRedis.add(new MyBookRedis("C-003", "C 003 books"));
  }

  public List<MyBookRedis> getAllBooks() {
    return myBookRedis;
  }

  public MyBookRedis getBook(String bookName) {

    MyBookRedis rtnValue = null;
    for (MyBookRedis item : myBookRedis) {
      if (true == item.getTag().equals(bookName)) {
        rtnValue = item;
      }
    }

    return rtnValue;
  }

  public List<MyBookRedis> searchBooks(String keyword) {


    return myBookRedis.stream()
                      .filter(book -> book.getName().indexOf(keyword) >= 0)
                      .collect(Collectors.toList());
  }

  public void updateBook(List<MyBookRedis> myBookRedisList) {
    for (MyBookRedis item : myBookRedisList) {
      int index = myBookRedis.indexOf(item);
      if (index >= 0) {
        MyBookRedis targetItem = myBookRedis.get(index);
        //targetItem = item.
      }
    }
  }

  public void createBook(MyBookRedis newBook) {
    myBookRedis.add(newBook);
  }

  public Map<String, Object> deleteBook(String tag) {
    Map<String, Object> result = new LinkedHashMap<>();
    result.put("RESULT", "FAIL");

    for (MyBookRedis item : myBookRedis) {
      int index = myBookRedis.indexOf(item);
      if (index >= 0) {
        myBookRedis.remove(index);
        result.put("RESULT", "PASS");
        break;
      }
    }

    return result;
  }
}

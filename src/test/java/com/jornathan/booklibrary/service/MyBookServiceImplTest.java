package com.jornathan.booklibrary.service;

import com.jornathan.booklibrary.model.redis.MyBook;
import com.jornathan.booklibrary.service.redis.MyBookService;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import redis.embedded.RedisServer;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class MyBookServiceImplTest {

  @Autowired
  private MyBookService myBookService;

  private RedisServer redisServer;

  @Value("${spring.redis.host}")
  private String redisHost;

  @Value("${spring.redis.port}")
  private int redisPort;


  @BeforeEach
  void setUp() {
    //        redisServer = new RedisServer(redisPort);
    //        redisServer.start();
  }

  @AfterEach
  void tearDown() {
    //        if (redisServer != null) {
    //            redisServer.stop();
    //        }
  }

  @Test
  public void TestSample() {
  }

  @Test
  void getAllBooks() {
    List<MyBook> myBookList = this.myBookService.getAllBooks();
    assertTrue(myBookList.size() > 0);
  }

  @Test
  void getBook() {
    String bookName = "test";
    MyBook newBook = new MyBook(bookName, "test book name.");
    this.myBookService.createBook(newBook);

    MyBook testBook = this.myBookService.getBook(bookName);
    assertTrue(testBook != null);
    assertTrue(testBook.getTag().equals(bookName));

  }

  @Test
  void searchBooks() {
    //MyBookServiceImpl myBookService = new MyBookServiceImpl();
    String tag = "A-001";
    List<MyBook> rtnValue = myBookService.searchBooks(tag);
  }

  @Test
  void updateBook() {
  }
}
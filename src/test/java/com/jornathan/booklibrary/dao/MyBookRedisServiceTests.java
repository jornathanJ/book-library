package com.jornathan.booklibrary.dao;

import com.jornathan.booklibrary.model.redis.MyBookRedis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class MyBookRedisServiceTests {

  @Autowired
  private MyBookRepositoryTemp myBookRepository;

  @Test
  public void testGetAllBooks() {
    List<MyBookRedis> list = this.myBookRepository.getAllBooks();
    assertTrue(list.size() > 0);
  }

  @Test
  public void testGetBook() {
    assertNotNull(this.myBookRepository.getBook("A-001"));
  }

  @Test
  public void testSearchBooks() {
    List<MyBookRedis> list = this.myBookRepository.getAllBooks();
    assertNotNull(list);
    assertTrue(list.size() > 0);
  }

  @Test
  void updateBook() {
  }

  @Test
  void createBook() {
  }
}
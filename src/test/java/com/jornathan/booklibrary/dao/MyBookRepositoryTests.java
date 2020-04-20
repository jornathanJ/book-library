package com.jornathan.booklibrary.dao;

import com.jornathan.booklibrary.model.MyBook;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class MyBookRepositoryTests {

    @Autowired
    private MyBookRepository myBookRepository;

    @Test
    public void testGetAllBooks() {
        List<MyBook> list = this.myBookRepository.getAllBooks();
        assertTrue(list.size() > 0);
    }

    @Test
    public void testGetBook() {
        assertNotNull(this.myBookRepository.getBook("A-001"));
    }

    @Test
    public void testSearchBooks() {
        List<MyBook> list = this.myBookRepository.getAllBooks();
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
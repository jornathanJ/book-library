package com.jornathan.booklibrary.service;

import com.jornathan.booklibrary.dao.MyBookRepository;
import com.jornathan.booklibrary.domain.Point;
import com.jornathan.booklibrary.domain.PointRedisRepository;
import com.jornathan.booklibrary.model.MyBook;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import redis.embedded.RedisServer;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.validation.constraints.AssertTrue;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class MyBookServiceImplTest {

    @Autowired
    private MyBookService myBookService;

    private RedisServer redisServer;

    @Value("${spring.redis.host}")
    private String redisHost;

    @Value("${spring.redis.port}")
    private int redisPort;

    @Autowired
    private PointRedisRepository pointRedisRepository;

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

        System.setProperty("spring.profiles.default", "local");
        //given
        String id = "jojoldu";
        LocalDateTime refreshTime = LocalDateTime.of(2018, 5, 26, 0, 0);
//        Point point = Point.builder()
//                .id(id)
//                .amount(1000L)
//                .refreshTime(refreshTime)
//                .build();

        Point point = new Point(id, 1000L, refreshTime);

        //when
        pointRedisRepository.save(point);

        //then
        Point savedPoint = pointRedisRepository.findById(id).get();
        //Assert.assertTrue(savedPoint.getAmount()).isEqualTo(1000L);
        //Assert.assertTrue(savedPoint.getRefreshTime()).isEqualTo(refreshTime);
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
package com.jornathan.booklibrary;

import com.jornathan.booklibrary.domain.Point;
import com.jornathan.booklibrary.domain.PointRedisRepository;
import com.jornathan.booklibrary.model.BookRedisRepository;
import com.jornathan.booklibrary.model.MyBook;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.jupiter.api.Test;


import java.time.LocalDateTime;

//@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest1 {

    @Autowired
    private PointRedisRepository pointRedisRepository;

    @Autowired
    private BookRedisRepository bookRedisRepository;

//    @After
//    public void tearDown() throws Exception {
//        pointRedisRepository.deleteAll();
//    }

    //@BeforeAll
    //public void t

    @Test
    public void TestSample() {

        //given
        String id = "jojoldu";
//        LocalDateTime refreshTime = LocalDateTime.of(2018, 5, 26, 0, 0);
////        Point point = Point.builder()
////                .id(id)
////                .amount(1000L)
////                .refreshTime(refreshTime)
////                .build();
//
//        Point point = new Point(id, 1000L, refreshTime);
//
//        //when
//        pointRedisRepository.save(point);

        //then
        Point savedPoint = pointRedisRepository.findById(id).get();
        //Assert.assertTrue(savedPoint.getAmount()).isEqualTo(1000L);
        //Assert.assertTrue(savedPoint.getRefreshTime()).isEqualTo(refreshTime);
    }

    @Test
    public void TestBookCreate(){
        String tag = "A-a";
        MyBook myBook = new MyBook(tag, "Rest API.");
        myBook.setLoaned(false);

        bookRedisRepository.save(myBook);
        MyBook savedBook = bookRedisRepository.findById(tag).get();
    }

}

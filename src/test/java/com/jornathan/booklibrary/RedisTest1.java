package com.jornathan.booklibrary;

import com.jornathan.booklibrary.model.redis.BookRedisRepository;
import com.jornathan.booklibrary.model.redis.MyBookRedis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest1 {

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

  }

  @Test
  public void TestBookCreate() {
    String tag = "A-a";
    MyBookRedis myBookRedis = new MyBookRedis(tag, "Rest API.");
    myBookRedis.setLoaned(false);

    bookRedisRepository.save(myBookRedis);
    MyBookRedis savedBook = bookRedisRepository.findById(tag).get();
  }

}

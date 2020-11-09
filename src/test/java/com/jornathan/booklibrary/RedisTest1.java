package com.jornathan.booklibrary;

import com.jornathan.booklibrary.model.redis.BookRedisRepository;
import com.jornathan.booklibrary.model.redis.MyBook;

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
    MyBook myBook = new MyBook(tag, "Rest API.");
    myBook.setLoaned(false);

    bookRedisRepository.save(myBook);
    MyBook savedBook = bookRedisRepository.findById(tag).get();
  }

}

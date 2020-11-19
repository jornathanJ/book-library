package com.jornathan.booklibrary.controller;

import com.jornathan.booklibrary.model.hibernate.MyBook;
import com.jornathan.booklibrary.model.hibernate.MyBookProjections;
import com.jornathan.booklibrary.model.hibernate.MyUser;
import com.jornathan.booklibrary.service.hibernate.MyBookServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

/**
 * Database 에 저장되어 있는 정보를 처리
 */
@RestController
@RequestMapping("/books")
public class MyBookController {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  private final MyBookServiceImpl myBookService;

  public MyBookController(MyBookServiceImpl myBookService) {
    this.myBookService = myBookService;
  }

  @GetMapping(path = "/all", produces = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<List<MyBookProjections.BookList>> findAllByOrderByTagAsc() {
    List<MyBookProjections.BookList> resultList = this.myBookService.findAllByOrderByTagAsc();
//    for (MyBook book : resultList) {
//      book.setYn(true);
//    }
    return new ResponseEntity<>(resultList, HttpStatus.OK);
  }

  @GetMapping(path = "/book/{id}")
  public ResponseEntity<MyBook> findByTag(@PathVariable("id") String id) {
    MyBook result = this.myBookService.findById(id);
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @PostMapping(path = "/book")
  public ResponseEntity<MyBook> save(@RequestBody MyBook myBook) {
    MyBook result = this.myBookService.save(myBook);
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @PatchMapping(path = "/book")
  public ResponseEntity<MyBook> saveBookDetail(@RequestBody MyBook myBook) {
    MyBook result = this.myBookService.saveBookDetail(myBook);
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @PostMapping(path = "/loan/{userId}")
  public ResponseEntity<MyBook> save(@PathVariable(name = "userId") String userId,
                                     @RequestBody MyBook myBook) {
    MyBook result = this.myBookService.saveBookHistory(userId, myBook);
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  //  @PatchMapping(path = "/book")
  //  public ResponseEntity<MyBook> updateBookStatus(@RequestBody MyBook myBook) {
  //    MyBook result = this.myBookService.updateBookStatus(myBook);
  //    return new ResponseEntity<>(result, HttpStatus.OK);
  //  }

  @DeleteMapping(path = "/book")
  public ResponseEntity delete(@RequestBody MyBook myBook) {
    this.myBookService.delete(myBook);
    return new ResponseEntity(HttpStatus.OK);
  }

  @PostMapping(path = "/users/authenticate", produces = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<Map<String, String>> findUserInfo() {
    //List<MyBook> resultList = this.myBookService.findAllByOrderByTagAsc();
    Map<String, String> resultList = new LinkedHashMap<>();
    resultList.put("id", "jornathan");
    resultList.put("username", "jornathan");
    resultList.put("password", "jornathan");
    resultList.put("firstName", "jornathan");
    resultList.put("lastName", "jornathan");
    resultList.put("token", "jornathan");

    return new ResponseEntity<>(resultList, HttpStatus.OK);
  }
}

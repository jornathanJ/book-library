package com.jornathan.booklibrary.controller;

import com.jornathan.booklibrary.model.hibernate.MyUser;
import com.jornathan.booklibrary.service.hibernate.MyUserService;
import com.jornathan.booklibrary.service.hibernate.MyUserServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class MyBookUserController {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  private final MyUserService myUserService;

  public MyBookUserController(MyUserServiceImpl myBookUserService) {
    this.myUserService = myBookUserService;
  }

  @PostMapping(path="/user")
  public ResponseEntity<MyUser> save(@RequestBody MyUser myUser) {
    MyUser result = this.myUserService.save(myUser);
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @GetMapping(path="/user/{id}")
  public ResponseEntity<MyUser> findById(@PathVariable("id") String id) {
    MyUser result = this.myUserService.findById(id);
    return new ResponseEntity<>(result, HttpStatus.OK);
  }
}

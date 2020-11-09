package com.jornathan.booklibrary.controller;

import com.jornathan.booklibrary.model.hibernate.MyBookVO;
import com.jornathan.booklibrary.service.hibernate.MyBookPersistentServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persistent/books")
public class MyBookPersistentController {

    // 기본형
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MyBookPersistentServiceImpl myBookPersistentService;

    @GetMapping(path="", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<MyBookVO>> getAllBooks(){
        List<MyBookVO> resultList = this.myBookPersistentService.findAllByOrderByTagAsc();
        return new ResponseEntity<>(resultList, HttpStatus.OK);
    }

    @GetMapping(path="/tag/{tag}")
    public ResponseEntity<MyBookVO> getBook(@PathVariable("tag") String tag){
        MyBookVO result = this.myBookPersistentService.findByTag(tag);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping(path="/book")
    public ResponseEntity<MyBookVO> save(@RequestBody MyBookVO myBookVO){
        MyBookVO result = this.myBookPersistentService.save(myBookVO);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping(path="/book")
    public ResponseEntity<MyBookVO> update(@RequestBody MyBookVO myBookVO){
        MyBookVO result = this.myBookPersistentService.update(myBookVO);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @DeleteMapping(path="/book")
    public ResponseEntity delete(@RequestBody MyBookVO myBookVO){
        this.myBookPersistentService.delete(myBookVO);
        return new ResponseEntity(HttpStatus.OK);
    }

}

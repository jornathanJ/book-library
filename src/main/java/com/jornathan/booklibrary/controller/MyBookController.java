package com.jornathan.booklibrary.controller;


import com.jornathan.booklibrary.annotation.TokenRequired;
import com.jornathan.booklibrary.model.hibernate.NvBookInfo;
import com.jornathan.booklibrary.model.redis.MyBook;
import com.jornathan.booklibrary.service.OpenAPI.NaverBookService;
import com.jornathan.booklibrary.service.redis.MyBookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/books")
public class MyBookController {

    private static final Logger logger = LoggerFactory.getLogger(MyBookController.class);

    public static final String TITLE = "d_titl";

    @Autowired
    private MyBookService myBookService;

    @Autowired
    private NaverBookService naverBookService;

    @GetMapping("")
    public List<MyBook> getAllBooks(){
        return this.myBookService.getAllBooks();
    }


    @GetMapping("/tag/{tag}")
    public MyBook getBook(@PathVariable("tag") String tag){
        return this.myBookService.getBook(tag);
    }

    @GetMapping("/name/{keyword}")
    public List<MyBook> searchBooks(@PathVariable("keyword") String keyword){
        return this.myBookService.searchBooks(keyword);
    }

    @PutMapping("")
    public void updateBook(@RequestBody List<MyBook> myBookList){
        this.myBookService.updateBook(myBookList);
    }

    @ResponseBody
    @TokenRequired
    @DeleteMapping("/tag/{tag}")
    public Map<String, Object> deleteBook(@PathVariable("tag") String tag){
        return this.myBookService.deleteBook(tag);
    }

    /**
     * Open API Call
     */
    @GetMapping("/openapi/search/{queryType}")
    public NvBookInfo getOpenAPIByTitle(@PathVariable("queryType") String queryType
    , @RequestParam("keyword") String keyword){
        return this.naverBookService.GetBookInfo(queryType, keyword);
    }

//    /**
//     * Open API Call
//     */
//    @GetMapping("/openapi/title/{keyword}")
//    public List<MyBook> getOpenAPIByISBN(@PathVariable("keyword") String keyword){
//        return this.naverBookService.GetBookInfo(TITLE, keyword);
//    }

}

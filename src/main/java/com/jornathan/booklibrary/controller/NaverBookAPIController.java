package com.jornathan.booklibrary.controller;


import com.jornathan.booklibrary.model.hibernate.NvBookInfo;
import com.jornathan.booklibrary.service.naver.NaverBookService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Naver 에서 제공하는 책 정보를 가져와서 사용
 */
@RestController
@RequestMapping("/books/naver")
public class NaverBookAPIController {

  private static final Logger logger = LoggerFactory.getLogger(NaverBookAPIController.class);

  //public static final String TITLE = "d_titl";

  private final NaverBookService naverBookService;

  public NaverBookAPIController(NaverBookService naverBookService) {
    this.naverBookService = naverBookService;
  }

  /**
   * Open API Call
   */
  @GetMapping("/search/{queryType}")
  public NvBookInfo getOpenAPIByTitle(@PathVariable("queryType") String queryType
      , @RequestParam("keyword") String keyword) {
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

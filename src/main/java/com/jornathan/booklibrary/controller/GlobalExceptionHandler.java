/*
    각 Exception의 구현 순서는 예외의 단계에 맞게 해야 합니다.
    그렇지 랂으면 상단에서 모두 처리 해 버림
*/
package com.jornathan.booklibrary.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

  //    @ResponseStatus(HttpStatus.BAD_REQUEST)
  //    @ExceptionHandler(value = BaseException.class)
  //    public String handlerBaseException(BaseException e) {
  //        return e.getMessage();
  //    }

  @ExceptionHandler(value = ArithmeticException.class)
  public Map<String, String> handleArithmeticExceptionHandler(ArithmeticException e) {
    Map<String, String> result = new HashMap<>();

    result.put("errorMsg", e.getMessage());
    result.put("status", "error");

    return result;
  }

  @ExceptionHandler(value = Exception.class)
  public Map<String, String> handleException(Exception e) {
    Map<String, String> result = new HashMap<>();

    result.put("errorMsg", e.getMessage());
    result.put("status", "error");

    return result;
  }

  //    @ExceptionHandler(value = NumberFormatException.class)
  //    public String nfeHandler(NumberFormatException e){
  //        return e.getMessage();
  //    }

}

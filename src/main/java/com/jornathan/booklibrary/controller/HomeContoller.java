package com.jornathan.booklibrary.controller;

import com.jornathan.booklibrary.annotation.TokenRequired;
import com.jornathan.booklibrary.service.SecurityService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/books/security")
public class HomeContoller {

  private final SecurityService securityService;

  public HomeContoller(SecurityService securityService) {
    this.securityService = securityService;
  }

  @GetMapping("/token")
  public Map<String, Object> generateToken(@RequestParam(value = "subject") String subject) {
    String token = securityService.createToken(subject, (2 * 1000 * 60));
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("userid", subject);
    map.put("result", token);
    return map;
  }

  @ResponseBody
  @GetMapping("/subject")
  public Map<String, Object> getSubject(@RequestParam("token") String token) {
    String subject = securityService.getSubject(token);
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("result", subject);
    return map;
  }

  @ResponseBody
  @GetMapping("/test/aop/with/annotation")
  @TokenRequired
  public Map<String, Object> testAOPAnnotation() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("result", "Aloha");

    return map;
  }
}

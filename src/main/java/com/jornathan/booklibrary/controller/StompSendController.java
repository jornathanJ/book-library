package com.jornathan.booklibrary.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books/message")
public class StompSendController {

  private final ObjectMapper objectMapper;

  private final SimpMessagingTemplate messagingTemplate;

  public StompSendController(ObjectMapper objectMapper,
                             SimpMessagingTemplate messagingTemplate) {
    this.objectMapper = objectMapper;
    this.messagingTemplate = messagingTemplate;
  }

  @PostMapping(path = "/send")
  public ResponseEntity<String> send(@RequestParam("topic") String topic,
                                     @RequestBody Object objectMessage) throws JsonProcessingException {


    String message = objectMapper.writeValueAsString(objectMessage);
    String result = "Send : " + message;
    messagingTemplate.convertAndSend(topic, message);
    return new ResponseEntity<>(result, HttpStatus.OK);
  }
}

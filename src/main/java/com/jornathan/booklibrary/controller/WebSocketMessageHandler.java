package com.jornathan.booklibrary.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.util.Objects;

@Controller
public class WebSocketMessageHandler {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  private final SimpMessagingTemplate messagingTemplate;

  public WebSocketMessageHandler(SimpMessagingTemplate messagingTemplate){
    this.messagingTemplate = messagingTemplate;
  }

  @MessageMapping("/hello")
  public void hello(SimpMessageHeaderAccessor accessor,
                    String message) {

    logger.debug("accessor : {}", accessor);
    messagingTemplate.convertAndSend("/topic/greetings", message);
  }

  @MessageMapping("/topic/demo")
  public void hello2(SimpMessageHeaderAccessor accessor,
                     String message) {

    logger.debug("accessor : {}", accessor);
    messagingTemplate.convertAndSend("/topic/demo", message);
  }

  @MessageMapping("/demo")
  public void hello3(SimpMessageHeaderAccessor accessor,
                     String message) {

    messagingTemplate.convertAndSend("/topic/demo", message);
  }

  @MessageMapping("/notification/to/{username}")
  public void directNotificationMessage(SimpMessageHeaderAccessor accessor,
                                        @DestinationVariable String username,
                                        Message message) {

    logger.debug("[WS-{}] Send apm message from {} to {} : {}", accessor.getSessionId(), Objects.requireNonNull(accessor.getUser()).getName(), username, message);

    //notificationService.sendNotificationToSocket(accessor.getUser().getName(), apmMessage);
  }

}

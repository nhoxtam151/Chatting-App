package com.ductam.chatapp.config;

import com.ductam.chatapp.model.Message;
import com.ductam.chatapp.model.Message.MessageType;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;


@Component
public class WebSocketEventListener {

  private final SimpMessageSendingOperations messageSendingOperations;

  public WebSocketEventListener(SimpMessageSendingOperations messageSendingOperations) {
    this.messageSendingOperations = messageSendingOperations;
  }

  @EventListener
  public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
    StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
    String username =  (String) headerAccessor.getSessionAttributes().get("username");
    if(username != null) {
      Message message = new Message(username, null, MessageType.LEAVE);
      messageSendingOperations.convertAndSend("/topic/public", message);
    }
  }
}

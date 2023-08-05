package com.ductam.chatapp.model;

public class Message {
  private String sender;
  private String content;

  private MessageType type;

  public enum MessageType {
    CHAT, LEAVE, JOIN
  }

  public Message(String sender, String content, MessageType type) {
    this.sender = sender;
    this.content = content;
    this.type = type;
  }

  public String getSender() {
    return sender;
  }

  public void setSender(String sender) {
    this.sender = sender;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public MessageType getType() {
    return type;
  }

  public void setType(MessageType type) {
    this.type = type;
  }
}

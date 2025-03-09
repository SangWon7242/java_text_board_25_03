package com.sbs.java.text_board;

public class Article {
  int id;
  String subject;
  String content;

  @Override
  public String toString() {
    return "{id: %d, subject: \"%s\", content: \"%s\"}".formatted(id, subject, content);
  }
}

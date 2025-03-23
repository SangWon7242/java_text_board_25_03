package com.sbs.java.text_board.article.dto;

import lombok.*;

@AllArgsConstructor
@Data
public class Article {
  private final int id;
  private String subject;
  private String content;
}

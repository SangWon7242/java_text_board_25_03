package com.sbs.java.text_board.article.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Article {
  private int id;
  private String subject;
  private String content;
}

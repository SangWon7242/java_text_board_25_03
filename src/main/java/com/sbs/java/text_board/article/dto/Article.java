package com.sbs.java.text_board.article.dto;

import lombok.*;

@AllArgsConstructor
@Data
public class Article {
  private final int id;
  private String subject;
  private String content;
  private int memberId;
  private String writerName; // 작성자명
}

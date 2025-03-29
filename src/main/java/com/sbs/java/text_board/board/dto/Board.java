package com.sbs.java.text_board.board.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Board {
  private final int id;
  private String name;
  private String code;
}

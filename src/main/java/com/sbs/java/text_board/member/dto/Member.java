package com.sbs.java.text_board.member.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Member {
  private final int id;
  private String loginId;
  private String loginPw;
  private String name;
}

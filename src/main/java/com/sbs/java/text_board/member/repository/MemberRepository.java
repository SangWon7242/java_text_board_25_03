package com.sbs.java.text_board.member.repository;

import com.sbs.java.text_board.member.dto.Member;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class MemberRepository {
  private List<Member> members;
  private int lastId;

  public MemberRepository() {
    members = new ArrayList<>();
    lastId = 0;

    makeMemberTestData();
  }

  public void makeMemberTestData() {
    IntStream.rangeClosed(1, 3)
        .forEach(i -> join("user" + i, "user" + i, "이름" + i));
  }

  public void join(String loginId, String loginPw, String name) {
    int id = ++lastId;

    Member member = new Member(id, loginId, loginPw, name);

    members.add(member);
  }

  public Member findByLoginId(String loginId) {
    return members.stream()
        .filter(member -> member.getLoginId().equals(loginId))
        .findFirst()
        .orElse(null);
  }

  public Member findById(int id) {
    return members.stream()
        .filter(member -> member.getId() == id)
        .findFirst()
        .orElse(null);
  }
}

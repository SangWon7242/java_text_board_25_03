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
    join("user1", "1234", "양관식");
    join("user2", "12345", "오애순");
    join("love", "5566", "양금명");
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

package com.sbs.java.text_board.session;

import java.util.HashMap;
import java.util.Map;

public class Session {
  Map<String, Object> sessionStore;
  
  public Session() {
    sessionStore = new HashMap<>();
  }
  
  // 세션 생성
  public void setAttribute(String attName, Object value) {
    sessionStore.put(attName, value);
  }
  
  // 세션 조회
  public Object getAttribute(String attrName) {
    return sessionStore.get(attrName);
  }
  
  // 세션 제거
  public void removeAttribute(String attrName) {
    sessionStore.remove(attrName);
  }
  
  // 세션 존재 여부
  public boolean hasAttribute(String attrName) {
    return sessionStore.containsKey(attrName);
  }
}

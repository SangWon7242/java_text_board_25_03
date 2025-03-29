package com.sbs.java.text_board.base;

import com.sbs.java.text_board.container.Container;
import com.sbs.java.text_board.session.Session;
import com.sbs.java.text_board.util.Util;
import lombok.Getter;

import java.util.Map;

public class Rq {
  private String url;
  @Getter
  private Map<String, String> params;

  @Getter
  private String urlPath;

  @Getter
  private Session session;

  public String loginedMember = "loginedMember";

  public Rq() {
    session = Container.session;
  }

  public void setCommand(String url) {
    this.url = url;
    params = Util.getParamsFromUrl(this.url);
    urlPath = Util.getPathFromUrl(this.url);
  }

  public int getIntParam(String paramName, int defaultValue) {
    if(!params.containsKey(paramName)) {
      return defaultValue;
    }

    try {
      return Integer.parseInt(params.get(paramName));
    } catch (NumberFormatException e) {
      return defaultValue;
    }
  }

  public String getParam(String paramName, String defaultValue) {
    if(!params.containsKey(paramName)) return defaultValue;

    return params.get(paramName);
  }
  
  // 세션에서 로그인 되어 있는지 확인
  public boolean isLogined() {
    return hasSessionAttr(loginedMember);
  }

  // 세션에서 로그아웃 되어 있는지 확인
  public boolean isLogout() {
    return !isLogined();
  }

  public void setSessionAttr(String attrName, Object value) {
    session.setAttribute(attrName, value);
  }

  public Object getSessionAttr(String attrName) {
    return session.getAttribute(attrName);
  }

  public void removeSessionAttr(String attrName) {
    session.removeAttribute(attrName);
  }

  public boolean hasSessionAttr(String attrName) {
    return session.hasAttribute(attrName);
  }
}

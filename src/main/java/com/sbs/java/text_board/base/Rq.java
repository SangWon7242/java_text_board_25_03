package com.sbs.java.text_board.base;

import com.sbs.java.text_board.util.Util;

import java.util.Map;

public class Rq {
  private String url;
  private Map<String, String> params;
  private String urlPath;

  public Rq(String url) {
    this.url = url;
    params = Util.getParamsFromUrl(this.url);
    urlPath = Util.getPathFromUrl(this.url);
  }

  public Map<String, String> getParams() {
    return params;
  }

  public String getUrlPath() {
    return urlPath;
  }
}

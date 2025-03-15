package com.sbs.java.text_board.base;

import com.sbs.java.text_board.util.Util;

import java.util.Map;

public class Rq {
  public String url;
  public Map<String, String> params;
  public String urlPath;

  public Rq(String url) {
    this.url = url;
    params = Util.getParamsFromUrl(this.url);
    urlPath = Util.getPathFromUrl(this.url);
  }

  Map<String, String> getParams() {
    return params;
  }

  String getUrlPath() {
    return urlPath;
  }
}

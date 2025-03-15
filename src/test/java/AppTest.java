import java.util.HashMap;
import java.util.Map;

public class AppTest {
  public static void main(String[] args) {
    Rq rq = new Rq("/usr/article/write?subject=자바 코드 질문 있어요.&content=자바에서 1+2=3을 어떻게 표현하나요?&writerName=홍길동&boardId=1");
    Map<String, String> params = rq.getParams();
    System.out.println(params);
    System.out.println(rq.getParams());
    System.out.println(rq.getParams());

    String urlPath = rq.getUrlPath();
    System.out.println(urlPath); // /usr/article/write
    System.out.println(rq.getUrlPath());
    System.out.println(rq.getUrlPath());
  }
}

class Rq {
  String url;
  Map<String, String> params;
  String urlPath;

  Rq(String url) {
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

class Util {
  static Map<String, String> getParamsFromUrl(String url) {
    System.out.println("getParamsFromUrl 실행!!!");
    Map<String, String> params = new HashMap<>();

    String[] urlBits = url.split("\\?", 2);

    if(urlBits.length == 1) return params;

    String queryStr = urlBits[1];

    for(String bit : queryStr.split("&")) {
      String[] bits = bit.split("=", 2);

      if(bits.length == 1) continue;

      params.put(bits[0], bits[1]);
    }

    return params;
  }

  static String getPathFromUrl(String url) {
    System.out.println("getPathFromUrl 실행!!!");
    return url.split("\\?", 2)[0];
  }
}
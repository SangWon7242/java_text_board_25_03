import java.util.HashMap;
import java.util.Map;

public class AppTest {
  public static void main(String[] args) {
    // 파라미터 분석
    String url = "/usr/article/write?subject=자바 코드 질문 있어요.&content=자바에서 1+2=3을 어떻게 표현하나요?&writerName=홍길동&boardId=1";
    Map<String, String> params = Util.getParamsFromUrl(url);
    System.out.println(params);

    System.out.println(params.get("subject")); // 자바 코드 질문 있어요.
    System.out.println(params.get("content")); // 자바에서 1+2=3을 어떻게 표현하나요?
    System.out.println(params.get("writerName")); // 홍길동
    System.out.println(params.get("boardId")); // 1

  }
}

class Util {
  static Map<String, String> getParamsFromUrl(String url) {
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
}
import java.util.LinkedHashMap;
import java.util.Map;


public class AppTest {
  public static void main(String[] args) {
    String queryString1 = "subject=제목1&content=내용1&writerName=홍길동&boardId=1";
    Map<String, String> params1 = Util.getParams(queryString1);
    System.out.println(params1);

    String queryString2 = "id=20&subject=제목수정1&content=내용수정1&writerName=임꺽정";
    Map<String, String> params2 = Util.getParams(queryString2);
    System.out.println(params2);
  }
}

class Util {
  static Map<String, String> getParams(String queryStr) {
    Map<String, String> params = new LinkedHashMap<>();

    String[] queryStringBits1 = queryStr.split("&");

    for(String bit : queryStringBits1) {
      String[] bitBits = bit.split("=");

      params.put(bitBits[0], bitBits[1]);
    }

    return params;
  }
}
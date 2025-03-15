import java.util.*;

public class AppTest {
  public static void main(String[] args) {
    String queryString = "subject=제목1&content=내용1&writerName=홍길동&boardId=1";
    String[] queryStringBits = queryString.split("&");

    Map<String, String> params = new LinkedHashMap<>();

    for(String bit : queryStringBits) {
      String[] bitBits = bit.split("=");

      params.put(bitBits[0], bitBits[1]);
    }

    System.out.println(params);

    System.out.println("== 원하는 것을 하나씩 출력 ==");
    System.out.printf("subject : %s\n", params.get("subject"));
    System.out.printf("content : %s\n", params.get("content"));
    System.out.printf("writerName : %s\n", params.get("writerName"));
    System.out.printf("boardId : %d\n", Integer.parseInt(params.get("boardId")));

    System.out.println("== 반복문을 이용한 순회 ==");
    params.forEach((key, value) -> System.out.printf("%s : %s\n", key, value));
  }
}

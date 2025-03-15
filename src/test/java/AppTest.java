import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppTest {
  public static void main(String[] args) {
    String queryString = "content=내용1&writerName=홍길동&boardId=1&subject=제목1";
    String[] queryStringBits = queryString.split("&");
    System.out.println(queryStringBits);
    System.out.println(Arrays.toString(queryStringBits));

    List<String> paramNames = new ArrayList<>();
    List<String> paramValues = new ArrayList<>();

    for(String bit : queryStringBits) {
      String[] bitBits = bit.split("=");

      String paramName = bitBits[0];
      String paramValue = bitBits[1];

      paramNames.add(paramName);
      paramValues.add(paramValue);
      // System.out.printf("%s : %s\n", paramName, paramValue);
    }

    System.out.println(paramNames);
    System.out.println(paramValues);

    int findIndex = paramNames.indexOf("subject");
    System.out.println(paramValues.get(findIndex));
  }
}

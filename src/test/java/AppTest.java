import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppTest {
  public static void main(String[] args) {
    String queryString = "d=4&a=1&b=2&c=3&f=4";
    String[] queryStringBits = queryString.split("&");
    System.out.println(queryStringBits);
    System.out.println(Arrays.toString(queryStringBits));

    List<String> paramNames = new ArrayList<>();
    List<Integer> paramValues = new ArrayList<>();

    for(String bit : queryStringBits) {
      String[] bitBits = bit.split("=");

      String paramName = bitBits[0];
      String paramValue = bitBits[1];

      paramNames.add(paramName);
      paramValues.add(Integer.parseInt(paramValue));
      // System.out.printf("%s : %s\n", paramName, paramValue);
    }

    for(int i = 0; i < paramNames.size(); i++) {
      String paramName = paramNames.get(i);
      int paramValue = paramValues.get(i);

      System.out.printf("%s : %d\n", paramName, paramValue);
    }

  }
}

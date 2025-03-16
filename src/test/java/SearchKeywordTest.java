import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class SearchKeywordTest {
  public static void main(String[] args) {
    List<Article> articles = new ArrayList<>();

    IntStream.rangeClosed(1, 5)
        .forEach(
            i -> articles.add(new Article(i, "제목" + i, "내용" + i))
        );

    articles.add(new Article(6, "자바는 무슨 언어입니까?", "자바가 무슨 언어인지 궁금해서 질문 남겨요."));
    articles.add(new Article(7, "코딩 실력이 빨리 늘려면 어떻게 하나요?", "코딩 실력이 빠르게 늘고 싶어요."));

    String searchKeyword = "내용5";

    List<Article> filteredArticles = new ArrayList<>();

    for(Article article : articles) {
      if(article.subject.contains(searchKeyword) || article.content.contains(searchKeyword)) {
        filteredArticles.add(article);
      }
    }

    filteredArticles.forEach(System.out::println);
  }
}

class Article {
  int id;
  String subject;
  String content;

  public Article(int id, String subject, String content) {
    this.id = id;
    this.subject = subject;
    this.content = content;
  }

  @Override
  public String toString() {
    return "{id: %d, subject: \"%s\", content: \"%s\"}".formatted(id, subject, content);
  }
}



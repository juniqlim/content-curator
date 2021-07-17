package im.juniq.contentcurator.content;

import static org.assertj.core.api.Assertions.assertThat;

import im.juniq.contentcurator.rss.ConvertToArticle;
import im.juniq.contentcurator.rss.FeedReaderTest;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ArticleServiceTest {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private ArticleRepository articleRepository;

    @Test
    void save() {
        Article article = Article.of("test", "title", "content", "tags", "test");
        articleService.create(article);
        List<Article> articles = articleRepository.findAll();
        assertThat(articles.get(0).getCategory()).isEqualTo("test");
    }

    @Test
    void findByTitle() {
        List<Article> articles = articleRepository.findByTitle("title");
        assertThat(articles.get(0).getCategory()).isEqualTo("test");
    }

    @Test
    void fetchAndSave() {
        articleService.create(ConvertToArticle.convert(FeedReaderTest.feed.getEntries()));
        List<Article> articles = articleRepository.findAll();
        assertThat(articles.size()).isGreaterThan(0);

        articleRepository.findByTitleLike("포트").stream()
            .forEach(article -> System.out.println("article.getTitle() = " + article.getTitle()));
    }
}
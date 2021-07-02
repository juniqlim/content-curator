package im.juniq.contentcurator.content;

import static org.assertj.core.api.Assertions.assertThat;

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
    void create() {
        Article article = Article.of("test", "title", "content", "tags", "test");
        articleService.create(article);
        List<Article> articles = articleRepository.findAll();
        assertThat(articles.get(0).getCategory()).isEqualTo("test");
    }
}
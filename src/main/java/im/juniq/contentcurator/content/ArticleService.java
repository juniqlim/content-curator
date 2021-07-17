package im.juniq.contentcurator.content;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    public void create(Article article) {
        articleRepository.save(article);
    }

    public void create(List<Article> articles) {
        articleRepository.saveAll(articles);
    }

    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    public List<Article> findByTitle(String title) {
        return articleRepository.findByTitle(title);
    }
}

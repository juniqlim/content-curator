package im.juniq.contentcurator.content;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findByTitle(String title);

    List<Article> findByTitleLike(String title);
}

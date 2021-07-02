package im.juniq.contentcurator.content;

import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.Test;

class ArticleTest {
    @Test
    void create() {
        assertThatCode(() -> Article.of("test", "title", "content", "tags", "test")).doesNotThrowAnyException();
    }
}

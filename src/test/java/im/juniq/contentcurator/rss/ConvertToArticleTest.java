package im.juniq.contentcurator.rss;

import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.Test;

class ConvertToArticleTest {
    @Test
    void convert() {
        assertThatCode(() -> ConvertToArticle.convert(FeedReaderTest.feed.getEntries())).doesNotThrowAnyException();
    }
}

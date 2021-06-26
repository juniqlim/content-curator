package im.juniq.contentcurator.rss;

import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.Test;

class FeedParserTest {
    @Test
    void test() {
        FeedParser parser = new FeedParser("https://rss.blog.naver.com/new10yrs.xml");
        assertThatCode(parser::readFeed).doesNotThrowAnyException();
    }
}
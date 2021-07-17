package im.juniq.contentcurator.rss;

import static org.assertj.core.api.Assertions.assertThatCode;

import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import java.io.IOException;
import java.net.URL;
import org.junit.jupiter.api.Test;

public class FeedReaderTest {
    public static SyndFeed feed;

    static {
        SyndFeedInput input = new SyndFeedInput();
        input.setPreserveWireFeed(true);
        try {
            feed = input.build(new XmlReader(new URL("https://rss.blog.naver.com/arystal.xml")));
        } catch (FeedException | IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void test() {
        assertThatCode(() -> ((CustomItem)feed.getEntries().get(0).getWireEntry()).getTags()).doesNotThrowAnyException();
    }
}
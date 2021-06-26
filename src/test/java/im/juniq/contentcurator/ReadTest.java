package im.juniq.contentcurator;

import im.juniq.contentcurator.rss.Feed;
import im.juniq.contentcurator.rss.FeedMessage;
import im.juniq.contentcurator.rss.FeedParser;

public class ReadTest {
    public static void main(String[] args) {
        FeedParser parser = new FeedParser(
                "https://rss.blog.naver.com/new10yrs.xml");
        Feed feed = parser.readFeed();
        System.out.println(feed);
        for (FeedMessage message : feed.getMessages()) {
            System.out.println(message);

        }

    }
}
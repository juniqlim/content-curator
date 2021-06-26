package im.juniq.contentcurator.rss;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class FeedMessage {
    private String author;
    private String category;
    private String title;
    private String link;
    private String guid;
    private String description;
    private LocalDateTime pubDate;
    private String tag;
}
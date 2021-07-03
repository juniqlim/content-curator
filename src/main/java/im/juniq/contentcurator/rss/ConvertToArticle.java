package im.juniq.contentcurator.rss;

import com.rometools.rome.feed.synd.SyndEntry;
import im.juniq.contentcurator.content.Article;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertToArticle {
    public static List<Article> convert(List<SyndEntry> entries) {
        return entries.stream()
            .map(entry -> ((CustomItem) entry.getWireEntry()).convert())
            .collect(Collectors.toList());
    }
}

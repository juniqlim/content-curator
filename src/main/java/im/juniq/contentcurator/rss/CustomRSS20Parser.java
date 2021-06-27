package im.juniq.contentcurator.rss;

import com.rometools.rome.io.impl.RSS20Parser;
import java.util.Locale;
import lombok.SneakyThrows;
import org.jdom2.Element;

public class CustomRSS20Parser extends RSS20Parser {
    @SneakyThrows
    @Override
    public CustomItem parseItem(final Element rssRoot, final Element eItem, final Locale locale) {
        final CustomItem item = CustomItem.of(super.parseItem(rssRoot, eItem, locale));
        final Element tags = eItem.getChild("tag", getRSSNamespace());
        if (tags != null) {
            item.setTags(tags.getText());
        }
        return item;
    }
}

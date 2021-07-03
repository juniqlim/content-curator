package im.juniq.contentcurator.rss;

import com.rometools.rome.feed.rss.Category;
import com.rometools.rome.feed.rss.Item;
import im.juniq.contentcurator.content.Article;
import java.lang.reflect.InvocationTargetException;
import java.util.stream.Collectors;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;

public class CustomItem extends Item {
    private String tags;

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public static CustomItem of(Item item) throws InvocationTargetException, IllegalAccessException {
        BeanUtilsBean.getInstance().getConvertUtils().register(false, true, -1);
        CustomItem customItem = new CustomItem();
        BeanUtils.copyProperties(customItem, item);
        return customItem;
    }

    public Article convert() {
        return Article.of(getCategories().stream()
                .map(Category::getValue)
                .collect(Collectors.joining(",")),
            getTitle(), getDescription().getValue(), getTags(), getAuthor());
    }
}

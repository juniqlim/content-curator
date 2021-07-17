package im.juniq.contentcurator.content;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.ToString;

@Entity
@Getter @ToString
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String category;
    private String title;
    @Column(length = 2000)
    private String content;
    private String tags;
    private String createdBy;
    private LocalDateTime createdAt;

    protected Article() {
    }

    private Article(String category, String title, String content, String tags, String createdBy) {
        this.category = category;
        this.title = title;
        this.content = content;
        this.tags = tags;
        this.createdBy = createdBy;
        this.createdAt = LocalDateTime.now();
    }

    public static Article of(String category, String title, String content, String tags, String createdBy) {
        return new Article(category, title, content, tags, createdBy);
    }
}

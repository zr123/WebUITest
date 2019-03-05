package poc;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@XmlRootElement(name = "article")
@XmlAccessorType(XmlAccessType.FIELD)
public class Article{

    @XmlElement
    public String author;

    @XmlElement
    public String title;

    @XmlElement
    public String content;

    @XmlElement
    public Date date;

    @XmlElement
    public String category;

    public Article(){}

    public Article(String author, String title, String content){
        this.author = author;
        this.title = title;
        this.content = content;
        this.date = new Date();
    }

    public static List<Article> loadArticles(String text){
        return null;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}

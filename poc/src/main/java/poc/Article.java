package poc;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import java.io.File;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@XmlRootElement(name = "article")
@XmlAccessorType(XmlAccessType.FIELD)
public class Article{

    @XmlElement
    public String author = "";

    @XmlElement
    public String title = "";

    @XmlElement
    public String content = "";

    @XmlElement
    public Date date = new Date(0);

    @XmlElement
    public String category = "";

    public Article(){}

    public Article(String author, String title, String content){
        this.author = author;
        this.title = title;
        this.content = content;
        this.date = new Date();
    }

    public static void exportArticles(List<Article> articles, String path) throws JAXBException {
        File file = new File(path);
        JAXBContext context = JAXBContext.newInstance(Articles.class);
        Marshaller marshaller = context.createMarshaller();
        Articles articlesObject = new Articles(articles);
        marshaller.marshal(articlesObject, file);
    }

    public static List<Article> importArticles(String path) throws JAXBException {
        File file = new File(path);
        JAXBContext context = JAXBContext.newInstance(Articles.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Articles articles = (Articles) unmarshaller.unmarshal(file);
        return articles.getArticles();
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

    public boolean equals(Object obj){
        if(obj.getClass() != Article.class)
            return false;
        Article article = (Article) obj;
        return  this.author.equals(article.author) &&
                this.title.equals(article.title) &&
                this.content.equals(article.content) &&
                this.date.equals(article.date) &&
                this.category.equals(article.category);
    }
}

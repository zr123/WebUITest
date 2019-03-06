package poc;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

@XmlRootElement(name = "article")
@XmlAccessorType(XmlAccessType.FIELD)
public class Article{

    @XmlElement
    private String author = "";

    @XmlElement
    private String title = "";

    @XmlElement
    private String content = "";

    @XmlElement
    private Date date;

    @XmlElement
    private String category = "";

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

    public static List<Article> filterArticleCategories(List<Article> articles, String category){
        if(articles == null)
            return new ArrayList<>();
        if(category == null || category.isEmpty())
            return new ArrayList<>(articles);
        return articles.stream().filter(a -> category.equals(a.getCategory())).collect(Collectors.toList());
    }

    public static List<Article> filterArticleCategories(List<Article> articles, List<String> categories){
        if(articles == null)
            return new ArrayList<>();
        if(categories == null || categories.isEmpty())
            return new ArrayList<>(articles);
        return articles.stream().filter(a -> categories.contains(a.getCategory())).collect(Collectors.toList());
    }

    public static List<Article> sortArticlesByDate(List<Article> articles){
        if(articles == null)
            return new ArrayList<>();
        return articles.stream().sorted(Comparator.comparing(Article::getDate).reversed()).collect(Collectors.toList());
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
        if(!(obj instanceof Article))
            return false;
        Article article = (Article) obj;
        return
            Objects.equals(this.author, article.author) &&
            Objects.equals(this.title, article.title) &&
            Objects.equals(this.content, article.content) &&
            Objects.equals(this.category, article.category) &&
            Objects.equals(this.date, article.date);
    }
}

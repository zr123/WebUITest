package beans;

import poc.Article;
import poc.Category;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
public class IndexBean {

    private List<Article> articles;

    private List<SelectItem> categories;

    @PostConstruct
    public void init(){
        articles = new ArrayList<>();
        articles.add(new Article("zr123", "story 1" , "Lorem Ipsum usw."));
        articles.add(new Article("zr123", "story 2" , "blabalbla"));

        categories = new ArrayList<>();
        for (Category category : Category.getCategories()) {
            categories.add(new SelectItem(category.getName(), category.getName()));
        }
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public List<SelectItem> getCategories() {
        return categories;
    }

    public void setCategories(List<SelectItem> categories) {
        this.categories = categories;
    }

}

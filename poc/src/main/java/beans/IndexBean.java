package beans;

import poc.Article;
import poc.Category;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBException;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
public class IndexBean {

    private List<Article> articles;

    private List<SelectItem> categories;

    @PostConstruct
    public void init(){
        try {
            articles = Article.importArticles("src/main/resources/articles.xml");
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        categories = new ArrayList<>();
        for (Category category : Category.getCategories()) {
            categories.add(new SelectItem(category.getName(), category.getName()));
        }
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String filter = req.getParameter("category");
        articles = Article.filterArticleCategories(articles, filter);
    }

    public void filterCategories(){
        throw new NotImplementedException();
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

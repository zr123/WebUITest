package beans;

import poc.Article;
import poc.Category;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBException;
import java.util.List;

@ManagedBean
public class IndexBean {

    private List<Article> articles;

    private List<SelectItem> categories;

    public static String articleFile = "src/main/resources/articles.xml";

    @PostConstruct
    public void init(){
        articles = loadArticles();
        categories = Category.getCategoriesAsSelectItems();
    }

    public static List<Article> loadArticles(){
        List<Article> articles = null;
        try {
            articles = Article.importArticles(articleFile);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return Article.sortArticlesByDate(filterArticles(articles));
    }

    public static List<Article> filterArticles(List<Article> articles){
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String filter = req.getParameter("category");
        return Article.filterArticleCategories(articles, filter);
    }

    public void filterCategories(){
        // TODO
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "test", null);
        FacesContext.getCurrentInstance().addMessage(null, message);
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

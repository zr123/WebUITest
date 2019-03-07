package beans;

import poc.Article;
import poc.Category;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ManagedBean
@ViewScoped
public class IndexBean {

    private List<Article> articles;

    private String selectedCategory;
    private String[] selectedCategories;
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

    public String filterAction(){
        return "/index.xhtml?faces-redirect=true&category=" + getSelectedCategoriesString();
    }

    public static List<Article> filterArticles(List<Article> articles){
        String param = getGETParameter("category");
        if(param != null){
            List<String> cats = Arrays.asList(param.split(" "));
            return Article.filterArticleCategories(articles, cats);
        }
        return articles;
    }

    private static String getGETParameter(String name){
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        return req.getParameter(name);
    }

    public String getSelectedCategoriesString(){
        if(selectedCategories == null)
            return "";
        else
            return String.join("+", selectedCategories);
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

    public String[] getSelectedCategories() {
        return selectedCategories;
    }

    public void setSelectedCategories(String[] selectedCategories) {
        this.selectedCategories = selectedCategories;
    }

    public String getSelectedCategory() {
        return selectedCategory;
    }

    public void setSelectedCategory(String selectedCategory) {
        this.selectedCategory = selectedCategory;
    }
}

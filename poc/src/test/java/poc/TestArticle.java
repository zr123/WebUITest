package poc;

import org.junit.BeforeClass;
import org.junit.Test;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class TestArticle {

    private static List<Article> articles = new ArrayList<>();

    @BeforeClass
    public static void init(){
        articles.add(new Article("zr123", "Title", "Content"));
        articles.get(0).setDate(null);
        articles.get(0).setCategory("Politics");
        articles.add(new Article("someone", "test", "Lorem Ipsum"));
        articles.get(1).setDate(null);
        articles.get(1).setCategory("Sports");
        articles.add(new Article("Picasso", "Photos", "Insert Photos here"));
        articles.get(2).setDate(null);
        articles.get(2).setCategory("Photography");
    }

    @Test
    public void testExportArticles() throws JAXBException, IOException {
        Article.exportArticles(articles,"src/test/resources/export.xml");
        File file = new File("src/test/resources/export.xml");
        assertTrue(file.exists());
        List<String> lines = Files.readAllLines(Paths.get("src/test/resources/export.xml"));
        assertEquals(
                "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><articles><article><author>zr123</author><title>Title</title><content>Content</content><category>Politics</category></article><article><author>someone</author><title>test</title><content>Lorem Ipsum</content><category>Sports</category></article><article><author>Picasso</author><title>Photos</title><content>Insert Photos here</content><category>Photography</category></article></articles>",
                lines.get(0)
        );
        assertTrue(file.delete());
    }

    @Test
    public void testImportArticles() throws JAXBException {
        List<Article> articleList = Article.importArticles("src/test/resources/import.xml");
        assertNotNull(articleList);
        assertEquals(articles.get(0), articleList.get(0));
        assertEquals(articles.get(1), articleList.get(1));
        assertEquals(articles.get(2), articleList.get(2));
    }

    @Test
    public void testFilterArticleCategories1(){
        List<Article> filteredArticles = Article.filterArticleCategories(articles, "Politics");
        assertEquals(filteredArticles.size(), 1);
        assertEquals(articles.size(), 3);
        assertEquals(articles.get(0), filteredArticles.get(0));
    }

    @Test
    public void testFilterArticleCategories2(){
        List<Article> filteredArticles = Article.filterArticleCategories(articles, "Sports");
        assertEquals(filteredArticles.size(), 1);
        assertEquals(articles.size(), 3);
        assertEquals(articles.get(1), filteredArticles.get(0));
    }

    @Test
    public void testFilterArticleCategories_empty(){
        List<Article> filteredArticles = Article.filterArticleCategories(articles, "");
        assertEquals(filteredArticles.size(), 3);
        assertEquals(articles.size(), 3);
        assertEquals(articles, filteredArticles);
    }

    @Test
    public void testFilterArticleCategories_null(){
        String nullString = null;
        List<Article> filteredArticles = Article.filterArticleCategories(articles, nullString);
        assertEquals(filteredArticles.size(), 3);
        assertEquals(articles.size(), 3);
        assertEquals(articles, filteredArticles);
    }

    @Test
    public void testFilterArticleCategories_nullList(){
        List<Article> filteredArticles = Article.filterArticleCategories(null, "");
        assertEquals(filteredArticles.size(), 0);
        assertEquals(articles.size(), 3);
    }

    @Test
    public void testFilterArticleCategoriesList1(){
        ArrayList<String> filter = new ArrayList<>();
        filter.add("Politics");
        filter.add("Photography");
        List<Article> filteredArticles = Article.filterArticleCategories(articles, filter);
        assertEquals(filteredArticles.size(), 2);
        assertEquals(articles.size(), 3);
        assertTrue(filteredArticles.contains(articles.get(0)));
        assertTrue(filteredArticles.contains(articles.get(2)));
    }

    @Test
    public void testFilterArticleCategoriesList2(){
        ArrayList<String> filter = new ArrayList<>();
        filter.add("Sports");
        filter.add("Art");
        List<Article> filteredArticles = Article.filterArticleCategories(articles, filter);
        assertEquals(filteredArticles.size(), 1);
        assertEquals(articles.size(), 3);
        assertTrue(filteredArticles.contains(articles.get(1)));
    }

    @Test
    public void testFilterArticleCategoriesList3(){
        ArrayList<String> filter = new ArrayList<>();
        filter.add("Unknown");
        List<Article> filteredArticles = Article.filterArticleCategories(articles, filter);
        assertEquals(filteredArticles.size(), 0);
        assertEquals(articles.size(), 3);
    }

    @Test
    public void testFilterArticleCategoriesList_empty(){
        List<Article> filteredArticles = Article.filterArticleCategories(articles, new ArrayList<>());
        assertEquals(filteredArticles.size(), 3);
        assertEquals(articles.size(), 3);
        assertEquals(articles, filteredArticles);
    }

    @Test
    public void testFilterArticleCategoriesList_null(){
        List<String> nullList = null;
        List<Article> filteredArticles = Article.filterArticleCategories(articles, nullList);
        assertEquals(filteredArticles.size(), 3);
        assertEquals(articles.size(), 3);
        assertEquals(articles, filteredArticles);
    }

    @Test
    public void testSortArticlesByDate(){
        List<Article> datedArticles = new ArrayList<>();
        datedArticles.add(new Article("", "oldest", ""));
        datedArticles.get(0).setDate(new Date(3600));
        datedArticles.add(new Article("", "newest", ""));
        datedArticles.get(1).setDate(new Date(7200));
        datedArticles.add(new Article("", "middle", ""));
        datedArticles.get(2).setDate(new Date(4800));
        List<Article> sortedArticles = Article.sortArticlesByDate(datedArticles);
        assertEquals("newest", sortedArticles.get(0).getTitle());
        assertEquals("middle", sortedArticles.get(1).getTitle());
        assertEquals("oldest", sortedArticles.get(2).getTitle());
    }
}

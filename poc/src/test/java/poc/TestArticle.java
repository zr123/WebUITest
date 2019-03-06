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

    static List<Article> articles = new ArrayList<>();

    @BeforeClass
    public static void init(){
        articles.add(new Article("zr123", "Title", "Content"));
        articles.get(0).setDate(new Date(0));
        articles.add(new Article("someone", "test", "Lorem Ipsum"));
        articles.get(1).setDate(new Date(0));
    }

    @Test
    public void testExportArticles() throws JAXBException, IOException {
        Article.exportArticles(articles,"src/test/resources/export.xml");
        File file = new File("src/test/resources/export.xml");
        assertTrue(file.exists());
        List<String> lines = Files.readAllLines(Paths.get("src/test/resources/export.xml"));
        assertEquals(
                "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><articles><article><author>zr123</author><title>Title</title><content>Content</content><date>1970-01-01T01:00:00+01:00</date><category></category></article><article><author>someone</author><title>test</title><content>Lorem Ipsum</content><date>1970-01-01T01:00:00+01:00</date><category></category></article></articles>",
                lines.get(0)
        );
        file.delete();
    }

    @Test
    public void testImportArticles() throws JAXBException {
        List<Article> articleList = Article.importArticles("src/test/resources/import.xml");
        assertNotNull(articleList);
        assertEquals(articles.get(0), articleList.get(0));
        assertEquals(articles.get(1), articleList.get(1));
    }
}

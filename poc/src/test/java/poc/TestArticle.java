package poc;

import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Test;
import poc.Article;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestArticle {

    @Test
    public void testExportArticles() throws JAXBException, IOException, ParseException {
        Articles articles = new Articles();
        articles.articles.add(new Article("zr123", "Title", "Content"));
        articles.articles.get(0).setDate(new Date(0));
        articles.articles.add(new Article("someone", "test", "Lorem Ipsum"));
        articles.articles.get(1).setDate(new Date(0));
        articles.exportArticles("src/test/resources/testfile.xml");
        File file = new File("src/test/resources/testfile.xml");
        assertTrue(file.exists());
        List<String> lines = Files.readAllLines(Paths.get("src/test/resources/testfile.xml"));
        assertEquals(
                "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><articles><article><author>zr123</author><title>Title</title><content>Content</content><date>1970-01-01T01:00:00+01:00</date></article><article><author>someone</author><title>test</title><content>Lorem Ipsum</content><date>1970-01-01T01:00:00+01:00</date></article></articles>",
                lines.get(0)
        );
        file.delete();
    }
}

package webapp;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class TestBlog {

    static WebDriver driver;

    @BeforeClass
    public static void init(){
        driver = new ChromeDriver();
    }

    @AfterClass
    public static void teardown(){
        driver.close();
    }

    @Before
    public void before(){
        driver.get("localhost:8090/index.xhtml");
    }

    @Test
    public void testTitle(){
        assertEquals("Ein Blog", driver.getTitle());
    }


}

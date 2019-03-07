package webapp;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        driver.get("http://localhost:8090/index.xhtml");
    }

    @Test
    public void testTitle(){
        assertEquals("Ein Blog", driver.getTitle());
    }

    @Test
    public void testHeader() throws InterruptedException {
        WebElement header = driver.findElement(By.id("header"));
        assertEquals("BLOG", header.getText());
    }


}

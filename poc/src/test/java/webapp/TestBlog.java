package webapp;

import org.junit.*;
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
        driver.get("localhost:8090");
    }

    @Test
    public void testTitle(){
        assertEquals("Ein Blog", driver.getTitle());
    }


}

package webapp;

import PrimeWrapper.DataListWrapper;
import org.junit.*;
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

    @Test
    public void testNumberOfArticles(){
        DataListWrapper dataList = new DataListWrapper(driver, "articlelist");
        Assert.assertEquals(4, dataList.getListElements().size());
    }

    @Test
    public void testSingleGetParameterCategory(){
        driver.get("http://localhost:8090/index.xhtml?category=Politics");
        DataListWrapper dataList = new DataListWrapper(driver, "articlelist");
        Assert.assertEquals(2, dataList.getListElements().size());
    }

    @Test
    public void testTwoGetParameterCategory(){
        driver.get("http://localhost:8090/index.xhtml?category=Politics+Photography");
        DataListWrapper dataList = new DataListWrapper(driver, "articlelist");
        Assert.assertEquals(3, dataList.getListElements().size());
    }

    @Test
    public void testThreeGetParameterCategory(){
        driver.get("http://localhost:8090/index.xhtml?category=Politics+Photography+Sports");
        DataListWrapper dataList = new DataListWrapper(driver, "articlelist");
        Assert.assertEquals(4, dataList.getListElements().size());
    }
}

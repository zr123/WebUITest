import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class TestGUI {

    @Test
    public void testMinimalWikipedia(){
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://google.com/");
        WebElement inputQuery = driver.findElement(By.name("q"));
        inputQuery.sendKeys("wikipedia");
        inputQuery.submit();
        driver.findElement(By.xpath("//h3[text()='Wikipedia']")).click();
        assertEquals("Wikipedia", driver.getTitle());
        driver.quit();
    }
}

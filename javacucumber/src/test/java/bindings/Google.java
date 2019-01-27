package bindings;

import cucumber.api.PendingException;
import cucumber.api.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class Google {
    WebDriver driver;


    @Given("^that i am on \"([^\"]*)\"$")
    public void thatIAmOn(String arg0) throws Throwable {
        System.setProperty("webdriver.chrome.driver", "C:\\Daten\\driver\\chromedriver.exe");
       driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(arg0);
        driver.manage().window().maximize();
    }

    @When("^i enter bundesbank and press enter$")
    public void iEnterBundesbankAndPressEnter() throws Throwable {
        driver.findElement(By.name("q")).sendKeys("bundesbank");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        Thread.sleep(1000);
    }

    @Then("^the first result will be the website of bundesbank$")
    public void theFirstResultWillBeTheWebsiteOfBundesbank() throws Throwable {
        driver.findElement(By.xpath("//h3[text()='Deutsche Bundesbank: Startseite']")).click();
        Thread.sleep(1000);
        driver.quit();
    }
}
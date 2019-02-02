package bindings;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;


public class Google {
    private WebDriver driver;

    @Before
    public void setup() throws Exception{
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Given("^that i am on \"([^\"]*)\"$")
    public void thatIAmOn(String arg0) throws Throwable {
        driver.get(arg0);
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
    }
}

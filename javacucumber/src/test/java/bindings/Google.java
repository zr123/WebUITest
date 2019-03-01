package bindings;

import cucumber.api.java.*;
import cucumber.api.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;


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

    @Given("^that I am on \"([^\"]*)\"$")
    public void that_I_am_on(String arg1) throws Throwable {
        driver.get(arg1);
    }

    @When("^I insert \"([^\"]*)\" and press enter$")
    public void i_insert_and_press_enter(String arg1) throws Throwable {
        WebElement input = driver.findElement(By.name("q"));
        input.sendKeys(arg1);
        input.submit();
    }

    @When("^I click the link with the text \"([^\"]*)\"$")
    public void i_click_the_link_with_the_text(String arg1) throws Throwable {
        driver.findElement(By.xpath("//*[text()='" + arg1 + "']")).click();
    }

    @Then("^then I will be on the website with the title \"([^\"]*)\"$")
    public void then_I_will_be_on_the_website_with_the_title(String arg1) throws Throwable {
        assertEquals(arg1, driver.getTitle());
    }
}

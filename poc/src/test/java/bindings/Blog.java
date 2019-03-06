package bindings;

import beans.IndexBean;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.de.Dann;
import cucumber.api.java.de.Gegebensei;
import cucumber.api.java.de.Wenn;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import poc.Article;

public class Blog {

    private WebDriver driver;

    @Before
    public void setup(){
        driver = new ChromeDriver();
    }

    @After
    public void teardown(){
        driver.close();
    }

    @Gegebensei("^ich bin auf dem Blog$")
    public void ich_bin_auf_dem_Blog() throws Throwable {
        driver.get("localhost:8090/index.xhtml");
    }

    @Dann("^möchte ich die neusten Blogeinträge sehen$")
    public void möchte_ich_die_neusten_Blogeinträge_sehen() throws Throwable {
        Article newestArticle = IndexBean.loadArticles().get(0);
        WebElement panel = driver.findElement(By.id("articlelist:0:articles"));
        // TODO fancy-schmancy PrimeWrapper benutzen
        Assert.assertEquals(newestArticle.getTitle(), driver.findElement(By.id("articlelist:0:articles_header")).getText());
    }

    @Wenn("^ich den Filter \"([^\"]*)\" anwende$")
    public void ich_den_Filter_anwende(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Dann("^möchte ich Einräge der Kategorie \"([^\"]*)\" sehen$")
    public void möchte_ich_Einräge_der_Kategorie_sehen(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Dann("^ich möchte keine Einträge außer \"([^\"]*)\" sehen$")
    public void ich_möchte_keine_Einträge_außer_sehen(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Gegebensei("^ich bin auf der Loginseite$")
    public void ich_bin_auf_der_Loginseite() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Wenn("^ein Benutzer seinen John und sein (\\d+) eingibt$")
    public void ein_Benutzer_seinen_John_und_sein_eingibt(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Dann("^soll er eingeloggt werden wenn es Ja$")
    public void soll_er_eingeloggt_werden_wenn_es_Ja() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Dann("^er soll nicht eingeloggt werden wenn es nicht Ja$")
    public void er_soll_nicht_eingeloggt_werden_wenn_es_nicht_Ja() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Wenn("^ein Benutzer seinen Eve und sein password eingibt$")
    public void ein_Benutzer_seinen_Eve_und_sein_password_eingibt() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Dann("^soll er eingeloggt werden wenn es Nein$")
    public void soll_er_eingeloggt_werden_wenn_es_Nein() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Dann("^er soll nicht eingeloggt werden wenn es nicht Nein$")
    public void er_soll_nicht_eingeloggt_werden_wenn_es_nicht_Nein() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}

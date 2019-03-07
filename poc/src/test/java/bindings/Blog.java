package bindings;

import PrimeWrapper.*;
import beans.IndexBean;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.de.Dann;
import cucumber.api.java.de.Gegebensei;
import cucumber.api.java.de.Und;
import cucumber.api.java.de.Wenn;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.primefaces.application.resource.PrimeResource;
import poc.Article;

import javax.swing.*;

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
        Article newestArticle = Article.sortArticlesByDate(Article.importArticles(IndexBean.articleFile)).get(0);

        DataListWrapper articleList = PrimeWrapper.findDataList(driver, "articlelist");
        WebElement articlePanel = articleList.getListElements().get(0);
        WebElement titleElement = articlePanel.findElement(By.xpath("div/div[1]"));
        Assert.assertEquals(newestArticle.getTitle(), titleElement.getText());
    }

    @Wenn("^ich den Filter \"([^\"]*)\" anwende$")
    public void ichDenFilterAnwende(String arg0) throws Throwable {
        SelectCheckboxMenuWrapper menu = PrimeWrapper.findSelectCheckboxMenu(driver, "menuform:categories");
        menu.selectItemByValue(arg0);
        driver.findElement(By.id("menuform:submitbutton")).click();
    }

    @Dann("^möchte ich Einräge der Kategorie \"([^\"]*)\" sehen$")
    public void möchteIchEinrägeDerKategorieSehen(String arg0) throws Throwable {
        DataListWrapper articlelist = PrimeWrapper.findDataList(driver, "articlelist");
        for (WebElement listElement : articlelist.getListElements()) {
            WebElement footer = listElement.findElement(By.xpath("div/div[3]"));
            Assert.assertTrue(footer.getText().contains("[" + arg0 + "]"));
        }
    }
}

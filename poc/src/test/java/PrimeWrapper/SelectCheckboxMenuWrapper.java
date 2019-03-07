package PrimeWrapper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectCheckboxMenuWrapper extends PrimeWrapper {

    public SelectCheckboxMenuWrapper(WebDriver driver, String id) {
        super(driver, id);
    }

    public void click(){
        node.findElement(By.xpath("//div[@id='" + id + "']/div[3]")).click();
    }

    public void selectItemByValue(String value) {
        openDropdownMenu();
        node.findElement(By.xpath("//div[@id='" + id + "_panel']//label[text()='" + value + "']")).click();
        closeDropdownMenu();
    }

    public void openDropdownMenu(){
        if(!isMenuOpen()) {
            click();
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='" + id + "_panel']")));
        }
    }

    public void closeDropdownMenu(){
        if(isMenuOpen()) {
            click();
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='" + id + "_panel']"))));
        }
    }

    private boolean isMenuOpen(){
        WebElement dropdownmenu = node.findElement(By.xpath("//div[@id='" + id + "_panel']"));
        return dropdownmenu.isDisplayed();
    }
}

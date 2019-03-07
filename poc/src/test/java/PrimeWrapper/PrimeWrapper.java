package PrimeWrapper;

import org.openqa.selenium.*;

import java.util.List;

public abstract class PrimeWrapper implements WebElement{

    WebDriver driver;
    String id;
    WebElement node;

    public PrimeWrapper(WebDriver driver, String id){
        this.driver = driver;
        this.id = id;
        node = driver.findElement(By.id(id));
    }

    public static SelectCheckboxMenuWrapper findSelectCheckboxMenu(WebDriver driver, String id) {
        return new SelectCheckboxMenuWrapper(driver, id);
    }

    public static DataListWrapper findDataList(WebDriver driver, String id){
        return new DataListWrapper(driver, id);
    }


    @Override
    public void click() {
        node.click();
    }

    @Override
    public void submit() {
        node.submit();
    }

    @Override
    public void sendKeys(CharSequence... charSequences) {
        node.sendKeys(charSequences);
    }

    @Override
    public void clear() {
        node.clear();
    }

    @Override
    public String getTagName() {
        return node.getTagName();
    }

    @Override
    public String getAttribute(String s) {
        return node.getAttribute(s);
    }

    @Override
    public boolean isSelected() {
        return node.isSelected();
    }

    @Override
    public boolean isEnabled() {
        return node.isEnabled();
    }

    @Override
    public String getText() {
        return node.getText();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return node.findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return node.findElement(by);
    }

    @Override
    public boolean isDisplayed() {
        return node.isDisplayed();
    }

    @Override
    public Point getLocation() {
        return node.getLocation();
    }

    @Override
    public Dimension getSize() {
        return node.getSize();
    }

    @Override
    public Rectangle getRect() {
        return node.getRect();
    }

    @Override
    public String getCssValue(String s) {
        return node.getCssValue(s);
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return node.getScreenshotAs(outputType);
    }
}

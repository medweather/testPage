package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddEntryPage extends BasePage{

    AddEntryPage(WebDriver webDriver) {
        super(webDriver);
    }

    private By header = By.xpath("//h1[contains(text(),'entry')]");
    private By title = By.id("id_title");
    private By slug = By.id("id_slug");
    private By textMarkdown = By.id("id_text_markdown");
    private By text = By.id("id_text");
    private By buttonSave = By.xpath("//input[@name='_save']");


    public boolean verifyHeader(String strHeader) {
        return driver.findElement(header).getText().equals(strHeader);
    }

    public BlogPage saveEntry(String titl, String sl, String testMark, String t) {
        driver.findElement(title).sendKeys(titl);
        driver.findElement(slug).sendKeys(sl);
        driver.findElement(textMarkdown).sendKeys(testMark);
        driver.findElement(text).sendKeys(t);
        driver.findElement(buttonSave).click();
        driver.get("http://igorakintev.ru/blog/");
        return new BlogPage(driver);
    }

}

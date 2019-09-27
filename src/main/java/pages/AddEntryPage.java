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

    public BlogPage saveEntry(String titl, String sl, String testMark, String t) throws InterruptedException {

        Thread.sleep(1000);
        driver.findElement(title).sendKeys(titl);

        Thread.sleep(1000);
        driver.findElement(slug).sendKeys(sl);

        Thread.sleep(1000);
        driver.findElement(textMarkdown).sendKeys(testMark);

        Thread.sleep(1000);
        driver.findElement(text).sendKeys(t);

        Thread.sleep(1000);
        driver.findElement(buttonSave).click();

        Thread.sleep(2000);
        driver.get("http://igorakintev.ru/blog/");

        Thread.sleep(2000);
        return new BlogPage(driver);
    }

}

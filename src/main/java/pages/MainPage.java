package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {

    private By header = By.xpath("//h1[@class='dashboard-title']");
    private By addEntries = By.xpath("//div[@id='module_2']//ul[1]//li[1]//ul[1]//li[1]//a[1]");

    MainPage(WebDriver driver) {
        super(driver);
    }

    public boolean verifyHeader(String strHeader) {
        return driver.findElement(header).getText().equals(strHeader);
    }

    public AddEntryPage addedEntries() {
        driver.findElement(addEntries).click();
        return new AddEntryPage(driver);
    }
}

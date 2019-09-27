package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminPanelPage extends BasePage {

    AdminPanelPage(WebDriver webDriver) {
        super(webDriver);
    }

    private By entry = By.xpath("//tbody//tr[1]//th[1]");
    private By delete = By.xpath("//a[@class='deletelink']");
    private By confirmDelete = By.xpath("//div[@id='content']//input[2]");

    public void deleteEntry() {
        driver.findElement(entry).findElement(By.tagName("a")).click();
        driver.findElement(delete).click();
        driver.findElement(confirmDelete).click();
    }

    public boolean verifyDeletedEntry(String strTitle) {
        driver.get("https://igorakintev.ru/admin/blog/entry/");
        return driver.findElement(entry).findElement(By.tagName("a")).getText().equals(strTitle);
    }
}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BlogPage extends BasePage {

    BlogPage(WebDriver webDriver) {
        super(webDriver);
    }

    private By entry = By.className("entry_title");

    public boolean verifyEntry(String strTitle) {
        return driver.findElement(entry).getText().equals(strTitle);
    }

    public AdminPanelPage getAdminPanel() {
        driver.get("https://igorakintev.ru/admin/blog/entry/");
        return new AdminPanelPage(driver);
    }
}

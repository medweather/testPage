package pages;

import org.openqa.selenium.WebDriver;

abstract class BasePage {

    WebDriver driver;

    BasePage(WebDriver webDriver) {
        this.driver = webDriver;
    }
}

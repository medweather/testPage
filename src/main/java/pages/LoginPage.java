package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    private By username = By.id("id_username");
    private By password = By.id("id_password");
    private By loginButton = By.xpath("//div[@class='submit-row']//input");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public MainPage loginToSite(String strUsername, String strPassword) throws InterruptedException {

        driver.findElement(username).sendKeys(strUsername);
        Thread.sleep(1000);

        driver.findElement(password).sendKeys(strPassword);
        Thread.sleep(1000);

        driver.findElement(loginButton).click();
        
        return new MainPage(driver);
    }
}

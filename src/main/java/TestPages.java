import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.*;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class TestPages {

    private WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://igorakintev.ru/admin/");
    }

    @Test
    private void autoTestSite() throws InterruptedException {

        // инициализируем логин-страницу
        LoginPage login = new LoginPage(driver);

        // заполняем поля, входим в систему и проверяем, что заголовок - "Панель управления"
        MainPage mainPage = login.loginToSite("selenium", "super_password");
        assertTrue(mainPage.verifyHeader("Панель управления"));

        // переходим на страницу "Добавить entry" и проверяем, что заголовок - "Добавить entry"
        AddEntryPage addPage = mainPage.addedEntries();
        assertTrue(addPage.verifyHeader("Добавить entry"));

        String randTitle = RandomStringUtils.randomAlphanumeric(10);
        String randSlug = RandomStringUtils.randomAlphanumeric(12);
        String randTextMark = RandomStringUtils.randomAlphanumeric(25);
        String randText = RandomStringUtils.randomAlphanumeric(15);

        // заполняем поля, сохраняем запись, переходим на страницу блога и проверяем, что данная запись сохранилась
        BlogPage blogPage = addPage.saveEntry(randTitle, randSlug, randTextMark, randText);
        assertTrue(blogPage.verifyEntry(randTitle));

        // переходим в админ-панель, удаляем entry и проверяем после удаления
        AdminPanelPage adminPanel = blogPage.getAdminPanel();
        adminPanel.deleteEntry();
        assertFalse(adminPanel.verifyDeletedEntry(randTitle));
        
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}

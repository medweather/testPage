import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
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
    private void autoTestSite() {

        // инициализация логин-страницы
        LoginPage login = new LoginPage(driver);

        // вход в систему и проверка заголовка "Панель управления"
        MainPage mainPage = login.loginToSite("selenium", "super_password");
        assertTrue(mainPage.verifyHeader("Панель управления"));

        // инициализация страницы "Добавить entry" и проверка, что заголовок - "Добавить entry"
        AddEntryPage addPage = mainPage.addedEntries();
        assertTrue(addPage.verifyHeader("Добавить entry"));

        String randTitle = RandomStringUtils.randomAlphanumeric(10);
        String randSlug = RandomStringUtils.randomAlphanumeric(12);
        String randTextMark = RandomStringUtils.randomAlphanumeric(25);
        String randText = RandomStringUtils.randomAlphanumeric(15);

        // сохранение entry, переход на страницу блога и проверка, что данная запись сохранилась
        BlogPage blogPage = addPage.saveEntry(randTitle, randSlug, randTextMark, randText);
        assertTrue(blogPage.verifyEntry(randTitle));

        // переход в админ-панель, удаление entry и проверка после удаления
        AdminPanelPage adminPanel = blogPage.getAdminPanel();
        adminPanel.deleteEntry();
        assertFalse(adminPanel.verifyDeletedEntry(randTitle));
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}

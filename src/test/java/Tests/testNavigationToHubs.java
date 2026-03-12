package Tests;

import core.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import org.openqa.selenium.By;

public class testNavigationToHubs extends BaseTest {

    @Test
    void testNavigationToHubs() {

        MainPage mainPage = new MainPage(driver);

        mainPage.open();

        mainPage.clickHubs();

        String pageTitle = driver.findElement(By.tagName("h1")).getText();

        Assertions.assertEquals("Все хабы", pageTitle, "Заголовок страницы 'Все хабы'");
    }
}

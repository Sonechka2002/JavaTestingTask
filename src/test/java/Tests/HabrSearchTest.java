package Tests;

import core.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import org.openqa.selenium.By;

public class HabrSearchTest extends BaseTest {

    @Test
    void testSearchOnHabr() {

        MainPage mainPage = new MainPage(driver);

        mainPage.open();

        mainPage.searchFor("Selenium");

        boolean isResultsPresent = driver.findElements(By.cssSelector("article")).size() > 0;

        Assertions.assertTrue(isResultsPresent, "Результаты поиска на странице");
    }
}
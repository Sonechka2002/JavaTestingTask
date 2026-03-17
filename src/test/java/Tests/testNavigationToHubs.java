package tests;

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

        // 1. Кликаем по разделу "Хабы"
        mainPage.clickHubs();

        // 2. Проверяем, что в адресе страницы появилось слово "hubs"
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertTrue(currentUrl.contains("/hubs/"), "URL должен содержать '/hubs/'");

        // 3. Проверяем заголовок
        String pageTitle = driver.findElement(By.tagName("h1")).getText();
        System.out.println("Заголовок страницы: " + pageTitle);

        // Проверяем наличие слова "хабы" в заголовке
        Assertions.assertTrue(pageTitle.toLowerCase().contains("хабы"), "Заголовок должен содержать слово 'хабы'");
    }
}

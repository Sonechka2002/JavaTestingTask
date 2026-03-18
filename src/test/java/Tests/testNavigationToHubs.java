package Tests;

import core.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.MainPage;
import steps.MainPageSteps;

public class testNavigationToHubs extends BaseTest {

    @Test
    public void testNavigationToHubs() {
        System.out.println("=== ТЕСТ НАВИГАЦИИ ===");

        MainPage mainPage = new MainPage(driver);

        System.out.println("1. Открываем habr.com");
        mainPage.open();

        try { Thread.sleep(3000); } catch (Exception e) {}
        System.out.println("   Текущий URL после открытия: " + driver.getCurrentUrl());
        System.out.println("   Заголовок страницы: " + driver.getTitle());

        System.out.println("2. Ищем ссылки на хабы:");
        var allLinks = driver.findElements(By.xpath("//a[contains(@href, '/hubs') or contains(text(), 'Хабы')]"));
        System.out.println("   Найдено ссылок: " + allLinks.size());

        if (allLinks.size() > 0) {
            for (int i = 0; i < allLinks.size(); i++) {
                System.out.println("   Ссылка " + (i+1) + ": " + allLinks.get(i).getText() + " -> " + allLinks.get(i).getAttribute("href"));
            }

            System.out.println("3. Кликаем по первой ссылке");
            allLinks.get(0).click();

            try { Thread.sleep(3000); } catch (Exception e) {}
            System.out.println("4. URL после клика: " + driver.getCurrentUrl());
        } else {
            System.out.println("   Ссылки на хабы не найдены!");
        }

        System.out.println("=== ТЕСТ ЗАВЕРШЕН ===");
    }
}
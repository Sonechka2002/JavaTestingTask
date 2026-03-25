package Tests;

import core.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class testNavigationToHubs extends BaseTest {

    @Test
    public void testNavigationToHubs() {
        System.out.println("=== ТЕСТ НАВИГАЦИИ ===");

        try {
            // 1. Открываем главную
            System.out.println("Открываем habr.com...");
            driver.get("https://habr.com/ru/");

            // Ждем загрузки
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
            System.out.println("Страница загружена");

            Thread.sleep(3000);

            // 2. Ищем и кликаем по ссылке "Хабы"
            System.out.println("Ищем ссылку на Хабы...");

            // Правильный локатор для ссылки на Хабы
            By hubsLink = By.xpath("//a[contains(text(), 'Хабы') or contains(@href, '/hubs/')]");

            try {
                wait.until(ExpectedConditions.elementToBeClickable(hubsLink)).click();
                System.out.println("Клик по ссылке 'Хабы'");
            } catch (Exception e) {
                System.out.println("Не нашли ссылку 'Хабы', пробуем другой вариант...");
                // Альтернативный вариант - через меню
                By menuLink = By.cssSelector(".tm-header-menu__item a[href*='hubs']");
                wait.until(ExpectedConditions.elementToBeClickable(menuLink)).click();
                System.out.println("Клик через меню");
            }

            // Ждем загрузки
            Thread.sleep(5000);

            // 3. Проверяем URL
            String currentUrl = driver.getCurrentUrl();
            System.out.println("Текущий URL: " + currentUrl);

            if (currentUrl.contains("/hubs/") || currentUrl.contains("hub")) {
                System.out.println("✓ URL содержит /hubs/");
            } else {
                System.out.println("✗ URL НЕ содержит /hubs/");
            }

            // 4. Проверяем заголовок
            String title = driver.getTitle();
            System.out.println("Заголовок: " + title);

            if (title.toLowerCase().contains("хаб") || title.toLowerCase().contains("hub")) {
                System.out.println("✓ Заголовок содержит 'хабы'");
            } else {
                System.out.println("✗ Заголовок НЕ содержит 'хабы'");
            }

            System.out.println("=== ТЕСТ ЗАВЕРШЕН ===");

        } catch (Exception e) {
            System.out.println("Ошибка в тесте: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
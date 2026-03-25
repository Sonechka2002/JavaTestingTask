package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public abstract class BaseTest {
    protected WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.out.println("=== НАСТРОЙКА ТЕСТА ===");

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

        // Маскировка под обычного пользователя
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");

        // Отключаем автоматизацию
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);

        // Дополнительные настройки
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);

        // Удаляем признак WebDriver - используем JavascriptExecutor
        try {
            ((JavascriptExecutor) driver).executeScript("Object.defineProperty(navigator, 'webdriver', {get: () => undefined})");
            System.out.println("✓ Маскировка WebDriver выполнена");
        } catch (Exception e) {
            System.out.println("⚠ Не удалось выполнить маскировку: " + e.getMessage());
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        System.out.println("=== НАСТРОЙКА ЗАВЕРШЕНА ===");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("=== ЗАВЕРШЕНИЕ ТЕСТА ===");
        if (driver != null) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            driver.quit();
            System.out.println("Браузер закрыт");
        }
    }
}
package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

    public abstract class BaseTest {
        protected WebDriver driver;

        @BeforeEach
        public void setUp() {
            // 1. Автоматически скачиваем и настраиваем драйвер для Chrome
            WebDriverManager.chromedriver().setup();

            // 2. Запускаем сам браузер
            driver = new ChromeDriver();

            // 3. Раскрываем окно на весь экран
            driver.manage().window().maximize();

            // 4. Неявное ожидание: если элемент не найден сразу,
            // Selenium будет искать его в течение 10 секунд
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }

        @AfterEach
        public void tearDown() {
            // 5. Закрываем браузер после каждого теста
            if (driver != null) {
                driver.quit();
            }
        }
    }

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Локаторы
    private final By emailInput = By.id("email_field");
    private final By passwordInput = By.id("password_field");
    private final By loginButton = By.name("go");
    private final By errorMessage = By.cssSelector(".s-error");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public LoginPage open() {
        driver.get("https://account.habr.com/login/");
        return this;
    }

    // Меняем private на public
    public LoginPage enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput)).sendKeys(email);
        return this;
    }

    public LoginPage enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
        return this;
    }

    public LoginPage clickLogin() {
        driver.findElement(loginButton).click();
        return this;
    }

    // Метод для входа с НЕправильными данными
    public LoginPage loginWithInvalidData(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLogin();
        return this;
    }

    // Метод для получения текста ошибки
    public String getErrorText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage)).getText();
    }

    // Метод для проверки ошибки
    public void wrongEmail() {
        String errorText = getErrorText();
        assert errorText.contains("Неверный") :
                "Ожидалось сообщение 'Неверный', но получено: " + errorText;
    }
}
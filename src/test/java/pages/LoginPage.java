package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    private final By emailInput = By.id("email_field"); // Поле Email
    private final By passwordInput = By.id("password_field"); // Поле Пароль
    private final By loginButton = By.name("go"); // Кнопка "Войти"
    private final By errorMessage = By.cssSelector(".s-error"); // Сообщение об ошибке

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        // Прямая ссылка на страницу входа Хабра
        driver.get("https://account.habr.com/login/" );
    }

    public void loginWithInvalidData(String email, String password) {
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public String getErrorText() {
        return driver.findElement(errorMessage).getText();
    }
}
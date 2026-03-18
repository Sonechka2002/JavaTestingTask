package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MainPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private final By loginLink = By.xpath("//a[contains(@href, '/login')]");
    private final By hubsLink = By.xpath("//a[contains(@href, '/hubs/')]");
    private final By searchIcon = By.cssSelector(".tm-header__search-toggle");
    private final By searchInput = By.cssSelector(".tm-input-text-decorated__input");
    private final By searchResults = By.cssSelector(".tm-articles-list");

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public MainPage open() {
        driver.get("https://habr.com/ru/");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
        return this;
    }

    public LoginPage goToLoginPage() {
        wait.until(ExpectedConditions.elementToBeClickable(loginLink)).click();
        return new LoginPage(driver);
    }

    public MainPage clickHubs() {
        wait.until(ExpectedConditions.elementToBeClickable(hubsLink)).click();
        return this;
    }

    public MainPage searchFor(String query) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(searchIcon)).click();
            Thread.sleep(1000);
            wait.until(ExpectedConditions.visibilityOfElementLocated(searchInput))
                    .sendKeys(query + "\n");
            System.out.println("Поисковый запрос '" + query + "' отправлен");
        } catch (Exception e) {
            System.out.println("Ошибка при поиске: " + e.getMessage());
        }
        return this;
    }

    public boolean areResultsPresent() {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(searchResults));
            return driver.findElements(By.cssSelector(".tm-articles-list article")).size() > 0;
        } catch (Exception e) {
            return false;
        }
    }

    // ДОБАВЛЯЕМ ЭТОТ МЕТОД
    public WebDriver getDriver() {
        return driver;
    }
}
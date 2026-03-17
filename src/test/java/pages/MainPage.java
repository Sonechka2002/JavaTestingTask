package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;

    // Локаторы
    private final By searchButton = By.xpath("//a[contains(@href, '/search/')]");
    private final By searchInput = By.name("q");
    private final By hubsLink = By.xpath("//a[contains(@href, '/hubs/')]");

    // Локатор для кнопки "Войти" в шапке сайта (ведет на account.habr.com)
    private final By loginButtonHeader = By.xpath("//a[contains(@href, 'account.habr.com')]");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    // Методы
    public void open() {
        driver.get("https://habr.com/ru/all/" );
    }

    public void searchFor(String text) {
        driver.findElement(searchButton).click();
        driver.findElement(searchInput).sendKeys(text);
        driver.findElement(searchInput).sendKeys(Keys.ENTER);
    }

    public void clickHubs() {
        driver.findElement(hubsLink).click();
    }

    // Метод для перехода на страницу входа через главную
    public void goToLoginPage() {
        driver.findElement(loginButtonHeader).click();
    }
}

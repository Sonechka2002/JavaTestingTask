package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;

    private final By searchButton = By.xpath("//a[contains(@href, '/search/')]");
    private final By searchInput = By.name("q");
    private final By hubsLink = By.linkText("ХАБЫ"); // Наш новый локатор для навигации

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

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
}
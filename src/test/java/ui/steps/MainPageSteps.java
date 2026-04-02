package ui.steps;

import ui.pages.MainPage;
import org.junit.jupiter.api.Assertions;

public class MainPageSteps {
    private MainPage mainPage;

    public MainPageSteps(MainPage mainPage) {
        this.mainPage = mainPage;
    }

    public MainPageSteps openMainPage() {
        mainPage.open();
        System.out.println("✓ Открыта главная страница");
        return this;
    }

    public MainPageSteps searchFor(String query) {
        mainPage.searchFor(query);
        System.out.println("✓ Выполнен поиск: " + query);
        return this;
    }

    public MainPageSteps navigateToHubs() {
        mainPage.clickHubs();
        System.out.println("✓ Переход в раздел Хабы");
        return this;
    }

    public MainPageSteps verifySearchResults() {
        boolean resultsPresent = mainPage.areResultsPresent();
        Assertions.assertTrue(resultsPresent, "Результаты поиска должны отображаться");
        System.out.println("✓ Проверка: результаты поиска отображаются");
        return this;
    }

    public MainPageSteps verifyUrlContains(String expectedText) {
        String currentUrl = mainPage.getDriver().getCurrentUrl();
        Assertions.assertTrue(
                currentUrl.contains(expectedText),
                "URL должен содержать '" + expectedText + "', но содержит: " + currentUrl
        );
        System.out.println("✓ Проверка: URL содержит '" + expectedText + "'");
        return this;
    }

    public MainPageSteps verifyTitleContains(String expectedText) {
        String title = mainPage.getDriver().getTitle();
        Assertions.assertTrue(
                title.toLowerCase().contains(expectedText.toLowerCase()),
                "Заголовок должен содержать '" + expectedText + "', но содержит: " + title
        );
        System.out.println("✓ Проверка: заголовок содержит '" + expectedText + "'");
        return this;
    }
}

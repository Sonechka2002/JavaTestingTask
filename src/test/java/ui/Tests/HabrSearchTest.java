package ui.Tests;

import ui.core.BaseTest;
import org.junit.jupiter.api.Test;
import ui.pages.MainPage;
import ui.steps.MainPageSteps;

public class HabrSearchTest extends BaseTest {

    @Test
    public void testSearchWithSelenium() {
        MainPageSteps steps = new MainPageSteps(new MainPage(driver));

        steps.openMainPage()
                .searchFor("Selenium")
                .verifySearchResults();
    }

    @Test
    public void testSearchWithJava() {
        MainPageSteps steps = new MainPageSteps(new MainPage(driver));

        steps.openMainPage()
                .searchFor("Java")
                .verifySearchResults();
    }
}
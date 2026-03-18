package Tests;

import core.BaseTest;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import steps.MainPageSteps;

public class HabrSearchTest extends BaseTest {

    @Test
    public void testSearchOnHabr() {
        MainPageSteps steps = new MainPageSteps(new MainPage(driver));

        steps.openMainPage()
                .searchFor("Selenium")
                .verifySearchResults();
    }

    @Test
    public void testSearchWithDifferentQuery() {
        MainPageSteps steps = new MainPageSteps(new MainPage(driver));

        steps.openMainPage()
                .searchFor("Java")
                .verifySearchResults();
    }
}
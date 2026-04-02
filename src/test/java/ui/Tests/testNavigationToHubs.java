package ui.Tests;

import ui.core.BaseTest;
import org.junit.jupiter.api.Test;
import ui.pages.MainPage;
import ui.steps.MainPageSteps;

public class testNavigationToHubs extends BaseTest {

    @Test
    public void testNavigationToHubs() {
        MainPageSteps steps = new MainPageSteps(new MainPage(driver));

        steps.openMainPage()
                .navigateToHubs()
                .verifyUrlContains("/hubs/")
                .verifyTitleContains("хабы");
    }
}
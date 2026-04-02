package ui.Tests;

import ui.core.BaseTest;
import org.junit.jupiter.api.Test;
import ui.pages.LoginPage;
import ui.pages.MainPage;
import ui.steps.AuthSteps;

public class HabrAuthTest extends BaseTest {

    @Test
    public void testInvalidLoginError() {
        AuthSteps steps = new AuthSteps(
                new LoginPage(driver),
                new MainPage(driver)
        );

        steps.openMainPage()
                .goToLogin()
                .enterEmail("wrong@email.com")
                .enterPassword("wrongpass")
                .submitLogin()
                .verifyErrorContains("Неверный");
    }
}
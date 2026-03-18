package Tests;

import core.BaseTest;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.MainPage;
import steps.AuthSteps;

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
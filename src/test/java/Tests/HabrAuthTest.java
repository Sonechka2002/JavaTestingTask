package Tests;

import core.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

public class HabrAuthTest extends BaseTest {

    @Test
    void testInvalidLoginError() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.open();

        loginPage.loginWithInvalidData("wrong-email@test.com", "wrong-password");

        String errorText = loginPage.getErrorText();

        Assertions.assertTrue(errorText.contains("Неверный"),
                "Сообщение о неверных данных. Текст ошибки: " + errorText);
    }
}



package Tests;

import core.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.MainPage;

public class HabrAuthTest extends BaseTest {

    @Test
    void testInvalidLoginError() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        // 1. Открываем главную страницу Хабра
        mainPage.open();

        // 2. Нажимаем кнопку "Войти" в шапке сайта
        mainPage.goToLoginPage();

        // 3. Теперь мы на странице входа. Вводим неверные данные
        loginPage.loginWithInvalidData("wrong-email@test.com", "wrong-password");

        // 4. Проверяем, что появилось сообщение об ошибке
        String errorText = loginPage.getErrorText();

        // Проверяем, что текст ошибки содержит слово "Неверный" (логин или пароль)
        Assertions.assertTrue(errorText.contains("Неверный"),
                "Должно появиться сообщение о неверных данных. Текст ошибки: " + errorText);
    }
}
package steps;

import pages.LoginPage;
import pages.MainPage;
import org.junit.jupiter.api.Assertions;

public class AuthSteps {
    private LoginPage loginPage;
    private MainPage mainPage;
    private MainPageSteps mainPageSteps;

    public AuthSteps(LoginPage loginPage, MainPage mainPage) {
        this.loginPage = loginPage;
        this.mainPage = mainPage;
        this.mainPageSteps = new MainPageSteps(mainPage);
    }

    public AuthSteps openMainPage() {
        mainPageSteps.openMainPage();
        return this;
    }

    public AuthSteps goToLogin() {
        mainPage.goToLoginPage();
        System.out.println("✓ Переход на страницу логина");
        return this;
    }

    public AuthSteps enterEmail(String email) {
        loginPage.enterEmail(email);
        System.out.println("✓ Введен email: " + email);
        return this;
    }

    public AuthSteps enterPassword(String password) {
        loginPage.enterPassword(password);
        System.out.println("✓ Введен пароль");
        return this;
    }

    public AuthSteps submitLogin() {
        loginPage.clickLogin();
        System.out.println("✓ Отправлена форма логина");
        return this;
    }

    public AuthSteps verifyErrorContains(String expectedText) {
        String actualError = loginPage.getErrorText();
        Assertions.assertTrue(
                actualError.contains(expectedText),
                "Ошибка должна содержать '" + expectedText + "', но получено: '" + actualError + "'"
        );
        System.out.println("✓ Проверка: ошибка содержит '" + expectedText + "'");
        return this;
    }
}


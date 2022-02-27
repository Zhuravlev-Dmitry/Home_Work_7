package org.example;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;


@Epic("Авторизация на сайте")
public class AuthorizationTest extends AbstractClassTest{
    @Test
    @DisplayName("Позитивная авторизация")
    @Description("Тест проверяет успешный вход")
    @Link("https://www.trxtraining.ru/")
    @Issue("https://www.trxtraining.ru/help/publichnaya-oferta/")
    @Severity(SeverityLevel.BLOCKER)
    void checkPositiveSignIn (){
        new TrxMainPage(getWebDriver()).goToAccountPage();
        Assertions
                .assertTrue(getWebDriver()
                .getCurrentUrl()
                .equals("https://www.trxtraining.ru/users/login/"),"Страница входа не доступна");
        new AuthorisationPage(getWebDriver()).loginIn("dmitry.yand2.mail@yandex.ru","TRXtest1");
        Assertions.assertTrue(getWebDriver()
                .getCurrentUrl()
                .equals("https://www.trxtraining.ru/users/settings/"),"Страница входа не доступна");
}
    @Test
    @DisplayName("Негативная авторизация")
    @Description("Тест проверяет вывод сообщения об ошибке ввода данных")
    @Link("https://www.trxtraining.ru/")
    @Issue("https://www.trxtraining.ru/help/publichnaya-oferta/")
    @Severity(SeverityLevel.CRITICAL)
    void checkNegativeSignIn () throws IOException {
        new TrxMainPage(getWebDriver()).goToAccountPage();
        Assertions
                .assertTrue(getWebDriver()
                        .getCurrentUrl()
                        .equals("https://www.trxtraining.ru/users/login/"),"Страница входа не доступна");

        new AuthorisationPage(getWebDriver()).loginIn("dmitry.yand2.mail@yandex.ru","TRXtestNegative");
try {
    Assertions.assertTrue(new AuthorisationPage(getWebDriver())
            .getError_massage()
            .getText()
            .equals("Вы ввели неверный логин или пароль. Проверьте раскладку клавиатуры," +
                    " не нажата ли клавиша «Caps Lock» и попробуйте ввести логин и пароль ещё раз:"));
}catch (Exception e){
    File file = ScreenshotClass.makeScreenshot(getWebDriver(),"AuthorizationTest.checkNegativeSignIn" + System.currentTimeMillis() + ".png");
    saveScreenshot(Files.readAllBytes(file.toPath()));
}
    }

    @Test
    @DisplayName("Повторная регистрация")
    @Description("Тест проверяет вывод сообщения о уже существующем пользователе с такими данными")
    @Link("https://www.trxtraining.ru/")
    @Issue("https://www.trxtraining.ru/help/publichnaya-oferta/")
    @Severity(SeverityLevel.CRITICAL)
    void checkDuplicateAuthorisation () throws IOException {
        new TrxMainPage(getWebDriver()).goToAccountPage();
        Assertions
                .assertTrue(getWebDriver()
                        .getCurrentUrl()
                        .equals("https://www.trxtraining.ru/users/login/"),"Страница входа не доступна");

        new AuthorisationPage(getWebDriver()).registration("Лутохин","Дмитрий","Анатольевич"
                ,"+7 (910) 234-93-75","dmitry.yand2.mail@yandex.ru","TRXtest1"
                ,"TRXtest1");
        File file = ScreenshotClass.makeScreenshot(getWebDriver(),"AuthorizationTest.checkDuplicateAuthorisation" + System.currentTimeMillis() + ".png");
        saveScreenshot(Files.readAllBytes(file.toPath()));
        Assertions.assertTrue(new AuthorisationPage(getWebDriver())
                .getError_massage1()
                .getText()
                .equals("Пользователь с таким логином уже существует."));
    }
    @Test
    @DisplayName("Негативная регистрация")
    @Description("Тест проверяет вывод сообщения об ошибке ввода данных")
    @Link("https://www.trxtraining.ru/")
    @Issue("https://www.trxtraining.ru/help/publichnaya-oferta/")
    @Severity(SeverityLevel.NORMAL)
    void checkNegativeAuthorisation () throws IOException {
        new TrxMainPage(getWebDriver()).goToAccountPage();
        Assertions
                .assertTrue(getWebDriver()
                        .getCurrentUrl()
                        .equals("https://www.trxtraining.ru/users/login/"),"Страница входа не доступна");
        new AuthorisationPage(getWebDriver()).registration("Лутохин","Дмитрий","Анатольевич"
                ,"+7 (910) 234-93-75","dmitry.yand2@yandex.ru",""
                ,"");
try {
    Assertions.assertTrue(new AuthorisationPage(getWebDriver())
            .getError_massage2()
            .getText()
            .equals("Пароль не должен содержать пробелы."));
}catch (Exception e) {
    File file = ScreenshotClass.makeScreenshot(getWebDriver(),"AuthorizationTest.checkNegativeAuthorisation" + System.currentTimeMillis() + ".png");
    saveScreenshot(Files.readAllBytes(file.toPath()));
}
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }


}

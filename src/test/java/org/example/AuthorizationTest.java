package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class AuthorizationTest extends AbstractClassTest{
    @Test
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
    void checkNegativeSignIn (){
        new TrxMainPage(getWebDriver()).goToAccountPage();
        Assertions
                .assertTrue(getWebDriver()
                        .getCurrentUrl()
                        .equals("https://www.trxtraining.ru/users/login/"),"Страница входа не доступна");

        new AuthorisationPage(getWebDriver()).loginIn("dmitry.yand2.mail@yandex.ru","TRXtestNegative");
        Assertions.assertTrue(new AuthorisationPage(getWebDriver())
                .getError_massage()
                .getText()
                .equals("Вы ввели неверный логин или пароль. Проверьте раскладку клавиатуры," +
                        " не нажата ли клавиша «Caps Lock» и попробуйте ввести логин и пароль ещё раз:"));
    }

    @Test
    void checkDuplicateAuthorisation (){
        new TrxMainPage(getWebDriver()).goToAccountPage();
        Assertions
                .assertTrue(getWebDriver()
                        .getCurrentUrl()
                        .equals("https://www.trxtraining.ru/users/login/"),"Страница входа не доступна");

        new AuthorisationPage(getWebDriver()).registration("Лутохин","Дмитрий","Анатольевич"
                ,"+7 (910) 234-93-75","dmitry.yand2.mail@yandex.ru","TRXtest1"
                ,"TRXtest1");
        Assertions.assertTrue(new AuthorisationPage(getWebDriver())
                .getError_massage1()
                .getText()
                .equals("Пользователь с таким логином уже существует."));
    }
    @Test
    void checkNegativeAuthorisation (){
        new TrxMainPage(getWebDriver()).goToAccountPage();
        Assertions
                .assertTrue(getWebDriver()
                        .getCurrentUrl()
                        .equals("https://www.trxtraining.ru/users/login/"),"Страница входа не доступна");
        new AuthorisationPage(getWebDriver()).registration("Лутохин","Дмитрий","Анатольевич"
                ,"+7 (910) 234-93-75","dmitry.yand2@yandex.ru",""
                ,"");

        Assertions.assertTrue(new AuthorisationPage(getWebDriver())
                .getError_massage2()
                .getText()
                .equals("Пароль не должен содержать пробелы."));
    }


}

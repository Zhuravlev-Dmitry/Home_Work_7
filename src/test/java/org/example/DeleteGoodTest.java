package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.NoSuchElementException;


public class DeleteGoodTest extends AbstractClassTest{
    @Test
    void checkDelete () {
        new TrxMainPage(getWebDriver()).goToAccountPage();
        Assertions
                .assertTrue(getWebDriver()
                        .getCurrentUrl()
                        .equals("https://www.trxtraining.ru/users/login/"), "Страница входа не доступна");
        new AuthorisationPage(getWebDriver()).loginIn("dmitry.yand2.mail@yandex.ru", "TRXtest1");
        Assertions.assertTrue(getWebDriver()
                .getCurrentUrl()
                .equals("https://www.trxtraining.ru/users/settings/"), "Страница входа не доступна");

        new TrxMainPage(getWebDriver()).navigateToCard();
        Assertions
                .assertTrue(getWebDriver()
                        .getCurrentUrl()
                        .equals("https://www.trxtraining.ru/emarket/cart/"), "Страница не доступна");
        try {
            new BasketPage(getWebDriver()).getDelete();
            Assertions.assertTrue(new BasketPage(getWebDriver())
                    .getMassage()
                    .getText()
                    .equals("Ваша корзина пуста"));
        } catch (NoSuchElementException e) {
            System.out.println("Что бы удалить товар из корзины, необходимо его сначала туда добавить!");
        }
    }
}

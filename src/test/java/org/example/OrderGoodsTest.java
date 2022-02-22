package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class OrderGoodsTest extends AbstractClassTest {
    @Test
    void checkAuthorUserOrder (){
        new TrxMainPage(getWebDriver()).goToAccountPage();
        Assertions
                .assertTrue(getWebDriver()
                        .getCurrentUrl()
                        .equals("https://www.trxtraining.ru/users/login/"),"Страница входа не доступна");
        new AuthorisationPage(getWebDriver()).loginIn("dmitry.yand2.mail@yandex.ru","TRXtest1");
        Assertions.assertTrue(getWebDriver()
                .getCurrentUrl()
                .equals("https://www.trxtraining.ru/users/settings/"),"Страница входа не доступна");

        new AccountPage(getWebDriver()).navigateToAksessuary();
        Assertions
                .assertTrue(getWebDriver()
                        .getCurrentUrl()
                        .equals("https://www.trxtraining.ru/shop/aksessuary/"),"Страница не доступна");

        new ShopPage(getWebDriver()).findShejker().clickSlide11().addToCart();
        Assertions.assertTrue(new ShopPage(getWebDriver()).getAddMassage()
                .getAttribute("class").equals("message"));
    }

}

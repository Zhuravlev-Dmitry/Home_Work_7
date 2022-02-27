package org.example;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Story("Заказ товара авторизованного пользователя")
public class OrderGoodsTest extends AbstractClassTest {
    @Test
    @DisplayName("Успешный заказ товара")
    @Description("Тест проверяет успешный заказ товара")
    @Link("https://www.trxtraining.ru/")
    @Issue("https://www.trxtraining.ru/shop/")
    @Severity(SeverityLevel.BLOCKER)
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

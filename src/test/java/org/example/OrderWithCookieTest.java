package org.example;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
@Story("Заказ товара не авторизованного пользователя")
public class OrderWithCookieTest extends AbstractClassTest{
    @Test
    @DisplayName("Успешный заказ")
    @Description("Тест проверяет успешный заказ товара")
    @Link("https://www.trxtraining.ru/")
    @Issue("https://www.trxtraining.ru/shop/")
    @Severity(SeverityLevel.BLOCKER)
    void checkNotAuthorUserOrder (){

        new TrxMainPage(getWebDriver()).navigateToPetli_trx();
        Assertions
                .assertTrue(getWebDriver()
                        .getCurrentUrl()
                        .equals("https://www.trxtraining.ru/shop/petli-trx/"),"Страница не доступна");

        new ShopPage(getWebDriver()).findPetliTrx().nextSlide().addToCart();
        Assertions.assertTrue(new ShopPage(getWebDriver()).getAddMassage()
                .getAttribute("class").equals("message"));
    }
    @Test
    @DisplayName("Проверка сохранения заказа")
    @Description("Тест проверяет содержание ранее заказанного товара")
    @Link("https://www.trxtraining.ru/")
    @Severity(SeverityLevel.MINOR)
    void checkOrderWithCookie (){
        new TrxMainPage(getWebDriver()).setCookie();
        new TrxMainPage(getWebDriver()).navigateToCard();
        Assertions.assertTrue(new BasketPage(getWebDriver())
                .showPetli()
                .isDisplayed());
    }
}

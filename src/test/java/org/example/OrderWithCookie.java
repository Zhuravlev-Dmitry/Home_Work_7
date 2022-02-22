package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderWithCookie extends AbstractClassTest{
    @Test
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
    void checkOrderWithCookie (){
        new TrxMainPage(getWebDriver()).setCookie();
        new TrxMainPage(getWebDriver()).navigateToCard();
        Assertions.assertTrue(new BasketPage(getWebDriver())
                .showPetli()
                .isDisplayed());
    }
}

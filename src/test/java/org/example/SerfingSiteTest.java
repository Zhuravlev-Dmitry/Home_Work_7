package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class SerfingSiteTest extends AbstractClassTest{
    @Test
    void checkSearch (){
        new TrxMainPage(getWebDriver()).getSearch("тренажер");
        Assertions.assertTrue(new TrxMainPage(getWebDriver())
                .getSearchMassage()
                .getText()
                .contains("По вашему запросу \"тренажер\" найдено товаров: "));
    }
    @Test
    void checkPagination (){
       new TrxMainPage(getWebDriver()).navigateToNovosti();
        Assertions
                .assertTrue(getWebDriver()
                        .getCurrentUrl()
                        .equals("https://www.trxtraining.ru/publikacii/novosti/"),"Страница новости не доступна");

        new NovostiPage(getWebDriver()).scroll("window.scrollBy(0,4200)");

        new NovostiPage(getWebDriver()).clickPagNext();
        Assertions
                .assertTrue(getWebDriver()
                        .getCurrentUrl()
                        .equals("https://www.trxtraining.ru/publikacii/novosti/?p=1"),"Не перешли на следующую страницу");

        new NovostiPage(getWebDriver()).clickPag6();
        Assertions
                .assertTrue(getWebDriver()
                        .getCurrentUrl()
                        .equals("https://www.trxtraining.ru/publikacii/novosti/?p=5"),"Не перешли на 6-ю страницу");

        new NovostiPage(getWebDriver()).clickPagBack();
        Assertions
                .assertTrue(getWebDriver()
                        .getCurrentUrl()
                        .equals("https://www.trxtraining.ru/publikacii/novosti/?p=4"),"Не перешли на страницу назад");

        new NovostiPage(getWebDriver()).scroll("window.scrollBy(0,3900)");
    }
}

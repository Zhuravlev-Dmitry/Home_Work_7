package org.example;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.management.GarbageCollectorMXBean;

@Story("Просмотр сайта")
public class SerfingSiteTest extends AbstractClassTest{
    @Feature("Фича - 1")
    @Test
    @DisplayName("Проверка поля поиска")
    @Description("Тест проверяет вывод результата по определённому запросу")
    @Link("https://www.trxtraining.ru/")
    @Severity(SeverityLevel.NORMAL)
    void checkSearch (){
        new TrxMainPage(getWebDriver()).getSearch("тренажер");
        Assertions.assertTrue(new TrxMainPage(getWebDriver())
                .getSearchMassage()
                .getText()
                .contains("По вашему запросу \"тренажер\" найдено товаров: "));
    }
    @Test
    @DisplayName("Проверка пагинации в разделе новостей")
    @Description("Тест проверяет успешный переход на другие страницы раздела")
    @Link("https://www.trxtraining.ru/")
    @Severity(SeverityLevel.TRIVIAL)
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
        BrowserGetLogClass.testLogs(getWebDriver());
    }
}

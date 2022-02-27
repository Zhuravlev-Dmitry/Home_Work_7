package org.example;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.NoSuchElementException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Story("Удаление товара из корзины авторизованного пользователя")
public class DeleteGoodTest extends AbstractClassTest{

    @Test
    @Step("Степ 1")
    @DisplayName("Позитивное удаление и корзины")
    @Description("Тест проверяет успешное удаление добавленного ранее товара")
    @Link("https://www.trxtraining.ru/")
    @Issue("https://www.trxtraining.ru/help/pravila-prodazh/oplata-i-dostavka/")
    @Severity(SeverityLevel.NORMAL)
    void checkDelete () throws IOException {
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
            File file = ScreenshotClass.makeScreenshot(getWebDriver(),"DeleteGoodTest.AssertionTest" + System.currentTimeMillis() + ".png");
            saveScreenshot(Files.readAllBytes(file.toPath()));
            System.out.println("Что бы удалить товар из корзины, необходимо его сначала туда добавить!");
        }
    }
    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }
}

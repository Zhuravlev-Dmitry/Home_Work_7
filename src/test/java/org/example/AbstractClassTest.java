package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public abstract class AbstractClassTest {
    private static WebDriver webDriver;

    @BeforeAll
    static void initial () {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--incognito");
        options.addArguments("disable-popup-blocking");
        webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    @BeforeEach
    void goToMainPage () {
        Assertions.assertDoesNotThrow( () -> getWebDriver().navigate().to("https://www.trxtraining.ru/")
                ,"Страница не доступна");
        Assertions.assertTrue(true);
    }

    @AfterAll
    public static void exit(){
        if(webDriver !=null) webDriver.quit();
    }
    public WebDriver getWebDriver(){
        return this.webDriver;
   }

}



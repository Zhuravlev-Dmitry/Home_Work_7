package org.example;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TrxMainPage extends AbstractPage{

    @FindBy(css = "a > i.fa.fa-user-circle")
    private WebElement signIn;

    @FindBy(css = "div.mainmenu-content > ul > li > a[href='/shop/']")
    private WebElement shop;

    @FindBy(css = "div.mainmenu-content > ul > li> ul > li> a[href = '/shop/aksessuary/']")
    private WebElement aksessuary;

    @FindBy(css = "div.mainmenu-content > ul > li> ul > li> a[href = '/shop/petli-trx/']")
    private WebElement petli_trx;

    @FindBy(css = ".mini-cart > a[href='/emarket/cart/']")
    private WebElement cart;

    @FindBy(css = "div.mainmenu-content > ul > li > a[href='/publikacii/']")
    private WebElement publikacii;

    @FindBy(css = "div.mainmenu-content > ul > li> ul > li> a[href = '/publikacii/novosti/']")
    private WebElement novosti;

    @FindBy(xpath = "//*[@id='main-menu']//i[@class='fa fa-search']")
    private WebElement search;

    @FindBy(id = "search-input")
    private WebElement search_input;

    @FindBy(id = "big-forward-arrow-icon")
    private WebElement start_search;

    @FindBy(xpath = "//*[@id='results-box']/div/div[@class='post-title']")
    private WebElement searchMassage;

    public TrxMainPage(WebDriver driver) {
        super(driver);
    }

    public void goToAccountPage(){
        signIn.click();
        new WebDriverWait(getDriver(), 5)
                .until(ExpectedConditions.urlContains("/login/"));
    }

    public void navigateToPetli_trx(){
        shop.click();
        petli_trx.click();
        new WebDriverWait(getDriver(), 5)
                .until(ExpectedConditions.urlContains("/petli-trx/"));
    }
    public void navigateToCard(){
        cart.click();
    }
    public void setCookie(){
        getDriver().manage().addCookie(new Cookie("customer-id","UdEUqAwl"));
        getDriver().manage().addCookie(new Cookie("_fbp","fb.1.1645529829608.1587918023"));
    }

    public void navigateToNovosti(){
        publikacii.click();
        novosti.click();
        new WebDriverWait(getDriver(), 5)
                .until(ExpectedConditions.urlContains("https://www.trxtraining.ru/"));
    }
    public void getSearch(String text){
        Actions search = new Actions(getDriver());
        search
                .click(this.search)
                .click(this.search_input)
                .sendKeys(text)
                .click(this.start_search)
                .build()
                .perform();
    }
    public WebElement getSearchMassage(){
        return this.searchMassage;
    }


}

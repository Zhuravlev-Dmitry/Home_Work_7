package org.example;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ShopPage extends AbstractPage{

    @FindBy(xpath = "//*[@id='content_wrapper']//p/a[@href='/shop/aksessuary/trx-shejker/']")
    private WebElement trx_shejker;

    @FindBy(xpath = "//div/a[@href='/shop/petli-trx/petli-trx-move/']")
    private WebElement petli_trx;

    @FindBy(xpath = "//*[@id='pdp-carousel-indicators']/div/div/li[@aria-describedby='slick-slide11']/img")
    private WebElement slide11;

    @FindBy(id = "add-to-cart")
    private WebElement add_to_cart;

    @FindBy(css = "#alert-message > div > div > div.modal-body > div")
    private WebElement add_massage;

    @FindBy(css = "div > li[data-slick-index='1']> img")
    private WebElement slick1;

    @FindBy(css = "//div/li[@data-slick-index='2']/img")
    private WebElement slick2;


    public ShopPage(WebDriver driver) {
        super(driver);
    }

    public ShopPage findShejker(){
        this.trx_shejker.click();
        return this;
    }
    public ShopPage clickSlide11(){
        this.slide11.click();
        return this;
    }
    public ShopPage addToCart(){
        this.add_to_cart.click();
        return this;
    }
    public ShopPage findPetliTrx(){
        this.petli_trx.click();
        return this;
    }
    public ShopPage nextSlide(){
        this.slick1.click();
        return this;
    }
    public WebElement getAddMassage(){
        return this.add_massage;
    }

}

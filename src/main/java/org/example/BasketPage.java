package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasketPage extends AbstractPage{

    @FindBy(id = "cart_item_701304")
    private WebElement petli;

    @FindBy(css = " div[class='col-xs-24'] > div")
    private WebElement massage_basket_empty;

    @FindBy(css = ".remove-cart-item-text")
    private WebElement delete;

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    public WebElement showPetli(){
        return this.petli;
    }

    public void getDelete(){
        delete.click();
    }
    public WebElement getMassage(){
        return this.massage_basket_empty;}
}

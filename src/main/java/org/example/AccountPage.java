package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountPage extends AbstractPage{
    @FindBy(css = "div.mainmenu-content > ul > li > a[href='/shop/']")
    private WebElement shop;

    @FindBy(css = "div.mainmenu-content > ul > li> ul > li> a[href = '/shop/aksessuary/']")
    private WebElement aksessuary;

    public AccountPage(WebDriver driver) {
        super(driver);
    }
    public void navigateToAksessuary(){
        shop.click();
        aksessuary.click();
        new WebDriverWait(getDriver(), 10)
                .until(ExpectedConditions.urlContains("/shop/aksessuary/"));
    }

}

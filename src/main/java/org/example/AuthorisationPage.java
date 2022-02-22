package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AuthorisationPage extends AbstractPage {

    @FindBy(id = "user_email")
    private WebElement login;

    @FindBy(id = "user_password")
    private WebElement password;

    @FindBy(xpath = ".//*[@id='login_form']/div/input[@name='commit']")
    private WebElement commit;

    @FindBy(id = "field_lname")
    private WebElement lname;

    @FindBy(id = "field_fname")
    private WebElement fname;

    @FindBy(id = "field_father_name")
    private WebElement father_name;

    @FindBy(id = "field_phone")
    private WebElement phone;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "password_confirm")
    private WebElement password_confirm;

    @FindBy(css = ".sign-up-submit > .btn")
    private WebElement sign_up_submit;

    @FindBy(xpath = "//ul[@class='woocommerce-error']/li")
    private WebElement error_massage;

    @FindBy(xpath = "//*[@id='registrate_form']/div/div/div/ul/li")
    private WebElement error_massage1;

    @FindBy(css = "div.has-success > ul > li")
    private WebElement error_massage2;

    public AuthorisationPage(WebDriver driver) {
        super(driver);
    }


    public void loginIn(String login, String password){

        Actions loginIn = new Actions(getDriver());
        loginIn
                .sendKeys(this.login,login)
                .sendKeys(this.password,password)
                .click(this.commit)
                .build()
                .perform();
    }
    public void registration(String lname, String fname, String father_name, String phone, String email
            , String password,String password_confirm){
        Actions registration = new Actions(getDriver());
        registration
                .sendKeys(this.lname,lname)
                .sendKeys(this.fname,fname)
                .sendKeys(this.father_name,father_name)
                .sendKeys(this.phone,phone)
                .sendKeys(this.email,email)
                .sendKeys(this.password,password)
                .sendKeys(this.password_confirm,password_confirm)
                .click(this.sign_up_submit)
                .build()
                .perform();
    }
    public WebElement getError_massage(){
        return this.error_massage;
    }
    public WebElement getError_massage1(){
        return this.error_massage1;
    }
    public WebElement getError_massage2(){
        return this.error_massage2;
    }

}

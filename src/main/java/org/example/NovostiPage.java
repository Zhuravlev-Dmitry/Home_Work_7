package org.example;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NovostiPage extends AbstractPage{

    @FindBy(css = "#postlist > div.pagination.pagination__posts > ul > li.next > a")
    private WebElement pag_next;

    @FindBy(xpath = "//*[@id='postlist']/div/ul/li/a[.='6']")
    private WebElement pag_6;

    @FindBy(xpath = "//*[@id='postlist']/div/ul/li/a[.='←']")
    private WebElement pag_back;


    public NovostiPage(WebDriver driver) {
        super(driver);
    }
    public void scroll(String script){
        JavascriptExecutor javascr = (JavascriptExecutor) getDriver();
        javascr.executeScript(script);
    }
    public void clickPagNext(){
        pag_next.click();
    }
    public void clickPag6(){
        pag_6.click();
    }
    public void clickPagBack(){
        pag_back.click();
    }
}

package com.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonHomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name="email")
    private WebElement emailTextBox;

    @FindBy(name="password")
    private WebElement passwordTextBox;

    @FindBy(id="continue")
    private WebElement continueBtn;


    public AmazonHomePage(WebDriver driver){
        this.driver=driver;
        this.wait= new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    public void goTo(){
        this.driver.get("https://www.amazon.com/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com%2F%3Fref_%3Dnav_custrec_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=usflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");
        this.wait.until(ExpectedConditions.visibilityOf(this.emailTextBox));
    }
    public void enterUserName(String userName){
        this.emailTextBox.sendKeys(userName);
    }
    public void clickContinue(){
    
        this.continueBtn.click();
    }
}

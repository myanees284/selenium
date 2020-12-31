package com.newtours.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name="firstName")
    private WebElement firstNametxt;

    @FindBy(name="lastName")
    private WebElement lastNametxt;

    @FindBy(name="email")
    private WebElement usernameTxt;

    @FindBy(name="password")
    private WebElement passwordTxt;

    @FindBy(name="confirmPassword")
    private WebElement confirmPasswordTxt;

    @FindBy(name="register")
    private WebElement submitBtn;

    public RegistrationPage(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }
    public void goTo(){
        this.driver.get("https://vins-udemy.s3.amazonaws.com/docker/docker-book-flight.html#");
        this.wait.until(ExpectedConditions.visibilityOf(this.firstNametxt));
    }

    public void enterUserDetails(String firstName, String lastName){
    this.firstNametxt.sendKeys(firstName);
    this.lastNametxt.sendKeys(lastName);
    }

    public void enterUserCrdentials(String userName,String Password){
        this.usernameTxt.sendKeys(userName);
        this.passwordTxt.sendKeys(Password);
        this.confirmPasswordTxt.sendKeys(Password);
    }

    public void submit(){
        this.submitBtn.click();
    }
}

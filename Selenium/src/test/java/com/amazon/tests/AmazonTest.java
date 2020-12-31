package com.amazon.tests;

import com.amazon.pages.AmazonHomePage;
import com.newtours.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AmazonTest {

    private WebDriver driver;

    @BeforeTest
    public void setUpDriver(){
        System.setProperty("webdriver.chrome.driver","C:\\Projects\\chromedriver\\chromedriver.exe");
        this.driver=new ChromeDriver();
            }
    @Test
    public void loginPage(){
        AmazonHomePage amazonHomePage= new AmazonHomePage(driver);
        amazonHomePage.goTo();
        amazonHomePage.enterUserName("anees2184@gmail.com");
        amazonHomePage.clickContinue();
        }

}

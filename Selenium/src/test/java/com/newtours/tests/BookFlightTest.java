package com.newtours.tests;

import com.newtours.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BookFlightTest {

    private WebDriver driver;
    private String noOfPassenger;
    private String expectedPrice;

    @BeforeTest
    @Parameters({"noOfPassenger","expectedPrice"})
    public void setUpDriver(String noOfPassenger,String expectedPrice){
        this.noOfPassenger=noOfPassenger;
        this.expectedPrice=expectedPrice;
        System.setProperty("webdriver.chrome.driver","C:\\Projects\\chromedriver\\chromedriver.exe");
        this.driver=new ChromeDriver();
            }
    @Test
    public void resgistrationPage(){
        RegistrationPage registrationPage= new RegistrationPage(driver);
        registrationPage.goTo();
        registrationPage.enterUserDetails("selenium","docker");
        registrationPage.enterUserCrdentials("selenium","docker");
        registrationPage.submit();
    }
    @Test(dependsOnMethods = "resgistrationPage")
    public void registrationConfirmationPage(){
        RegistrationConfirmationPage registrationConfirmationPage= new RegistrationConfirmationPage(driver);
        registrationConfirmationPage.gotoFLightDetailsPage();
    }

    @Test(dependsOnMethods = "registrationConfirmationPage")
    public void flightDetailsPage(){
        FlightDetailsPage flightDetailsPage= new FlightDetailsPage(driver);
        flightDetailsPage.selectPassengers(noOfPassenger);
        flightDetailsPage.goToFindFlightsPage();
    }

    @Test(dependsOnMethods ="flightDetailsPage")
    public void findFlightsPage(){
        FindFlightPage findFlightPage=new FindFlightPage(driver);
        findFlightPage.SubmitFindFlightPage();
        findFlightPage.goToFlightConfirmtionPage();
    }

    @Test(dependsOnMethods = "findFlightsPage")
    public void flightConfirmationPage(){
        FlightConfirmationPage flightConfirmationPage= new FlightConfirmationPage(driver);
        String actualPrice=flightConfirmationPage.getPrice();
        Assert.assertEquals(actualPrice,expectedPrice);
    }
    @AfterTest
    public void quitBrowser(){
        this.driver.quit();
    }
}

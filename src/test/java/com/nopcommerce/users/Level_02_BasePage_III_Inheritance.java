package com.nopcommerce.users;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Level_02_BasePage_III_Inheritance extends BasePage{
    WebDriver driver;
    String emailAddress = "Ashura" + generateRandomNumber() + "@gmail.com";

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void TC_01_Register() {
        waitForElementClickable(driver,"//a[@class='ico-register']");
        clickToElement(driver,"//a[@class='ico-register']");

        waitForElementClickable(driver,"//a[@id='gender-male']");
        clickToElement(driver,"//a[@id='gender-male']");

        sendkeyToElement(driver, "//input[@id='FirstName']", "Ashura");
        sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
        sendkeyToElement(driver, "//input[@id='Password']", "123456");
        sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");

        waitForElementClickable(driver,"//button[@id='register-button']");
        clickToElement(driver,"//button[@id='register-button']");


        Assert.assertEquals(getElementText(driver,"//div[@class='result']"),"Your registration completed");
        waitForElementClickable(driver,"//a[@class='ico-logout']");
        clickToElement(driver,"//a[@class='ico-logout']");
    }

    @Test
    public void TC_02_Login() {
        sendkeyToElement(driver,"//input[@id='Email']",emailAddress);
        sendkeyToElement(driver,"//input[@id='Password']","123456");
        waitForElementClickable(driver,"//button[contains(@class,'login-button')]");
        clickToElement(driver,"//button[contains(@class,'login-button')]");

        Assert.assertTrue(isElementDisplayed(driver,"//a[@class='ico-account' and text()='My account']"));
    }

    @Test
    public void TC_03_My_Account() {
        waitForElementClickable(driver,"//a[@class='ico-account']");
        clickToElement(driver,"//a[@class='ico-account']");
        
        Assert.assertTrue(isElementSelected(driver,"//input[@id='gender-male']"));
        Assert.assertEquals(getElementAttribute(driver,"//input[@id='FirstName']", "value"),"Ashura");
        Assert.assertEquals(getElementAttribute(driver,"//input[@id='LastName']", "value"),"Figure");
        Assert.assertEquals(getElementAttribute(driver,"//input[@id='Email']", "value"),emailAddress);
    }

    private int generateRandomNumber() {
        return new Random().nextInt(99999);
    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}

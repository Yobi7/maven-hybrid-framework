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

public class Level_02_BasePage_I_Init {
    WebDriver driver;
    BasePage basePage;
    String emailAddress = "Ashura" + generateRandomNumber() + "@gmail.com";

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        basePage = new BasePage();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void TC_01_Register() {
        basePage.waitForElementClickable(driver,"//a[@class='ico-register']");
        basePage.clickToElement(driver,"//a[@class='ico-register']");

        basePage.waitForElementClickable(driver,"//a[@id='gender-male']");
        basePage.clickToElement(driver,"//a[@id='gender-male']");

        basePage.sendkeyToElement(driver, "//input[@id='FirstName']", "Ashura");
        basePage.sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
        basePage.sendkeyToElement(driver, "//input[@id='Password']", "123456");
        basePage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");

        basePage.waitForElementClickable(driver,"//button[@id='register-button']");
        basePage.clickToElement(driver,"//button[@id='register-button']");


        Assert.assertEquals(basePage.getElementText(driver,"//div[@class='result']"),"Your registration completed");
        basePage.waitForElementClickable(driver,"//a[@class='ico-logout']");
        basePage.clickToElement(driver,"//a[@class='ico-logout']");
    }

    @Test
    public void TC_02_Login() {
        basePage.sendkeyToElement(driver,"//input[@id='Email']",emailAddress);
        basePage.sendkeyToElement(driver,"//input[@id='Password']","123456");
        basePage.waitForElementClickable(driver,"//button[contains(@class,'login-button')]");
        basePage.clickToElement(driver,"//button[contains(@class,'login-button')]");

        Assert.assertTrue(basePage.isElementDisplayed(driver,"//a[@class='ico-account' and text()='My account']"));
    }

    @Test
    public void TC_03_My_Account() {
        basePage.waitForElementClickable(driver,"//a[@class='ico-account']");
        basePage.clickToElement(driver,"//a[@class='ico-account']");

        Assert.assertTrue(basePage.isElementSelected(driver,"//input[@id='gender-male']"));
        Assert.assertEquals(basePage.getElementAttribute(driver,"//input[@id='FirstName']", "value"),"Ashura");
        Assert.assertEquals(basePage.getElementAttribute(driver,"//input[@id='LastName']", "value"),"Figure");
        Assert.assertEquals(basePage.getElementAttribute(driver,"//input[@id='Email']", "value"),emailAddress);
    }

    private int generateRandomNumber() {
        return new Random().nextInt(99999);
    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}

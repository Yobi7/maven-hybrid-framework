package com.facebook.cases;

import commons.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.facebook.LoginPO;
import pageObjects.facebook.PageGenerator;
import pageObjects.nopCommerce.user.*;

@Feature("User")
public class Level_18_Undisplayed extends BaseTest {
    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        loginPage = PageGenerator.getLoginPage(driver);

        loginPage.clickToNewAccountButton();
    }

    @Test
    public void TC_01_Element_Undisplayed() {
        loginPage.enterToEmailAddressTextbox("dam@gmail.com");

        // Case 1 - Verify Confirm Email textbox is displayed (visible)
        Assert.assertTrue(loginPage.isConfirmEmailTextboxDisplayed());

        // Case 2 - Verify Confirm Email textbox is not displayed (present)
        loginPage.enterToEmailAddressTextbox("");
        Assert.assertFalse(loginPage.isConfirmEmailTextboxDisplayed());

        // Case 3 - Verify Confirm Email textbox is not displayed (non-present)
        loginPage.clickToCloseIcon();
        Assert.assertTrue(loginPage.isConfirmEmailTextboxUndisplayed());


    }

    @Test
    public void TC_02_Element_Undisplayed() {
        loginPage.enterToEmailAddressTextbox("dam@gmail.com");

        // Case 1 - Verify Confirm Email textbox is displayed (visible)
        Assert.assertFalse(loginPage.isConfirmEmailTextboxUndisplayed());

        // Case 2 - Verify Confirm Email textbox is not displayed (present)
        loginPage.enterToEmailAddressTextbox("");
        Assert.assertTrue(loginPage.isConfirmEmailTextboxUndisplayed());

        // Case 3 - Verify Confirm Email textbox is not displayed (non-present)
        loginPage.clickToCloseIcon();
        Assert.assertTrue(loginPage.isConfirmEmailTextboxUndisplayed());


    }

    // Post-Condition
    @AfterClass
    public void afterClass() {
        driver.quit();
    }


    // Declare Variables
    private WebDriver driver;
    private LoginPO loginPage;

}

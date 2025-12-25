package com.orangehrm.login;

import commons.BaseTest;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.orangehrm.pim.ForgotPassPO;
import pageObjects.orangehrm.pim.LoginPO;
import pageObjects.orangehrm.pim.PageGenerator;
import testDataPOJO.jsonData.orangeHRM.LoginInfoJSON;

import java.util.Map;

public class Login_Positive extends BaseTest {
    WebDriver driver;
    private LoginPO loginPage;
    private ForgotPassPO forgotPassPage;
    private String username;
    private String password;
    private Map<String, LoginInfoJSON> loginDataMap;
    LoginInfoJSON loginInfo;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browser, String url) {
        driver = getBrowserDriver(browser, url);
        loginPage = PageGenerator.getLoginPage(driver);
        loginDataMap = LoginInfoJSON.getLoginInfoAsMap();
    }

    @Description("Verify page title on login page")
    @Test
    public void Login_Verify_01_Title() {
        Assert.assertEquals(loginPage.getPageTitle(driver), "OrangeHRM");
    }

    @Description("Verify page logo on login page")
    @Test
    public void Login_Verify_02_Logo() {
        Assert.assertTrue(loginPage.isLogoVisible(), "❌ Logo is NOT visible!");
    }

    @Description("Verify forgot password on login page")
    @Test
    public void Login_Verify_03_Forgot_Password() {
        forgotPassPage = loginPage.clickToForgotPasswordButton();
        Assert.assertEquals(forgotPassPage.getResetPageTitle(),"Reset Password");

    }


    @AfterClass
    public void afterClass() {
        closeBrowserDriver();
    }

}
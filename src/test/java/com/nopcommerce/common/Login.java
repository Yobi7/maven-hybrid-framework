package com.nopcommerce.common;

import commons.BaseTest;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import pageObjects.nopCommerce.PageGenerator;
import pageObjects.nopCommerce.user.*;

import java.util.Set;


public class Login extends BaseTest {


    @Parameters("browser")
    @BeforeTest
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);

        homePage = PageGenerator.getUserHomePage(driver);

        firstName = "Asaki";
        lastName = "Hyuga";
        emailAddress = "Asaki" + generateRandomNumber() + "@gmail.ce";
        companyName = "ABC";
        password = "123456";

        // New User --------------------------------------------------------------
        registerPage = homePage.openRegisterPage();

        registerPage.clickToRadioByID(driver, "gender-male");

        registerPage.enterToTextboxByID(driver, "FirstName", firstName);
        registerPage.enterToTextboxByID(driver, "LastName", lastName);
        registerPage.enterToTextboxByID(driver, "EmailAddress", emailAddress);
        registerPage.enterToTextboxByID(driver, "Company", companyName);
        registerPage.enterToTextboxByID(driver, "Password", password);
        registerPage.enterToTextboxByID(driver, "ConfirmPassword", password);

        registerPage.clickToButtonByText(driver, "Register");

        verifyEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed!!!");

        // Login --------------------------------------------------------------
        loginPage = registerPage.openLoginPage();
        homePage = loginPage.loginToSystem(emailAddress, password);

        verifyTrue(homePage.isMyAccountLinkDisplayed());

        // Get cookie --------------------------------------------------------------
        nopCommerceCookies = homePage.getAllCookies(driver);

        driver.quit();

    }

    // Declare Variables
    private WebDriver driver;
    private UserHomePO homePage;
    private UserRegisterPO registerPage;
    private UserLoginPO loginPage;
    private UserCustomerInfoPO customerInfoPage;
    private UserAddressPO addressPage;
    private UserOrderPO orderPage;
    private UserRewardPointPO rewardPointPage;
    private String firstName, lastName, emailAddress, companyName, password;
    public static Set<Cookie> nopCommerceCookies;

}

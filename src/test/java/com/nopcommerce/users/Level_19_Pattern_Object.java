package com.nopcommerce.users;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.PageGenerator;
import pageObjects.nopCommerce.user.*;


public class Level_19_Pattern_Object extends BaseTest {

    // Declare Variables
    private WebDriver driver;
    private UserHomePO homePage;
    private UserRegisterPO registerPage;
    private UserLoginPO loginPage;
    private UserCustomerInfoPO customerInfoPage;
    private UserAddressPO addressPage;
    private UserOrderPO orderPage;
    private UserRewardPointPO rewardPointPage;
    private String firstName, lastName, day, month, year, emailAddress, companyName, password;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);

        homePage = PageGenerator.getUserHomePage(driver);

        firstName = "Asaki";
        lastName = "Hyuga";
        day = "07";
        month = "March";
        year = "1995";
        emailAddress = "Asaki" + generateRandomNumber() + "@gmail.ce";
        companyName = "ABC";
        password = "123456";
    }

    // Test case
    @Test
    public void User_01_Register() {
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
    }

    @Test
    public void User_02_Login() {
        loginPage = registerPage.openLoginPage();
        homePage = loginPage.loginToSystem(emailAddress, password);

        verifyTrue(homePage.isMyAccountLinkDisplayed());
    }
    @Test
    public void User_03_My_Account() {
        customerInfoPage = homePage.openCustomerInfoPage();

        verifyTrue(customerInfoPage.isRadioByIDSelected(driver, "gender-male"));

        verifyEquals(customerInfoPage.getTextboxValueByID(driver, "FirstName"),firstName);
        verifyEquals(customerInfoPage.getTextboxValueByID(driver, "LastName"),lastName);
        verifyEquals(customerInfoPage.getTextboxValueByID(driver, "EmailAddress"),emailAddress);
        verifyEquals(customerInfoPage.getTextboxValueByID(driver, "Company"),companyName);
    }

    // Post-Condition
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}

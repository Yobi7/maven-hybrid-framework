package com.nopcommerce.users;

import commons.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.PageGenerator;
import pageObjects.nopCommerce.user.*;

@Feature("User")
public class Level_17_JIRA extends BaseTest {
    String browserName;


    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        homePage = PageGenerator.getUserHomePage(driver);

        this.browserName = browserName.toUpperCase();

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
    @Description("Register to application")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void User_01_Register() {
        registerPage = homePage.openRegisterPage();

        // Assert 01 => FAILED
        //verifyEquals(registerPage.getRegisterPageTitle(),"Register");

        registerPage.clickToMaleRadio();

        registerPage.enterToFirstNameTextbox(firstName);

        registerPage.enterToLastNameTextbox(lastName);

        registerPage.enterToEmailTextbox(emailAddress);

        registerPage.enterToCompanyTextbox(companyName);

        registerPage.enterToPasswordTextbox(password);

        registerPage.enterToConfirmPasswordTextbox(password);

        registerPage.clickToRegisterButton();

        //    Assert 02 => FAILED
        verifyEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed!!!");
    }

    @Description("Verify My Account Info")
    @Severity(SeverityLevel.MINOR)
    @Test
    public void User_02_My_Account() {
        customerInfoPage = homePage.openCustomerInfoPage();

        verifyTrue(customerInfoPage.isGenderMaleSelected());
        verifyEquals(customerInfoPage.getFirstNameTextboxValue(),firstName);
        verifyEquals(customerInfoPage.getLastNameTextboxValue(),lastName);
        verifyEquals(customerInfoPage.getEmailTextboxValue(),emailAddress);

    }

    @Description("Dynamic Page")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void User_03_Dynamic_Page() {
        // Customer Info --> Address
        addressPage = (UserAddressPO) customerInfoPage.openSidebarLinkByName("Addresses");

        // Address --> Reward Point
        rewardPointPage = (UserRewardPointPO) addressPage.openSidebarLinkByName("Reward points");

        // Reward Point --> Order
        orderPage = (UserOrderPO) rewardPointPage.openSidebarLinkByName("Orders");

        // Order --> Address
        addressPage = (UserAddressPO) orderPage.openSidebarLinkByName("Addresses");

        // Address --> Customer Info
        customerInfoPage = (UserCustomerInfoPO) addressPage.openSidebarLinkByName("Customer info");
    }


    // Post-Condition
    @AfterClass
    public void afterClass() {
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
    private String firstName, lastName, day, month, year, emailAddress, companyName, password;
}

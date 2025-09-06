package com.nopcommerce.users;

import ReportConfigs.ExtentManager;
import com.aventstack.extentreports.Status;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.PageGenerator;
import pageObjects.nopCommerce.user.*;

import java.lang.reflect.Method;


public class Level_15_ExtentReport extends BaseTest {
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
    @Test
    public void User_01_Register(Method method) {
        ExtentManager.startTest(method.getName() + "" + browserName, "User_01_Register - STEP 01: Open Register page");

        ExtentManager.getTest().log(Status.INFO, "User_01_Register - STEP 01: Open Register page");
        registerPage = homePage.openRegisterPage();

        // Assert 01 => FAILED
        //verifyEquals(registerPage.getRegisterPageTitle(),"Register");

        ExtentManager.getTest().log(Status.INFO, "User_01_Register - STEP 02: Click to Male to radio button");
        registerPage.clickToMaleRadio();

        ExtentManager.getTest().log(Status.INFO, "User_01_Register - STEP 03: Enter to FirstName textbox with value" + firstName);
        registerPage.enterToFirstNameTextbox(firstName);

        ExtentManager.getTest().log(Status.INFO, "User_01_Register - STEP 04: Enter to lastName textbox with value" + lastName);
        registerPage.enterToLastNameTextbox(lastName);

        ExtentManager.getTest().log(Status.INFO, "User_01_Register - STEP 08: Enter to emailAddress textbox with value" + emailAddress);
        registerPage.enterToEmailTextbox(emailAddress);

        ExtentManager.getTest().log(Status.INFO, "User_01_Register - STEP 09: Enter to companyName textbox with value" + companyName);
        registerPage.enterToCompanyTextbox(companyName);

        ExtentManager.getTest().log(Status.INFO, "User_01_Register - STEP 10: Enter to password textbox with value" + password);
        registerPage.enterToPasswordTextbox(password);

        ExtentManager.getTest().log(Status.INFO, "User_01_Register - STEP 11: Enter to Confirmpassword textbox with value" + password);
        registerPage.enterToConfirmPasswordTextbox(password);

        ExtentManager.getTest().log(Status.INFO, "User_01_Register - STEP 12: Click to Register button");
        registerPage.clickToRegisterButton();

        //    Assert 02 => FAILED
        ExtentManager.getTest().log(Status.INFO, "User_01_Register - STEP 13: Verify success message is displayed");
        verifyEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed!!!");
    }

    @Test
    public void User_02_My_Account(Method method) {
        ExtentManager.startTest(method.getName() + "" + browserName, "User_03_My_Account - STEP 01: Open Register page");
        customerInfoPage = homePage.openCustomerInfoPage();

        verifyTrue(customerInfoPage.isGenderMaleSelected());
        verifyEquals(customerInfoPage.getFirstNameTextboxValue(),firstName);
        verifyEquals(customerInfoPage.getLastNameTextboxValue(),lastName);
        verifyEquals(customerInfoPage.getEmailTextboxValue(),emailAddress);

    }

    @Test
    public void User_03_Dynamic_Page(Method method) {
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

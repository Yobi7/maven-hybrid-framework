package com.nopcommerce.users;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.PageGenerator;
import pageObjects.nopCommerce.user.*;


public class Level_13_Assert extends BaseTest {

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

        // Assert 01 => FAILED
        Assert.assertEquals(registerPage.getRegisterPageTitle(),"REGISTER");

        registerPage.clickToMaleRadio();
        registerPage.enterToFirstNameTextbox(firstName);
        registerPage.enterToLastNameTextbox(lastName);
        registerPage.enterToEmailTextbox(emailAddress);
        registerPage.enterToCompanyTextbox(companyName);
        registerPage.enterToPasswordTextbox(password);
        registerPage.enterToConfirmPasswordTextbox(password);
        registerPage.clickToRegisterButton();

        //    Assert 02 => FAILED
        Assert.assertEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed!!!");
    }

    @Test
    public void User_02_Login() {
        loginPage = registerPage.openLoginPage();

        homePage = loginPage.loginToSystem(emailAddress, password);

        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
    }
    @Test
    public void User_03_My_Account() {
        customerInfoPage = homePage.openCustomerInfoPage();

        Assert.assertTrue(customerInfoPage.isGenderMaleSelected());
        Assert.assertEquals(customerInfoPage.getFirstNameTextboxValue(),firstName);
        Assert.assertEquals(customerInfoPage.getLastNameTextboxValue(),lastName);
        Assert.assertEquals(customerInfoPage.getDayDropdownSelectedValue(),day);
        Assert.assertEquals(customerInfoPage.getMonthDropdownSelectedValue(),month);
        Assert.assertEquals(customerInfoPage.getYearDropdownSelectedValue(),year);
        Assert.assertEquals(customerInfoPage.getEmailTextboxValue(),emailAddress);
        Assert.assertEquals(customerInfoPage.getCompanyTextboxValue(),companyName);
    }

    @Test
    public void User_04_Dynamic_Page() {
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

    @Test
    public void User_05_Dynamic_Page() {
        // Address --> Reward Point
        addressPage.openSidebarLinkByNames("Reward points");
        rewardPointPage = PageGenerator.getUserRewardPointPage(driver);

        // Reward Point --> Order
        rewardPointPage.openSidebarLinkByNames("Orders");
        orderPage = PageGenerator.getUserOrderPage(driver);

        // Order --> Address
        orderPage.openSidebarLinkByNames("Addresses");
        addressPage = PageGenerator.getUserAddressPage(driver);

        // Address --> Customer Info
        addressPage.openSidebarLinkByNames("Customer info");
        customerInfoPage = PageGenerator.getUserCustomerPage(driver);
    }

    // Post-Condition
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}

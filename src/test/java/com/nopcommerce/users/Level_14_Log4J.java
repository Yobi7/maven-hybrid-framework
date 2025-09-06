package com.nopcommerce.users;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.PageGenerator;
import pageObjects.nopCommerce.user.*;


public class Level_14_Log4J extends BaseTest {

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
        log.info("User_01_Register - STEP 01: Open Register page");
        registerPage = homePage.openRegisterPage();

        // Assert 01 => FAILED
        verifyEquals(registerPage.getRegisterPageTitle(),"REGISTER");

        log.info("User_01_Register - STEP 02: Click to Male to radio button");
        registerPage.clickToMaleRadio();

        log.info("User_01_Register - STEP 03: Enter to FirstName textbox with value" + firstName);
        registerPage.enterToFirstNameTextbox(firstName);

        log.info("User_01_Register - STEP 04: Enter to lastName textbox with value" + lastName);
        registerPage.enterToLastNameTextbox(lastName);


        log.info("User_01_Register - STEP 08: Enter to emailAddress textbox with value" + emailAddress);
        registerPage.enterToEmailTextbox(emailAddress);

        log.info("User_01_Register - STEP 09: Enter to companyName textbox with value" + companyName);
        registerPage.enterToCompanyTextbox(companyName);

        log.info("User_01_Register - STEP 10: Enter to password textbox with value" + password);
        registerPage.enterToPasswordTextbox(password);

        log.info("User_01_Register - STEP 11: Enter to Confirmpassword textbox with value" + password);
        registerPage.enterToConfirmPasswordTextbox(password);

        log.info("User_01_Register - STEP 12: Click to Register button");
        registerPage.clickToRegisterButton();

        //    Assert 02 => FAILED
        log.info("User_01_Register - STEP 13: Verify success message is displayed");
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

        verifyTrue(customerInfoPage.isGenderMaleSelected());
        verifyEquals(customerInfoPage.getFirstNameTextboxValue(),firstName);
        verifyEquals(customerInfoPage.getLastNameTextboxValue(),lastName);
        verifyEquals(customerInfoPage.getDayDropdownSelectedValue(),day);
        verifyEquals(customerInfoPage.getMonthDropdownSelectedValue(),month);
        verifyEquals(customerInfoPage.getYearDropdownSelectedValue(),year);
        verifyEquals(customerInfoPage.getEmailTextboxValue(),emailAddress);
        verifyEquals(customerInfoPage.getCompanyTextboxValue(),companyName);
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

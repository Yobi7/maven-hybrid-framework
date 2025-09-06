package com.nopcommerce.users;

import com.nopcommerce.common.Login;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.PageGenerator;
import pageObjects.nopCommerce.user.*;


public class Level_20_Share_State extends BaseTest {

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

        // Pre-condition: login by cookie
        homePage.setCookies(driver, Login.nopCommerceCookies);

        homePage.refreshCurrentPage(driver);

        verifyEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed!!!");

    }

    // Test case
    @Test
    public void User_01_Order() {

    }

    @Test
    public void User_02_Payment() {

    }
    @Test
    public void User_03_My_Account() {

    }

    // Post-Condition
    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserDriver();
    }
}

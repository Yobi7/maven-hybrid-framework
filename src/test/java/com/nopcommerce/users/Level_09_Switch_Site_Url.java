package com.nopcommerce.users;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.admin.AdminDashboardPO;
import pageObjects.nopCommerce.admin.AdminLoginPO;
import pageObjects.nopCommerce.user.UserCustomerInfoPO;
import pageObjects.nopCommerce.user.UserHomePO;
import pageObjects.nopCommerce.user.UserLoginPO;
import pageObjects.nopCommerce.PageGenerator;
import pageObjects.nopCommerce.user.UserRegisterPO;

public class Level_09_Switch_Site_Url extends BaseTest {
    // Declare Variables
    private WebDriver driver;
    private UserHomePO userHomePage;
    private UserRegisterPO userRegisterPage;
    private UserLoginPO userLoginPage;
    private UserCustomerInfoPO userCustomerInfoPage;
    private AdminDashboardPO adminDashboardPage;
    private AdminLoginPO adminLoginPage;
    private String firstName, lastName, day, month, year, emailAddress, companyName, password;
    private String userURL, adminURL, adminEmailAddress, adminPassword;

    @Parameters({"browser", "userURL", "adminURL"})
    @BeforeClass
    public void beforeClass(String browserName, String userURL, String adminURL) {
        this.userURL = userURL;
        this.adminURL = adminURL;

        driver = getBrowserDriver(browserName, userURL);

        userHomePage = PageGenerator.getUserHomePage(driver);

        firstName = "Asaki";
        lastName = "Hyuga";
        day = "07";
        month = "March";
        year = "1995";
        emailAddress = "Asaki" + generateRandomNumber() + "@gmail.ce";
        companyName = "ABC";
        password = "123456";

        adminEmailAddress = "admin@yourstore.com";
        adminPassword = "admin";

        // Pre-Condition
        userRegisterPage = userHomePage.openRegisterPage();

        userRegisterPage.clickToMaleRadio();
        userRegisterPage.enterToFirstNameTextbox(firstName);
        userRegisterPage.enterToLastNameTextbox(lastName);
        userRegisterPage.enterToEmailTextbox(emailAddress);
        userRegisterPage.enterToCompanyTextbox(companyName);
        userRegisterPage.enterToPasswordTextbox(password);
        userRegisterPage.enterToConfirmPasswordTextbox(password);
        userRegisterPage.clickToRegisterButton();

        Assert.assertEquals(userRegisterPage.getRegisterSuccessMessage(),"Your registration completed");

        userHomePage = userRegisterPage.clickToLogoutLink();
    }

    // Test case
    @Test
    public void Role_01_User_Site_To_Admin_Site() {
        userLoginPage = userHomePage.openLoginPage();

        userHomePage = userLoginPage.loginToSystem(emailAddress, password);

        // Step để order 1 product nào đó
        // ...

        // Qua trang Admin để verify/approve cái order ở trên vs quyền Admin
        userHomePage.openPageURL(driver, this.adminURL);
        adminLoginPage = PageGenerator.getAdminLoginPage(driver);

        // Login vào trang Admin
        adminLoginPage.enterToEmailTextbox(adminEmailAddress);
        adminLoginPage.enterToPasswordTextbox(adminPassword);
        adminDashboardPage = adminLoginPage.clickToLoginButton();
    }

    @Test
    public void Role_02_Admin_Site_To_User_Site() {
        // Vào trang Order / Customer / ...
        // ...
        adminDashboardPage.openPageURL(driver, this.userURL);
        userHomePage = PageGenerator.getUserHomePage(driver);

        // Action các step tiếp theo
        //...
        userCustomerInfoPage = userHomePage.openCustomerInfoPage();
        Assert.assertTrue(userCustomerInfoPage.isGenderMaleSelected());
        Assert.assertEquals(userCustomerInfoPage.getFirstNameTextboxValue(),firstName);
        Assert.assertEquals(userCustomerInfoPage.getLastNameTextboxValue(),lastName);
        Assert.assertEquals(userCustomerInfoPage.getDayDropdownSelectedValue(),day);
        Assert.assertEquals(userCustomerInfoPage.getMonthDropdownSelectedValue(),month);
        Assert.assertEquals(userCustomerInfoPage.getYearDropdownSelectedValue(),year);
        Assert.assertEquals(userCustomerInfoPage.getEmailTextboxValue(),emailAddress);
        Assert.assertEquals(userCustomerInfoPage.getCompanyTextboxValue(),companyName);

    }

    // Post-Condition
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}

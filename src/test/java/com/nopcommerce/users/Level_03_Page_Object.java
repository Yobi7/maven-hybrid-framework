package com.nopcommerce.users;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.user.UserCustomerInfoPO;
import pageObjects.nopCommerce.user.UserHomePO;
import pageObjects.nopCommerce.user.UserLoginPO;
import pageObjects.nopCommerce.user.UserRegisterPO;

import java.time.Duration;

public class Level_03_Page_Object extends BaseTest {

    // Declare Variables
    private WebDriver driver;
    private UserHomePO homePage;
    private UserRegisterPO registerPage;
    private UserLoginPO loginPage;
    private UserCustomerInfoPO customerInfoPage;
    private String firstName, lastName, day, month, year, emailAddress, companyName, password;

    // Pre-Condition
    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        homePage = new UserHomePO(driver);

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
        homePage.openRegisterPage();

        registerPage = new UserRegisterPO(driver);
        registerPage.clickToMaleRadio();
        registerPage.enterToFirstNameTextbox(firstName);
        registerPage.enterToLastNameTextbox(lastName);
        registerPage.enterToEmailTextbox(emailAddress);
        registerPage.enterToCompanyTextbox(companyName);
        registerPage.enterToPasswordTextbox(password);
        registerPage.enterToConfirmPasswordTextbox(password);
        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed");
    }

    @Test
    public void User_02_Login() {
        registerPage.openLoginPage();

        // Từ Register Page qua Login Page
        // Page đó được sinh ra và bắt đầu làm những action của Page đó
        loginPage = new UserLoginPO(driver);

        loginPage.enterToEmailTextbox(emailAddress);
        loginPage.enterToPasswordTextbox(password);
        loginPage.clickToLoginButton();

        // Từ Login Page qua Home Page
        // Page đó được sinh ra và bắt đầu làm những action của Page đó
        homePage = new UserHomePO(driver);

        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
    }
    @Test
    public void User_03_My_Account() {
        // Từ Home Page qua Customer Info Page
        // Page đó được sinh ra và bắt đầu làm những action của Page đó
        homePage.openCustomerInfoPage();
        customerInfoPage = new UserCustomerInfoPO(driver);
        Assert.assertTrue(customerInfoPage.isGenderMaleSelected());
        Assert.assertEquals(customerInfoPage.getFirstNameTextboxValue(),firstName);
        Assert.assertEquals(customerInfoPage.getLastNameTextboxValue(),lastName);
        Assert.assertEquals(customerInfoPage.getDayDropdownSelectedValue(),day);
        Assert.assertEquals(customerInfoPage.getMonthDropdownSelectedValue(),month);
        Assert.assertEquals(customerInfoPage.getYearDropdownSelectedValue(),year);
        Assert.assertEquals(customerInfoPage.getEmailTextboxValue(),emailAddress);
        Assert.assertEquals(customerInfoPage.getCompanyTextboxValue(),companyName);
    }

    // Post-Condition
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}

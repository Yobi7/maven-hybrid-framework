package com.orangehrm.pim;

import commons.BaseTest;
import jdk.jfr.Description;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.orangehrm.pim.DashboardPO;
import pageObjects.orangehrm.pim.LoginPO;
import pageObjects.orangehrm.pim.PageGenerator;
import pageObjects.orangehrm.pim.employee.AddNewEmployeePO;
import pageObjects.orangehrm.pim.employee.EmployeeListPO;
import pageObjects.orangehrm.pim.employee.PersonalDetailsPO;
import testdata.jsonData.orangeHRM.LoginInfoJSON;

import java.util.List;
import java.util.Map;

public class Login extends BaseTest {
    WebDriver driver;
    //FakerConfig fakerConfig;
    private LoginPO loginPage;
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

    @Description("Verify login fails with invalid username")
    @Test
    public void Login_01_Invalid_Username() {
        loginInfo = loginDataMap.get("invalid username");
        username = loginInfo.getUsername();
        password = loginInfo.getPassword();
        loginPage.clickToLoginFail(username, password);
        System.out.println(">>> Running test with data: " + username + " / " + password);

        Assert.assertEquals(loginPage.getErrorMessage(), "Invalid credentials");
    }

    @Description("Verify login fails with invalid password")
    @Test
    public void Login_02_Invalid_Password() {
        loginInfo = loginDataMap.get("invalid password");
        username = loginInfo.getUsername();
        password = loginInfo.getPassword();
        loginPage.clickToLoginFail(username, password);
        System.out.println(">>> Running test with data: " + username + " / " + password);

        Assert.assertEquals(loginPage.getErrorMessage(), "Invalid credentials");
    }

    @Description("Verify login fails with empty username")
    @Test
    public void Login_03_Empty_UserName() {
        loginInfo = loginDataMap.get("empty username");
        username = loginInfo.getUsername();
        password = loginInfo.getPassword();
        loginPage.clickToLoginFail(username, password);
        System.out.println(">>> Running test with data: " + username + " / " + password);

        Assert.assertEquals(loginPage.getErrorMessage(), "Invalid credentials");
    }


    @Description("Verify login fails with empty password")
    @Test
    public void Login_04_Empty_Password() {
        loginInfo = loginDataMap.get("empty password");
        username = loginInfo.getUsername();
        password = loginInfo.getPassword();
        loginPage.clickToLoginFail(username, password);
        System.out.println(">>> Running test with data: " + username + " / " + password);

        Assert.assertEquals(loginPage.getErrorMessage(), "Invalid credentials");
    }

    @Description("Verify login fails with empty all")
    @Test
    public void Login_05_Empty_All() {
        loginInfo = loginDataMap.get("empty all");
        username = loginInfo.getUsername();
        password = loginInfo.getPassword();
        loginPage.clickToLoginFail(username, password);
        System.out.println(">>> Running test with data: " + username + " / " + password);

        Assert.assertEquals(loginPage.getErrorMessage(), "Invalid credentials");
    }

    @AfterClass
    public void afterClass() {
        closeBrowserDriver();
    }

}
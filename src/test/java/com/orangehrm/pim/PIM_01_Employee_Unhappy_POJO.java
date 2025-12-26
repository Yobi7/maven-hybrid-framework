package com.orangehrm.pim;

import commons.BaseTest;
import commons.LoginHelper;
import models.PIM.Employee;
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
import testData.EmployeeData;

public class PIM_01_Employee_Unhappy_POJO extends BaseTest {
    private WebDriver driver;
    private LoginPO loginPage;
    private DashboardPO dashboardPage;
    private EmployeeListPO employeeListPage;
    private AddNewEmployeePO addNewEmployeePage;
    private PersonalDetailsPO personalDetailsPage;
    private String employeeID, firstName, lastName;
    private String editFirstName, editLastName, driverLicenseNumber, driverLicenseExpiryDate, nationality, maritalStatus, dateOfBirth, gender;
    private String avatarImageName = "Nguyen Mie (2).jpg";


    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        loginPage = PageGenerator.getLoginPage(driver);

        editFirstName = "Donald";
        editLastName = "Trump";
        driverLicenseNumber = "012345678";
        driverLicenseExpiryDate = "2030-10-10";
        nationality = "American";
        maritalStatus = "Married";
        dateOfBirth = "1995-03-05";
        gender = "Male";

        dashboardPage = LoginHelper.LoginAsAdmin(driver);
    }

    @Test
    public void Employee_01_firstNameNull() {
        employeeListPage = dashboardPage.clickToPIMPage();
        addNewEmployeePage = employeeListPage.clickToAddEmployeeButton();

        addNewEmployeePage.addEmployeeWithFirstNameNull(EmployeeData.happyCase());

        employeeID = addNewEmployeePage.getEmployeeID();
        personalDetailsPage = addNewEmployeePage.clickToSaveButtonAtEmployeeContainer();
        Assert.assertEquals(addNewEmployeePage.showErrorMessage(), "Required");
    }



    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserDriver();
    }
}

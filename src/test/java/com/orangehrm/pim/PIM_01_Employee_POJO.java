package com.orangehrm.pim;

import commons.BaseTest;
import commons.LoginHelper;
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
import models.PIM.Employee;

public class PIM_01_Employee_POJO extends BaseTest {
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
    public void Employee_01_Add_New() {
        employeeListPage = dashboardPage.clickToPIMPage();
        addNewEmployeePage = employeeListPage.clickToAddEmployeeButton();

        addNewEmployeePage.addNewEmployee(EmployeeData.happyCase());
        employeeID = addNewEmployeePage.getEmployeeID();
        personalDetailsPage = addNewEmployeePage.clickToSaveButtonAtEmployeeContainer();
    }

    @Test
    public void Employee_02_Upload_Avatar() {
        personalDetailsPage.clickToEmployeeAvatarImage();

        // Lấy ra height / width của element (avatar) => A
        Dimension beforeUpload = personalDetailsPage.getAvatarSize();
        System.out.println("before save:" + beforeUpload);

        personalDetailsPage.uploadMultipleFiles(driver, avatarImageName);

        personalDetailsPage.clickToSaveButtonAtProfileContainer();

        //1
        Assert.assertTrue(personalDetailsPage.isSuccessMessageIsDisplayed(driver));

        //2
        personalDetailsPage.waitAllLoadingIconInvisible(driver);

        //3
        Assert.assertTrue(personalDetailsPage.isProfileAvatarUpdateSuccess(beforeUpload));

    }

    @Test
    public void Employee_03_Update_Personal_Details() {
        personalDetailsPage.openPersonalDetailPage();
        Employee editEmployee = EmployeeData.happyCase();

        personalDetailsPage.enterToFirstNameTextbox(editEmployee.getFirstName());
        personalDetailsPage.enterToLastNameTextbox(editEmployee.getLastName());

        Assert.assertEquals(personalDetailsPage.getEmployeeID(), employeeID);

        personalDetailsPage.enterToDriverLicenseTextbox(editEmployee.getDriverLicenseNumber());
        personalDetailsPage.enterToLicenseExpiryDateTextbox(editEmployee.getDriverLicenseExpiryDate());
        personalDetailsPage.selectNationalityDropdown(editEmployee.getNationality());
        personalDetailsPage.selectMaritalStatusDropdown(editEmployee.getMaritalStatus());
        personalDetailsPage.enterToDateOfBirthTextbox(editEmployee.getDateOfBirth());
        personalDetailsPage.selectGenderMaleRadioButton(editEmployee.getGender());
        personalDetailsPage.clickSaveButtonAtPersonalDetailContainer();

        Assert.assertTrue(personalDetailsPage.isSuccessMessageIsDisplayed(driver));

        Assert.assertEquals(personalDetailsPage.getFirstNameTextboxValue(), editEmployee.getFirstName());
        Assert.assertEquals(personalDetailsPage.getLastNameTextboxValue(), editEmployee.getLastName());
        Assert.assertEquals(personalDetailsPage.getEmployeeID(), employeeID);
        Assert.assertEquals(personalDetailsPage.getDriverLicenseTextboxValue(), editEmployee.getDriverLicenseNumber());
        Assert.assertEquals(personalDetailsPage.getLicenseExpiryDateTextboxValue(), editEmployee.getDriverLicenseExpiryDate());
        Assert.assertEquals(personalDetailsPage.getNationalityDropdownValue(), editEmployee.getNationality());
        Assert.assertEquals(personalDetailsPage.getMaritalStatusDropdownValue(), editEmployee.getMaritalStatus());
        Assert.assertEquals(personalDetailsPage.getDateOfBirthTextboxValue(), editEmployee.getDateOfBirth());
        Assert.assertTrue(personalDetailsPage.isGenderMaleRadioSelected(editEmployee.getGender()));
    }

//    @Test
//    public void Employee_04_Contact_Details() {
//
//    }
//
//    @Test
//    public void Employee_05_Emergency_Contact() {
//
//    }
//
//    @Test
//    public void Employee_06_Dependents() {
//
//    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserDriver();
    }
}

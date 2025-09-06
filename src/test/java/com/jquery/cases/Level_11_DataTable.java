package com.jquery.cases;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.jquery.HomePO;
import pageObjects.jquery.PageGenerator;

public class Level_11_DataTable extends BaseTest {

    // Declare Variables
    private WebDriver driver;
    private HomePO homePage;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        homePage = PageGenerator.getHomePgae(driver);
    }

    // Test case
    //@Test
    public void Table_01_Paging() {
        // Navigate to any page (paging)
        homePage.openPageByNumber("15");
        Assert.assertTrue(homePage.isPageNumberActived("15"));

        homePage.openPageByNumber("5");
        Assert.assertTrue(homePage.isPageNumberActived("5"));
    }

    //@Test
    public void Table_02_Search() {
        // Enter value to header textbox
        homePage.enterToTextboxByHeaderName("Country", "Algeria");
        homePage.sleepInSecond(2);
        Assert.assertTrue(homePage.isRowDataValueDisplayed("283821", "Algeria", "295140", "578961"));
        homePage.refreshCurrentPage(driver);

        homePage.enterToTextboxByHeaderName("Males", "12599691");
        homePage.sleepInSecond(2);
        homePage.refreshCurrentPage(driver);

        homePage.enterToTextboxByHeaderName("Females", "764956");
        homePage.sleepInSecond(2);
        homePage.refreshCurrentPage(driver);

        // Verify data in any row
    }
    //@Test
    public void Table_03_Delete_Edit() {
        // Search by country
        homePage.enterToTextboxByHeaderName("Country", "Afghanistan");
        homePage.sleepInSecond(2);

        // Click delete button
        homePage.deleteRowByCountryName("Afghanistan");
        homePage.refreshCurrentPage(driver);

        // Click edit button
        homePage.enterToTextboxByHeaderName("Country", "Algeria");
        homePage.sleepInSecond(2);
        homePage.clickEditButtonByCountryName("Algeria");

    }

    @Test
    public void Table_04_Get_All_Row_Or_Columnm() {
        System.out.println(homePage.getAllValueAtColumnName("Country"));
        homePage.getAllValueAtColumnName("Females");
    }

    //@Test
    public void Table_05_Action_By_Index() {
        homePage.openPageURL(driver,"https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");
        driver.manage().window().maximize();

        homePage.clickToLoadDataButton();

        // Có thể thao tác vs bất kì 1 column/row nào
        homePage.enterToTextboxByIndex("4", "Contact Person", "Hyuga Asaki");
        homePage.sleepInSecond(3);

        homePage.enterToTextboxByIndex("5", "Company", "Hyuga Company");

        homePage.selectToDropdownByIndex("6", "Country", "Hong Kong");
        homePage.selectToDropdownByIndex("8", "Country", "United Kingdom");

        homePage.checkToCheckboxByIndex("6", "NPO?", true);
        homePage.checkToCheckboxByIndex("5", "NPO?", false);

        homePage.clickToIconByIndex("6", "Insert");

    }

    // Post-Condition
    @AfterClass
    public void afterClass() {
       // driver.quit();
    }
}

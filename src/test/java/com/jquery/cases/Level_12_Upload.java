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

public class Level_12_Upload extends BaseTest {

    // Declare Variables
    private WebDriver driver;
    private HomePO homePage;
    private String azura, jiyan, rover;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        homePage = PageGenerator.getHomePgae(driver);
        azura = "Azura.jpeg";
        jiyan = "Jiyan.jpeg";
        rover = "Rover_1.jpg";
    }

    // Test case
    @Test
    public void Upload_01() {
        // Lấy ra được đường dẫn của file / thư mục cho đúng
        // Tất cả các OS: Window / Linux / MAC đều chạy được
        // UPLOAD_PATH

        // Có thể upload 1 lần 1 file => Dùng 1 hàm
        homePage.uploadMultipleFiles(driver, azura);
        homePage.sleepInSecond(3);
        homePage.refreshCurrentPage(driver);

        // Có thể upload 1 lần nhiều file => Dùng 1 hàm
        homePage.uploadMultipleFiles(driver, azura, jiyan, rover);
        homePage.sleepInSecond(3);

        // Verify load file
        Assert.assertTrue(homePage.isFileLoadedByName(azura));
        Assert.assertTrue(homePage.isFileLoadedByName(jiyan));
        Assert.assertTrue(homePage.isFileLoadedByName(rover));

        // Click upload button at each file
        homePage.clickToUploadButton();

        // Có thể verify 1 file / nhiều file uploaded xong => Dùng 1 hàm
        Assert.assertTrue(homePage.isFileUploadedByName(azura));
        Assert.assertTrue(homePage.isFileUploadedByName(jiyan));
        Assert.assertTrue(homePage.isFileUploadedByName(rover));

        // Có cần care tới Open File Dialog hay không?

        // Không cần care - cách đang làm không cần đụng tới Open File Dialog

    }

    // Post-Condition
    @AfterClass
    public void afterClass() {
       // driver.quit();
    }
}

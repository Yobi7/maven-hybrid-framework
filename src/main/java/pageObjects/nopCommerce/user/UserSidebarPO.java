package pageObjects.nopCommerce.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.nopCommerce.PageGenerator;
import pageUIs.nopCommerce.user.UserSidebarPageUI;

public class UserSidebarPO extends BasePage {
    WebDriver driver;

    public UserSidebarPO(WebDriver driver) {
        this.driver = driver;
    }

    public UserAddressPO openAddressPage() {
        waitForElementClickable(driver, UserSidebarPageUI.ADDRESS_LINK);
        clickToElement(driver, UserSidebarPageUI.ADDRESS_LINK);
        return PageGenerator.getUserAddressPage(driver);
    }

    public UserRewardPointPO openRewardPointPage() {
        waitForElementClickable(driver, UserSidebarPageUI.REWARD_POINT_LINK);
        clickToElement(driver, UserSidebarPageUI.REWARD_POINT_LINK);
        return PageGenerator.getUserRewardPointPage(driver);
    }

    public UserOrderPO openOrderPage() {
        waitForElementClickable(driver, UserSidebarPageUI.ORDER_LINK);
        clickToElement(driver, UserSidebarPageUI.ORDER_LINK);
        return PageGenerator.getUserOrderPage(driver);
    }

    public UserCustomerInfoPO openCustomerInfoPage() {
        waitForElementClickable(driver, UserSidebarPageUI.CUSTOMER_INFO_LINK);
        clickToElement(driver, UserSidebarPageUI.CUSTOMER_INFO_LINK);
        return PageGenerator.getUserCustomerPage(driver);
    }

    // Case nay chi danh cho truong hop it truong hop (TC_04)
    public UserSidebarPO openSidebarLinkByName(String pageName) {
        waitForElementClickable(driver, UserSidebarPageUI.DYNAMIC_LINK, pageName);
        clickToElement(driver, UserSidebarPageUI.DYNAMIC_LINK, pageName);
        switch (pageName) {
            case "Addresses":
                return PageGenerator.getUserAddressPage(driver);
            case "Reward points":
                return PageGenerator.getUserRewardPointPage(driver);
            case "Orders":
                return PageGenerator.getUserOrderPage(driver);
            case "Customer info":
                return PageGenerator.getUserCustomerPage(driver);
            default:
                throw new RuntimeException("Page name is not valid!!!!");
        }
    }

    // Case nay cho nhieu truong hop (TC_05)
    public void openSidebarLinkByNames(String pageName) {
        waitForElementClickable(driver, UserSidebarPageUI.DYNAMIC_LINK, pageName);
        clickToElement(driver, UserSidebarPageUI.DYNAMIC_LINK, pageName);
    }
}

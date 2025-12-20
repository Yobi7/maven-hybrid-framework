package pageObjects.orangehrm.pim;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.orangehrm.ForgotPasswrodPUI;
import pageUIs.orangehrm.LoginPUI;

public class ForgotPassPO extends BasePage {
    private WebDriver driver;

    public ForgotPassPO(WebDriver driver) {
        this.driver = driver;
    }


    public String getResetPageTitle() {
        waitForElementVisible(driver, ForgotPasswrodPUI.RESET_TITLE);
        return getElementText(driver, ForgotPasswrodPUI.RESET_TITLE);
    }
}

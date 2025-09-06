package pageObjects.orangehrm.pim;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.orangehrm.LoginPUI;

public class LoginPO extends BasePage {
    private WebDriver driver;

    public LoginPO(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToUsernameTextbox(String userName) {
        waitForElementVisible(driver, LoginPUI.USERNAME_TEXBOX);
        sendkeyToElement(driver, LoginPUI.USERNAME_TEXBOX, userName);
    }

    public void enterToPasswordTextbox(String password) {
        waitForElementVisible(driver, LoginPUI.PASSWORD_TEXBOX);
        sendkeyToElement(driver, LoginPUI.PASSWORD_TEXBOX, password);
    }

    public DashboardPO clickToLoginButton() {
        waitForElementClickable(driver, LoginPUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPUI.LOGIN_BUTTON);
        waitAllLoadingIconInvisible(driver);
        return PageGenerator.getDashboardPage(driver);
    }
}

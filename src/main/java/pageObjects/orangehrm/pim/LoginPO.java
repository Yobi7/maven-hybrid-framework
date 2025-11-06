package pageObjects.orangehrm.pim;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.user.UserRegisterPageUI;
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
        //waitAllLoadingIconInvisible(driver);
        return PageGenerator.getDashboardPage(driver);
    }

    public void clickToLoginFail(String username, String password) {
        enterToUsernameTextbox(username);
        enterToPasswordTextbox(password);
        sleepInSecond(1);
        clickToElement(driver, LoginPUI.LOGIN_BUTTON);
    }

    public String getErrorMessage() {
        waitForElementVisible(driver, LoginPUI.ERROR_MESSAGE);
        return getElementText(driver, LoginPUI.ERROR_MESSAGE);
    }
}

package pageObjects.orangehrm.pim;

import commons.BasePage;
import commons.LoginHelper;
import org.openqa.selenium.WebDriver;
import pageObjects.nopCommerce.user.UserHomePO;
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

    public DashboardPO loginToSystem(String emailAddress, String password) {
        enterToUsernameTextbox(emailAddress);
        enterToPasswordTextbox(password);
        clickToLoginButton();
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

    public boolean isLogoVisible() {
        waitForElementVisible(driver,LoginPUI.LOGO_LOGIN_IMG);
        return isElementDisplayed(driver, LoginPUI.LOGO_LOGIN_IMG);
    }

    public ForgotPassPO clickToForgotPasswordButton() {
        waitForElementClickable(driver,LoginPUI.FORGOT_PASSWORD_LINK);
        clickToElement(driver,LoginPUI.FORGOT_PASSWORD_LINK);
        return PageGenerator.getForgotPassPage(driver);
    }
}

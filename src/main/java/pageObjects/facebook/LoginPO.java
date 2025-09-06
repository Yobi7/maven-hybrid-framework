package pageObjects.facebook;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.facebook.LoginPageUI;

public class LoginPO extends BasePage {
    WebDriver driver;

    public LoginPO(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToNewAccountButton() {
        waitForElementClickable(driver, LoginPageUI.CREATE_NEW_ACCOUNT_BUTTON);
        clickToElement(driver, LoginPageUI.CREATE_NEW_ACCOUNT_BUTTON);
    }

    public void enterToEmailAddressTextbox(String emailAdress) {
        waitForElementVisible(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX);
        sendkeyToElement(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX, emailAdress);
    }

    public boolean isConfirmEmailTextboxDisplayed() {
        //waitForElementVisible(driver, LoginPageUI.CONFIRM_EMAIL_ADDRESS_TEXTBOX);
        return isElementDisplayed(driver, LoginPageUI.CONFIRM_EMAIL_ADDRESS_TEXTBOX);
    }

    public boolean isConfirmEmailTextboxUndisplayed() {
        //waitForElementVisible(driver, LoginPageUI.CONFIRM_EMAIL_ADDRESS_TEXTBOX);
        return isElementDisplayed(driver, LoginPageUI.CONFIRM_EMAIL_ADDRESS_TEXTBOX);
    }

    public void clickToCloseIcon() {
        waitForElementClickable(driver, LoginPageUI.CLOSE_ICON);
        clickToElement(driver, LoginPageUI.CLOSE_ICON);

    }
}

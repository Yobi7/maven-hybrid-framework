package pageObjects.orangehrm.pim.employee;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.orangehrm.pim.PageGenerator;
import pageUIs.orangehrm.pim.employee.AddNewPUI;

public class AddNewEmployeePO extends BasePage {
    private WebDriver driver;

    public AddNewEmployeePO(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToFirstNameTextbox(String firstName) {
        waitForElementVisible(driver, AddNewPUI.FIRSTNAME_TEXTBOX);
        sendkeyToElement(driver, AddNewPUI.FIRSTNAME_TEXTBOX,firstName);
    }

    public void enterToLastNameTextbox(String lastName) {
        waitForElementVisible(driver, AddNewPUI.LASTNAME_TEXTBOX);
        sendkeyToElement(driver, AddNewPUI.LASTNAME_TEXTBOX,lastName);
    }

    public String getEmployeeID() {
        waitForElementVisible(driver, AddNewPUI.EMPLOYEE_ID_TEXTBOX);
        return getElementAttribute(driver, AddNewPUI.EMPLOYEE_ID_TEXTBOX, "value");
    }

    public PersonalDetailsPO clickToSaveButtonAtEmployeeContainer() {
        waitForElementClickable(driver, AddNewPUI.SAVE_BUTTON_AT_ADD_EMPLOYEE_CONTAINER);
        clickToElement(driver, AddNewPUI.SAVE_BUTTON_AT_ADD_EMPLOYEE_CONTAINER);
        waitAllLoadingIconInvisible(driver);
        return PageGenerator.getPersonalDetailsPage(driver);
    }
}

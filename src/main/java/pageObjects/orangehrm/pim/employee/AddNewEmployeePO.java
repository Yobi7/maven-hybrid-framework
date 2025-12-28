package pageObjects.orangehrm.pim.employee;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.orangehrm.pim.PageGenerator;
import pageUIs.orangehrm.pim.employee.AddNewPUI;
import models.PIM.Employee;

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

    // ===== business flow (HAPPY CASE) =====
//    public void addNewEmployee(Employee employee) {
//        enterToFirstNameTextbox(employee.getFirstName());
//        enterToLastNameTextbox(employee.getLastName());
//    }
//
//    public void addEmployeeWithFirstNameNull(Employee employee) {
//        employee.setFirstName("");
//        addNewEmployee(employee);
//    }

    public String showErrorMessage() {
        waitForElementVisible(driver, AddNewPUI.ERROR_TEXT_WITH_FIRSTNAME_NULL);
        return getElementText(driver, AddNewPUI.ERROR_TEXT_WITH_FIRSTNAME_NULL);
    }

    // ===== JSON - Happy flow =====
    public void addNewEmployee(Employee employee) {
        enterToFirstNameTextbox(employee.getFirstName());
        enterToLastNameTextbox(employee.getLastName());
    }

    // ===== JSON - Unhappy behavior =====
    public void addEmployeeWithoutFirstName(Employee employee) {
        // Override data không hợp lệ tại PO
        employee.setFirstName("");
        addNewEmployee(employee);
    }
}

package pageObjects.orangehrm.pim.employee;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.orangehrm.pim.PageGenerator;
import pageUIs.orangehrm.pim.employee.EmployeeListPUI;

public class EmployeeListPO extends BasePage {
    private WebDriver driver;

    public EmployeeListPO(WebDriver driver) {
        this.driver = driver;
    }

    public AddNewEmployeePO clickToAddEmployeeButton() {
        waitForElementClickable(driver, EmployeeListPUI.ADD_EMPLOYEE_NAV_BUTTON);
        clickToElement(driver, EmployeeListPUI.ADD_EMPLOYEE_NAV_BUTTON);
        waitAllLoadingIconInvisible(driver);
        return PageGenerator.getAddNewEmployeePage(driver);
    }
}

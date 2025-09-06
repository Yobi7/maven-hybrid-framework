package pageObjects.orangehrm.pim.employee;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.orangehrm.pim.PageGenerator;
import pageUIs.orangehrm.pim.employee.EmployeeTabsPUI;

public class EmployeeTabs extends BasePage {
    private WebDriver driver;

    public EmployeeTabs(WebDriver driver) {
        this.driver = driver;
    }

    public PersonalDetailsPO openPersonalDetailPage()   {
        waitForElementClickable(driver, EmployeeTabsPUI.PERSONAL_DETAILS_LINK);
        clickToElement(driver, EmployeeTabsPUI.PERSONAL_DETAILS_LINK);
        waitAllLoadingIconInvisible(driver);
        return PageGenerator.getPersonalDetailsPage(driver);
    }
    public ContactDetailsPO openContactDetailsDetailPage()   {
        waitForElementClickable(driver, EmployeeTabsPUI.CONTACT_DETAILS_LINK);
        clickToElement(driver, EmployeeTabsPUI.CONTACT_DETAILS_LINK);
        waitAllLoadingIconInvisible(driver);
        return PageGenerator.getContactDetailsPage(driver);
    }
    public EmergencyContactsPO openEmergencyContactsPage()   {
        waitForElementClickable(driver, EmployeeTabsPUI.EMERGENCY_CONTACTS_LINK);
        clickToElement(driver, EmployeeTabsPUI.EMERGENCY_CONTACTS_LINK);
        waitAllLoadingIconInvisible(driver);
        return PageGenerator.getEmergencyContactsPage(driver);
    }

}

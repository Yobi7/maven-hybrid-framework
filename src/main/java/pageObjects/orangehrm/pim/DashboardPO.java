package pageObjects.orangehrm.pim;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.orangehrm.pim.employee.EmployeeListPO;
import pageUIs.orangehrm.DashboardPUI;

public class DashboardPO extends BasePage {
    private WebDriver driver;

    public DashboardPO(WebDriver driver) {
        this.driver = driver;
    }

    public EmployeeListPO clickToPIMPage() {
        waitForElementClickable(driver, DashboardPUI.PIM_LINK);
        clickToElement(driver, DashboardPUI.PIM_LINK);
        waitAllLoadingIconInvisible(driver);
        return PageGenerator.getEmployeeListPage(driver);
    }
}

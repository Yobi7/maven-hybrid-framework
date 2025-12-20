package commons;

import org.openqa.selenium.WebDriver;
import pageObjects.orangehrm.pim.DashboardPO;
import pageObjects.orangehrm.pim.LoginPO;
import pageObjects.orangehrm.pim.PageGenerator;
import pageUIs.orangehrm.LoginPUI;

public class LoginHelper extends BasePage{

    public static DashboardPO LoginAsAdmin(WebDriver driver) {
        LoginPO loginPage = new LoginPO(driver);
        return loginPage.loginToSystem(GlobalConstants.ADMIN_USERNAME, GlobalConstants.ADMIN_PASSWORD);
    }
}

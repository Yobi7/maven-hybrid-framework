package api;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginAPITest {

    @Test
    public void test_Login_API() {
        String cookie = LoginAPI.loginAndGetCookie();
        System.out.println("Cookie = " + cookie);
        Assert.assertNotNull(cookie);
    }

//        @Test
//        public void TC_Login_API_Then_Access_Dashboard() {
//
//            // 1. Login bằng API → lấy cookie
//            String sessionId = LoginAPI.loginAndGetCookie();
//
//            // 2. Mở browser (chưa login)
//            WebDriver driver = new ChromeDriver();
//            driver.get("http://localhost/orangehrm/web/index.php/auth/login");
//
//            // 3. Inject cookie
//            Cookie cookie = new Cookie(
//                    "_orangehrm",        // name
//                    sessionId,           // value
//                    "localhost",         // domain
//                    "/orangehrm/web",    // path
//                    null                 // expiry
//            );
//            driver.manage().addCookie(cookie);
//
//            // 4. Refresh để dùng cookie
//            driver.navigate().refresh();
//
//            // 5. Check dashboard (element chỉ có sau login)
//            boolean isDashboardDisplayed =
//                    driver.getCurrentUrl().contains("/dashboard");
//
//            Assert.assertTrue(isDashboardDisplayed);
//
//            driver.quit();
//        }
    }



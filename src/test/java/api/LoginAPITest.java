package api;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginAPITest {

    @Test
    public void test_Login_API() {
        String cookie = LoginAPI.loginAndGetCookie();
        System.out.println("Cookie = " + cookie);
        Assert.assertNotNull(cookie);
    }
}


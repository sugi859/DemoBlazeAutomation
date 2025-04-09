package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LogoutTests extends BaseTest {

    @Test
    public void testLogoutFunctionality() throws InterruptedException {
        HomePage home = new HomePage(driver);
        LoginPage login = new LoginPage(driver);

        // Login first
        home.clickLogin();
        login.enterUsername("validUsername"); // Replace with actual valid username
        login.enterPassword("validPassword"); // Replace with actual password
        login.clickLoginButton();

        Thread.sleep(2000);

        // Check logout visibility
        Assert.assertTrue(home.isLogoutVisible(), "Logout button is not visible");

        // Click logout
        home.clickLogout();
        Thread.sleep(2000);

        // Verify redirection (e.g., login button should be visible again)
        Assert.assertTrue(home.isLoginVisible(), "Redirection to home page failed after logout");
    }
}
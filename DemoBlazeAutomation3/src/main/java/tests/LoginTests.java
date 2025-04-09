package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {

    @Test
    public void testLoginButtonVisibility() {
        HomePage home = new HomePage(driver);
        Assert.assertTrue(home.isLoginVisible(), "Login button is not visible");
    }

    @Test
    public void testLoginFunctionalityWithValidCredentials() throws InterruptedException {
        HomePage home = new HomePage(driver);
        LoginPage login = new LoginPage(driver);

        home.clickLogin();
        login.enterUsername("validUsername"); // Use registered user
        login.enterPassword("validPassword"); // Use matching password
        login.clickLoginButton();

        Thread.sleep(2000); // Wait for login to complete, use explicit wait if preferred

        Assert.assertTrue(home.isWelcomeUserVisible(), "Login failed or Welcome user not displayed");
    }
}
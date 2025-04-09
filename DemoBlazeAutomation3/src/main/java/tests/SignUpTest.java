package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SignUpPage;

public class SignUpTest extends BaseTest {

    @Test
    public void testSignUpButtonVisibility() {
        HomePage home = new HomePage(driver);
        Assert.assertTrue(home.isSignUpVisible(), "Sign up button is not visible");
    }

    @Test
    public void testSignUpFunctionality() {
        HomePage home = new HomePage(driver);
        SignUpPage signUp = new SignUpPage(driver);

        home.clickSignUp();
        signUp.enterUsername("user" + System.currentTimeMillis()); // unique username
        signUp.enterPassword("Test@123");
        signUp.clickSignUpConfirm();

        // You can handle alert here to confirm sign up success
    }
}
package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {
    // Web Elements from the Sign Up modal
    @FindBy(id = "sign-username")
    private WebElement usernameField;

    @FindBy(id = "sign-password")
    private WebElement passwordField;

    @FindBy(xpath = "//button[text()='Sign up']")
    private WebElement signUpConfirmButton;

    @FindBy(xpath = "//div[@id='signInModal']//button[@class='btn btn-secondary' and text()='Close']")
    private WebElement closeButton;

    // Constructor
    public SignUpPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // Actions
    public void enterUsername(String username) {
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickSignUpConfirm() {
        signUpConfirmButton.click();
    }

    public void clickCloseButton() {
        closeButton.click();
    }
}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Web elements
    @FindBy(id = "nameofuser")
    private WebElement welcomeUser;

    @FindBy(id = "logout2")
    private WebElement logoutButton;

    @FindBy(id = "login2")
    private WebElement loginButton;

    @FindBy(id = "nava")
    private WebElement logo;

    @FindBy(xpath = "//a[contains(text(),'Phones') or contains(text(),'Laptops') or contains(text(),'Monitors')]")
    private List<WebElement> categories;

    @FindBy(xpath = "//a[@class='nav-link']")
    private List<WebElement> menuItems;

    // Action methods
    public boolean isWelcomeUserVisible() {
        return welcomeUser.isDisplayed();
    }

    public boolean isLogoutVisible() {
        return logoutButton.isDisplayed();
    }

    public boolean isLoginVisible() {
        return loginButton.isDisplayed();
    }

    public boolean isLogoVisible() {
        return logo.isDisplayed();
    }

    public boolean areCategoriesListed() {
        for (WebElement category : categories) {
            if (!category.isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    public boolean areMenuItemsDisplayed() {
        for (WebElement item : menuItems) {
            if (!item.isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    public void selectProduct(String productName) {
        driver.findElement(org.openqa.selenium.By.linkText(productName)).click();
    }

    public void navigateToCart() {
        driver.findElement(org.openqa.selenium.By.id("cartur")).click();
    }

    public void addToCart() {
        driver.findElement(org.openqa.selenium.By.xpath("//a[text()='Add to cart']")).click();
    }

	public void clickLogin() {
		// TODO Auto-generated method stub
		
	}

	public void clickLogout() {
		// TODO Auto-generated method stub
		
	}

	public void clickSignUp() {
		// TODO Auto-generated method stub
		
	}

	public boolean isSignUpVisible() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isLogoDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean areMenuItemsVisible() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean areCategoriesVisible() {
		// TODO Auto-generated method stub
		return false;
	}
}
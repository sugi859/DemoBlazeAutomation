package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage {
    private WebDriver driver;

    // WebElements
    @FindBy(xpath = "//button[text()='Place Order']")
    private WebElement placeOrderButton;

    @FindBy(id = "totalp")
    private WebElement totalPrice;

    // Constructor
    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Actions

    public void clickPlaceOrder() {
        placeOrderButton.click();
    }

    public String getTotalPrice() {
        return totalPrice.getText();
    }

    public void deleteProductByName(String productName) {
        List<WebElement> rows = driver.findElements(By.xpath("//tr"));
        for (WebElement row : rows) {
            if (row.getText().contains(productName)) {
                row.findElement(By.xpath(".//a[text()='Delete']")).click();
                break;
            }
        }
    }

    public boolean isCartEmpty() {
        List<WebElement> rows = driver.findElements(By.xpath("//tr"));
        return rows.size() <= 1; // Header only
    }
}
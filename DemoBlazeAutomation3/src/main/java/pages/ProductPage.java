package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductPage {
    private WebDriver driver;

    // WebElements
    @FindBy(xpath = "//div[@id='tbodyid']/div")
    private List<WebElement> productList;

    @FindBy(xpath = "//a[text()='Add to cart']")
    private WebElement addToCartButton;

    @FindBy(id = "cartur")
    private WebElement cartLink;

    // Constructor
    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Actions

    public void clickProductByName(String productName) {
        for (WebElement product : productList) {
            WebElement title = product.findElement(By.tagName("a"));
            if (title.getText().equalsIgnoreCase(productName)) {
                title.click();
                break;
            }
        }
    }

    public void clickAddToCart() {
        addToCartButton.click();
    }

    public void goToCart() {
        cartLink.click();
    }

    public String getProductTitleOnDetailsPage() {
        return driver.findElement(By.xpath("//h2[@class='name']")).getText();
    }

    public String getProductPriceOnDetailsPage() {
        return driver.findElement(By.xpath("//h3[@class='price-container']")).getText();
    }
}

package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductPage;

public class ProductTests extends BaseTest {

    @Test
    public void testProductMenuAndCategoriesVisible() throws InterruptedException {
        HomePage home = new HomePage(driver);

        Assert.assertTrue(home.isLogoDisplayed(), "Logo not displayed");
        Assert.assertTrue(home.isWelcomeUserVisible(), "Welcome user not visible");
        Assert.assertTrue(home.areMenuItemsVisible(), "Menu items not visible");
        Assert.assertTrue(home.areCategoriesVisible(), "Categories not listed");
    }

    @Test
    public void testProductDetailNavigationAndInfo() throws InterruptedException {
        ProductPage productPage = new ProductPage(driver);

        productPage.clickProductByName("Samsung galaxy s6");

        String actualTitle = productPage.getProductTitleOnDetailsPage();
        String actualPrice = productPage.getProductPriceOnDetailsPage();

        Assert.assertEquals(actualTitle, "Samsung galaxy s6", "Product title mismatch");
        Assert.assertTrue(actualPrice.contains("$"), "Product price not displayed properly");
    }
}

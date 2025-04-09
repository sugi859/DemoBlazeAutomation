package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ProductPage;

public class CartTests extends BaseTest {

    @Test
    public void testAddProductToCart() throws InterruptedException {
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);

        productPage.clickProductByName("Samsung galaxy s6");
        productPage.clickAddToCart();

        // Wait for alert and accept it
        Thread.sleep(2000);
        driver.switchTo().alert().accept();

        productPage.goToCart();
        Thread.sleep(2000);

        String total = cartPage.getTotalPrice();
        Assert.assertTrue(Integer.parseInt(total) > 0, "Cart total should be greater than 0");
    }

    @Test
    public void testDeleteProductFromCart() throws InterruptedException {
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);

        productPage.clickProductByName("Nokia lumia 1520");
        productPage.clickAddToCart();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();

        productPage.goToCart();
        Thread.sleep(2000);

        cartPage.deleteProductByName("Nokia lumia 1520");
        Thread.sleep(2000);

        Assert.assertTrue(cartPage.isCartEmpty(), "Cart should be empty after deletion");
    }
}
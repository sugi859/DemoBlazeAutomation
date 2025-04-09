package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.OrderPage;
import pages.ProductPage;

public class OrderTests extends BaseTest {

    @Test
    public void testCompleteOrderProcess() throws InterruptedException {
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);
        OrderPage orderPage = new OrderPage(driver);

        // Step 1: Add a product to cart
        productPage.clickProductByName("Samsung galaxy s6");
        productPage.clickAddToCart();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();

        // Step 2: Go to cart
        productPage.goToCart();
        Thread.sleep(2000);

        // Step 3: Click Place Order
        cartPage.clickPlaceOrder();
        Thread.sleep(1000);

        // Step 4: Fill form and purchase
        orderPage.enterOrderDetails("John Doe", "USA", "New York", "1234123412341234", "04", "2025");
        orderPage.clickPurchase();
        Thread.sleep(2000);

        // Step 5: Assert success and click OK
        Assert.assertTrue(orderPage.isSuccessMessageDisplayed(), "Purchase success message not shown");
        orderPage.clickOkButton();
    }
}
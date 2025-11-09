package com.example.tests;

import com.example.pageobject.*;
import com.example.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class MultipleProductPriceVerificationTest extends BaseTest {

    @Test
    public void verifyTotalPriceForMultipleProducts() {
        // Login
        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");

        // Add multiple products
        InventoryPage inventory = new InventoryPage(driver);
        inventory.addToCart("Sauce Labs Backpack");
        inventory.addToCart("Sauce Labs Bike Light");
        inventory.addToCart("Sauce Labs Bolt T-Shirt");
        inventory.clickCartIcon();

        // Verify sum of item prices on the cart page
        CartPage cart = new CartPage(driver);
        List<Double> itemPrices = cart.getAllItemPrices();

        double sumOfPrices = itemPrices.stream().mapToDouble(Double::doubleValue).sum();

        // Proceed to checkout
        cart.clickCheckout();

        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.fillUserInfo("John", "Doe", "12345");
        checkout.continueCheckout();

        // Get totals from checkout summary
        double itemTotal = checkout.getItemTotal();
        double tax = checkout.getTax();
        double displayedTotal = checkout.getTotal();
        double expectedTotal = sumOfPrices + tax;

        // Validate subtotal and total
        Assert.assertEquals(itemTotal, sumOfPrices, 0.01,
                "Subtotal mismatch! UI shows " + itemTotal + " but calculated is " + sumOfPrices);

        Assert.assertEquals(displayedTotal, expectedTotal, 0.01,
                "Final total mismatch! Expected " + expectedTotal + " but UI shows " + displayedTotal);
    }
}

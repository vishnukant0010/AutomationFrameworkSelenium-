package com.example.tests;

import com.example.pageobject.*;
import com.example.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PriceVerificationTest extends BaseTest {

    @Test
    public void verifyTotalPriceCalculation() {
        // Login
        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");

        // Add an item to the cart
        InventoryPage inventory = new InventoryPage(driver);
        inventory.addToCart(); // Adds Sauce Labs Onesie
        inventory.clickCartIcon();

        //Proceed to checkout
        CartPage cart = new CartPage(driver);
        cart.clickCheckout();

        // Fill user info and continue
        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.fillUserInfo("Vishnu", "maurya", "12345");
        checkout.continueCheckout();

        //Validate total price calculation
        double itemTotal = checkout.getItemTotal();
        double tax = checkout.getTax();
        double expectedTotal = itemTotal + tax;
        double displayedTotal = checkout.getTotal();

        Assert.assertEquals(displayedTotal, expectedTotal, 0.01,
                "Total price mismatch! Expected: " + expectedTotal + " but got: " + displayedTotal);
    }
}

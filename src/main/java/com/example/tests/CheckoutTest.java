package com.example.tests;

import com.example.pageobject.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    @Test
    public void verifySuccessfulCheckout() {
        // Login
        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");

        // Add item to cart
        InventoryPage inventory = new InventoryPage(driver);
        inventory.addToCart();
        inventory.clickCartIcon();

        // Go to cart and click checkout
        CartPage cart = new CartPage(driver);
        cart.clickCheckout();

        // Fill user info and finish
        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.fillUserInfo("Vishnu", "Kant", "285123");
        checkout.continueCheckout();
        checkout.finishCheckout();

        // Verify success
        String msg = checkout.getSuccessMessage();
        Assert.assertEquals(msg, "Thank you for your order!");
    }
}
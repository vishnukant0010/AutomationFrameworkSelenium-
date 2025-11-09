package com.example.tests;

import com.example.pageobject.InventoryPage;
import com.example.pageobject.CartPage;
import com.example.pageobject.LoginPage;
import com.example.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RemoveFromCartTest extends BaseTest {

    @Test
    public void verifyItemRemovedFromCart() {
        //Login
        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");

        //Add an item to cart
        InventoryPage inventory = new InventoryPage(driver);
        inventory.addToCart();
        inventory.clickCartIcon();

        // Remove item from cart
        CartPage cart = new CartPage(driver);
        String productName = "Sauce Labs Onesie";
        cart.removeItem(productName);

        //Verify item is no longer present in cart
        Assert.assertFalse(cart.isItemPresent(productName),
                "Item still present in cart after removal!");
    }
}

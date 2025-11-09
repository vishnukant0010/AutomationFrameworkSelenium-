package com.example.tests;

import com.example.pageobject.InventoryPage;
import com.example.pageobject.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartTest extends BaseTest {

    @Test
    public void verifyAddToCartFunctionality() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventory = new InventoryPage(driver);
//        String product = inventory.getFirstProductName();
        inventory.addToCart();
        inventory.clickCartIcon();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("cart"), "Cart page did not open after adding product!");
    }
}

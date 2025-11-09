package com.example.tests;

import com.example.pageobject.InventoryPage;
import com.example.pageobject.LoginPage;
import com.example.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class InventorySortTest extends BaseTest {

    @Test
    public void verifySortingByPriceLowToHigh() {
        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");

        InventoryPage inventory = new InventoryPage(driver);
        inventory.sortProducts("lohi");  // low to high

        List<Double> prices = inventory.getAllProductPrices();
        boolean sorted = true;

        for (int i = 0; i < prices.size() - 1; i++) {
            if (prices.get(i) > prices.get(i + 1)) {
                sorted = false;
                break;
            }
        }

        Assert.assertTrue(sorted, "❌ Products are NOT sorted by price Low → High!");
    }

    @Test
    public void verifySortingByNameZtoA() {
        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");

        InventoryPage inventory = new InventoryPage(driver);
        inventory.sortProducts("za");  // Z to A

        List<String> names = inventory.getAllProductNames();
        boolean sorted = true;

        for (int i = 0; i < names.size() - 1; i++) {
            if (names.get(i).compareTo(names.get(i + 1)) < 0) {
                sorted = false;
                break;
            }
        }

        Assert.assertTrue(sorted, "❌ Products are NOT sorted by Name Z → A!");
    }
}

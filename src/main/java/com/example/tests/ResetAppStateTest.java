package com.example.tests;

import com.example.pageobject.InventoryPage;
import com.example.pageobject.LoginPage;
import com.example.utilities.ScreenshotUtil;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ResetAppStateTest extends BaseTest {

    @Test
    public void verifyResetAppStateResetsButtonsProperly() {
        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");

        InventoryPage inventory = new InventoryPage(driver);
        inventory.addToCart("Sauce Labs Backpack");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("shopping_cart_badge")));

            WebElement menuButton = wait.until(
                    ExpectedConditions.elementToBeClickable(By.id("react-burger-menu-btn")));
            menuButton.click();

            WebElement resetLink = wait.until(
                    ExpectedConditions.elementToBeClickable(By.id("reset_sidebar_link")));
            Thread.sleep(3000);

            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", resetLink);


            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("shopping_cart_badge")));

            Thread.sleep(2000);

            boolean isCartBadgePresent = driver.findElements(By.className("shopping_cart_badge")).size() > 0;
            Assert.assertFalse(isCartBadgePresent, "Cart badge still visible after reset!");

            WebElement addToCartButton = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//div[text()='Sauce Labs Backpack']/ancestor::div[@class='inventory_item']//button")));

            String buttonText = addToCartButton.getText().trim();
            Assert.assertEquals(buttonText, "Add to cart",
                    "Reset App State failed — button still shows '" + buttonText + "' after reset!");

        } catch (Exception e) {
            ScreenshotUtil.captureScreenshot(driver, "reset_app_state_error");
            throw new RuntimeException("Test failed with error: " + e.getMessage(), e);
        }
    }
}
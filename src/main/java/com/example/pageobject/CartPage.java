package com.example.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage {
    private WebDriver driver;

    private By checkoutBtn = By.id("checkout");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCheckout() {
        driver.findElement(checkoutBtn).click();
    }

    // remove item dynamically by name
    public void removeItem(String itemName) {
        driver.findElement(By.xpath("//div[text()='" + itemName + "']/ancestor::div[@class='cart_item']//button"))
                .click();
    }

    // if item is still present in cart
    public boolean isItemPresent(String itemName) {
        return !driver.findElements(By.xpath("//div[text()='" + itemName + "']")).isEmpty();
    }

    public List<Double> getAllItemPrices() {
        List<WebElement> priceElements = driver.findElements(By.className("inventory_item_price"));
        return priceElements.stream()
                .map(e -> Double.parseDouble(e.getText().replace("$", "")))
                .toList();
    }

}

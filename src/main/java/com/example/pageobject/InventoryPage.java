package com.example.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class InventoryPage {
    private WebDriver driver;

    // Locators
    private By productTitles = By.className("inventory_item_name");
    private By addToCartBtn = By.id("add-to-cart-sauce-labs-onesie");
    private By cartIcon = By.className("shopping_cart_link");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    // Existing method (for single predefined product)
    public void addToCart() {
        driver.findElement(addToCartBtn).click();
    }

    // Overloaded method (for any product by name)
    public void addToCart(String productName) {
        String xpath = "//div[text()='" + productName + "']/ancestor::div[@class='inventory_item']//button";
        driver.findElement(By.xpath(xpath)).click();
    }

    public void clickCartIcon() {
        driver.findElement(cartIcon).click();
    }

    public void sortProducts(String optionValue) {
        WebElement sortDropdown = driver.findElement(By.className("product_sort_container"));
        Select select = new Select(sortDropdown);
        select.selectByValue(optionValue);
    }

    public List<Double> getAllProductPrices() {
        List<WebElement> priceElements = driver.findElements(By.className("inventory_item_price"));
        return priceElements.stream()
                .map(e -> Double.parseDouble(e.getText().replace("$", "")))
                .collect(Collectors.toList());
    }

    public List<String> getAllProductNames() {
        List<WebElement> nameElements = driver.findElements(By.className("inventory_item_name"));
        return nameElements.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}

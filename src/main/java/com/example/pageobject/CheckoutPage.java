package com.example.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    private WebDriver driver;

    // Locators
    private By firstName = By.id("first-name");
    private By lastName = By.id("last-name");
    private By postalCode = By.id("postal-code");
    private By continueBtn = By.id("continue");
    private By finishBtn = By.id("finish");
    private By successMsg = By.className("complete-header");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    // Fill user details in checkout form
    public void fillUserInfo(String fName, String lName, String zip) {
        driver.findElement(firstName).sendKeys(fName);
        driver.findElement(lastName).sendKeys(lName);
        driver.findElement(postalCode).sendKeys(zip);
    }

    // Click Continue
    public void continueCheckout() {
        driver.findElement(continueBtn).click();
    }

    // Click Finish to complete checkout
    public void finishCheckout() {
        driver.findElement(finishBtn).click();
    }

    // Get order success confirmation
    public String getSuccessMessage() {
        return driver.findElement(successMsg).getText();
    }

    // Get subtotal (Item total)
    public double getItemTotal() {
        String text = driver.findElement(By.className("summary_subtotal_label")).getText();
        return Double.parseDouble(text.replace("Item total: $", ""));
    }

    // Get tax
    public double getTax() {
        String text = driver.findElement(By.className("summary_tax_label")).getText();
        return Double.parseDouble(text.replace("Tax: $", ""));
    }

    // Get final total
    public double getTotal() {
        String text = driver.findElement(By.className("summary_total_label")).getText();
        return Double.parseDouble(text.replace("Total: $", ""));
    }
}

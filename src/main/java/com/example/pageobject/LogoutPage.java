package com.example.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutPage {
    private WebDriver driver;

    private By menuBtn = By.id("react-burger-menu-btn");
    private By logoutLink = By.id("logout_sidebar_link");
    public LogoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void logout() {
        driver.findElement(menuBtn).click();
        driver.findElement(logoutLink).click();
    }
}
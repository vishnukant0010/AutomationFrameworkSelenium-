package com.example.tests;

import com.example.pageobject.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
    @Test
    public void verifyValidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
    }

}

package com.example.tests;

import com.example.pageobject.LoginPage;
import com.example.pageobject.LogoutPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {

    @Test
    public void verifyLogout() throws Exception{
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        Thread.sleep(2000);
        LogoutPage logout = new LogoutPage(driver);
        logout.logout();

        Assert.assertTrue(driver.getCurrentUrl().contains("saucedemo.com"));
    }
}
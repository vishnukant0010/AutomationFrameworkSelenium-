package com.example.tests;

import com.example.pageobject.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginNegativeTest extends BaseTest {

    @Test
    public void verifyLoginWithInvalidUsername() {
        LoginPage login = new LoginPage(driver);
        login.login("invalid_user", "secret_sauce");
        Assert.assertTrue(login.getErrorMessage().contains("Username and password do not match"),
                "Error message not displayed correctly for invalid username!");
    }

    @Test
    public void verifyLoginWithInvalidPassword() {
        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "wrong_password");
        Assert.assertTrue(login.getErrorMessage().contains("Username and password do not match"),
                "Error message not displayed correctly for invalid password!");
    }

    @Test
    public void verifyLoginWithEmptyFields() {
        LoginPage login = new LoginPage(driver);
        login.login("", "");
        Assert.assertTrue(login.getErrorMessage().contains("Username is required"),
                "Error message not displayed correctly for empty fields!");
    }

    @Test
    public void verifyLockedOutUserCannotLogin() {
        LoginPage login = new LoginPage(driver);
        login.login("locked_out_user", "secret_sauce");
        Assert.assertTrue(login.getErrorMessage().contains("Sorry, this user has been locked out."),
                "Locked out user message not displayed correctly!");
    }
}

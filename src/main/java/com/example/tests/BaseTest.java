package com.example.tests;

import com.example.utilities.ConfigReader;
import com.example.utilities.ScreenshotUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected ConfigReader configReader;
    protected WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        configReader = new ConfigReader();

        String browser = configReader.getProperty("browser");

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        driver.manage().window().maximize();

        int implicitWait = Integer.parseInt(configReader.getProperty("implicitWait"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(configReader.getProperty("baseUrl"));
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        try {
            // Take screenshot before quitting driver
            if (result.getStatus() == ITestResult.FAILURE) {
                String testName = result.getName();
                System.out.println("Test Failed: " + testName);
                ScreenshotUtil.captureScreenshot(driver, testName);
            } else if (result.getStatus() == ITestResult.SUCCESS) {
                System.out.println("Test Passed: " + result.getName());
            }
        } catch (Exception e) {
            System.err.println("Error during screenshot capture: " + e.getMessage());
        } finally {
            // Quit driver only in finally block
            if (driver != null) {
                driver.quit();
            }
        }
    }
}
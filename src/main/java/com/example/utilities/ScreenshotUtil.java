package com.example.utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

    public static String captureScreenshot(WebDriver driver, String testName) {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String screenshotPath = System.getProperty("user.dir") + "/screenshots/" + testName + "_" + timestamp + ".png";

        try {
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destFile = new File(screenshotPath);
            FileUtils.copyFile(srcFile, destFile);
            System.out.println("Screenshot captured: " + screenshotPath);
        } catch (IOException e) {
            System.err.println("Screenshot capture failed: " + e.getMessage());
        }

        return screenshotPath;
    }
}

package com.commerce.actionclass;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.UUID;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ActionClass {


public static String captureScreenshot(WebDriver driver, String testName) {

    try {
        TakesScreenshot ts = (TakesScreenshot) driver;

        File source = ts.getScreenshotAs(OutputType.FILE);

        // Create screenshot folder
        String folderPath = System.getProperty("user.dir")
                + "/src/test/resources/ScreenShot/";

        File folder = new File(folderPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }

        // Generate unique screenshot name
        //This creates practically unique filenames, even when multiple threads capture screenshots at nearly the same time.
        String destination = folderPath + testName + "_"
                + UUID.randomUUID() + ".png";

        File target = new File(destination);

        Files.copy(source.toPath(), target.toPath());

        return destination;

    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}

}

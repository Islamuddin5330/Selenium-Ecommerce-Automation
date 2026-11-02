package com.commerce.actionclass;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionClass {

	public WebDriver driver;
	//for elemtn
	public void click(WebElement element) {
		element.click();
	}
	//for locator
	public void click1(By locator) {
		WebElement ele = driver.findElement(locator);
		ele.click();
	}
	
	public void send(WebElement element) {
		element.click();
	}
	//By locator
	public void sendText(By locator) {
		WebElement ele  = driver.findElement(locator);
		ele.click();
	}
	
	public void waitElem(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
	}
	
	
	
	
	
	
	
	
	
	
	

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

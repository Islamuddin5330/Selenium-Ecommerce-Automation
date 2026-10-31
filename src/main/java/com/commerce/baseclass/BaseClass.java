package com.commerce.baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.internal.BaseClassFinder;

import com.commerce.utilities.LoggerManager;

public class BaseClass {

	private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	public Logger logger = LoggerManager.getLogger();
//	public WebDriver driver;
	public Properties pro;
	
	@BeforeMethod
	public void setUp() throws IOException {
		logger.info("========== Test Execution Started ==========");
		pro = new Properties();
		String configPath = System.getProperty("user.dir")
		        + File.separator + "src"
		        + File.separator + "main"
		        + File.separator + "resources"
		        + File.separator + "config.properties";
		FileInputStream fis = new FileInputStream(configPath);
		pro.load(fis);
		
		String browser = pro.getProperty("browser");
		String Url = pro.getProperty("url");
		
		logger.info("Browser selected: " + browser);
		
		if(browser.equalsIgnoreCase("Chrome")) {

		    ChromeOptions options = new ChromeOptions();

		    boolean headless = Boolean.parseBoolean(
		            System.getProperty("headless", "false"));

		    if(headless) {
		        options.addArguments("--headless=new");
		        options.addArguments("--no-sandbox");
		        options.addArguments("--disable-dev-shm-usage");
		        options.addArguments("--window-size=1920,1080");

		        logger.info("Chrome launched in headless mode");
		    }

		    driver.set(new ChromeDriver(options));

		    logger.info("Chrome browser launched successfully");
		}else if(browser.equalsIgnoreCase("Edge")) {
			driver.set(new EdgeDriver());
		}else if(browser.equalsIgnoreCase("Firefox")) {
			driver.set(new FirefoxDriver());
		}else {
			logger.error("Invalid browser selected: " + browser);
			throw new RuntimeException("Browser is not lunch...");
		}
		
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		getDriver().get(Url);
		
		logger.info("Application opened successfully: " + Url);
		
	}
	
	public static  WebDriver getDriver() {
		return driver.get();
	}
	
	@AfterMethod
	public void tearDown() {
		if(driver.get() != null) {
			driver.get().quit();
			driver.remove();
		}
	}
	
}

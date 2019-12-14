package com.seleniumsingleton;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

//In TestBase2 Class we have intialize(), where we do all browser launching operations
// and implicitly wait operation & maximize the window
// here we have declared Webdriver object as null, so that if any create the webdriver object need to point to 
// same object & all the methods are static so that we can call them by using class name itself

public class TestBase2 {
	
	public static WebDriver driver = null;
	public static ChromeOptions options = new ChromeOptions();
	
	
	public static void intialize()
	{
		if(driver == null)
		{
			if(Constants.browserName.equalsIgnoreCase("chrome"))
			{
				WebDriverManager.chromedriver().setup();
				options.addArguments("headless");
				driver = new ChromeDriver();
			}
			else if(Constants.browserName.equalsIgnoreCase("firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);		
		driver.manage().window().maximize();
	}
	
	
	public static void quitBrowser()
	{
		System.out.println("Quiting the browser");
		driver.quit();
		driver = null;
	}

}

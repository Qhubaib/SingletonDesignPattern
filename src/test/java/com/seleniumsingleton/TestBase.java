package com.seleniumsingleton;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/***
 * 
 * @author "Syed Qhubaib Ahmed"
 * TestBase Class is a type of Singleton class
 * Here we are declaring the browserLaunch() as non-static
 * so that we can we able launch the browser by creating the reference of class with getInstance()
 *
 */

public class TestBase {
	
	public WebDriver driver;
	public static ChromeOptions options = new ChromeOptions();
	public static TestBase base = null;
	
	private TestBase()
	{
		
	}
	
	public void browserLaunch()
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
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	public static TestBase getInstance()
	{
		if(base == null)
			base = new TestBase();
		return base;
	}
	
	public void quitBrowser()
	{
		System.out.println("Quiting the browser");
		driver.quit();
	}

}

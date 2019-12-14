package com.seleniumsingleton;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class TestCase2 {
	
	WebDriver driver;
	
	
	
	@BeforeMethod
	public void setUp()
	{
		TestBase2.intialize();
	}
	
	@Test(priority=1)
	public void testGoogle()
	{
		TestBase2.driver.get("https://google.com");
		String GoogleTitle=TestBase2.driver.getTitle();
		System.out.println(GoogleTitle);
	}
	
	@Test(priority=2,invocationCount=3)
	public void testAmazon()
	{
		TestBase2.driver.get("https://amazon.com");
		TestBase2.driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
		String AmazonTitle=TestBase2.driver.getTitle();
		System.out.println(AmazonTitle);
	}
	
	@AfterMethod
	public void tearDown()
	{
		TestBase2.quitBrowser();
	}

}

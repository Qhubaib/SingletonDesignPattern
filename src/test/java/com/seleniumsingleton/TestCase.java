package com.seleniumsingleton;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class TestCase {
	
	WebDriver driver;
	TestBase base;
	
	
	@BeforeMethod
	public void setUp()
	{
		base=TestBase.getInstance();
		base.browserLaunch();
	}
	
	@Test
	public void testGoogle()
	{
		base.driver.get("https://google.com");
		String GoogleTitle=base.driver.getTitle();
		System.out.println(GoogleTitle);
	}
	
	@Test
	public void testAmazon()
	{
		base.driver.get("https://amazon.com");
		String AmazonTitle=base.driver.getTitle();
		System.out.println(AmazonTitle);
	}
	
	@AfterMethod
	public void tearDown()
	{
		base.quitBrowser();
	}

}

package com.seleniumsingleton;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

/**
 * org.openqa.selenium.NoSuchSessionException: Session ID is null. Using WebDriver after calling quit()?
 * this Exception is coming in console while running the second @Test - Because in TestBase3 Class we have not specified
 * WebDriver Instance to null
 * In browserLaunch() we have given a condition that - if any driver == null then only perform browser related operation
 * Here whats happening is in TestBase3.quitBrowser() we are quitting the browser & not intializing the driver object to null
 * so, for performing another operation on the second @Test - it is trying to access the driver condition , so we have not met this condition
 * That is why it is throwing "NoSuchSessionException"
 * @author Qhubaib
 * Now after specifying driver object as null in quitBrowser() Method, It works fine without any errors
 *
 */
public class TestCase3 {
	
	WebDriver driver;
	TestBase3 base;
	
	
	@BeforeMethod
	public void setUp()
	{
		base=TestBase3.getInstance();
		driver = base.browserLaunch();
	}
	
	@Test(priority=1,invocationCount=2)
	public void testGoogle()
	{
		driver.get("https://google.com");
		String GoogleTitle=driver.getTitle();
		System.out.println(GoogleTitle);
	}
	
	@Test(priority=2)
	public void testAmazon()
	{
		driver.get("https://amazon.com");
		String AmazonTitle=driver.getTitle();
		System.out.println(AmazonTitle);
	}
	
	@AfterMethod
	public void tearDown()
	{
		base.quitBrowser();
	}

}

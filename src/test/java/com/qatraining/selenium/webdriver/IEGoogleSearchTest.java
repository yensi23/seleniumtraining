package com.qatraining.selenium.webdriver;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.ie.InternetExplorerDriver;

public class IEGoogleSearchTest {
	private WebDriver driver;
	
	@Before
	public void setUp() {
		
		System.setProperty("webdriver.ie.driver","./src/test/resources/drivers/IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
	}

	@Test
	public void testGooglePage() {
		WebElement searchbox = driver.findElement(By.name("q"));
		
		searchbox.clear();
		
		searchbox.sendKeys("selenium");
		searchbox.submit();
		
		//assertEquals("selenium - Google Search", driver.getTitle());
		assertEquals("Google", driver.getTitle());
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
}


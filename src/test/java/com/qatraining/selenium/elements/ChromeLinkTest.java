package com.qatraining.selenium.elements;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeLinkTest {
	private WebDriver driver;
	
	@Before
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver","./src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
	}

	@Test
	public void testGooglePage() {
		
		WebElement searchbox = driver.findElement(By.name("q"));
		searchbox.sendKeys("selenium");
		searchbox.submit();
		
		driver.findElement(By.linkText("Selenium - Wikipedia, la enciclopedia libre")).click();
		
		//assertEquals("selenium - Google Search", driver.getTitle());
		assertEquals("Selenium - Wikipedia, la enciclopedia libre", driver.getTitle());
	}
	
	@After
	public void tearDown() {
		//driver.quit();
	}
}

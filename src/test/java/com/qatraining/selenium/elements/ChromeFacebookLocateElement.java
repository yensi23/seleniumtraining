package com.qatraining.selenium.elements;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeFacebookLocateElement {
	private WebDriver driver;
	
	@Before
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver","./src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.facebook.com");
	}

	@Test
	public void testLocateEmailFacebookPage() {
		
		String tagName = driver.findElement(By.id("email")).getTagName();
		
		System.out.println("tagName: "+tagName);
		
		assertEquals("input", tagName);
		
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}	

}

package com.qatraining.selenium.elements;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeFacebookClickElement {
	private WebDriver driver;
	
	@Before
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver","./src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.facebook.com");
	}

	@Test
	public void testInstantiatingEmailFacebookPage() {
		
		WebElement mailElement = driver.findElement(By.id("email"));
		mailElement.sendKeys("ss");
		
		driver.findElement(By.id("loginbutton")).click();
		
		assertNotNull( driver.findElement(By.id("error_box")));
			
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}	

}

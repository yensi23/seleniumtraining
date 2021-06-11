package com.qatraining.selenium.action;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ChromeScrollDownUp {
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
	public void testGooglePage() throws InterruptedException{
		Actions action = new Actions(driver);
		WebElement searchbox = driver.findElement(By.name("q"));
		searchbox.sendKeys("selenium");
		searchbox.submit();
		
		Thread.sleep(3000);
        //SCROLL DOWN
		
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		
		Thread.sleep(3000);
        //SCROLL UP
		
		action.sendKeys(Keys.PAGE_UP).build().perform();
		
		//assertEquals("selenium - Google Search", driver.getTitle());
		assertEquals("selenium - Buscar con Google", driver.getTitle());
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
}

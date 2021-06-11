package com.qatraining.selenium.file;

import static org.junit.Assert.assertNotNull;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class ChromeUploadFile {
	private WebDriver driver;
	
	@Before
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver","./src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://gofile.io/?t=uploadFiles");
	}

	@Test
	public void testUpload() {
		
		WebElement uploadElement = driver.findElement(By.id("inputFile"));
		
		uploadElement.sendKeys("C:\\borrame\\seleniumscreenshoot\\chrome_screenshoot_1569350969600.png");
		
		driver.findElement(By.id("btnUpload")).click();
				
		assertNotNull(uploadElement);
		
	}
	
	@After
	public void tearDown() {
		//driver.quit();
	}
}

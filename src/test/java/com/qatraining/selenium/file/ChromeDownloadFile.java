package com.qatraining.selenium.file;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class ChromeDownloadFile {
	private WebDriver driver;
	
	@Before
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver","./src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://kaboompics.com/photo/13441/the-man-with-the-halloween-balloon");
	}

	@Test
	public void testUpload() {
		
		//WebElement we = driver.findElements(By.className("quick-download"));
		WebElement downloadElement = driver.findElement(By.className("quick-download"));
		downloadElement.click();
		
		//((WebElement)driver.findElement((By.className("quick-download")))).click();
		
		
				
		//assertNotNull(uploadElement);
		
	}
	
	@After
	public void tearDown() {
		//driver.quit();
	}
}

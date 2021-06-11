package com.qatraining.selenium.screenshoot;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxWebDriverScreenShoot {
	private WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.gecko.driver","./src/test/resources/drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
	}

	@Test
	public void testGooglePage() throws Exception{
		
		FirefoxWebDriverScreenShoot.takeSnapShot(driver, "c://borrame//seleniumscreenshoot//firefox_screenshoot_"+System.currentTimeMillis()+".png") ; 
		
		WebElement searchbox = driver.findElement(By.name("q"));
				
		searchbox.sendKeys("selenium");
		
		FirefoxWebDriverScreenShoot.takeSnapShot(driver, "c://borrame//seleniumscreenshoot//firefox_screenshoot_"+System.currentTimeMillis()+".png") ; 
		
		searchbox.submit();
		
		assertEquals("Google", driver.getTitle());
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}	

    public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{
        //Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot =((TakesScreenshot)webdriver);
        //Call getScreenshotAs method to create image file
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        //Move image file to new destination
        File DestFile=new File(fileWithPath);
        //Copy file at destination
        FileUtils.copyFile(SrcFile, DestFile);
    }	
	
 	
}

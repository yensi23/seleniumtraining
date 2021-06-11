package com.qatraining.selenium.file;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class ChromeUploadDownloadFile {
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
		
		//We find the download links
		List<WebElement> list =driver.findElements(By.id("link"));
		 
		//Click the last one to downaload 5MB file :)
		WebElement el = list.get(list.size()-1);
		el.click();
		
		WebElement btnDownload = driver.findElement(By.id("fileInfoDownload"));
		
		btnDownload.click();
		//((WebElement)driver.findElement((By.id("fileInfoDownload")))).click();
		
		
		//---

		File folder = new File(System.getProperty("C:\\borrame\\seleniumdownloads"));
		 
		//List the files on that folder
		File[] listOfFiles = folder.listFiles();
		boolean found = false;
		File f = null;
 
		//Look for the file in the files
		// You should write smart REGEX according to the filename
		/*
		for (File listOfFile : listOfFiles) {
		    if (listOfFile.isFile()) {
		       String fileName = listOfFile.getName();
		       System.out.println("File " + listOfFile.getName());
		       if (fileName.matches("5MB.zip")) {
		           f = new File(fileName);
		           found = true;
		       }
		    }
		}
		*/
		     
		//Assert.assertTrue(found, "Downloaded document is not found");
		
		f.deleteOnExit();
		
	}
	
	@After
	public void tearDown() {
		//driver.quit();
	}
}

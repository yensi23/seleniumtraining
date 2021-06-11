package com.qatraining.selenium.grid;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GridFirefoxDragAndDrop {
	private WebDriver driver;
	
	@Before
	public void setUp() throws MalformedURLException {
		
		System.setProperty("webdriver.gecko.driver","./src/test/resources/drivers/geckodriver.exe");

		FirefoxOptions options = new FirefoxOptions();
		
		driver = new RemoteWebDriver(new URL("http://192.168.1.11:4444/"), options);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void droppable() throws InterruptedException{
		Actions action = new Actions(driver);
		
		driver.get("http://jqueryui.com/droppable/");
        
        //WebdriverWait is used to wait for a frame to be available. Once it is availble we switch to the frame to achieve our task 
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector(".demo-frame")));
        //To get source locator
		WebElement sourceLocator = driver.findElement(By.cssSelector("#draggable"));
        //To get target locator
		WebElement targetLocator = driver.findElement(By.cssSelector("#droppable"));
        //dragAndDrop(source, target) method accepts two parameters source and locator. 
        //used dragAndDrop method to drag and drop the source locator to target locator
		action.dragAndDrop(sourceLocator, targetLocator).build().perform();
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
}

package com.qatraining.selenium.elements;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeFacebookClickImage {
	private WebDriver driver;
	
	@Before
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver","./src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/login/identify?ctx=recover");
	}

	@Test
	public void testInstantiatingEmailFacebookPage() {
		
		driver.findElement(By.cssSelector("a[title=\"Go to Facebook home\"]")).click();
		//driver.findElement(By.cssSelector("a[title=\"Ir a la página de inicio de Facebook\"]")).click();					

		//verify that we are now back on Facebook's homepage		
		if (driver.getTitle().equals("Facebook - log in or sign up")) {							
	        System.out.println("We are back at Facebook's homepage");					
	    } else {			
	        System.out.println("We are NOT in Facebook's homepage");					
	    }		
			
	}
	
	@After
	public void tearDown() {
		//driver.quit();
	}	

}

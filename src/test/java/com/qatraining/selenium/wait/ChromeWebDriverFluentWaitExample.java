package com.qatraining.selenium.wait;

import java.time.Duration;
import java.util.function.Function;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class ChromeWebDriverFluentWaitExample {
	private WebDriver driver;
	private Wait<WebDriver> wait;
	
	@Before
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver","./src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		wait = new FluentWait<WebDriver>(driver)							
				.withTimeout(Duration.ofSeconds(30)) 			
				.pollingEvery(Duration.ofSeconds(5)) 			
				.ignoring(NoSuchElementException.class);
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
	}

	@Test
	public void testGooglePage() {
		
        WebElement element = driver.findElement(By.name("q"));

       element.sendKeys("Cheese in tongo!");

        element.submit();

        System.out.println("Page title is: " + driver.getTitle());
        
         
        String title = wait.until(new Function<WebDriver, String>(){
        	
    		public String apply(WebDriver d ) {
    			return d.getTitle();
    		}
    	});


        System.out.println("Page title is: " + title);		
		
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
}

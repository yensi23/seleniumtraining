package com.qatraining.selenium.grid;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SimpleChromeGridTest {
	WebDriver driver;
	String baseUrl, nodeURL;
	
	@Before
	public void setUp() throws MalformedURLException {
		//System.setProperty("webdriver.gecko.driver","./src/test/resources/drivers64/geckodriver.exe");
		baseUrl = "http://www.google.com";
		nodeURL = "http://localhost:4444/wd/hub";
		//nodeURL = "http://localhost:5566/wd/hub";
		//nodeURL = "http://192.168.1.35:5566/wd/hub";
		
		ChromeOptions options = new ChromeOptions();
				
		driver = new RemoteWebDriver(new URL(nodeURL), options);
		
	}
	
	@Test
	public void simpleTest(){
		driver.get(baseUrl);
		assertEquals("Google", driver.getTitle());
	}
	
	@After
	public void afterTest() {
		driver.quit();
	}

}

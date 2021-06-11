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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class GridChromeDownloadFile {
	private WebDriver driver;
	private String nodeURL;
	
	@Before
	public void setUp() throws MalformedURLException {
		
		System.setProperty("webdriver.chrome.driver","./src/test/resources/drivers/chromedriver.exe");

//		driver = new ChromeDriver();
//        DesiredCapabilities dc = DesiredCapabilities.chrome();
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        
//       dc.setBrowserName("chrome");
//        //dc.setCapability("version","80");
//        
//        driver = new RemoteWebDriver(new URL("http://192.168.1.11:4444/wd/hub"),dc);
//		driver.manage().window().maximize();
		
		nodeURL = "http://192.168.1.11:4444/wd/hub";
		ChromeOptions options = new ChromeOptions();
		driver = new RemoteWebDriver(new URL(nodeURL), options);
		
		
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

package com.qatraining.selenium.elements;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultiSelectDropdownWithSwitch {
	
	private WebDriver driver;
	
	@Before
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver","./src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");
        
	}

	@Test
	public void multiSelectDropdown() {
		
		WebElement element = driver.findElement(By.id("iframeResult"));
		
		driver.switchTo().frame(element);
		
		WebElement selectList = driver.findElement(By.xpath("//select[@name='cars']"));
        Select select = new Select(selectList);
        select.selectByVisibleText("Volvo");
        select.selectByVisibleText("Saab");
       
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}		

}

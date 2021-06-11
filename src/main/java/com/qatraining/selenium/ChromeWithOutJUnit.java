package com.qatraining.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeWithOutJUnit {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","./src/test/resources/drivers/chromedriver.exe"); 
		
		String baseURL = "https://www.jccm.es/";
		WebDriver driver;
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseURL);

	}

}

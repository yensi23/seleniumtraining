package com.qatraining.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxWithOutJUnit {
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver","./src/test/resources/drivers/geckodriver.exe");
		
		String baseURL = "https://www.jccm.es/";
		WebDriver driver;
		
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(baseURL);
	}

}


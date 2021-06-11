package com.qatraining.selenium;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SampleSeleniumTest {
	private WebDriver driver;
	
	  @Before
	  public void setUp() {
		  System.setProperty("webdriver.chrome.driver","./src/test/resources/drivers/chromedriver.exe");
		  
	    driver = new ChromeDriver();
	  }
	  @After
	  public void tearDown() {
	    driver.quit();
	  }
	  @Test
	  public void google() {
	    driver.get("https://www.google.com/");
	    driver.manage().window().setSize(new Dimension(1936, 1056));
	    assertThat(driver.getTitle(), is("Google"));
	    driver.close();
	  }

}

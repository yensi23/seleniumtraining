package com.qatraining.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;

public class TestGoogleElmundoTest {
  private static WebDriver driver;
  private static Map<String, Object> vars;
  static JavascriptExecutor js;
  
  @Before
  public void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  
  @After
  public void tearDown() {
    driver.quit();
  }
  
  @Test
  public void testGoogleElmundo() {
	  //System.setProperty("webdriver.chrome.driver","./src/test/resources/drivers/chromedriver.exe");
    driver.get("https://www.google.com/");
    driver.manage().window().setSize(new Dimension(1936, 1056));
    driver.findElement(By.name("q")).click();
    driver.findElement(By.name("q")).sendKeys("el mundo");
    driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
    driver.findElement(By.cssSelector(".g:nth-child(1) > div:nth-child(2) .LC20lb")).click();
    driver.close();
  }
}

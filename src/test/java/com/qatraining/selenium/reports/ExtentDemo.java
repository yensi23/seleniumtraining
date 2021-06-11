package com.qatraining.selenium.reports;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentDemo {
	static ExtentTest test;
	static ExtentReports report;

	@BeforeClass
	public static void startTest(){
		report = new ExtentReports("c://borrame//seleniumreport//chrome_screenshoot_"+System.currentTimeMillis()+"//ExtentReportResults.html");
		test = report.startTest("ExtentDemo");
	}
	
	@Test
	public void extentReportsDemo(){
		System.setProperty("webdriver.chrome.driver","./src/test/resources/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.elmundo.es/hola");
		if(driver.getTitle().equals("Google"))	{
			test.log(LogStatus.PASS, "Navigated to the specified URL");
		}else{
			test.log(LogStatus.FAIL, "Test Failed");
		}
	}
	
	@Test
	public void extentReportsDemo1() throws IOException{
		System.setProperty("webdriver.chrome.driver","./src/test/resources/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		if(driver.getTitle().equals("Google"))	{
			test.log(LogStatus.PASS, "Navigated to the specified URL");
		}else{
			//test.log(LogStatus.FAIL, "Test Failed");
			test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Test Failed");
		}
	}	
	
	@AfterClass
	public static void endTest(){
		report.endTest(test);
		report.flush();
	}
	
	public static String capture(WebDriver driver) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File Dest = new File("src/../ErrImages/" + System.currentTimeMillis()
		+ ".png");
		String errflpath = Dest.getAbsolutePath();
		FileUtils.copyFile(scrFile, Dest);
		return errflpath;
	}
}

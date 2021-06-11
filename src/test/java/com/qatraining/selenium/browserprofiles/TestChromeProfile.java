package com.qatraining.selenium.browserprofiles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class TestChromeProfile {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","./src/test/resources/drivers/chromedriver.exe"); 
		
		String baseURL = "https://www.indracompany.com/";
		WebDriver driver;
		
		ChromeOptions options = new ChromeOptions();
		//options.addArguments("user-data-dir=C://Users//ynavarro//AppData//Local//Google//Chrome//User Data//Profile 2");
		options.addArguments("user-data-dir=C://Users//ynavarro//AppData//Local//Google//Chrome//User Data");
		options.addArguments("profile-directory=Profile 2");
		//options.addArguments("user-data-dir=C:\\Users\\ynavarro\\AppData\\Local\\Temp\\scoped_dir9916_1817971511\\Default");
		
		options.addArguments("--start-maximized");
		driver = new ChromeDriver(options);
		
		//driver.manage().window().maximize();
		driver.get(baseURL);
	}

}

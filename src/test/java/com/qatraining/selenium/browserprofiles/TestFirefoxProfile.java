package com.qatraining.selenium.browserprofiles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

public class TestFirefoxProfile {
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver","./src/test/resources/drivers/geckodriver.exe");
		
		String baseURL = "https://www.indracompany.com/";
		WebDriver driver;
		
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile fxProfile = profile.getProfile("testProfile");
		
		FirefoxOptions options = new FirefoxOptions();
		options.setProfile(fxProfile);
		
		driver = new FirefoxDriver(options);
		driver.manage().window().maximize();
		driver.get(baseURL);
	}

}

package com.mercury.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.mercury.testbase.TestBase;
import com.mercury.util.TestUtil;

public class HomePage extends TestBase {

	//Declaring the variables- page objects
	WebElement username;
	WebElement password;
	WebElement loginButton;	

	public HomePage() {
		//Initializing the page objects
		username = driver.findElement(By.name("userName"));
		password = driver.findElement(By.name("password"));
		loginButton = driver.findElement(By.name("login"));
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	public SignOnPage login(String strUsername, String strPassword) throws IOException {
		username.sendKeys(strUsername);
		password.sendKeys(strPassword);
		loginButton.click();
		TestUtil.takeScreenshot();
		return new SignOnPage();
	}
	
}

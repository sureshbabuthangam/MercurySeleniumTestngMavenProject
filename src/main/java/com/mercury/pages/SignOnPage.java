package com.mercury.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.mercury.testbase.TestBase;
import com.mercury.util.TestUtil;

public class SignOnPage extends TestBase {

	WebElement welcomeText;

	public SignOnPage() {
		welcomeText = driver.findElement(By.xpath("//*[contains(text(),'Welcome back to')]"));
	}
	
	public String verifyPageTitle(){
		return driver.getTitle();
	}
	
	public boolean verifyWelcomeText() throws IOException{
		TestUtil.takeScreenshot();		
		return welcomeText.isDisplayed();
	}
	
}

	
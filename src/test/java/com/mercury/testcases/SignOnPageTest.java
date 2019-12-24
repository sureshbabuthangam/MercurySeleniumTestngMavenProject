package com.mercury.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mercury.pages.HomePage;
import com.mercury.pages.SignOnPage;
import com.mercury.testbase.TestBase;


public class SignOnPageTest extends TestBase{
	SignOnPage signOnPage;
	HomePage homePage;

	public SignOnPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException{
		initialization();
		System.out.println("Sign on page setup");

		homePage = new HomePage();
		String username = prop.getProperty("adminlogin");
		String password = prop.getProperty("adminpassword");
		homePage.login(username, password);
		
		signOnPage = new SignOnPage();	
	}
	
	@Test(priority=1)
	public void signOnPageTitleTest(){
		String title = signOnPage.verifyPageTitle();
		System.out.println("SignOnPageTitleTest");
		Assert.assertEquals(title, "Sign-on: Mercury Tours");
	}

	
	@Test(priority=2)
	public void verifyWelcomeTest() throws IOException{
		System.out.println("verifyWelcomeTest");
		Assert.assertTrue(signOnPage.verifyWelcomeText());
	}
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.close();
	}
	
	
	
	

}

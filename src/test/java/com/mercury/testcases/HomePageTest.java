package com.mercury.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mercury.pages.HomePage;
import com.mercury.testbase.TestBase;


public class HomePageTest extends TestBase{
	HomePage homePage;
	
	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		System.out.println("home page setup");
		homePage = new HomePage();	
	}
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		String title = homePage.verifyHomePageTitle();
		System.out.println("loginPageTitleTest");
		Assert.assertEquals(title, "Welcome: Mercury Tours");
	}

	
	@Test(priority=2)
	public void loginTest() throws IOException{
		System.out.println("login test");

		String username = prop.getProperty("adminlogin");
		String password = prop.getProperty("adminpassword");
		homePage.login(username, password);
	}
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	

}

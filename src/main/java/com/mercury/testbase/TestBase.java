package com.mercury.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.mercury.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static String testdatasheetpath;
	
	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/mercury/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization(){
		String browserName = prop.getProperty("browser");
		String chromedriverpath = prop.getProperty("chromedriverpath");
		String geckodriverpath =  prop.getProperty("geckodriverpath");	
		String iedriverpath = prop.getProperty("iedriverpath");
		String edgedriverpath =  prop.getProperty("edgedriverpath");	
		testdatasheetpath = prop.getProperty("testdatapath");

		int page_load_timeout = Integer.parseInt(prop.getProperty("PAGE_LOAD_TIMEOUT"));
		int global_implicit_wait =  Integer.parseInt(prop.getProperty("GLOBAL_IMPLICIT_WAIT"));	
		
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", chromedriverpath);	
			driver = new ChromeDriver(); 
		} else if(browserName.equals("firefox")){
			System.setProperty("webdriver.gecko.driver", "firefoxdriverpath");
			FirefoxOptions options = new FirefoxOptions();
			options.setBinary("C:/Program Files/Mozilla Firefox/firefox.exe");
			WebDriver driver = new FirefoxDriver(options);
		} else if(browserName.equals("edge")){
			System.setProperty("webdriver.edge.driver", "edgedriverpath");
			WebDriver driver = new EdgeDriver();
		} else if(browserName.equals("IE")){
			System.setProperty("webdriver.ie.driver", "iedriverpath");
			WebDriver driver = new InternetExplorerDriver();
		} else {
			System.setProperty("webdriver.chrome.driver", chromedriverpath);	
			driver = new ChromeDriver(); 
		}
		
		//Browser properties
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(page_load_timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(global_implicit_wait, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
	}
	
	
	
	
	
	
	
	

}

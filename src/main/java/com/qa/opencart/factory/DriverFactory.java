package com.qa.opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.qa.opencart.frameworkexception.FrameworkException;

public class DriverFactory

{
    WebDriver driver;
	
    public WebDriver initDriver(Properties prop)
	{
		String browserName =prop.getProperty("browser").trim();//to fetch browsername value from config.properties file
    	
    	System.out.println("Browser name is " + browserName);
		switch (browserName) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "safari":
			driver = new SafariDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;

		default:
			System.out.println("Please pass the correct browser" + browserName);
			throw new FrameworkException("NOBROWSERFOUNDEXCEEPTION");
		
		}
		  driver.manage().deleteAllCookies();
		  driver.manage().window().maximize();
		  driver.get(prop.getProperty("url"));//now fetching url from config.properties file using refrence obj of Properties class
		  return driver;
	}
	
	public Properties initProp() 
	{
		Properties prop =  new Properties();
		//Properties class will interact with file config.proerties
		try {
			FileInputStream ip =  new FileInputStream("./src/main/resources/config/config.properties");
			//This FileInputStream will make the connection with file config.proerties
			
			 prop.load(ip);//this will load all properties into Properties class object as key value pair
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     
		  return prop;
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

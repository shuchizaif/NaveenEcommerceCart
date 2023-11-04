package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProductPage;
import com.qa.opencart.pages.SearchResultPage;

public class BaseTest {
	
	WebDriver driver;
	protected LoginPage loginPage;
	protected AccountsPage acctPage;
	protected SearchResultPage searchresultPage;
	protected ProductPage productPage;
   
	protected DriverFactory df;
	protected Properties prop;
	
	protected SoftAssert softAssert;
	
	@BeforeTest
	public void setup()
	{
		
		
		df = new DriverFactory();
		prop = df.initProp();
		driver = df.initDriver(prop);
		
		
		loginPage = new LoginPage(driver);
		softAssert = new SoftAssert();
	   acctPage =loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
		searchresultPage =acctPage.doSearch("Mac");
		productPage= searchresultPage.doclickproduct();

	}
	
	
	
	/*@AfterTest
	public void teardown()
	{
		driver.quit();
	}*/

}

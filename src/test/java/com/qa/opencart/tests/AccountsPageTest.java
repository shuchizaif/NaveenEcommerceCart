package com.qa.opencart.tests;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;



public class AccountsPageTest extends BaseTest {
	
	@Test
	public void AccountPageTitleTest()
	{
		String actAccountPagetitle = acctPage.AccountPageTitle();
		softAssert.assertEquals(actAccountPagetitle, "My Account");
	}
	
	@Test
	public void AccountPageUrlTest()
	{
		String actAccountPageUrl = acctPage.AccountPageUrl();
		softAssert.assertEquals(actAccountPageUrl, "https://naveenautomationlabs.com/opencart/index.php?route=account/account");
	}
	
	@Test
	public void getAccountPageheaderListTest()
	{
		List<String> listofheaders = acctPage.getAccountPageheaderList();
		List<String> actaccountHeaderList = Arrays.asList("My Account","My Orders","My Affiliate Account","Newsletter");
		softAssert.assertEquals(listofheaders,actaccountHeaderList );
	    softAssert.assertAll();
	}
	
	/*@AfterTest
	public void tearDown()
	{
		driver.quit();
	}*/
	
	

}

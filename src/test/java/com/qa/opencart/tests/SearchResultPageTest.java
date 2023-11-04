package com.qa.opencart.tests;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.SearchResultPage;

public class SearchResultPageTest extends BaseTest {

	
	/*@Test
	public void searchresultheadingtextTest()
	{
		String actsearchPageheading =  searchresultPage.searchresultheadingtext();
		Assert.assertEquals(actsearchPageheading, "Products meeting the search criteria");
	
	}*/
	
	@DataProvider
	public Object[][] getProductNameData()
			{
		       return new Object[][]
		       
		       {
		    	   {"Mac"},
		    	   {"Samsung"},
		    	   {"Macbook"}
		       };
			}
	@Test(dataProvider = "getProductNameData")
	public void pageSearchTitleTest(String searchkey)
	{
		String acttitle = searchresultPage.pageSearchTitle();
		softAssert.assertEquals(acttitle, searchkey);
	}
	
	@Test(dataProvider = "getProductNameData")

	public void searchbartextTest(String searchkey)
	{
		String actsearchtext = searchresultPage.searchbartext();
	    softAssert.assertEquals(actsearchtext, searchkey);
	}
	
	
	@Test
	
	
	public void categoriesfiltersizeTest()
	{
		 int count =searchresultPage.categoriesfiltersize();
		softAssert.assertEquals(count, 53);
		
	}
	
	@Test
	public void searchcriteriatextTest() throws InterruptedException
	{
		String actsearchcriteriatext = searchresultPage.searchcriteriatext();
		Thread.sleep(1000);
		softAssert.assertEquals(actsearchcriteriatext,"Mac");
		softAssert.assertAll();
	}
	
	

}
	
	
	
	
	

	
	
	
	
	
	
	



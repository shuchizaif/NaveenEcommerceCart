package com.qa.opencart.tests;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProductPage;
import com.qa.opencart.pages.SearchResultPage;

public class ProductPageTest extends BaseTest {
	

	
	@Test
	public void ProductPageTitleTest()
	{
		String actTitle =productPage.ProductPageTitle();
		softAssert.assertEquals(actTitle, "iMac");
	}
	
	@Test
	public void getProductInfoTest()
	{
		Map<String,String> productInfoMap = productPage.getProductInfo();
		System.out.println(productInfoMap);
		softAssert.assertEquals(productInfoMap.get("Brand"), "Apple");
		softAssert.assertEquals(productInfoMap.get("Availability"), "Out Of Stock");
		softAssert.assertEquals(productInfoMap.get("Product Code"),"Product 14");
	}
	
	@Test
	public void quantityAddedTest()
	{
		String quantityvalue =productPage.quantityShown();
		softAssert.assertEquals(quantityvalue, "1");
		softAssert.assertAll();
	}
	
	
	

}

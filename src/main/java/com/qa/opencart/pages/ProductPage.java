package com.qa.opencart.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage {

	private WebDriver driver;
	
	public ProductPage(WebDriver driver) 
	{
		this.driver= driver;
	}

	//locators
	private By productMetaData = By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[position()=1]/li");
	private By productPriceData = By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[position()=2]/li ");		
	private By quantity         = By.xpath(" //input[@id='input-quantity' and @value='1']");	
	private By addToCartbtn     = By.xpath("//button[@id='button-cart'] ");
	
	
	private Map<String,String>productInfoMap;
	
	//Action Methods
	public String ProductPageTitle()
	{
		String pagetitle =driver.getTitle();
		return pagetitle;
	}
	
	/*Brand: Apple
	Product Code: Product 14
	Availability: Out Of Stock*/
	private void productMetaDataRead()
	{
		List<WebElement> metadata = driver.findElements(productMetaData);
		productInfoMap = new HashMap<String,String>();
		for(WebElement data : metadata )
		{
			String metatext =data.getText();
			String metaInfo[] = metatext.split(":");
			String key =metaInfo[0].trim();
			String value = metaInfo[1].trim();
			productInfoMap.put(key, value);
		}
	}
	
		/*$122.00
          Ex Tax: $100.00*/
		private void  productPriceDataRead()
		{
			List<WebElement>priceListdata = driver.findElements(productPriceData);
			String actualprice = priceListdata.get(0).getText();//$122.00
			String extTaxPrice = priceListdata.get(1).getText();//Ex Tax:
			String extTaxPriceValue = extTaxPrice.split(": ")[1].trim();//$100.00
			productInfoMap.put("productprice", actualprice);
			productInfoMap.put(extTaxPrice, extTaxPriceValue);
		}
		  
		public Map<String, String> getProductInfo()
		{
			productMetaDataRead();
			productPriceDataRead();
			return productInfoMap;
		}
		
		
		public String quantityShown()
		{
			String quantityadd = driver.findElement(quantity).getText();
			return quantityadd;
		}
		
		/*public void doclickAddtoCart()
		{
			driver.findElement(addToCartbtn)
		}*/
		
	}
	

		




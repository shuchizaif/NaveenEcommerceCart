package com.qa.opencart.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SearchResultPage {
	 WebDriver driver;
	
	public SearchResultPage(WebDriver driver)
	{
		this.driver= driver;
	}
	
	//locators
	
	private By searchresultheading = By.xpath("//input[@id='button-search']/following-sibling::h2] ");
	private By search =              By.xpath("//input[@placeholder='Search']");
	private By productlist =         By.xpath("//input[@id='button-search']/following-sibling::h2[text()='Products meeting the search criteria'] ");
	private By allcategories =       By.xpath("//select[@class='form-control']/option");//size of items
    private By options        =      By.xpath("//option[text()='All Categories']");
	private By subcategories =       By.xpath("//input[@name='sub_category'] ");//clickable
	private By productdescription =  By.xpath("//input[@id='description'] ");//clickable
    private By buttonsearch   =      By.xpath("//input[@id='button-search'] ");//clickable
    private By searchitemstitle =    By.xpath("//input[@id='button-search']/following-sibling::h2");//verify title
   private  By sortByfilter       =  By.xpath("//select/option");//53 elements        
    private By sortByfiltervalue =   By.xpath("//select[@id ='input-sort']/option[text()='Name (A - Z)'] ");//verify  if selected list item is same as expected
    private By showfilter   =        By.xpath("//select[@id ='input-limit']");//verify selected value is 15
    private By searchfilterresult =  By.xpath("//a[text()='iMac'] ");//verify result list has first product iMac
    private By addToCart           = By.xpath("(//span[text()='Add to Cart'])[1] ");
    private By productselect       = By.xpath("(//a[text()='iMac'])");
    private By cartitemprice         = By.xpath("//span[@id='cart-total' and text()='0 item(s) - $0.00'] " );
   
    
  
    
    
    
    public String searchresultheadingtext()
    {
    	String pageheading =driver.findElement(searchresultheading).getText();
    	System.out.println("Search Page heading is " + pageheading);
    	return pageheading; 
    }
    
    public String pageSearchTitle()
    {
    	String SearchPageTitle = driver.getTitle();
		return SearchPageTitle;
    }
    
    public String searchbartext()
    {
    	 String searchcontent =driver.findElement(search).getAttribute("value");
    	 return searchcontent;
    }
  
    
    public int categoriesfiltersize()
    {
    	int categorieslist = driver.findElements(allcategories).size();
    	System.out.println("List of elements in categorylist filter are " + categorieslist);
    	return categorieslist;
    			
  }
    
  public void issubcategoriesclickable()
    {
    	driver.findElement(subcategories).click();
    }
    
    public void isproductdescriptionclickable()
    {
    	driver.findElement(productdescription).click();
    }
    
    public void doclickbuttonsearch()
    {
    	driver.findElement(buttonsearch).click();
    }
    
    
    public void searchitemstitle()
    {
    	String searchitemstitletext = driver.findElement(searchitemstitle).getText();
    	System.out.println("Title for Search items page is" + searchitemstitletext );
    }
    
    
    public void doclicksortByfiltervalue()
    {
    	WebElement sorting = driver.findElement(sortByfilter);
    	Select sel = new Select(sorting);
    	sel.selectByVisibleText("Name(A - Z)");
    
    
    }
    
    public void doclickshowfilter()
    {
    	WebElement show = driver.findElement(showfilter);
    	Select sel1 = new Select(show);
    	sel1.deselectByVisibleText("15");
    }
    
    
    
  public String Productlistheading()
	{
		String heading =driver.findElement(productlist).getText();
		System.out.println("Product list heading after search is " + heading);
		return heading;
	
	}
	
	public String searchcriteriatext()
	{
	
		String filtertext2 = driver.findElement(search).getAttribute("value");
		System.out.println("Text displayed in search criteria after search is " + filtertext2 );
		System.out.println("filtertext2=" + filtertext2 );
		return filtertext2;
	}
	
	/*public String  doclickAddtoCart()
	{
		 driver.findElement(addToCart).click();
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(5000,40)");
		 
	    String priceitemsvalue = driver.findElement(cartitemprice).getText();
	     System.out.println(priceitemsvalue);
	     return priceitemsvalue;
	}*/
		
	

    //redirecting to ProductPage when we we run doclickProduct() on SearchResultPage
   public ProductPage doclickproduct()
   {
	   driver.findElement(productselect).click();
	   return new ProductPage(driver);
   }


}



    

	
	
	
	
	




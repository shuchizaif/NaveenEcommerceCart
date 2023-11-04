package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class LoginPage {

	
		private WebDriver driver;//define WebDriver
		private ElementUtil eleutil;
	
	//Constructor
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;//initialize earlier defined driver with driver value passed in Constructor
		eleutil = new ElementUtil(this.driver);
	}
	//By locators
	private By emailid = By.id("input-email");//By is a class which is return type of locator used
	private By password = By.id("input-password");
	private By forgotPwrd =By.xpath("//a[text()='Forgotten Password'] ");
	private By login = By.xpath("//input[@value='Login'] ");
	private By rightcolumnlinks = By.xpath("//div[@class='list-group']/a");
	
	private By registerLink = By.xpath("//div[@class='list-group']/a[text()='Register']");
	

	
	
	//public Page Actions/methods
	
	public String getLoginpageTitle()
	{
//		String title = driver.getTitle();
//		System.out.println("Login Page Title is " +title);
//		return title;
//		
		return eleutil.waitForTitleIsAndCapture(AppConstants.LOGIN_PAGE_TITLE_VALUE,AppConstants.LONG_DEFAULT_WAIT);//this eleutil method will retuen title of LoginPage
	  //As LOGIN_PAGE_TITLE_VALUE is defined static so calling this variable directly using Classname "AppConstants"
	}
	
	public String getLoginPageUrl()
	{
//		String URL = driver.getCurrentUrl();//replacing with ElementUtil code with wait
//        System.out.println("Login Page URL is " +URL);
//		return URL;
		return eleutil.waitForURLContainsAndCapture(AppConstants.LOGIN_PAGE_FRACTION_VALUE, AppConstants.LONG_DEFAULT_WAIT);//this method will return Url
		
	}
	
	public boolean isForgotPwrdLinkExist()
	{
		return eleutil.checkElementIsDisplayed(forgotPwrd);

	}
	
	public List<String> RightColumnlinksclickable()
	{
		//List<WebElement> rightcollinks = driver.findElements(rightcolumnlinks);//replacing with elementUtil
		List<WebElement> rightcollinks = eleutil.waitForElementsVisible(rightcolumnlinks, AppConstants.MEDIUM_DEFAULT_WAIT);
		List<String>collinks = new ArrayList();
		for(WebElement link : rightcollinks)
		{
			String alllinks =link.getText();
			collinks.add(alllinks);
		}
		  return collinks;
	}
 
	//Redirecting to AccountsPage when we run doLogin on LoginPage
	public AccountsPage doLogin(String userName, String Pwrd)
	{
		/*driver.findElement(emailid).sendKeys(userName);
		driver.findElement(password).sendKeys(Pwrd);
		driver.findElement(login).click();*/
		eleutil.waitForElementVisible(emailid, AppConstants.MEDIUM_DEFAULT_WAIT).sendKeys(userName);
		eleutil.waitForElementVisible(password, AppConstants.MEDIUM_DEFAULT_WAIT).sendKeys(Pwrd);
		eleutil.doClick(login);
		
		//return next Landing Page---HomePage--page chaining model
		return new AccountsPage(driver);
	}

	





}


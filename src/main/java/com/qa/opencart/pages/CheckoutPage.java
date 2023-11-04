package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage {
  WebDriver driver;
	
	
	
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	}

	

//locators
	
	
	
	//Action Methods
	public String checkoutPageTitle()
	{
		String title = driver.getTitle();
	     System.out.println("Checkout Page title is " +title);
		return title;
	}


	













}

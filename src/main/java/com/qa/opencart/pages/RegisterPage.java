package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
	private WebDriver driver;
	
	By firstName       = By.xpath("//input[@id='input-firstname']");
	By lastName        = By.xpath("//input[@id='input-lastname']");
	By email           = By.xpath("//input[@id='input-email']");
	By telephone       = By.xpath("//input[@id='input-telephone']");
    By password        = By.xpath("//input[@id='input-password']");
    By confirmpassword = By.xpath("//input[@id='input-confirm']");
    By agreeCheckbox   = By.xpath("//input[@name='agree']");
    By continueButton  = By.xpath("//input[@value='Continue']");
    By subscribeYes    = By.xpath("//input[@name='newsletter' and @value='1']");
    By subscribeNo     = By.xpath("//input[@name='newsletter' and @value='0']");






}

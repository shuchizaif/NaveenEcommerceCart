package com.qa.opencart.tests;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;

import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.AppConstants;

public class LoginPageTest extends BaseTest {
	
	
	
	@Test
	public void loginPageTitleTest()
	{
		String acttitle =loginPage.getLoginpageTitle();
		softAssert.assertEquals(acttitle,AppConstants.LOGIN_PAGE_TITLE_VALUE);
	}
	
	@Test
	public void loginPageURLTest()
	{
		String actURL =loginPage.getLoginPageUrl();
		softAssert.assertTrue(actURL.contains(AppConstants.LOGIN_PAGE_FRACTION_VALUE));
	}
	
	@Test
	public void forgotPwrdLinkTest()
	{
		softAssert.assertTrue(loginPage.isForgotPwrdLinkExist());
	}
	
	@Test
	public void RightColumnlinksclickableTest()
	{
		List<String> clicklinks =loginPage.RightColumnlinksclickable();
		List<String> expectedCollist = Arrays.asList("Login","Register","Forgotten Password","My Account","Address Book","Wish List","Order History","Downloads","Recurring payments","Reward Points","Returns","Transactions","Newsletter");
	   softAssert.assertEquals(clicklinks, expectedCollist);
	   softAssert.assertAll();
	   
	}
	
	

}

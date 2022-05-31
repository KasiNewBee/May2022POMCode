package com.qa.retail.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.retail.base.BaseTest;
import com.qa.retail.util.Constants;

public class LoginPageTest extends BaseTest {
	
	@Test(priority=1)
	public void verifyForgotPwdLinkPresence()
	{
		Assert.assertTrue(loginPage.IsForgotPasswordLinkPresent());			
	}

	@Test(priority=2)
	public void verifyPageTitle()
	{
		Assert.assertEquals(loginPage.getLoginPageTitle(),Constants.LOGIN_PAGE_TITLE);
	}
	
	@Test(priority=3)
	public void doLogin()
	{
		loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
		
	}
}

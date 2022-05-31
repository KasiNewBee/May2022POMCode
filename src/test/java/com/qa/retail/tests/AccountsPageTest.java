package com.qa.retail.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.retail.base.BaseTest;
import com.qa.retail.util.Constants;

public class AccountsPageTest extends BaseTest {
	
	
	@BeforeClass
	public void accountsPageSetUp()
	{
		accountsPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Test(priority=1)
	public void verifyPageTitle()
	{
		Assert.assertEquals(accountsPage.getPageTitle(),Constants.Accounts_Page_Title);
	}
	@Test(priority=2)
	public void validateAccountsSectionLinks()
	{
		List<String> act = accountsPage.getAndVerifyLinkSection();
		List<String> exp = Constants.getExpectedLinksSection();
		Assert.assertEquals(act, exp);
	}

}

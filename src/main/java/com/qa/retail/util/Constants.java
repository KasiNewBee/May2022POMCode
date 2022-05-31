package com.qa.retail.util;

import java.util.ArrayList;
import java.util.List;

public interface Constants {
	String LOGIN_PAGE_TITLE = "Account Login";
	String Accounts_Page_Title ="My Account";
	//String Products_Page_Title = "";
	public static List<String> getExpectedLinksSection()
	{
		List<String> expectedList = new ArrayList();
		expectedList.add("My Account");
		expectedList.add("My Orders");
		expectedList.add("My Affiliate Account");
		expectedList.add("Newsletter");		
		return expectedList;
	}
}

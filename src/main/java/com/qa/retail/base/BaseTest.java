package com.qa.retail.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.retail.pages.AccountsPage;
import com.qa.retail.pages.LoginPage;

public class BaseTest extends BasePage{
	
	public WebDriver driver;
	public Properties prop;
	public BasePage basePage;
	public LoginPage loginPage;
	public AccountsPage accountsPage;
	
	@BeforeTest
	public void setup()
	{
		basePage= new BasePage();
		prop = basePage.init_prop();
		driver = basePage.init_Driver(prop.getProperty("browser"));
		loginPage = new LoginPage(driver);
		driver.get(prop.getProperty("url"));
	//	accountsPage = new AccountsPage(driver);
	}
	
	@AfterTest
	public void quitBrowser() {
		driver.quit();
	}

}

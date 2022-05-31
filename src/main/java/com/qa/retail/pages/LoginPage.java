package com.qa.retail.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.retail.base.BasePage;

public class LoginPage extends BasePage {
	
	private WebDriver driver;
	private By emailAddress = By.cssSelector("input[type='text'][name='email']");
	private By password=By.cssSelector("input[type='password'][name='password']");
	private By loginButton = By.cssSelector("input.btn.btn-primary");
	private By forgotPwd = By.linkText("Forgotten Password");
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public String getLoginPageTitle()
	{
		WebDriverWait wait =new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.titleIs("Account Login"));
		return driver.getTitle();
		
	}
	
		
	public boolean IsForgotPasswordLinkPresent()
	{
		if(driver.findElement(forgotPwd).isDisplayed())
			return true;
		else
			return false;
	}
	
	public AccountsPage doLogin(String un,String pwd)
	{
		driver.findElement(emailAddress).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginButton).click();
		return new AccountsPage(driver);
		
	}
	

}

package com.qa.retail.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.retail.base.BasePage;

public class AccountsPage extends BasePage {
	private WebDriver driver;
	private By linkSection= By.cssSelector("#content h2");
	private By searchText=By.cssSelector("input[type='text'][name ='search']");
	private By searchBtn =By.cssSelector(".btn.btn-default.btn-lg");
	private By searchItemsList= By.cssSelector(".product-layout .product-thumb");	
	public AccountsPage(WebDriver driver)
	{
		this.driver = driver;	
	}
	
	public String getPageTitle()
	{
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.titleIs("Your Store"));
		return driver.getTitle();	
	}
	
	public boolean navigateToSearchResultsPage()
	{
			driver.findElement(searchText).sendKeys("Macbook");
			driver.findElement(searchBtn).click();
			int size= driver.findElements(searchItemsList).size();
			if(size>0)
				{return true;}
			return false;			
	}

	public ProductInfoPage selectProductFromList(String productName)
	{
		driver.findElement(searchText).sendKeys("Macbook");
		driver.findElement(searchBtn).click();
		List<WebElement> pl =driver.findElements(searchItemsList);
		pl.stream().forEach(e->
			{if(e.getText().equals("MacBook"))
				{e.click();}
			});	
		
		return new ProductInfoPage(driver);
	}
	
	public List<String> getAndVerifyLinkSection()
	{
		List<String> ACLinks = new ArrayList();
		List<WebElement> ls = driver.findElements(linkSection);
		ls.stream().forEach(e->ACLinks.add(e.getText()));
		return ACLinks;
	}
}

package com.zoopla.qa.Pages;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zoopla.qa.TestBase.TestBase;

public class ForSale extends TestBase
{
		@FindBy(xpath="//a[contains(@class,'listing-results-price text-price')]")
		WebElement s;
		
		@FindBy(xpath="//div[contains(@class,'ui-agent__logo')]//img")
		WebElement agentLogo;
		
		@FindBy(xpath="//div[contains(@class,'ui-agent__text')]//h4[@class='ui-agent__name']")
		WebElement agentName;
		
		@FindBy(xpath="//p[@class='ui-agent__tel ui-agent__text']//a[@class='ui-link']")
		WebElement agentPhoneNo;

         public ForSale()
	     {
	    	 PageFactory.initElements(driver, this);
	     }

	   public void printPropertyPrice()
	   {
		List<WebElement> price = driver.findElements(By.xpath("//a[contains(@class,'listing-results-price text-price')]"));
		List<String>prices = new ArrayList<String>();
		for(WebElement e: price)
		{
			prices.add(e.getText());
		}
         Collections.sort(prices,Collections.reverseOrder());	
         System.out.println("Property Price in descending order: ");
         for(String s:prices)
         {
        	 System.out.println(s);
         }
         
        }
	
	public UserSelectedPropertyPage selectProperty()
	{
		List<WebElement> price = driver.findElements(By.xpath("//a[contains(@class,'listing-results-price text-price')]"));
		List<String>prices = new ArrayList<String>();
		for(WebElement e: price)
		{
			prices.add(e.getText());
		}
         System.out.println("5th Property Price is: " + prices.get(4));
		price.get(4).click();
		System.out.println("Logo is: " + agentLogo.getText());
		System.out.println("Name is: " + agentName.getText());
		System.out.println("Number is: " + agentPhoneNo.getText());
		return new UserSelectedPropertyPage();
	}
}

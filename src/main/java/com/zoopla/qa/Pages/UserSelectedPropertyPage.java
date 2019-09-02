package com.zoopla.qa.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zoopla.qa.TestBase.TestBase;

public class UserSelectedPropertyPage extends TestBase
{
	 @FindBy(xpath="//div[contains(@class,'ui-agent__text')]//h4[@class='ui-agent__name']")
	public WebElement agentName;
	 
	 @FindBy(xpath="//h1[@class='bottom-half']//b")
     public WebElement verifyAgentName;	 
	 
	 public UserSelectedPropertyPage()
     {
    	 PageFactory.initElements(driver, this);
     }

      public void validateAgentName()
      {
    	  agentName.click();
      }
}

   


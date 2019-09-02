package com.zoopla.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zoopla.qa.TestBase.TestBase;

public class ZooplaHomePage extends TestBase
{
     @FindBy(xpath="//input[@id='search-input-location' and @type='text']")
     WebElement searchLocation;
     
     @FindBy(xpath="//button[@id='search-submit' and @value='Search']")
     WebElement searchButton;
     
     @FindBy(xpath="//img[contains(@class,'icon--logo')]")
     WebElement zooplaLogo;
     
     
     public ZooplaHomePage()
     {
    	 PageFactory.initElements(driver, this);
     }
     
     public String ValidateHomePageTitle()
     {
    	 return driver.getTitle();
     }
     
     public boolean ValidateZooplaLogo()
     {
    	 return zooplaLogo.isDisplayed();
     }
     
     public ForSale location(String enterLocation)
     {
    	 
    	 searchLocation.sendKeys(enterLocation);
    	 searchButton.click();
         return new ForSale();
     }
     
     public void login()
     {
    	 System.out.println("hello yeh func aisi hai");
     }
     
          	
}

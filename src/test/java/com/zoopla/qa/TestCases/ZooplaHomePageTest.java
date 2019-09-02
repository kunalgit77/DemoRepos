package com.zoopla.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.zoopla.qa.Pages.ForSale;
import com.zoopla.qa.Pages.ZooplaHomePage;
import com.zoopla.qa.TestBase.TestBase;

public class ZooplaHomePageTest extends TestBase
{
	   ZooplaHomePage zhp;
	   ForSale fs;
       public ZooplaHomePageTest()
       {
    	   super();
       }
       
       @BeforeMethod
       public void setUp()
       {
    	   setUps();
    	   zhp = new ZooplaHomePage();
       }
       
       @Test(priority=1)
       public void ValidateHomePageTitleTest()
       {
    	   String title = zhp.ValidateHomePageTitle();
    	   Assert.assertEquals(title, "Zoopla > Search Property to Buy, Rent, House Prices, Estate Agents");
       }
       
       @Test(priority=2)
       public void ValidateZooplaLogoTest()
       {
    	   boolean flag = zhp.ValidateZooplaLogo();
    	   Assert.assertTrue(flag);
       }
       
       @Test(priority=3)
       public void locationSearchTest()
       {
    	   fs = zhp.location("London");
       }
       
       @AfterMethod
       public void tearDown()
       {
    	   driver.quit();
       }
}

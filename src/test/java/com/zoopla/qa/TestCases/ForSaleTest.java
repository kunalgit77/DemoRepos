package com.zoopla.qa.TestCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.zoopla.qa.Pages.ForSale;
import com.zoopla.qa.Pages.UserSelectedPropertyPage;
import com.zoopla.qa.Pages.ZooplaHomePage;
import com.zoopla.qa.TestBase.TestBase;
import com.zoopla.qa.Utility.ZooplaUtility;

public class ForSaleTest extends TestBase
{
	   ZooplaHomePage zhp;
	    ForSale fst;
	    UserSelectedPropertyPage page;
        public ForSaleTest()
        {
        	super();
        }
        
        @BeforeMethod
        public void saleSetUp()
        {
        	setUps();
        	zhp = new ZooplaHomePage();
        	fst = zhp.location("London");
        }
        
        @Test(priority=1)
        public void printPropertyPriceTest()
        {
        	driver.manage().timeouts().pageLoadTimeout(ZooplaUtility.PAGE_LOAD, TimeUnit.SECONDS);
        	fst.printPropertyPrice();
        }
        
        @Test(priority=2)
        public void selectPropertyTest()
        {
        	page = fst.selectProperty();
        }
        
        @AfterMethod
        public void shutDown()
        {
     	   driver.quit();
        }
}

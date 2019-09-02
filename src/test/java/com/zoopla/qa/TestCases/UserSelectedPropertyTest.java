package com.zoopla.qa.TestCases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.zoopla.qa.Pages.ForSale;
import com.zoopla.qa.Pages.UserSelectedPropertyPage;
import com.zoopla.qa.Pages.ZooplaHomePage;
import com.zoopla.qa.TestBase.TestBase;
import com.zoopla.qa.Utility.ZooplaUtility;

public class UserSelectedPropertyTest extends TestBase 
{
	UserSelectedPropertyPage uspt;
	ZooplaHomePage zhps;
	ForSale fs;
	
    public UserSelectedPropertyTest()
    {
    	super();
    }
    
    @BeforeMethod()
    public void setUp()
    {
    	setUps();
    	zhps = new ZooplaHomePage();
    	fs = new ForSale();
    	uspt = new UserSelectedPropertyPage();
    	fs = zhps.location("London");
    	driver.manage().timeouts().pageLoadTimeout(ZooplaUtility.PAGE_LOAD, TimeUnit.SECONDS);
    	fs.printPropertyPrice();
    	uspt = fs.selectProperty();
    }
    
    @Test
    public void validateAgentNameTest()
    {
    	String onForSalePageAgent = uspt.agentName.getText();
    	uspt.validateAgentName();
    	String name = uspt.verifyAgentName.getText();
    	Assert.assertEquals(onForSalePageAgent, name);
    }
    
    @AfterMethod
    public void shutDown()
    {
 	   driver.quit();
    }

}

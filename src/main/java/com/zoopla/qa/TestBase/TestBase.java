package com.zoopla.qa.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.zoopla.qa.Utility.WebEventListener;
import com.zoopla.qa.Utility.ZooplaUtility;

public class TestBase 
{
    public static WebDriver driver;
    public static Properties property;
    public static WebEventListener elist;
	public static EventFiringWebDriver fdriver;

    
    public TestBase()
    {
    	try
    	{
    		property = new Properties();
    		FileInputStream fi = new FileInputStream("D:\\newjava\\ZooplaTest\\src\\main\\java\\com\\zoopla\\qa\\Config\\config.properties");
    		property.load(fi);
    		
    	}catch(FileNotFoundException e){
    		e.printStackTrace();
    	}catch(IOException e){
    		e.printStackTrace();
    	}
    }
    
    public static void setUps()
    {
    	String browserName = property.getProperty("browser");
    	if(browserName.equalsIgnoreCase("chrome"))
    	{
    		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
    		driver = new ChromeDriver();
    	}
    	else if(browserName.equalsIgnoreCase("firefox"))
    	{
    		System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");
    		driver = new FirefoxDriver();
    	}
    	
    	fdriver = new EventFiringWebDriver(driver);
		elist = new WebEventListener();
		fdriver.register(elist);
		driver = fdriver;

    	driver.manage().deleteAllCookies();
    	driver.manage().window().maximize();
    	driver.manage().timeouts().pageLoadTimeout(ZooplaUtility.PAGE_LOAD, TimeUnit.SECONDS);
    	driver.manage().timeouts().implicitlyWait(ZooplaUtility.IMPLICIT_WAIT, TimeUnit.SECONDS);
    	driver.get(property.getProperty("url"));
    }
    
}

package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties property;
	private static WebEventListener eventListener;
	@SuppressWarnings("deprecation")
	private static EventFiringWebDriver eDriver;
	private static boolean headlessMode = false;
	private static ChromeOptions options;
	
	public TestBase() {
		try {
		property = new Properties();
		FileInputStream inputS = new FileInputStream(System.getProperty("user.dir") +  "\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
		property.load(inputS);
		}
		catch(FileNotFoundException e) {
		e.printStackTrace();
		}
		catch(Exception ex) {
		ex.printStackTrace();
		}
	}
		
	@SuppressWarnings("deprecation")
	public static void initialization() throws InterruptedException {
		String browserName = property.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			if(headlessMode)
			{
				options = new ChromeOptions();
				options.addArguments("headless");
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
				driver = new ChromeDriver(options);
			}
			else
			{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
			driver = new ChromeDriver();
			}
		}
		else if(browserName.equals("ff"))
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		if(TestUtil.WEB_EVENT_LISTENER == true) {
			eDriver = new EventFiringWebDriver(driver);
			// Now create object of 
			eventListener = new WebEventListener();
			eDriver.register(eventListener);
			driver = eDriver;
		}
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
		driver.get(property.getProperty("url"));
		Thread.sleep(4000);
	}
	
	/**
	 * The base url used for requests
	 **/
	public static String baseURI() {
		return property.getProperty("api");		
	}
}

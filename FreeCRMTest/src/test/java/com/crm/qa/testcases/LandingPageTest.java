package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LandingPage;
import com.crm.qa.pages.SearchResultsPage;
import com.crm.qa.pages.SingleProductPage;

public class LandingPageTest extends TestBase {
	
	SearchResultsPage searchResultsPage;
	SingleProductPage singleProductPage;	
	LandingPage landingPage;	
	
	public LandingPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		TestBase.initialization();	
		 landingPage = new LandingPage();
	}
	
	@Test(priority=1)
	public void productSelectedTest() throws InterruptedException {
	landingPage.cookieButtonClicked();	
	Assert.assertTrue(landingPage.retailLogoDisplayed(),"Retail Logo could not be displayed");		
	searchResultsPage = landingPage.searchForItems("Juice");
	
	double productPrice = searchResultsPage.productPrice();	
	singleProductPage = searchResultsPage.productSearchedClicked();
	singleProductPage.productInformationExpanderClicked();
	
	Assert.assertNotNull(singleProductPage.productDescriptionValidated(),"There is no product information displayed to the customer");	
	Assert.assertEquals(productPrice,singleProductPage.getPrice(),"Cannot validate the product price");
	}	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}

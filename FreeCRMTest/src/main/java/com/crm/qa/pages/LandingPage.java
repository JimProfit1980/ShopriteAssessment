package com.crm.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LandingPage extends TestBase {
	
	@FindBy(xpath="//div[@class='yCmsComponent pnp-logo']")
	WebElement retialLogoImage;
	
	@FindBy(id="js-site-search-input")
	WebElement searchInputField;
	
	@FindBy(xpath="//form[@name='search_form_SearchBox']/div/span/a/../button/span")
	WebElement searchIconButton;
	
	@FindBy(name="policiesAcceptButton")
	@CacheLookup 
	WebElement cookieButton;	
	
	public boolean retailLogoDisplayed() throws InterruptedException {
		Thread.sleep(500);
		return retialLogoImage.isDisplayed();
	}
	
	public boolean searchInputFieldDisplayed() {
		return searchInputField.isDisplayed();
	}
	
	/**
	 * Cookie button clicked
	 **/	
	public void cookieButtonClicked() {
		try {
			cookieButton.click();
			
		}
		catch(Exception ex) {
			
		}
	}
	
	public LandingPage() {
		PageFactory.initElements(driver,this);
	}

	/**
	 *Searching for an item
	 *@param productName
	 * @throws InterruptedException 
	 **/
	public SearchResultsPage searchForItems(String productName) throws InterruptedException {		
		searchInputField.sendKeys(productName);
		Thread.sleep(1000);
		searchIconButton.click();		
		Thread.sleep(6000);
		return new SearchResultsPage();		
	}

}

package com.crm.qa.pages;

import java.math.BigDecimal;
import java.util.List;

import org.apache.poi.hpsf.Decimal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class SingleProductPage extends TestBase {
	
	@FindBy(className="promotion")
	WebElement promotionPrice;
	
	@FindBy(xpath="//h4[text()='Product Information']/../span[@class='openIndicator']")
	WebElement productionInformationExpander;
	
	@FindBy(xpath="//h4[text()='Nutritional Information']/../span[@class='openIndicator']")
	WebElement nutritionalInformationExpander;
	
	@FindBy(xpath="//h4[text()='Reviews']/../span[@class='openIndicator']")
	WebElement reviewExpander;
	
	@FindBy(xpath="//div[@class='headline' and contains(text(),'Features')]/..//div/ul/li")
	List<WebElement> productFeatureInformation;
	
	@FindBy(xpath="//div[@class='headline' and contains(text(),'Description')]/..")
	WebElement productDescriptionInformation;
	
	@FindBy(className="normalPrice")
	WebElement normalPrice;
	
	public SingleProductPage() {
		PageFactory.initElements(driver,this);
	}
	
	
	public String getPromotionPriceText() {
		return promotionPrice.getText();
	}
	
	 /**
	 * Product Information being clicked
	 **/
	public void productInformationExpanderClicked() {
		Actions action = new Actions(driver);
		action.scrollToElement(productionInformationExpander).clickAndHold().pause(1000).release().build().perform();
		}
	
	/**
	 * Returns the length of characters that is returned from the product descriptions
	 * @throws InterruptedException 
	 **/
	public boolean productDescriptionValidated() throws InterruptedException {
		Thread.sleep(500);
		String firstFeatureInformation =  productDescriptionInformation.getText();
		return firstFeatureInformation.isEmpty();
	}
	
	/**
	 * Nutritional Information being clicked
	 **/
	public void nutrionalInformationExpanderClicked() {
		nutritionalInformationExpander.click();
	}

	/**
	 * Review expand being clicked
	 **/
	public void reviewsExpanderClicked(){
		reviewExpander.click();
	}
	
	/**
	 * Normal price of the product
	 * **/
	public double getPrice() {
		String updatePrice = normalPrice.getText().replace("R","");
		double getPrice = Double.parseDouble(updatePrice);
		return getPrice * 0.01;
	}
}

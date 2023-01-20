package com.crm.qa.pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class SearchResultsPage extends TestBase {
	
	@FindBy(className="totalResults")
	WebElement totalResults;
	
	@FindBy(css =".thumb > img")
	List<WebElement> totalProductsPerPage;
	
	static int newRandomNumber = 0;
	static WebElement productSelected = null;
	String productId = null;
	
	/**
	 * Click on a random product
	 * @throws InterruptedException 
	 **/
	public SingleProductPage productSearchedClicked() throws InterruptedException {
//		newRandomNumber = TestUtil.RandonNumberGenerated(getMaxNumberOfProductsPerPage());
//		productSelected = driver.findElement(By.xpath("//div[contains(@id,'productCarouselItemContainer')][" + newRandomNumber  + "]"));
//		productId = productSelected.getAttribute("id");
		//int indexOf = productId.indexOf('_');
	//	int lastIndexOf = productId.lastIndexOf('_');
		Actions actionSingleProduct = new Actions(driver);
		actionSingleProduct.moveToElement(driver.findElement(By.xpath("//a[contains(@data-productcode,'" + productId  + "')]/div/img")))
		.pause(500).click().build().perform();
		Thread.sleep(1000);
		return new SingleProductPage();
	}
	
	/**
	 * Get the product Price
	 **/
	public double productPrice() {
		Actions actionProductPrice = new Actions(driver);	
		newRandomNumber = TestUtil.RandonNumberGenerated(getMaxNumberOfProductsPerPage());
		productSelected = driver.findElement(By.xpath("//div[contains(@id,'productCarouselItemContainer')][" + newRandomNumber  + "]"));
		productId = productSelected.getAttribute("id");
		int indexOf = productId.indexOf('_');
		//int lastIndexOf = productId.lastIndexOf('_');
		productId = productId.substring(indexOf + 1);		 
		actionProductPrice.moveToElement(driver.findElement(By.xpath("//a[contains(@data-productcode,'" + productId + "')]/div/../div/div"))).build().perform();
		String productPriceDisplayed = driver.findElement(By.xpath("//a[contains(@data-productcode,'" + productId + "')]/div/../div/div")).getText();
		productPriceDisplayed = productPriceDisplayed.replace("R","");
		return Double.parseDouble(productPriceDisplayed) / 100;
	}
	
	public SearchResultsPage() {
		PageFactory.initElements(driver,this);
	}
	
	public String getTotalResultsText() {
		return totalResults.getText();
	}
	
	/**
	 * Returns the number of products shown on the Search page
	 **/
	public int getMaxNumberOfProductsPerPage() {
		return totalProductsPerPage.size();
	}
	
}

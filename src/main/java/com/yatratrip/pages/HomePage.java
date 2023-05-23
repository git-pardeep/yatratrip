package com.yatratrip.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

import com.yatratrip.base.BaseClass;

public class HomePage extends BaseClass {
//	@FindBy(xpath="//a[@title='https://www.yatra.com']//i[@class='ico-newHeaderLogo']")
//	private WebElement logo;
//	@FindBy(id="BE_flight_origin_city") private WebElement from;
//	@FindBy(id="BE_flight_arrival_city") private WebElement arrival;
//	
//	
//	public HomePage() {
//		PageFactory.initElements(getDriver(), this);
//	}
//	public boolean logoDiplayed() {
//		return logo.isDisplayed();
//	}
//	public SearchPage flightSearch() throws InterruptedException {
//		from.click();
//		Thread.sleep(1000);
//		from.sendKeys("Bangalore");
//		from.sendKeys(Keys.ARROW_DOWN);
//		arrival.click();
//		Thread.sleep(1000);
//		arrival.sendKeys("Mumbai");
//		Thread.sleep(1000);
//		arrival.sendKeys(Keys.ARROW_DOWN);
//		Thread.sleep(1000);
//		return new SearchPage();
//	}
	
	By logo =By.xpath("//a[@title='https://www.yatra.com']//i[@class='ico-newHeaderLogo']");
	By from = By.id("BE_flight_origin_city");
	By arrival = By.id("BE_flight_arrival_city");
	
	public String gettitle() {
		return getDriver().getTitle();
	}
	public boolean logoDisplayed() {
		return getDriver().findElement(logo).isDisplayed();
	}
	
	public SearchPage flightSearch(String frm , String arvl) throws InterruptedException {
		 WebElement from1=getDriver().findElement(from);
		 Thread.sleep(2000);
		from1.clear();
		from1.sendKeys(frm);
		Thread.sleep(2000);
		from1.sendKeys(Keys.ARROW_DOWN);
		 WebElement arrival1=getDriver().findElement(arrival);
		 Thread.sleep(2000);
		arrival1.click();
		arrival1.sendKeys(arvl);
		Thread.sleep(2000);
		arrival1.sendKeys(Keys.ARROW_DOWN);
//		assert.assertEquals(true, false);
		return new SearchPage();
	}
	

}

package com.yatratrip;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.yatratrip.base.BaseClass;
import com.yatratrip.pages.HomePage;
import com.yatratrip.pages.SearchPage;
import com.yatratrip.utilities.Log;
import com.yatratrip.utilities.ReadExcelFile;

public class HomePageTest extends BaseClass {
	HomePage homepage = new HomePage();
	SearchPage searchpage = new SearchPage();
	@Parameters("browser")
	@BeforeMethod
	public void setUp(String browser) {
		launchBrowser(browser);
	}

	@AfterMethod
	public void tearDown() {
		getDriver().close();
	}
	@Test
	public void getTitle() {
		Log.startTestCase("getTitle");
		System.out.println(homepage.gettitle());
		Log.endTestCase("getTitle");
	}
	@Test
	public void logoCheck() {
		Log.startTestCase("logoCheck");
		boolean flag= homepage.logoDisplayed();
		System.out.println(flag);
		Log.endTestCase("logoCheck");
	}
	@Test(dataProvider="bvttest",dataProviderClass=ReadExcelFile.class)
	public void searchFlight(String from, String arvl) throws InterruptedException {
		Log.startTestCase("searchFlight");
		searchpage= homepage.flightSearch(from,arvl);
		Log.endTestCase("searchFlight");
	}

}

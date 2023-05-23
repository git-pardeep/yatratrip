package com.yatratrip.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.yatratrip.utilities.ExtentReport;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
	public static Properties prop =new Properties();
	public static FileInputStream fis;
	@BeforeSuite
	public void loadConfig() throws IOException {
		ExtentReport.setExtent();
		DOMConfigurator.configure("log4j.xml");
		fis=new FileInputStream(System.getProperty("user.dir")+"\\datatest\\config.properties");
		prop.load(fis);
	}
	
	public static WebDriver getDriver() {
		return driver.get();
	}
	
	public void launchBrowser(String browser) {
//		if (prop.getProperty("browser").equalsIgnoreCase("chrome"))
			if (browser.equalsIgnoreCase("chrome")){
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());
		}else 
//			if (prop.getProperty("browser").equalsIgnoreCase("firefox")) 
			if (browser.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
		}else if (browser.equalsIgnoreCase("edge"))
//			if (prop.getProperty("browser").equalsIgnoreCase("edge"))
			{
			WebDriverManager.edgedriver().setup();
			driver.set(new EdgeDriver());
		}
		else {
			System.out.println("enter valid browser");
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		System.out.println(prop.getProperty("url"));
		getDriver().get(prop.getProperty("url"));
//		getDriver().get("https://www.yatra.com/");
	}
	@AfterSuite
	public static void afetrSuite() {
		ExtentReport.endReport();
	}
	
}

package com.yatratrip.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReport {
	public static ExtentHtmlReporter htmlreporter;
	public static ExtentReports extent ;
	public static ExtentTest test ;
	
	public static void setExtent() {
		htmlreporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"\\test-output\\extentreport\\MyYatraReport.html");
//		htmlreporter=new ExtentHtmlReporter("C:\\java test\\javaDemo\\SeleniumAutomationFramework\\yatratrip\\test-output\\extentreport\\MyReport.html");
		htmlreporter.loadXMLConfig(System.getProperty("user.dir")+"\\extent-config.xml");
//		htmlreporter.loadXMLConfig("C:\\java test\\javaDemo\\SeleniumAutomationFramework\\yatratrip\\extent-config.xml");
		extent =new ExtentReports();
		extent.attachReporter(htmlreporter);
		extent.setSystemInfo("HostName", "MyHost");
		extent.setSystemInfo("ProjectName", "yatratrip");
		extent.setSystemInfo("OS", "Window 10");
		extent.setSystemInfo("browser", "chrome");
	}
	public static void endReport() {
		extent.flush();
	}
	
 
}

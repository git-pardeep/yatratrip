package com.yatratrip.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.yatratrip.base.BaseClass;

public class TakeScreenShot extends BaseClass {
	public void takeScreenShot(String testname) {
		Date date=new Date();
		String timestamp= date.toString().replace(":", "-").replace(" ", "_");
		File takescreenshot =((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(takescreenshot, new File("./screenshots/"+"_"+timestamp+ testname+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

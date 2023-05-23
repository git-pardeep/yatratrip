package com.yatratrip.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ReadExcelFile {
	public static File file;
	public static FileInputStream fis;
	@DataProvider(name="bvttest")
	public String[][] readExcel(Method m) throws EncryptedDocumentException, IOException {
		String sheetname = m.getName();
		file = new File(System.getProperty("user.dir") + "\\datatest\\testdata.xlsx");
		fis = new FileInputStream(file);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetname);
		int totalrows = sheet.getLastRowNum();
		System.out.println("total row= "+totalrows);
		Row rows = sheet.getRow(0);
		int totalcoln = rows.getLastCellNum();
		System.out.println("total row= "+totalcoln);
		DataFormatter formater = new DataFormatter();
		String testdata[][] = new String[totalrows][totalcoln];
		for (int i = 1; i <= totalrows; i++) {
			for (int j = 0; j <totalcoln; j++) {
				testdata[i - 1][j] = formater.formatCellValue(sheet.getRow(i).getCell(j));
			System.out.println("city is "+ testdata[i-1][j]);
			}
		}
		return testdata;
	}
}

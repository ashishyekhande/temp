package testpackage;

import java.io.FileInputStream;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.dashboard;
import pages.sausedemo;

//@Listeners(listen.class)
public class saucelabLogin extends baseclass {
	public dashboard d;
	public sausedemo s ;

	@Test(dataProvider = "exceldata")
	public void sauseloginTest(String user ,String pass)throws Exception 
	{
		openURl("https://www.saucedemo.com/");
		s=sauseobj();
		s.loginTest(user,pass) ;	
	}
	
	
	@DataProvider(name = "exceldata")
	public Object[][] excelData() throws Exception {
		FileInputStream fis = new FileInputStream("./data/veg.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheetAt(1);
		int rowcount = sh.getLastRowNum();
		int col = sh.getRow(0).getLastCellNum();

		Object o[][] = new Object[rowcount][col]; // creating object

		for (int i = 0; i < rowcount; i++) {
			XSSFRow row = sh.getRow(i + 1); // 3
			for (int j = 0; j < col; j++) {
				o[i][j] = row.getCell(j).getStringCellValue(); // [ [user, pass ] [ user2,pass2] [user3,pass3 ] ]
			}
		}
		return o; // returning object
	}

}

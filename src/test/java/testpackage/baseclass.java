package testpackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.io.Files;

import pages.basket;
import pages.dashboard;
import pages.sausedemo;

public class baseclass {
	
	public WebDriver w;
	dashboard d;
	basket b ;
	sausedemo s;
	
	public void initalize() throws Exception
	{
		FileReader fis = new FileReader("./info.properties");
		Properties p = new Properties();
		p.load(fis);
		//String browser = p.getProperty("browser");
		
		// comment by ashish
		
		String browser = System.getProperty("browser");  // chrome , edge

		if(browser!=null)
		{
			browser = System.getProperty("browser");
		}
		else
		{
			browser = p.getProperty("browser");
		}
		
		//This line will check if browser name is coming from terminal or not
		// if coming from terminal then use else use from property
		//String browser = System.getProperty("browser")!=null ? System.getProperty("browser")  :   p.getProperty("browser");
				  //	    if                          true ?  (then) print this           :  (else)   this;

		if (browser.contains("chrome")) // contains will check if string is having word "chrome"     chromeheadless
		{
			ChromeOptions op = new ChromeOptions();
			op.addArguments("--incognito");   // till this point we are interested in incognito mode
			
			//this is added to check if we want to run in headless mode or not	 
			if(browser.contains("headless")) // contains will check if string is having word "headless" 
			{
				op.addArguments("headless");
			}
			
			w = new ChromeDriver(op);
		}

		else if (browser.equalsIgnoreCase("MicrosoftEdge")) 
		{
			EdgeOptions op = new EdgeOptions();
			op.addArguments("inprivate");
			w = new EdgeDriver(op);
		}

		w.manage().window().maximize();
		w.manage().deleteAllCookies();
		w.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

		public String timestamp() 
		{
			SimpleDateFormat simple = new SimpleDateFormat("MMM dd HH.mm.ss");
			String currentDateTime =simple.format(Calendar.getInstance().getTime());
			return currentDateTime;
	    }
		
	public File screenshot(WebDriver w, String testname) throws Exception //WebDriver w, String name
	{
		String time =timestamp();
		TakesScreenshot ts = (TakesScreenshot) w; 
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./Screenshot/"+testname+"_"+timestamp()+".png");
		Files.copy(src, dest);
		return dest;
	}
	
	
	public WebDriver openURl(String url) throws Exception
	{
		initalize();
		w.get(url);
		return w;
	}
	
	public dashboard dashboardOBj() 
	{
		d = new dashboard(w);
		return d;
	}
	
	public basket basketObj()
	{
		b= new basket(w);
		return b;
	}
	
	public sausedemo sauseobj() {
		s = new sausedemo(w);
		return s;
	}
	
	@AfterMethod  //@AfterTest
	public void terminate()
	{
		w.quit();
	}
	
	
	public ExtentReports extentreport()
	{
		ExtentSparkReporter reporter = new ExtentSparkReporter("./Report/chekout.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		return extent;
	}
	
	
	public String datareading() throws Exception {
		
		FileInputStream fis = new FileInputStream("./data/veg.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheetAt(0);
		int rowcount = sh.getLastRowNum(); 
		String veg ="";
		for (int i = 1; i < rowcount; i++) 
		{
			 veg = veg+ sh.getRow(i).getCell(0).getStringCellValue() +",";  //veg =, brinjal, brovcoli, beetrrot , beans
			
		}
		
		return veg;
	}
	
	
}

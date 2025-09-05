package stepdefinationloginclass;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;

import com.google.common.io.Files;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepdefinationlogn {

	WebDriver w;
	@Given("user is on login page")
	public void user_is_on_login_page() throws Exception
	{
		FileReader fis = new FileReader("./info.properties");
		Properties p = new Properties();
		p.load(fis);
		String browser = System.getProperty("browser")!=null ?System.getProperty("browser"):p.getProperty("browser");
		
		if (browser.contains("chrome")) // contains will check if string is having word "chrome" 
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
		w.get("https://www.saucedemo.com/");
		
			
	}
	
	@When("^user enters (.+) and (.+)$")
	public void user_enters_username_and_password(String user, String pass)
	{
		w.findElement(By.xpath("//input[@id='user-name']")).sendKeys(user);
		w.findElement(By.xpath("//input[@id='password']")).sendKeys(pass);	
		System.out.println(w.getTitle());
	}
	
	@And("click on login button")
	public void click_on_login_button()
	{
		w.findElement(By.xpath("//input[@id='login-button']")).click();
	}
	
	@Then("{string} dashboard page shold disply")
	public void dashboard_page_shold_disply(String exp) throws Exception
	{
		
		Assert.assertEquals( w.getTitle(),"Swag Labs");
		System.out.println(exp);
		//System.out.println(w.getCurrentUrl());
		w.quit();
	}
	
	
}

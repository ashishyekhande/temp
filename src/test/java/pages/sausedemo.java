package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class sausedemo extends utility {

	public WebDriver w;

	public sausedemo(WebDriver w) 
	{
		super(w);
		this.w=w;
		PageFactory.initElements(w, this);
	}
	
	@FindBy(css = "input[placeholder='Username']")WebElement username;
	@FindBy(css = "input[placeholder='Password']")WebElement password;
	@FindBy(css = "#login-button")WebElement login;
	
		// TODO Auto-generated constructor stub
		public void loginTest(String user, String pass)
		{
			username.sendKeys(user);
			password.sendKeys(pass);
			login.click();
		}
	

}

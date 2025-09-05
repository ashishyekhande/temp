package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class dashboard extends utility
{

	WebDriver w;  // global variable of this class
	public dashboard(WebDriver w)
	{
		super(w);  // passing webdriver instance to parent/superclass
		this.w =w; // this line assign webdriver instance to this class webdriver
		PageFactory.initElements(w, this);
	
	}
	
	@FindBy(xpath ="//input[@type='search']" ) WebElement search;
	@FindBy(xpath = "//button[contains(text(),'ADD TO CART')]")WebElement addtocart;
	
	
	public void addveg(String veg) throws Exception
	{		
		search.sendKeys(veg);
		scroll();
		Thread.sleep(2000);
		addtocart.click();
		//sc
		search.clear();
			
	}
	
	
}

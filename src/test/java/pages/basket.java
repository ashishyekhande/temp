package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class basket extends utility
{
    
	
	public WebDriver w;
	public basket(WebDriver w)
	{
		super(w);
		this.w= w;
		PageFactory.initElements(w, this);
		
	}
	
	@FindBy(xpath = "//a[@class='cart-icon']")WebElement cartIcon;
	@FindBy(xpath = "//button[contains(text(),'PROCEED TO CHECKOUT')]") WebElement proccedButton;
	@FindBy(xpath = "//input[@class='promoCode']")WebElement promo;
	@FindBy(xpath = "//button[contains(text(),'Apply')]")WebElement apply;
	@FindBy(xpath = "//button[contains(text(),'Place Order')]")WebElement placeorder;
	@FindBy(xpath = "//select")WebElement countrylist;
	@FindBy(xpath = "//input[@type='checkbox']")WebElement checkbox;
	@FindBy(xpath = "//button[contains(text(),'Proceed')]")WebElement proceed;
	
	
	public void checkout(String country) throws Exception 
	{
		System.out.println("modified");
		
		System.out.println("ashish made new changes");
			
		cartIcon.click();
		proccedButton.click();
		promo.sendKeys("ashish");
		apply.click();
		placeorder.click();
		
		Select s = new Select(countrylist);
		s.selectByVisibleText(country);
		checkbox.click();	
		proceed.click();
		
	}
	

	
	
	
	
	

}

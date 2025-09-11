package stepdefinationclass;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import testpackage.baseclass;

public class stepdefinationclass extends baseclass
{
	@Given("i am on greenkart site")
	public void i_am_on_greenkart_site() throws Exception
	{
		openURl("https://rahulshettyacademy.com/seleniumPractise/#/");
	}
	
	
	@When("items added in kart")
	public void items_added_in_kart() throws Exception
	{
		String veglist = datareading();    // veglist =, brinjal, brovcoli, beetrrot , beans
		String veg[] = veglist.split(","); // veg [] ={brijal ,brocoli, beetroot, beans}
		for (String selectveg : veg)
		{
			System.out.println(selectveg);
			d.addveg(selectveg);
		}
	}

	@And("checkout is done")
	public void checkout_is_done() throws Exception
	{
		b.checkout("Barbados");
	}
	
	@Then("success messgae should be displayed")
	public void success_messgae_should_be_displayed() throws Exception
	{
		System.out.println("checkout done successfully");
		screenshot(w, "cucumberclassdemo");
		terminate();
	}
	
	
	
}

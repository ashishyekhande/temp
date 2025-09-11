package testpackage;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//@Listeners(listen.class)
public class greenkart extends baseclass {

	@Parameters({"country" ,"url"})
	@Test
	public void checkoutEndToEnd(String country,String url) throws Exception 
	{
		openURl(url);
		String veglist = datareading();    // veglist =, brinjal, brovcoli, beetrrot , beans
		String veg[] = veglist.split(","); // veg [] ={brijal ,brocoli, beetroot, beans}
		for (String selectveg : veg)
		{
			System.out.println(selectveg);
			d.addveg(selectveg);
		}
		b.checkout(country);
	}
	
	
	
	
}

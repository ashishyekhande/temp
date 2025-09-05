package stepdefinationloginclass;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/java/featureclass/loginclass.feature",
		glue = "stepdefinationloginclass",
		plugin = {  "pretty", "html:Report/login/logincucumber.html",
							   "json:Report/login/logincucumber.json"
					},
		monochrome = true 
		)

public class testrunnerlogin extends AbstractTestNGCucumberTests   {

}

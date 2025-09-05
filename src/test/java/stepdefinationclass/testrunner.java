package stepdefinationclass;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/java/featureclass/greenkart.feature",
		glue = "stepdefinationclass",
		plugin = { "pretty",  "html:Report/greenkart/cucumber.html" ,
				              "json:Report/greenkart/cucumber.json"  },
		monochrome = true
		)
public class testrunner extends AbstractTestNGCucumberTests 
{

}

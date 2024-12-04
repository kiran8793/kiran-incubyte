package TestRunner;

import org.junit.runner.RunWith;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features/CreateAccountAndSignIn.feature", glue = {
		"StepDefination" }, plugin = { "pretty", "html:target/cucumber-reports/reports.html" }, dryRun = false,
// "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
//Remove unnecessary character from console 
		monochrome = true)

public class Runner {

}

package step_definitions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/", plugin = { "pretty",
		"html:target/cucumber-html-report" }, glue = { "helpers", "pageobjects",
				"step_definitions", }, tags = { "@All" })
public class RunCukesTest {

}
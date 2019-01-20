package step_definitions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects.CWJobSeachPage;

public class CWJobsHomeSteps {

	public WebDriver webDriver;
	public CWJobSeachPage cwJobSeachPage;
	private final Logger logger = Logger.getLogger(CWJobsHomeSteps.class);

	public CWJobsHomeSteps() {
		webDriver = Hooks.driver;
		cwJobSeachPage = new CWJobSeachPage(webDriver);
	}

	@Given("^user on home page$")
	public void user_on_home_page() throws Throwable {
		webDriver.get("https://www.cwjobs.co.uk/");
	}

	@When("^user select job type$")
	public void user_select_job_type() throws Throwable {
		cwJobSeachPage.selectMoreOptions();

	}

	@Then("^display permanent \"([^\"]*)\"$")
	public void display_permanent(String jobType) throws Throwable {
		String strSelectedValue = cwJobSeachPage.selectDropdownValue(cwJobSeachPage.jobTypeID, jobType).getText();
		cwJobSeachPage.returnDropdown(cwJobSeachPage.jobTypeOption).selectByVisibleText(strSelectedValue);
		Assert.assertEquals(cwJobSeachPage.selectDropdownValue(cwJobSeachPage.jobTypeID, jobType).getText(), jobType);
	}

	@Then("^display companies have job ads listed$")
	public void display_companies_have_job_ads_listed() throws Throwable {
		logger.info("Total companies count: " + cwJobSeachPage.verifyJobsListed("COMPANIES"));
	}

	@When("^user select job type \"([^\"]*)\"$")
	public void user_select_job_type(String jobType) throws Throwable {

		cwJobSeachPage.selectMoreOptions();
		String strSelectedValue = cwJobSeachPage.selectDropdownValue(cwJobSeachPage.jobTypeID, jobType).getText();
		cwJobSeachPage.returnDropdown(cwJobSeachPage.jobTypeOption).selectByVisibleText(strSelectedValue);
	}

	@Then("^select recruiter type \"([^\"]*)\" in location \"([^\"]*)\"$")
	public void select_recruiter_type_in_location(String strRecruiterType, String strLocation) throws Throwable {
		cwJobSeachPage.selectButtonName(strRecruiterType).click();
		cwJobSeachPage.jobLocation.sendKeys(strLocation);
	}

	@Then("^select salary \"([^\"]*)\" of at least \"([^\"]*)\" for the keyword \"([^\"]*)\"$")
	public void with_salary_of_at_least_for_the_keyword(String strSalaryType, String strSalary, String strKeyword)
			throws Throwable {
		cwJobSeachPage.selectButtonName(strSalaryType).click();
		String selectedText = cwJobSeachPage.selectDropdownValue("salaryRate", strSalary).getText();
		cwJobSeachPage.returnDropdown(cwJobSeachPage.selectSalaryRate).selectByVisibleText(selectedText);
		cwJobSeachPage.keywordsInput.sendKeys(strKeyword);
		cwJobSeachPage.searchButton.click();
	}

	@Then("^verify at least (\\d+) pages of jobs returned$")
	public void verify_at_least_pages_of_jobs_returned(int pageNumber) throws Throwable {
		Assert.assertEquals(cwJobSeachPage.verifyPageNumbers(pageNumber), pageNumber);
	}

	@Then("^verify the result page html source contains \"([^\"]*)\"$")
	public void verify_the_result_page_html_source_contains(String strText) throws Throwable {
		Assert.assertTrue(webDriver.getPageSource().contains(strText));
	}

}

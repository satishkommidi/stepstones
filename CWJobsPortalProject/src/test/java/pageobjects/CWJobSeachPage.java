package pageobjects;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

/*
 * This page will hold all objects/id/xpaths for the given scenarios
 */
public class CWJobSeachPage extends BaseClass {

	private final Logger logger = Logger.getLogger(CWJobSeachPage.class);
	// "Button for more job options button
	@FindBy(how = How.ID, using = "more-options-toggle")
	public WebElement moreOptions;

	// input keyword
	@FindBy(how = How.ID, using = "keywords")
	public WebElement keywordsInput;

	// search button
	@FindBy(how = How.ID, using = "search-button")
	public WebElement searchButton;

	// Button for more job type options
	@FindBy(how = How.ID, using = "JobType")
	public WebElement jobTypeOption;

	public String jobTypeID = "JobType";

	// XPath for companies job listed
	@FindBy(how = How.XPATH, using = "//*[@class=\"counter\"]/h2")
	public WebElement jobsListCounter;

	// XPath for button groups
	@FindBy(how = How.XPATH, using = "//*[@class=\"btn-group\"]/label")
	public WebElement btnGroup;

	// XPath string for pagination
	public String strPaginationXPath = "//*[@class=\"pagination adjacent-to-drilldown\"]/li";

	// location identifier
	@FindBy(how = How.ID, using = "location")
	public WebElement jobLocation;

	// salary dropdown identifier
	@FindBy(how = How.ID, using = "salaryRate")
	public WebElement selectSalaryRate;

	public String salaryRateID = "salaryRate";

	// web driver from baseclass
	public CWJobSeachPage(WebDriver webDriver) {
		super(webDriver);
	}

	// this method expands the all filter options
	public void selectMoreOptions() {
		waitForPageToLoadCompletely();
		moreOptions.click();
		waitForPageToLoadCompletely();
	}

	// it take any selector / dropdown name and returns the Select instance of the
	// given value
	public Select returnDropdown(WebElement dropdownName) {
		waitForPageToLoadCompletely();
		Select dropdown = new Select(dropdownName);
		return dropdown;
	}

	// it takes either companies / total jobs listed and splits and trim finally
	// return the count value
	public String verifyJobsListed(String actualWord) {
		String strCompaniesCount = "";
		String strJobs = jobsListCounter.getText();
		logger.info("Actual word: " + strJobs);
		if (strJobs.contains(actualWord)) {
			String strCompanies = strJobs.split("\\|")[1].trim();
			logger.info("Companies word found: " + strCompanies);
			strCompaniesCount = strCompanies.split(" ")[0].trim();
			logger.info("Companies jobs count: " + strCompaniesCount);
		}
		return strCompaniesCount;
	}

	// this method implemented more generic and works with button name as input and
	// return the web element
	public WebElement selectButtonName(String buttonName) {
		WebElement webElement = null;
		waitForPageToLoadCompletely();
		try {
			List<WebElement> lstButtonList = webDriver.findElements(By.xpath("//*[@class=\"btn-group\"]/label"));
			for (WebElement eleBtnName : lstButtonList) {
				logger.info("button name: " + eleBtnName.getText());
				if (eleBtnName.getText().equals(buttonName)) {
					webElement = eleBtnName;
					logger.info("Button name found: " + eleBtnName.getText());
					break;
				}
			}

		} catch (Exception ex) {
			logger.error("Button name not found: " + buttonName);

		}

		return webElement;
	}

	// this method works very generic will take dropdown id and required option name
	// as text and return verified web element
	// for given option name
	public WebElement selectDropdownValue(String dropDownName, String strOptionName) {
		WebElement webElement = null;
		waitForPageToLoadCompletely();
		String xPath = "//*[@id=\"" + dropDownName + "\"]/option";

		try {
			List<WebElement> lstButtonList = webDriver.findElements(By.xpath(xPath));
			for (WebElement eleBtnName : lstButtonList) {
				logger.info("option name: " + eleBtnName.getText());
				if (eleBtnName.getText().contains(strOptionName)) {
					webElement = eleBtnName;
					logger.info("option name found: " + eleBtnName.getText());
					break;
				}
			}

		} catch (Exception ex) {
			logger.error("Button name not found: " + strOptionName);

		}

		return webElement;
	}

	// this method always find the number of pages for given search criteria and
	// number
	public int verifyPageNumbers(int pageNumber) {
		int pageNumberFound = -1;
		waitForPageToLoadCompletely();
		List<WebElement> lstPages = webDriver.findElements(By.xpath(strPaginationXPath));
		try {
			for (WebElement elePage : lstPages) {
				if (elePage.getText().trim().equals(String.valueOf(pageNumber))) {
					pageNumberFound = Integer.parseInt(elePage.getText());
					logger.info("Page number found: " + elePage.getText());
					break;
				}
			}

		} catch (Exception ex) {
			logger.error("Page number not found: " + pageNumber);
		}
		return pageNumberFound;
	}
}

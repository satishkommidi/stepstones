/*
 * This class used for all base members and methods across all page objects and step definitions
 * this can be used all page objects for driver instance
 */
package pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BaseClass {
	private static final long WAIT_TIME = 10;
	public static WebDriver webDriver;
	public static boolean bResult;
	private final Logger logger = Logger.getLogger(BaseClass.class);

	public BaseClass(WebDriver driver) {
		BaseClass.webDriver = driver;
		PageFactory.initElements(driver, this);
		BaseClass.bResult = true;
	}

	public void waitForPageToLoadCompletely() {
		new WebDriverWait(webDriver, WAIT_TIME).until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd)
				.executeScript("return document.readyState").equals("complete"));
		logger.info("Waiting for the page to load completely");
	}

}

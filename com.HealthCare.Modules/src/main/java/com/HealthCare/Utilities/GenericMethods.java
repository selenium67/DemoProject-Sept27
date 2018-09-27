package com.HealthCare.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.Status;


public class GenericMethods extends Reports {

	@BeforeClass(alwaysRun = true)
	@Parameters({ "browserName", "appURL" })
	public void launchApplication(String browser, String url) {
		getBrowser(browser);
		setURL(url);
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		try {
			driver.close();
			Runtime.getRuntime().exec("taskkill /im chromedriver.exe /f");
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	@AfterMethod(alwaysRun = true)
	public void verifyResult(ITestResult result) {

		try {
			if (result.getStatus() == ITestResult.SUCCESS) {

				logger.log(Status.PASS, "Test Class Name is " + result.getInstance().getClass().getName()
						+ "  Method Name is " + result.getName() + " is Successfully Executed");

			} else if (result.getStatus() == ITestResult.FAILURE) {

				TakesScreenshot screen = (TakesScreenshot) driver;
				File source = screen.getScreenshotAs(OutputType.FILE);
				String destination = System.getProperty("user.dir") + "/ScreenShots/" + timeStamp + " "
						+ result.getName() + ".png";
				FileHandler.copy(source, new File(destination));
				logger.log(Status.FAIL,
						"Test Class Name is " + result.getInstance().getClass().getName() + " and "
								+ "  Method Name is " + result.getName() + " is Failed due to " + result.getThrowable()
								+ logger.addScreenCaptureFromPath(destination));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getBrowser(String name) {

		if (name.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./BrowserDrivers/chromedriver_win32/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (name.equals("firefox")) {

			System.setProperty("webdriver.chrome.driver", "./BrowserDrivers/chromedriver_win32/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (name.equals("ie")) {

			System.setProperty("webdriver.chrome.driver", "./BrowserDrivers/chromedriver_win32/chromedriver.exe");
			driver = new ChromeDriver();
		} else {

			System.out.println("Please provide Valid browser name");
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	public void setURL(String url) {

		switch (url) {
		case "hms":
			driver.get("http://selenium4testing.com/hms/");
			break;

		default:
			System.out.println("Please Provide Valid URl");
			break;
		}
	}

	public Properties getRepoData() {
		Properties prop = null;
		try {
			File file = new File("./src/test/resources/locators.properties");
			FileInputStream fin = new FileInputStream(file);
			prop = new Properties();
			prop.load(fin);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		return prop;
	}

	public void input(WebElement element, String testData, String fieldName) {

		try {
			if (element.isDisplayed()) {
				element.clear();
				element.sendKeys(testData);
				logger.log(Status.INFO, "Entered " + testData + " in " + fieldName + " input box");
			} else {

				Assert.fail("Unalbe to locate " + fieldName + " field");
			}
		} catch (Exception e) {

		}

	}

	public void click(WebElement element, String fieldName) {

		try {

			if (element.isDisplayed()) {
				element.click();
				logger.log(Status.INFO, "Click on  " + fieldName + " field");
			} else {

				Assert.fail("Unalbe to click " + fieldName + " field");
			}

		} catch (Exception e) {

		}
	}

	public void selectByText(WebElement element, String testData, String fieldName) {

		try {

			if (element.isDisplayed()) {

				new Select(element).selectByVisibleText(testData);
				logger.log(Status.INFO, "Selected the " + testData + " from " + fieldName + " field");

			} else {

				Assert.fail("Unalbe to select value from " + fieldName + " field");
			}
		} catch (Exception e) {

		}

	}

	public void getText(WebElement element) {

		try {
			if (element.isDisplayed()) {

				String text = element.getText();
				logger.log(Status.INFO, "Retrieved text is  " + text);
			} else {

				Assert.fail("Unable to Retrieved the Text");
			}
		} catch (Exception e) {

		}

	}

}

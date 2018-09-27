package com.HealthCare.Utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Reports {
	
	public WebDriver driver = null;
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	public String timeStamp;
	public String reportPath;
	
	
	@BeforeTest
	public void startReport() {
		// Location of your report
		// add default xml into your project
		 timeStamp = new SimpleDateFormat("dd-MM-yyyy hh.mm.ss aa").format(Calendar.getInstance().getTime());
		
		 reportPath = "./extentReports/"+timeStamp+".html";
		
		htmlReporter = new ExtentHtmlReporter(reportPath);
		
		htmlReporter.loadXMLConfig(new File("./Extent-Config.xml"));
		
		extent = new ExtentReports();
		
		extent.attachReporter(htmlReporter);
		
	}
	
	@AfterTest
	public void endReport() {
		
		extent.flush();
		
	}

}

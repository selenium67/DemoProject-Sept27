package com.HealthCare.Registration;

import java.util.Map;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.HealthCare.Utilities.GenericMethods;
import com.HealthCare.Utilities.ReadTestData;

import webPages.Login_POM;

public class TempRegistration extends GenericMethods {
	
	@Test(dataProviderClass = ReadTestData.class,dataProvider = "hms")
	public void login(Map<String,String> data) {
		logger = extent.createTest("HMS Login");
		Login_POM login = PageFactory.initElements(driver, Login_POM.class);
		
		try {
			
			input(login.getUser(), data.get("UserName"), "Username");
			input(login.getPassword(), data.get("Password"), "Password");
			
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

}

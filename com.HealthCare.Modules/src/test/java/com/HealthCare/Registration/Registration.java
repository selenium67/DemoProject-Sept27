package com.HealthCare.Registration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.HealthCare.Utilities.GenericMethods;

import webPages.Login_POM;
import webPages.Registration_POM;

public class Registration extends GenericMethods {
	
	
	@Test(priority=1,groups= {"Smoke","Regeression"})
	public void login() {
		logger = extent.createTest("HMS Login");
		Login_POM login = PageFactory.initElements(driver, Login_POM.class);
		
		try {
			
			input(login.getUser(), "admin", "Username");
			input(login.getPassword(), "admin", "Password");
			click(login.getLogin(),"Login");
			
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}
	
	
	@Test(priority=2,groups= {"Smoke"},dependsOnMethods="login")
	public void permanent() {
		
		logger = extent.createTest("Permanent Registration");
		
		Registration_POM reg = PageFactory.initElements(driver, Registration_POM.class);
		
		try {
			
			click(reg.getRegistration(), "Registratioin");
			selectByText(reg.getPatient(), "Insurance", "Patient Category");
			
			WebElement ele;
			try {
				ele = driver.findElement(By.name("PATIENT_CAT"));
				Select select = new Select(ele);
				WebElement selectedOptionInPat_Cat = select.getFirstSelectedOption();
				System.out.println("------------ " + selectedOptionInPat_Cat.getText());
			} catch (Exception e) {
				Assert.fail(e.getMessage());
			}
			new Select(reg.getRelation()).selectByVisibleText("Father");
			WebElement title = driver.findElement(By.name("TITLE"));
			Select select2 = new Select(title);
			select2.selectByVisibleText("Ms.");
			driver.findElement(By.name("PNT_NAME")).sendKeys("Marie");
			WebElement Pat_ID = driver.findElement(By.name("PAT_IDENTITY"));
			Select select3 = new Select(Pat_ID);
			select3.selectByVisibleText("Voter ID");
			driver.findElement(By.name("LAST_NAME")).sendKeys("Gold");
			;
			driver.findElement(By.name("PAT_IDENTITY_PROOF")).sendKeys("12345");
			// unable to enter date from calender
			driver.findElement(By.name("DOB")).sendKeys("12/12/1994");
			WebElement nationality = driver.findElement(By.name("NATIONALITY"));
			Select select4 = new Select(nationality);
			select4.selectByVisibleText("Indian");
			driver.findElement(By.name("AGE")).sendKeys("19");
			WebElement VIP = driver.findElement(By.name("IS_MLC"));
			Select select5 = new Select(VIP);
			select5.selectByVisibleText("No");
			driver.findElement(By.name("AGE")).sendKeys("19");
			WebElement Gender = driver.findElement(By.name("SEX"));
			Select select6 = new Select(Gender);
			select6.selectByVisibleText("Female");
			WebElement education = driver.findElement(By.name("EDUCATION"));
			Select select7 = new Select(education);
			select7.selectByVisibleText("B.Sc");
			WebElement maritalStatus = driver.findElement(By.name("MTRL_STATUS"));
			Select select8 = new Select(maritalStatus);
			select8.selectByVisibleText("Single");
			WebElement occupation = driver.findElement(By.name("OCCUPATION"));
			Select select9 = new Select(occupation);
			select9.selectByVisibleText("Employee");
			WebElement religion = driver.findElement(By.name("RELIGION"));
			Select select10 = new Select(religion);
			select10.selectByVisibleText("Hindu");
			WebElement bloodGroup = driver.findElement(By.name("BLOOD_GRP_CODE"));
			Select select11 = new Select(bloodGroup);
			select11.selectByVisibleText("B+");
			WebElement priLang = driver.findElement(By.name("PLANGUAGE"));
			Select select12 = new Select(priLang);
			select12.selectByVisibleText("English");
			WebElement citizenship = driver.findElement(By.name("CITIZENSHIP"));
			Select select13 = new Select(citizenship);
			select13.selectByVisibleText("Indian");
			WebElement seniorCitizen = driver.findElement(By.name("SC_PROOF"));
			Select select14 = new Select(seniorCitizen);
			select14.selectByVisibleText("No");
			driver.findElement(By.name("ADDRESS1")).sendKeys("Hyderabad");
			driver.findElement(By.name("MOBILE_NO")).sendKeys("6789865443");
			WebElement countryCode = driver.findElement(By.name("COUNTRY_CODE"));
			Select select15 = new Select(countryCode);
			select15.selectByVisibleText("India");
			driver.findElement(By.name("ZIP")).sendKeys("123456");
			driver.findElement(By.name("image")).click();
			Thread.sleep(2000);
			// To Execute .exe File we will use below code
			Runtime.getRuntime().exec("D:\\AutoIT\\hmsjuly.exe");
			/*
			 * // having issue in uploading image
			 * driver.findElement(By.name("image")).click();
			 * driver.findElement(By.name("image")).sendKeys("C:\\Users\\my\\Documents");
			 */
			Thread.sleep(2000);
			driver.findElement(By.name("submit")).click();

			Alert alert = driver.switchTo().alert();

			System.out.println(alert.getText());
			Thread.sleep(2000);
			alert.accept();
		} catch (Exception e) {			
			Assert.fail(e.getMessage());
		}		
	}
	
	@Test(priority=3,groups= {"Hello"})
	public void search() {
		
		try {
			logger = extent.createTest("Dummy Search");
			driver.findElement(By.xpath("Test")).click();
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}
	
	@Test(priority=4,groups= {"Smoke","Hello"})
	public void emergency() {
		logger = extent.createTest("Emergency Registration");
		try {
			System.out.println("Emergency Registration");
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		
	}
	

}

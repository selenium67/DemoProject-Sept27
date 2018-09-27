package com.HealthCare.Registration;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.HealthCare.Utilities.GenericMethods;

public class Hello extends GenericMethods {

	@Test
	public void login() {
		try {
			driver.findElement(By.name(getRepoData().getProperty("USERNAME"))).sendKeys("admin");
			driver.findElement(By.xpath(getRepoData().getProperty("PASSWORD"))).sendKeys("admin");
			driver.findElement(By.name("submi")).click();
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

}

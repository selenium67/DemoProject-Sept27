package webPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Registration_POM {
	
	@FindBy(how=How.NAME,using="RELATION")
	@CacheLookup
	private WebElement relation;
		
	public WebElement getRelation() {
		
		return relation;
	}
	
	@FindBy(how=How.NAME,using="PATIENT_CAT")
	private WebElement patient;
		
	public WebElement getPatient() {
		
		return patient;
	}
	
	@FindBy(linkText="Registration")
	private WebElement Registration;
		
	public WebElement getRegistration() {
		
		return Registration;
	}

}

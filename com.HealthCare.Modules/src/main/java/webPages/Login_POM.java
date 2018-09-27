package webPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.HealthCare.Utilities.GenericMethods;

public class Login_POM extends GenericMethods {
	
	@FindBy(how=How.NAME,using="username")
	private WebElement user;
	
	public WebElement getUser() {
		return user;
	}
	
	@FindBy(how=How.XPATH,using="//input[@name='password']")
	private WebElement pass;
	
	public WebElement getPassword() {
		return pass;
	}
	
	
	@FindBy(name="submit")
	private WebElement login;
	
	public WebElement getLogin() {
		return login;
	}
	
	
	@FindBy(how=How.NAME,using="reset")
	private WebElement reset;
	
	public WebElement getReset() {
		return reset;
	}
	
	
	

}

package webPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Welcome_POM {
	
	@FindBy(how=How.LINK_TEXT,using="Logout")
	private WebElement Logout;
	
	public WebElement getLogout() {
		return Logout;
	}
	
	@FindBy(how=How.LINK_TEXT,using="Registration")
	private WebElement Registration;
	
	public WebElement getRegistration() {
		return Registration;
	}

}

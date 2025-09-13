package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage extends BasePage {
	
	

	public LogoutPage(WebDriver driver) {
		super(driver);
}

	//Locators.......
	
	@FindBy(xpath="//a[normalize-space()='Continue']")
	WebElement lnkContinueLogout;
	
	
	
	//Actions.........
	
	public void clickLnkContinueLogout() {
		lnkContinueLogout.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

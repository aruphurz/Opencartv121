package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage  {
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	//Locators......
	
	@FindBy(xpath="//div[@id='content']//h2[normalize-space()='My Account']")
	WebElement txtMyAccount;
	
	@FindBy(xpath="//div[@class='list-group']//a[normalize-space()='Logout']")
	WebElement lnkLogout;

	
	//Actions.......
	
	public boolean isMyAccountPageExist() {
		try {
		return (txtMyAccount.isDisplayed());
		}
		catch (Exception e) {
			return false;
		}
	}
	public void clickLogoutLnk() {
		lnkLogout.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

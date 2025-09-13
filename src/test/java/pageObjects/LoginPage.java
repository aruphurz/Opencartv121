package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	
	//		
	//	
	

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//Locators......
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmailField;
	
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPasswordField;
	
	
	@FindBy(xpath="//input[@type='submit'and@value='Login']")
	WebElement btnLogin;
	
	//Actions..........
	
	
	public void setEmailtxt(String email) {
		
		txtEmailField.sendKeys(email);
	}
	
	
	public void setPasswordtxt(String pwd) {
		
		txtPasswordField.sendKeys(pwd);
	}
	
	public void clickLoginBtn() {
		btnLogin.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

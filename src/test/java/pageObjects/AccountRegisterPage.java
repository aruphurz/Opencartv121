package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegisterPage extends BasePage {

	
	
	public AccountRegisterPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	} 

	//Locator........
	
	@FindBy(id="input-firstname")
	WebElement txtFirstName;
	
	
	@FindBy(id="input-lastname")
	WebElement txtLastName;
	
	
	@FindBy(id="input-email")
	WebElement txtEmail;
	
	@FindBy(id="input-telephone")
	WebElement txtTelephone;
	
	@FindBy(id="input-password")
	WebElement txtPassword;
	
	@FindBy(id="input-confirm")
	WebElement txtConfirmPassword;
	
	@FindBy(name="agree")
	WebElement chkdPolicy;
	
	@FindBy(xpath= "//input[@type='submit']")
	WebElement btnContinue;
	
	
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	//Actions.....
	
	public void setFirstName(String fName) {
		txtFirstName.sendKeys(fName);
	}
	
	public void setLastName(String lName) {
		txtLastName.sendKeys(lName);
	}
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	public void setTelephone(String telephone) {
		txtTelephone.sendKeys(telephone);
	}
	
	public void setPassword(String Password) {
		txtPassword.sendKeys(Password);
	}
	public void setConfirmPassword(String ConfirmPassword) {
		txtConfirmPassword.sendKeys(ConfirmPassword);
	}
	public void clickChkdPolicy() {
		
		chkdPolicy.click();
	}
public void clickContinue() {
		
		btnContinue.click();
	}
	
	
	
public String getConfirmationMsg() {
	
try {
	
return	(msgConfirmation.getText());

	
} catch (Exception e) {
	// TODO: handle exception
	
	return (e.getMessage());
	
}
	
	
}
}

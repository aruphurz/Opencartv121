package testCases;



import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.FileReader;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegisterPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest  extends BaseClass{

	
	
	
	@Test(groups={"Regression","Master"})
	public void verify_account_registration() throws InterruptedException {
	
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickRegister();
		
		AccountRegisterPage regPage = new AccountRegisterPage(driver);
		regPage.setFirstName(randomStrings().toUpperCase());
		regPage.setLastName(randomStrings().toUpperCase());
		regPage.setEmail(randomStrings()+"@gmail.com");
		regPage.setTelephone(randomNumbers());
		
		String pass=randomAlphaNumerics();
		
		
		regPage.setPassword(pass);
		regPage.setConfirmPassword(pass);
		
		regPage.clickChkdPolicy();
		regPage.clickContinue();
		
		Thread.sleep(5000);
		String cnfMsg=regPage.getConfirmationMsg();
		
		AssertJUnit.assertEquals(cnfMsg, "Your Account Has Been Created!");
		
		try {
			
		}
		catch (Exception e) {
			// TODO: handle exception
			
		}
		
		
	}
	
	
	
	
	
}

package testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.LogoutPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT_Test extends BaseClass
{
	
	@Test(dataProvider = "LoginData", dataProviderClass =DataProviders.class,groups = "Datadriven")
	public void verifyLoginDDT(String email,String pwd,String exp) 
	{
		logger.info("******* Starting TC003_LoginDDT_Test *******");
		
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLoginLnk();
				
		LoginPage lp=new LoginPage(driver);
		lp.setEmailtxt(email);
		lp.setPasswordtxt(pwd);
		lp.clickLoginBtn();
			
		MyAccountPage map=new MyAccountPage(driver);
		boolean targetPage = map.isMyAccountPageExist();
		
		LogoutPage lop=new LogoutPage(driver);
		
	if(exp.equalsIgnoreCase("valid")) 
	{
		if(targetPage==true) 
		  {
		
			AssertJUnit.assertTrue(true);
			map.clickLogoutLnk();
			lop.clickLnkContinueLogout();
			softAssert.assertAll();
		  }
		else {
				AssertJUnit.assertTrue(false);
			  }	
	}
		
	if(exp.equalsIgnoreCase("invalid"))
	{
			if(targetPage==true) 
			{	
				AssertJUnit.assertTrue(false);
				map.clickLogoutLnk();
				lop.clickLnkContinueLogout();
				softAssert.assertAll();
			}
			else 
			{
				AssertJUnit.assertTrue(true);
			}
	}
		} //try block closed
		catch (Exception e)
		{
			AssertJUnit.fail();
		} //Catch block closed
		
		
		
		
		
	logger.info("******* Ending TC003_LoginDDT_Test *******");
		
		
		
	}	//test method block closed
		
	
}  //class block closed

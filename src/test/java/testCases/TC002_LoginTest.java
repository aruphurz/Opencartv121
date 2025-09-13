package testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;



import org.testng.Assert;
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
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{
	
	
	
	
	@Test(groups = {"Sanity","Master"})
	public void verify_login() 
	{
	
	logger.info( " **** Starting TC002_LoginTest ****");	
	
	try {
	//HomePage...	
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLoginLnk();
		
		//LoginPage.......
		LoginPage lp= new LoginPage(driver);
		lp.setEmailtxt(p.getProperty("email"));
		lp.setPasswordtxt(p.getProperty("password"));
		lp.clickLoginBtn();
		
		
		//MyAccounPage......
		MyAccountPage map=new MyAccountPage(driver);
		
		if (map.isMyAccountPageExist()==true) {
			AssertJUnit.assertTrue(true);
		}
		else {
			
			AssertJUnit.assertTrue(false);
		}
	}
	catch (Exception e) {
		
		AssertJUnit.fail();
	}
		logger.info(" **** Finished TC002_LoginTest **** ");
		
		
		
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

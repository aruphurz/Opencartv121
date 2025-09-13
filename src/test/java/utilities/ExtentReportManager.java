package utilities;

import java.awt.Desktop;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.bidi.module.Browser;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentReportManager implements ITestListener  {
	
	
	
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	String repName;
	
	
	 public void onStart(ITestContext testcontext) {
		 
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());
		 repName = "Test_Report_" + timeStamp + ".html";
		 sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/"+repName);
		
		 sparkReporter.config().setDocumentTitle("Opencart Automation Report");
		 sparkReporter.config().setReportName("Opencart Functional Teting");
		 sparkReporter.config().setTheme(Theme.STANDARD);
		 
		 
		 
		 extent =  new ExtentReports();
		 extent.attachReporter(sparkReporter);
		 
		 extent.setSystemInfo("Application", "Opencart");
		 extent.setSystemInfo("Module", "Admin");
		 extent.setSystemInfo("Sub Module","Customers");
		 extent.setSystemInfo("User Name", System.getProperty("user.name"));
		 extent.setSystemInfo("Environment", "QA");
		 
		 
		 String os = testcontext.getCurrentXmlTest().getParameter("os");
		 extent.setSystemInfo("Operating System", os);
		 
		 String browser = testcontext.getCurrentXmlTest().getParameter("browser");
		 extent.setSystemInfo("Browser", browser);
		 
		List<String> includedGroups = testcontext.getCurrentXmlTest().getIncludedGroups();
		 
		 if(!includedGroups.isEmpty()) {
			 
			 extent.setSystemInfo("Groups", includedGroups.toString());
		 }
		 
		  }
	 
	 
	/* public void onTestStart(ITestResult result) {
		 
		 	test=extent.createTest(result.getTestClass().getName());
			
			test.assignCategory(result.getMethod().getGroups());
			test.log(Status.PASS, result.getName()+" got  started");			
	  
	  } */

		public void onTestSuccess(ITestResult result) {
		  
			
			test=extent.createTest(result.getTestClass().getName());
			
			test.assignCategory(result.getMethod().getGroups());
			test.log(Status.PASS, result.getName()+" got successfully executed");			

		  }
	
	
	 public void onTestFailure(ITestResult result) {
		    
		 
		 test=extent.createTest(result.getTestClass().getName());
		 test.assignCategory(result.getMethod().getGroups());
		
		 test.log(Status.FAIL,result.getName()+" got failed");
		 test.log(Status.INFO,result.getThrowable().getMessage());
		 
		 
		 //Capturing Screenshot........
		 
		try { 
		String imgPath = new BaseClass().captureScreen(result.getName());
		
		 test.addScreenCaptureFromPath(imgPath);
		}
		catch (Exception e) {
			e.printStackTrace();		}
		  }
	
	
	 public void onTestSkipped(ITestResult result) {
		  test= extent.createTest(result.getTestClass().getName());
		  test.assignCategory(result.getMethod().getGroups());
		  test.log(Status.SKIP,result.getName()+" got skipped");
		  test.log(Status.INFO,result.getThrowable().getMessage());
	 
	 }
	

		
		
		
	 public void onFinish(ITestContext context) {
		   
		 extent.flush();
		 
		String PathOfExtentReport = System.getProperty("user.dir") + "/reports/"+repName;
		 
		 
		 File extentRepot=new File(PathOfExtentReport);
		 
		 try {
			 Desktop.getDesktop().browse(extentRepot.toURI());
		 }
		 catch (Exception e) {
			e.printStackTrace();
		}
		 
	 
		  }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

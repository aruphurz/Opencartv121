package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Properties;
import java.util.logging.LogManager;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;
import org.apache.logging.log4j.Logger;  //Log4j



public class BaseClass {

	public static WebDriver driver;
	public Logger logger;
	public Properties p;
	public SoftAssert softAssert;
	
	
	
	@BeforeClass(groups = {"Sanity","Regression","Master","Datadriven"})
	@Parameters({"browser","os"})
public	void setup(String br,String os) throws IOException{
		
		//Loading Config.properties file
		FileReader file= new FileReader(".//src/test/resources/config.properties");
		//FileReader file= new FileReader(System.getProperty("user.dir")+"/src/test/resources/config.properties");
		p=new Properties();
		p.load(file);
		
		 softAssert=new SoftAssert();
		
		logger=org.apache.logging.log4j.LogManager.getLogger(this.getClass());
		
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote")) 
		{
			
			DesiredCapabilities capabilitis=new DesiredCapabilities();
			//os
			if(os.equalsIgnoreCase("Windows")) {
				capabilitis.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("mac")) {
				capabilitis.setPlatform(Platform.MAC);
			}else if(os.equalsIgnoreCase("linux")){
				capabilitis.setPlatform(Platform.LINUX);
			}
			else {
				System.out.println("No matching os/platform/OperatingSystem");
				return;
			}
			//browser
			switch(br.toLowerCase())
			{
			case "chrome": capabilitis.setBrowserName("chrome");break;
			case "safari": capabilitis.setBrowserName("safari");break;
			case "edge": capabilitis.setBrowserName("MicrosoftEdge");break;
			case "firefox": capabilitis.setBrowserName("firefox");break;
			default:System.out.println("invalid browser name");return;
			
			}	
			driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilitis);
		}
		
	 if(p.getProperty("execution_env").equalsIgnoreCase("local")) {
		switch(br.toLowerCase()) {
		
		case "chrome" :driver = new ChromeDriver();break;
		case "edge" :driver=new EdgeDriver();break;
		case "safari" :driver=new SafariDriver();break;
		case "firefox" : driver=new FirefoxDriver();break;
		default :{
			System.out.println("invalid browser");return;
			}
		}
		}
	 
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(p.getProperty("url"));
		
	
		
	}
	
	
	@AfterClass(groups = {"Sanity","Regression","Master","Datadriven"})
	public void tearDown() {
		driver.quit();
	}
	
	
	 //Capturing Screenshot........
	
	
	
	public String captureScreen(String tname) {
		
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		
		TakesScreenshot takesScreenshot=(TakesScreenshot)driver;
		
		File SourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		
		
	    String targetFilePath = System.getProperty("user.dir") + "/screenshots/" + tname + "_" + timeStamp + ".png";
		
		
		File targetFile=new File(targetFilePath);
		
		SourceFile.renameTo(targetFile);
		
		
		return targetFilePath;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//RandomAlphaNumericGenerator......................
	
	public String randomStrings() {
		
		String randomString = RandomStringUtils.randomAlphabetic(5);
		return randomString;
		}
	
	
public String randomNumbers() {
		
		String randomNumber = RandomStringUtils.randomNumeric(10);
		return randomNumber;
	}


public String randomAlphaNumerics() {
		
		String randomAlphaNumeric = RandomStringUtils.randomAlphanumeric(6);
		return randomAlphaNumeric;
	}


public String currentDateTime() {
	
	
	String dateTime = LocalDateTime.now().toString().replace(';', '-');
	
	return dateTime;
	
	}
	
}

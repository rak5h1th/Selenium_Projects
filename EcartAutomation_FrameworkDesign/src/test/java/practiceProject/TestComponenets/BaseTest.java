package practiceProject.TestComponenets;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import practiceProject.frameworkDesign.LandingPage;

public class BaseTest {
	public WebDriver driver;
	public LandingPage landingpage;
	
	public WebDriver initializeDriver() throws IOException {
		Properties prop= new Properties();
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"//src//main//java//practiceProject//Globalfiles//GlobalFile.properties");
		prop.load(fis);
		String Browsername=prop.getProperty("browser");
		
		if(Browsername.equalsIgnoreCase("chrome")){
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		}
		else if(Browsername.equalsIgnoreCase("edge")){
			//invoke edge driver
		}
		else if(Browsername.equalsIgnoreCase("firefox")) {
			//invoke geko driver
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		return driver;
	}
	

	@BeforeMethod(alwaysRun=true)
	public LandingPage launchApplication() throws IOException {
		driver = initializeDriver();
	    landingpage= new LandingPage(driver);
		landingpage.GoTo();
		return landingpage;
	}
	
	@AfterMethod(alwaysRun=true)
	public void teardown() {
		driver.close();
	}
	public String takeScreenshot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts=  (TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File file =new File(System.getProperty("user.dir")+"//reports//"+testCaseName+".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir")+"//reports//"+testCaseName+".png";
	}

}

package practiceProject.Globalfiles;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
	
	public static ExtentReports getReportObject() {
		String path= System.getProperty("user.dir")+"//Reports//index.html";
		ExtentSparkReporter reporter= new ExtentSparkReporter(path);
		reporter.config().setReportName("Automation result");
		reporter.config().setDocumentTitle("Test Result");
		
		ExtentReports extent= new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("tester1", "Rakshith");
		return extent;
	}

}

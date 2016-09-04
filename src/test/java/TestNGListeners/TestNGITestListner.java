package TestNGListeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Helper.TakeScreenshot;
import MavenGroup.DailyCheckSites.CreateAccount;

public class TestNGITestListner implements ITestListener{
	static ExtentReports test;
	static ExtentTest logger;
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
		
	public TestNGITestListner()
	{
		
		test = new ExtentReports(projectPath+ "/target/Reports/report.html");
	}
	
	public void onFinish(ITestContext result) {
		
		test.endTest(logger);
		test.flush();
	
	}

	public void onStart(ITestContext result) {
		System.out.println();
		Object obj = result.getClass();
		System.out.println(obj);
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

		
	}

	public void onTestFailure(ITestResult result) {
		driver = CreateAccount.getDriver();
		String path = TakeScreenshot.TakeAscreenShot(driver, result.getName());
		String addpath = logger.addScreenCapture(path);
		logger.log(LogStatus.FAIL, "Test case pass", addpath);
		System.out.println("Test failed");
				
	}

	public void onTestSkipped(ITestResult result) {
		
		
	}

	public void onTestStart(ITestResult result) {
		
		logger = test.startTest(result.getName());
		
	}

	public void onTestSuccess(ITestResult result) {
		driver = CreateAccount.getDriver();
		String path = TakeScreenshot.TakeAscreenShot(driver, result.getName());
		String addpath = logger.addScreenCapture(path);
		logger.log(LogStatus.PASS, "Test case pass", addpath);
	}
	
	public static void loginfo(String log)
	{
		logger.log(LogStatus.INFO, log);
	}


}

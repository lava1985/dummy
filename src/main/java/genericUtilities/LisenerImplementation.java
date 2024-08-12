package genericUtilities;

import org.checkerframework.common.reflection.qual.GetMethod;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class LisenerImplementation implements ITestListener
{
	ExtentReports report;
	ExtentTest test;
	
	public static ExtentTest stest;
	
	@Override
	public void onStart(ITestContext context) {
		ExtentSparkReporter spark=new ExtentSparkReporter("./EXtentReports/report.html");
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setDocumentTitle("Extent Report");
		spark.config().setReportName("VTiger_CRM");
		 
		report =new ExtentReports();
        report.attachReporter(spark);
        
        report.setSystemInfo("OS", System.getProperty("os.name"));
        report.setSystemInfo("OS Version", System.getProperty("os.version"));
        report.setSystemInfo("JDK version", System.getProperty("java.specification.version"));
        report.setSystemInfo("Author", System.getProperty(""));
        
		
	}

	@Override
	public void onTestStart(ITestResult result) {
	   Capabilities cap=((RemoteWebDriver) BaseClass.sdriver).getCapabilities();
	   report.setSystemInfo("Browser", cap.getBrowserName());
	   report.setSystemInfo("Browser Version",cap.getBrowserVersion());
	    test=report.createTest(result.getMethod().getMethodName());
	    stest=test;
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.pass(result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
        test.fail(result.getMethod().getMethodName());   
		test.fail(result.getThrowable());
           test.addScreenCaptureFromPath(new WebDriverUtility().getScreenshot(BaseClass.sdriver,result.getMethod().getMethodName(), BaseClass.sjutil));
           //getScreenshot(BaseClass.sdriver, result.getMethod().getMethodName(),BaseClass.sdriver));
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.skip(result.getMethod().getMethodName());
		test.skip(result.getThrowable());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}

}

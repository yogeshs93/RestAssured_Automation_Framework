package listeners;

import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.annotations.FrameworkAnnotations;
import com.reports.ExtentLogger;
import com.reports.ExtentReport;

public class TestListeners implements  ITestListener, ISuiteListener{

	
	@Override
	public void onStart(ITestContext context) {
		try {
			ExtentReport.initReports();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onFinish(ITestContext context) {
		try {
			ExtentReport.flushReports();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void onTestStart(ITestResult result) {
		ExtentReport.createTest(result.getName());
		String[] authors=result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class).author();
		ExtentReport.addAuthor(authors);
		
		String[] categories=result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class).category();
		ExtentReport.addCategory(categories);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentLogger.pass(result.getName()+" is passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		ExtentLogger.fail(String.valueOf(result.getThrowable()));

	}

	
	
	

}


	package listeners;

	import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
	import org.testng.ITestListener;
	import org.testng.ITestResult;

import dsAlgo_Driverfactory.DriverFactory;
import dsAlgo_Utilities.LoggerLoad;
import io.cucumber.java.Scenario;



	public class Listeners implements ITestListener{

		@Override
		public void onTestStart(ITestResult result) {
			LoggerLoad.info("inTestStart");
		}

		@Override
		public void onTestSuccess(ITestResult result) {
			LoggerLoad.info("Test Success");
		}

		@Override
		public void onTestFailure(ITestResult result) {
			LoggerLoad.info("Test Failed");
			
		}
		
		@Override
		public void onTestSkipped(ITestResult result) {
			LoggerLoad.info("Test Skipped" + result.getName());
			byte[] sourcePath=((TakesScreenshot)DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
			System.out.println(sourcePath);
		}
		

		@Override
		public void onFinish(ITestContext context) {
			LoggerLoad.info("Test Finished" +context.getName());
		}
		

	}



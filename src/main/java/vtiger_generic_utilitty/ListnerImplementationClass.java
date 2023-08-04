package vtiger_generic_utilitty;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * This class provides implementaion to ITestListner inteface of TestNG
 * @author Ashwini sampe
 *
 */
public class ListnerImplementationClass implements ITestListener{

	public void onTestStart(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		System.out.println("---Execution started---"+methodName);
	}

	public void onTestSuccess(ITestResult result) {

		String methodName=result.getMethod().getMethodName();
		System.out.println("---Pass---"+methodName);
	}

	public void onTestFailure(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		System.out.println("---Fail---"+methodName);
		System.out.println(result.getThrowable());
		
		WebDriverUtility wu=new WebDriverUtility();
		JavaUtility ju=new JavaUtility();
		String screenshotName=methodName+ju.getSystemDateInFormat();
		//Take screenshot for failed scripts-to attach with bug rising
	try {
		wu.takeeScreenShot(BaseClass.sdriver, screenshotName);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	public void onTestSkipped(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		System.out.println("---Skip---"+methodName);
		System.out.println(result.getThrowable());

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {


	}

	public void onTestFailedWithTimeout(ITestResult result) {


	}

	public void onStart(ITestContext context) {

    System.out.println("---Suite execution started---");
	}

	public void onFinish(ITestContext context) {
		System.out.println("---Suite execution ended---");

	}
	

}

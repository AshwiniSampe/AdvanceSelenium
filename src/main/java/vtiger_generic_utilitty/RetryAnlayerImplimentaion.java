package vtiger_generic_utilitty;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This class provides implementation for IRetryAnalyser interface
 * @author Ashwini sampe
 *
 */
public class RetryAnlayerImplimentaion implements IRetryAnalyzer {
	int count=1;
	int retryCount=3;
	//it will give pass or fails our test scripts
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		while(count<=retryCount)
		{
			count++;
			return true;//it will retry 3 times
		}
		return false;
	}

}

package vtiger_practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyserPractice {
@Test(retryAnalyzer = vtiger_generic_utilitty.RetryAnlayerImplimentaion.class)
public void sample()
{
	//Assert.fail();
	System.out.println("Hi");
	Assert.fail();
}
}

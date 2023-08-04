package vtiger_practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionPractices {
@Test
public void sampleTest()
{
	int a=1;//exp
	int b=1;//actual
	Assert.assertEquals(b, a);
	System.out.println("Exection and validation complete");
}
@Test
public void sampleTest1()
{
	SoftAssert sa=new SoftAssert();
	int a=1;//exp
	int b=2;//actual
	System.out.println("Step 1");
	System.out.println("Step 2");
	Assert.assertEquals(b, a);//passed
	System.out.println("Step 3");
	System.out.println("Step 4");
	sa.assertTrue(false);
	System.out.println("Exection and validation complete");
	sa.assertAll();//logging all the failure
	
}
}

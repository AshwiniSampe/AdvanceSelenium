package vtiger_practice;

import org.testng.annotations.Test;

public class TestNGPractice {
	@Test(invocationCount = 3,priority = 1)
	public void createCostomer()
	{
		System.out.println("customer created");
	}
		
	@Test
	public void modifyCostomer()
	{
		System.out.println("customer modify");
	}
	@Test
	public void deleteCostomer()
	{
		System.out.println("customer deleted");
	}

}

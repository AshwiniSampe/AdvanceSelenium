package vtiger_practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractices {
	@Test(dataProvider = "getData")
	public void addToCartTest(String name,int price,String model)
	{
	System.out.println("Phone name is "+name+" price is "+price+" model is "+model);	
	}
   @DataProvider(name="Iphone")
   public Object[][] getData()
   {
	   Object[][] data=new Object[3][3];
	   data[0][0]="Iphone";
	   data[0][1]=2000;
	   data[0][2]="A80";
	   
	   data[0][0]="Samsung";
	   data[0][1]=2000;
	   data[0][2]="s13";
	   
	   data[0][0]="Viva";
	   data[0][1]=2000;
	   data[0][2]="Y21";
	   return data;
   }
}

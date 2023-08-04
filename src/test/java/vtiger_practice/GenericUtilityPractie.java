package vtiger_practice;

import vtiger_generic_utilitty.ExcelFileUtility;
import vtiger_generic_utilitty.JavaUtility;
import vtiger_generic_utilitty.PropertyFileUtility;

public class GenericUtilityPractie {
	public static void main(String[] args) throws Exception {
		JavaUtility jutil=new JavaUtility();
		int value=jutil.getRandomNum();
		System.out.println(value);
		System.out.println(jutil.getSystemDate());
		System.out.println(jutil.getSystemDateInFormat());
		
		PropertyFileUtility putil=new PropertyFileUtility();
		System.out.println(putil.getDataFromPropetryFile("url"));
		
		ExcelFileUtility eutil=new ExcelFileUtility();
		String data=eutil.getDataFormExcel("Sheet1", 1, 1);
		System.out.println(data);
		
		eutil.writeDataInExcel("Test5", 2, 3, "BatMan");;
		System.err.println("data added");
	}

}

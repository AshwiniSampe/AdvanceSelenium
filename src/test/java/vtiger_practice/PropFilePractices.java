package vtiger_practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropFilePractices {
	public static void main(String[] args) throws Exception {
		//step 1:Load the document in java readable format
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\commondata.properties");
		//step 2:Create object of properties class from java.util
		Properties pobj=new Properties();
		//step 3:Load the file into properties class
		pobj.load(fis);
		//step 4:Provide the key and get the value
	   String value=pobj. getProperty("un");
	   System.out.println(value);
	}

}

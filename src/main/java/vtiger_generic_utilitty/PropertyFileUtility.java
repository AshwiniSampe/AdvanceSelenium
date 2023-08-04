package vtiger_generic_utilitty;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * This class consists of generic methods related to property file
 * @author Ashwini sampe
 *
 */

public class PropertyFileUtility {
    public String getDataFromPropetryFile(String key) throws Exception
    {
    	//FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\commondata.properties");
    	FileInputStream fis=new FileInputStream(IConstants.propertyFilePath);
    	Properties p=new Properties();
    	p.load(fis);
    	 String value=p.getProperty(key);
    	 return value;
    	
    	
    }
}

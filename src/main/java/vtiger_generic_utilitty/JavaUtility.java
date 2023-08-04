package vtiger_generic_utilitty;

import java.util.Date;
import java.util.Random;

import org.openqa.selenium.devtools.v111.page.model.AdFrameStatus;

/**
 * This class consists of all genric methods related to java
 * @author Ashwini sampe
 *
 */

public class JavaUtility {
	/**
	 * This method will generate a random number for every 
	 * @return Random value
	 */
	public int getRandomNum()
	{
		Random r=new Random();
		int ran=r.nextInt(1000);
		return ran;
	}
	/**
	 * This method will generate the system date
	 * @return
	 */
	public String getSystemDate()
	{
		Date d=new Date();
		String date=d.toString();
		return date;
	}
	public String getSystemDateInFormat()
	{
		Date d=new Date();
		String[] date=d.toString().split(" ");	
		String currentDate=date[2];
		String month=date[1];
		String year=date[5];
		String time=date[3].replace(":","_");
		
		String dateInFormate=currentDate+"_"+month+"_"+year+"_"+time;
		return dateInFormate;
		
		
	}

}

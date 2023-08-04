package vtiger_practice;

import org.testng.annotations.Test;

public class ReadDataFromCmdLineTest {
  @Test
  public void readi()
  {
	  String UN=System.getProperty("username");
	  System.out.println(UN);
	  String PWD=System.getProperty("password");
	  System.out.println(PWD);
	  
  }
}

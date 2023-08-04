package vtiger_generic_utilitty;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
/**
 * This class consists of all the basic connfiguration annotaions for 
 * all the common actions
 * @author Ashwini sampe
 *
 */
public class BaseClass {
	public JavaUtility jUtil=new JavaUtility();
	public ExcelFileUtility  eUtil=new ExcelFileUtility();
	public PropertyFileUtility pUtil=new PropertyFileUtility();
	public WebDriverUtility wUtil=new WebDriverUtility();
	public WebDriver driver=null;
	
	//only used for listner to take screenshot
	public static WebDriver sdriver;
	
    @BeforeSuite
    public void jdbcConection() 
    {
	System.out.println("Data base connecte");
    }
   @BeforeClass
   public void openApp() throws Throwable
   {
	 //step 1:Read the data from property file-common data
		String Browser=pUtil.getDataFromPropetryFile("browser");
		String Url=pUtil.getDataFromPropetryFile("url");
		
		if(Browser.equalsIgnoreCase("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			System.out.println(Browser+" ---- Broser launched");	
		}
		else if(Browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			System.out.println(Browser+" ---- Broser launched");
		
		}
		else
		{
			System.out.println("Invalid Browser name");
		}
		wUtil.maximisewindow(driver);
		wUtil.waitForElementToLoad(driver);
		//step 2: Load the url
		driver.get(Url);
		//only used for listner to take screenshot
		sdriver=driver;
   }
   @BeforeMethod
   public void login() throws Throwable
   {
	    String username=pUtil.getDataFromPropetryFile("un");
	    String password=pUtil.getDataFromPropetryFile("pwd");
		LoginPage lp=new LoginPage(driver);
		lp.loginApp(username, password);
	    System.out.println("Login succesfuly");  
   }
   @AfterMethod
   public void logOut() throws Exception
   {
	   HomePage hp=new HomePage(driver);
	   hp.logoutOfApp(driver);
	   System.out.println("Login succesfuly");  
   }
		
	@AfterClass
	public void appClosed()
	{
		driver.quit();
	}
   
    @AfterSuite
    public void jdbcDisconect() {
	System.out.println("Data base disconnecte");
}
}

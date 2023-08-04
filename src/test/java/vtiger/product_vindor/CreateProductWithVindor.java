package vtiger.product_vindor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger_generic_utilitty.ExcelFileUtility;
import vtiger_generic_utilitty.JavaUtility;
import vtiger_generic_utilitty.PropertyFileUtility;
import vtiger_generic_utilitty.WebDriverUtility;

public class CreateProductWithVindor {
	//create object of required utility
		JavaUtility jUtil=new JavaUtility();
		ExcelFileUtility  eUtil=new ExcelFileUtility();
		PropertyFileUtility pUtil=new PropertyFileUtility();
		WebDriverUtility wUtil=new WebDriverUtility();
		
		WebDriver driver=null;
		//step 1:Read the data from property file-common data
		String Browser=pUtil.getDataFromPropetryFile("browser");
		String Url=pUtil.getDataFromPropetryFile("url");
		String username=pUtil.getDataFromPropetryFile("un");
		String password=pUtil.getDataFromPropetryFile("pwd");
		
		//step 2:Read the data from excelsheet-test data
		String OrgName=eUtil.getDataFormExcel("Sheet2", 4, 3)+jUtil.getRandomNum();
		String LastName=eUtil.getDataFormExcel("Sheet2", 4, 2);
		//String VendName=eUtil.getDataFormExcel("Sheet3", 4, 3)+jUtil.getRandomNum();
		//String ProdName=eUtil.getDataFormExcel("Sheet3", 4, 2);
		//step 2: Launch browser
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
		//Step 3:Login to the Application
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		//step 4:click on orgnization
		//driver.findE
}
}

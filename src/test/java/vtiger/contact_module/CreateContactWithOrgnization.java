package vtiger.contact_module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.ObjectRepository.LoginPage;
import vtiger_generic_utilitty.ExcelFileUtility;
import vtiger_generic_utilitty.JavaUtility;
import vtiger_generic_utilitty.PropertyFileUtility;
import vtiger_generic_utilitty.WebDriverUtility;

public class CreateContactWithOrgnization {
	@Test
	public void createContactWithOrgTest() throws Exception
	{
		
//public static void main(String[] args) throws Exception {
//create  organization
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
	//driver.findElement(By.name("user_name")).sendKeys(username);
	//driver.findElement(By.name("user_password")).sendKeys(password);
	//driver.findElement(By.id("submitButton")).click();
	LoginPage lp=new LoginPage(driver);
	/*lp.getUserNameEdt().sendKeys(username);
	lp.getPasswordEdt().sendKeys(password);
	lp.getLoginBtn().click();*/
	
	lp.loginApp(username, password);
	//step 4:click on orgnization
	driver.findElement(By.linkText("Organizations")).click();
	
	//step 5:click on create organixzation look up image
	driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	//step 6:give org name
	
	driver.findElement(By.name("accountname")).sendKeys(OrgName);
	//step 7:click on save
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	//step 8:validate
	String OrgHeader=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	if(OrgHeader.contains(OrgName))
	{
		System.out.println("pass");
		System.out.println(OrgHeader);
	}
	else
	{
		System.out.println("Fail");
	}
	//Create the contact using organization
	//step 9:click on contact
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
    //step 10:click on create contacts(+)
    driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
    // step 10: Create a contact with mandatory information
	driver.findElement(By.name("lastname")).sendKeys(LastName);
    driver.findElement(By.xpath("//img[@title='Select']")).click();
    
	//driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@title='Select']")).click();
    //Switch to child window
    wUtil.switchToWindow(driver, "Accounts");
    //Step 12: search for Organisation
 	driver.findElement(By.name("search_text")).sendKeys(OrgName);

 	driver.findElement(By.name("search")).click();
 	driver.findElement(By.xpath("//a[text()='" + OrgName + "']")).click(); // dynamic xpath

	// Step 13: switch the control back to parent window
	wUtil.switchToWindow(driver, "Sheet2");

	// Step 14: save
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

	// Step 15: Validate for Organization
	String ContactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	if (ContactHeader.contains(LastName)) {
		System.out.println("PASS");
		System.out.println(ContactHeader);
	} else {
		System.out.println("Fail");
	}
	//step 16: Logout the Application
		WebElement adminImg=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(adminImg).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		//driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		System.out.println("Logout successfull");
}
	
	
	
}

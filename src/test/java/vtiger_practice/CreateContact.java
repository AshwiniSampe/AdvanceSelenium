package vtiger_practice;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {
public static void main(String[] args) throws Exception {
	//step 1:Lauch the browser
	WebDriverManager.firefoxdriver().setup();
	WebDriver driver=new FirefoxDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	//step 2: Load the url
	driver.get("http://localhost:8888");
	//Step 3:Login to the Application
	driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("admin");
	driver.findElement(By.id("submitButton")).click();
	//step 4:click on contact
	driver.findElement(By.xpath("//a[text()='Contacts']")).click();
	//step 5:click on create contacts(+)
	driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
	//step 6:Select the first name from dropdown
	WebElement ele=driver.findElement(By.name("salutationtype"));
	Select s=new Select(ele);
	s.selectByValue("Ms.");
	//step 7:Give the last name
	Random r=new Random();
	int random=r.nextInt(1000);
	String data="ab"+random;
	driver.findElement(By.name("lastname")).sendKeys(data);
	//step 8: click on save
	driver.findElement(By.name("button")).click();
	//step 9:validate
	//Thread.sleep(3000);
	String contHeader=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	Thread.sleep(3000);
	if(contHeader.contains("ab"))
	{
		System.out.println("pass");
		System.out.println(contHeader);
	}
	else
	{
		System.out.println("Fail");
	}
		
	//step 10: Logout the Application
	WebElement adminImg=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	Actions act=new Actions(driver);
	act.moveToElement(adminImg).perform();
	driver.findElement(By.linkText("Sign Out")).click();
	//driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	System.out.println("Logout successfull");
		
		
	
	
}
}

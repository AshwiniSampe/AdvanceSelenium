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

public class CreateOrgnization {
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
		//step 4:click on orgnization
		driver.findElement(By.linkText("Organizations")).click();
		//step 5:click on create organixzation look up image
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		//step 6:give org name
		Random r=new Random();
		int random=r.nextInt(1000);
		String OrgName="L&T"+random;
		driver.findElement(By.name("accountname")).sendKeys(OrgName);
		//step 7:choose the chemicals in industry dropdown
		WebElement indutryDropD=driver.findElement(By.name("industry"));
		Select s=new Select(indutryDropD);
		s.selectByValue("Chemicals");
		//step 8:click on save
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//step 9:validate
		String OrgHeader=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(OrgHeader.contains("L&T"))
		{
			System.out.println("pass");
			System.out.println(OrgHeader);
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

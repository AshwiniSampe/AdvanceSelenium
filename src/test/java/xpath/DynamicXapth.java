package xpath;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicXapth {
public static void main(String[] args) throws Exception {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.goibibo.com/");
	driver.findElement(By.xpath("//span[@class='logSprite icClose']")).click();
	driver.findElement(By.xpath("//span[text()='Departure']")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//div[text()='August 2023']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='30']")).click();
	
	
}
}

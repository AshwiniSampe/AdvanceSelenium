package vtiger_generic_utilitty;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * This class consists of all the rusuable methods related to web driver actions
 * @author Ashwini sampe
 *
 */

public class WebDriverUtility {
	/**
	 * This method will maximise the window
	 * @param driver
	 */
	public void maximisewindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * This method will minimimise the window
	 * @param driver
	 */
	public void minimisewindow(WebDriver driver)
	{
		driver.manage().window().minimize();;
	}
	/**
	 * This method will awit for all the findElement and findElements
	 * operations to performed
	 * @param driver
	 */
	public void waitForElementToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	/**
	 * This method will wait until the specified element is visible in DOM
	 * @param driver
	 * @param element
	 */
   public void waitForElemetToBeVisible(WebDriver driver,WebElement element)
   {
	   WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
   }
   /**
	 * This method will handle drop down using index
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement element, int index) 
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);		
	}
	/**
	 * This method will handle drop down using value
	 * @param element
	 * @param value
	 */
	public void handleDropDown(WebElement element, String value) 
	{
		Select sel = new Select(element);
		sel.selectByValue(value);	
	}
	
	/**
	 * This method will handle dropdown using visible text
	 * @param text
	 * @param element
	 */
	public void handleDropDown(String text, WebElement element)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	/**
	 * This method will perform mouse hover action on a target element
	 * @param driver
	 * @param element
	 */
	public void mouseHoverAction(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	/**
	 * This method will double click anywhere on the web page
	 * @param driver
	 */
	public void doubleClickAction(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.doubleClick().perform();
	}
	
	/**
	 * This method will double click on a web element
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	/**
	 * This method will perform right click anywhere on the web page
	 * @param driver
	 */
	public void rightClickAction(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.contextClick().perform();
	}
	
	/**
	 * This method will perform right click on a particular web element
	 * @param driver
	 * @param element
	 */
	public void rightClickAction(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	
	/**
	 * This method will perform drag and drop action
	 * @param driver
	 * @param srcElement
	 * @param targetElement
	 */
	public void dragAndDropAction(WebDriver driver, WebElement srcElement, WebElement targetElement)
	{
		Actions act = new Actions(driver);
		act.dragAndDrop(srcElement, targetElement).perform();
	}
	
	/**
	 * This method is used to move the cursor anywhere on the web page based on offset values
	 * @param driver
	 * @param xOffSet
	 * @param yOffSet
	 */
	public void moveAcrossWebPage(WebDriver driver, int xOffSet, int yOffSet)
	{
		Actions act = new Actions(driver);
		act.moveByOffset(xOffSet, yOffSet).click().perform();
	}
	
	/**
	 * This method will scroll vertically for 500 pixels
	 * @param driver
	 */
	public void scrollAction(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500);", "");
	}
	
	/**
	 * This method will scroll vertically until the element reference
	 * @param driver
	 * @param element
	 */
	public void scrollAction(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		int y=element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+");", element);
		
		//js.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	/**
	 * This method will accept the alert pop up
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	/**
	 * This method will cancel the confirmation pop up
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This method will enter the text in prompt pop up
	 * @param driver
	 */
	public void sendTextToAlert(WebDriver driver, String text)
	{
		driver.switchTo().alert().sendKeys(text);
	}
	
	/**
	 * This method will capture the alert message and return to the caller
	 * @param driver
	 * @return
	 */
	public String getAlertText(WebDriver driver)
	{
		return driver.switchTo().alert().getText();
	}
	
	/**
	 * This method will handle frame based on frame index
	 * @param driver
	 * @param index
	 */
	public void handleFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}

    /**
     * This method will handle frame based on value of name or ID attributes
     * @param driver
     * @param nameOrID
     */
	public void handleFrame(WebDriver driver, String nameOrID)
	{
		driver.switchTo().frame(nameOrID);
	}
	/**
     * This method will handle frame based on value of name or ID attributes
     * @param driver
     * @param nameOrID
     */
	public void handleFrame2(WebDriver driver, String nameOrID)
	{
		driver.switchTo().frame(nameOrID);
	}
	
	/**
	 * This method will handle frame based on web element
	 * @param driver
	 * @param element
	 */
	public void handleFrame(WebDriver driver, WebElement element)
	{
		driver.switchTo().frame(element);
	}/**
	 * This method will help to switch the control back to immediate parent
	 * @param driver
	 */
	public void switchToParentFrame(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}
	
	/**W
	 * This method will help to switch the control back to current page 
	 * @param driver
	 */
	public void switchToDefaultPage(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	/**
	 * This method will switch the selenium control from parent to child or
	 * child to parent based on patial window title
	 * @param driver
	 * @param partialWinTitle
	 */
	public void switchToWindow(WebDriver driver,String partialWinTitle)
	{
		//step1: capture all window IDs
		Set<String> allWindows=driver.getWindowHandles();
		//step2: iterate through individual Ids
		for(String windID:allWindows)
		{
			//step 3:switch to each Id and capture the title 
			String currentTitle=driver.switchTo().window(windID).getTitle();
			
			//Step4:compare the title with required reference
			if(currentTitle.contains(partialWinTitle))
			{
				break;
			}
		}
	}
	/**
	 * This method will take screen shot and return the absolute path for it
	 * @param driver
	 * @param screenshotName
	 * @return
	 * @throws Exception
	 */
	public String takeeScreenShot(WebDriver driver,String screenshotName) throws Exception	
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dst=new File(".\\ScreenShot\\"+screenshotName+".png");
		Files.copy(src, dst);
		return dst.getAbsolutePath();//attach the screen shotnto estent reports
	}
	
}


package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContactPage {
	@FindBy(name= "lastname")
	private WebElement OrgHeaderText;
	//save the contacts
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	//create constructor to initialise the web elements
		public CreateNewContactPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
	//Utitlzation(right clik-source-click on generate getter and setter)
	
}

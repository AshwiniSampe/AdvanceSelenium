package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	//Declarion
		@FindBy(xpath = "//img[@alt='Create Contact...']")
		private WebElement OrgHeaderText;
		//create constructor to initialise the web elements
			public ContactsPage(WebDriver driver)
			{
				PageFactory.initElements(driver, this);
			}
		//Utitlzation(right clik-source-click on generate getter and setter)
		
}

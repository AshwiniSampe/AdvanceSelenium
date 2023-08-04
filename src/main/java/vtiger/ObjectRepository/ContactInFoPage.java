package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInFoPage {
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement ContactHeaderText;
	//create constructor to initialise the web elements
		public ContactInFoPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		public WebElement getContactHeaderText() {
			return ContactHeaderText;
		}
		//Bussines Libray
		public String getContactHeader()
		{
			return ContactHeaderText.getText();
		}
}

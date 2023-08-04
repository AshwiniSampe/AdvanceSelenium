package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	//Declarion
	@FindBy(xpath = "//span[@class='dvHeaderText'")
	private WebElement OrgHeaderText;
	//create constructor to initialise the web elements
		public OrganizationInfoPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
	//Utitlzation(right clik-source-click on generate getter and setter)
		public WebElement getOrgHeaderText() {
			return OrgHeaderText;
		}
		//Business libray
		public String getHeaderText()
		{
			return OrgHeaderText.getText();
		}
}

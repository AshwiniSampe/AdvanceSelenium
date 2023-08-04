package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOrgPage {
	//Declarion
	@FindBy(name = "accountname")
	private WebElement OrgNameEdt;
	@FindBy(name = "industry")
	private WebElement IndustryDropDown;
	//click on save button
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	//create constructor to initialise the web elements
		public CreateNewOrgPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
	//Utitlzation(right clik-source-click on generate getter and setter)
		public WebElement getOrgNameEdt() {
			return OrgNameEdt;
		}
		public WebElement getIndustryDropDown() {
			return IndustryDropDown;
		}
		public WebElement getSaveBtn() {
			return SaveBtn;
		}
		
		//Bussiness libray
		public void createOrg(String OrgName)
		{
			OrgNameEdt.sendKeys(OrgName);
			SaveBtn.click();
		}
}


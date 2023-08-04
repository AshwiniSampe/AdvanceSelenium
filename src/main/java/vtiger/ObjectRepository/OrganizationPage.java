package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
//Declarion
@FindBy(xpath = "//img[@alt='Create Organization...']")
private WebElement CreateOrgLookUpImg;
//create constructor to initialise the web elements
	public OrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
//Utitlzation(right clik-source-click on generate getter and setter)
	public WebElement getCreateOrgLookUpImg() {
		return CreateOrgLookUpImg;
	}
	//Business libray
	public void clickOnCreateOrgLookUpImg()
	{
		CreateOrgLookUpImg.click();
	}
}

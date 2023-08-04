package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger_generic_utilitty.WebDriverUtility;

public class HomePage extends WebDriverUtility{
	@FindBy(linkText = "Organizations")
	private WebElement OrganizationLink;
	@FindBy(linkText = "Contacts")
	private WebElement ContactsLink;
	@FindBy(linkText = "Opportunities")
	private WebElement OpportunitiesLink;
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdministratorImg;
	@FindBy(linkText = "Sign Out")
	private WebElement SignOutLink;
	
	//Initialzation
	//create constructor to initialise the web elements
		public HomePage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
   //Utilzation

		public WebElement getOrganizationLink() {
			return OrganizationLink;
		}

		public WebElement getContactsLink() {
			return ContactsLink;
		}

		public WebElement getOpportunitiesLink() {
			return OpportunitiesLink;
		}

		public WebElement getAdministratorImg() {
			return AdministratorImg;
		}

		public WebElement getSignOutLink() {
			return SignOutLink;
		}
	//Business libray(We can use above utization or bussiness libray)
		/**
		 * This method will click on orgnization link
		 */
		public void clickOnOrgLink()
		{
			OrganizationLink.click();
		}
		/**
		 * This method will click on orgnization link
		 */
		public void clickOnContactsLink()
		{
			ContactsLink.click();
		}
		/**
		 * This met5hod will logout the application
		 * @param driver
		 * @throws Exception
		 */
		public void logoutOfApp(WebDriver driver) throws Exception
		{
			mouseHoverAction(driver, AdministratorImg);
			Thread.sleep(3000);
			SignOutLink.click();
		}
		
	
	

}

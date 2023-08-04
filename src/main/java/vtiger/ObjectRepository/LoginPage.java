package vtiger.ObjectRepository;
//Rule 1:Crwate a seperate pom class for every web page

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	//Rule 2:Identify the web elements using @FindBy, @FindBys,@FindAll
	@FindBy(name="user_name")
	private WebElement userNameEdt;
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	
	//Rule 3:create constructor to initialise the web elements
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//Rule 4:Provide getter to acess these web elements
	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	//Bussiness libray-project specific generic method
	/**
	 * This method will perform login operation
	 * @param username
	 * @param password
	 */
	public void loginApp(String username,String password)
	{
		userNameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
	}


	
    
}

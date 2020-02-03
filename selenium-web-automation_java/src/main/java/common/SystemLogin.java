package common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SystemLogin {

	WebDriver driver;

	// Identifying web elements

	@FindBy(css = "input[type='text']")
	private WebElement userNameBox;

	@FindBy(css = "input[type='password']")
	private WebElement passWordBox;

	@FindBy(css = "button[type='submit']")
	private WebElement clickLoginButton;

	@FindBy(xpath = "//p[text()='Invalid username or password!']")
	private WebElement invalidCredentials;

	@FindBy(css = "p[class='main-button']")
	private WebElement clickLogoutButton;

	@FindBy(xpath = "//p[contains(text(),'Hello Luke')]")
	private WebElement verifyLogin;

	public SystemLogin(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * Enter the Login details
	 * 
	 * @param userName     Username of the user
	 * @param userPassword Password of the user
	 * 
	 */
	public void enterLoginDetails(String userName, String userPassword) {
		userNameBox.sendKeys(userName);
		passWordBox.sendKeys(userPassword);
	}

	/**
	 * Login by clicking on submitButton
	 */
	public void clickLoginButton() throws InterruptedException {
		
		TimeUnit.SECONDS.sleep(2);
		clickLoginButton.click();
	}

	/**
	 * Verify Unsuccessful Login attempt
	 * @param wronguserName      Invalid username
	 * @param wronguserPassword  Invalid password
	 */
	public String unsuccessfulLoginMsg() {
		
		return invalidCredentials.getText();
	}

	/**
	 * Logout by clicking on Logout button
	 * @throws InterruptedException 
	 */

	
	public void clickLogoutButton() throws InterruptedException{
		TimeUnit.SECONDS.sleep(2);
        clickLogoutButton.click();

	}

	/**
	 * Verify successfully login
	 */

	public String verifyLogin() {
		return verifyLogin.getText();

	}
	
	/**
	 * Verify if the login button is displayed again after logout
	 */

	public boolean verifySucessfullLogout()  {
		return clickLoginButton.isDisplayed();

	}

}

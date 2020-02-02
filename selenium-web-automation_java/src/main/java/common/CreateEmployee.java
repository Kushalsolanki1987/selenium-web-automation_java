package common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateEmployee {
	WebDriver driver;

	// Identifying web elements

	@FindBy(id = "bAdd")
	private WebElement clickCreateButton;

	@FindBy(xpath = "//input[contains(@ng-model,'firstName')]")
	private WebElement firstNameBox;

	@FindBy(xpath = "//input[contains(@ng-model,'lastName')]")
	private WebElement lastNameBox;

	@FindBy(xpath = "//input[contains(@ng-model,'startDate')]")
	private WebElement startDateBox;

	@FindBy(xpath = "//input[contains(@ng-model,'email')]")
	private WebElement emailBox;

	@FindBy(xpath = "//button[contains(text(),'Add')]")
	private WebElement clickAddButton;
	
	
	
	
	
	
	/**
	 * Create employee by clicking on create button
	 */
	public void clickCreateButton() {
	
		clickCreateButton.click();
	}

	/**
	 * Enter the Employee details
	 * 
	 * @param firstName     Firstname of the user
	 * @param lastName      Last Name of the user
	 * @param startDate     Start date of the user
	 * @param email         Email of the user
	 */
	public void enterEmployeeDetails(String firstName, String lastName,String startDate, String email) {
		firstNameBox.sendKeys(firstName);
		lastNameBox.sendKeys(lastName);
		startDateBox.sendKeys(startDate);
		emailBox.sendKeys(email);	
		
	}
	
	/**
	 * Create employee by clicking on Add Button
	 */
	public void clickAddButton() throws InterruptedException {
		
		TimeUnit.SECONDS.sleep(2);
		clickAddButton.click();
	}

	
	
	
}

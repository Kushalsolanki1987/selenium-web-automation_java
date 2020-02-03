package common;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UpdateEmployee {


	
		// Identifying web elements
		
		@FindBy(id = "bEdit")
		private WebElement clickEditButton;
		
		@FindBy(xpath = "//button[contains(text(),'Update')]")
		private WebElement clickUpdateButton;
		
		@FindBy(xpath = "//ul[@id='employee-list']//following-sibling::li[1]")
		private WebElement selectEmployee;
		
		@FindBy(xpath = "//input[contains(@ng-model,'firstName')]")
		private WebElement firstNameBox;
		
		
		
		
		
		/**
		 * Update details by Clicking on Edit button
		 */
		
		public void clickEditButton() throws InterruptedException {
			
			TimeUnit.SECONDS.sleep(2);
			clickEditButton.click();
		}
		
		/**
		 * Update the Employee details
		 * @param updateFirstName     Update Firstname of the user
		 */
		
		
		public void updateEmployeeDetails(String firstName) {
			firstNameBox.sendKeys(firstName);
			
			
		}
		
		
		/**
		 * Select an employee to update
		 */
		
		
		public void selectEmployee() throws InterruptedException {
			
			TimeUnit.SECONDS.sleep(2);
			selectEmployee.click();
		}

		/**
		 * Update details by Clicking on Edit button
		 */
		
		
		public void clickUpdateButton() throws InterruptedException {
			
			TimeUnit.SECONDS.sleep(2);
			clickUpdateButton.click();
		}
		
		public boolean verifySucessfullUpdate()  {
			return clickEditButton.isDisplayed();

		}
		
	}
	
	
	
	


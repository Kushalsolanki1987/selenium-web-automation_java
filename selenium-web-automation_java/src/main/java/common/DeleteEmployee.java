package common;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteEmployee {


	@FindBy(id = "bDelete")
	private WebElement clickDeleteButton;
	
	
	
	
	/**
	 * Submit confirm button pop up
	 * @param driver2 
	 */

	public void submitConfirmButton(WebDriver driver) throws InterruptedException {
		
		TimeUnit.SECONDS.sleep(1);
		driver.switchTo().alert().accept();


	}

	/**
	 * Delete Employee details
	 */

	public void clickDeleteButton() {

		clickDeleteButton.click();

	}

}

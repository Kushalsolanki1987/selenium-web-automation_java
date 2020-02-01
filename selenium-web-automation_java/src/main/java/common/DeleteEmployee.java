package common;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteEmployee {

	WebDriver driver;

	@FindBy(id = "bDelete")
	private WebElement clickDeleteButton;
	
	
	
	
	/**
	 * Submit confirm button pop up
	 */

	public void submitConfirmButton() throws InterruptedException {

		TimeUnit.SECONDS.sleep(2);

		try{
		} catch (Exception e) {
		if(e.toString().contains("org.openqa.selenium.UnhandledAlertException"))
		 {
		    Alert alert = driver.switchTo().alert();
		    alert.accept();
		 }
		}

	}

	/**
	 * Delete Employee details
	 */

	public void clickDeleteButton() {

		clickDeleteButton.click();

	}

}

package ui;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import common.CreateEmployee;
import common.DeleteEmployee;
import common.SystemLogin;
import common.UpdateEmployee;

class TestExecutable {
	private WebDriver driver;
	private CreateEmployee create;
	private SystemLogin login;
	private UpdateEmployee update;
	private DeleteEmployee delete;
	String baseUrl;

	// Initialize properties and start browser
	@BeforeMethod
	public void openDriver() {
		if (System.getProperty("os.name").toLowerCase().contains("mac")) {
			System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
		} else {
			System.setProperty("webdriver.chrome.driver", "resources/geckodriver.exe");
		}
		driver = new ChromeDriver();
		baseUrl = "http://cafetownsend-angular-rails.herokuapp.com/employees";
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		// Initialize page objects
		login = new SystemLogin(driver);
		create = new CreateEmployee();
		update = new UpdateEmployee();
		delete = new DeleteEmployee();

		// Initialize page elements
		driver.get(baseUrl);
		PageFactory.initElements(driver, login);
		PageFactory.initElements(driver, create);
		PageFactory.initElements(driver, update);
		PageFactory.initElements(driver, delete);
	}

	@Parameters({ "userName", "userPassword" })
	@Test(description = "Verify if the user is able to login successfully", priority = 0)
	public void verifySuccessfulLogin(String userName, String userPassword) throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		login.enterLoginDetails(userName, userPassword);
		login.clickLoginButton();
		softAssert.assertEquals(login.verifyLogin(), "Hello Luke");
	}
	
	@Parameters({ "userName", "userPassword" })
	@Test(description = "Verify if the user is able to logout successfully", priority = 1)
	public void verifySuccessfulLogout(String userName, String userPassword) throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		login.enterLoginDetails(userName, userPassword);
		login.clickLoginButton();
		login.clickLogoutButton();
		softAssert.assertEquals(login.verifySucessfullLogout(), true);
	}
	
	
	@Parameters({ "wronguserName", "wronguserPassword" })
	@Test(description = "Verify if the user is not able to login with wrong credentials", priority = 2)
	public void verifyUnuccessfulLogin(String userName, String userPassword) throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		login.enterLoginDetails(userName, userPassword);
		login.clickLoginButton();
		softAssert.assertEquals(login.unsuccessfulLoginMsg(), "Invalid username or password!");
	}
	
	
	@Parameters({ "userName", "userPassword","firstName", "lastName","startDate","email" })
	@Test(description = "Verify if the employee details is added successfully", priority = 3)
	public void verifyCreateEmployeeDeatils(String userName, String userPassword,String firstName, String lastName, String startDate , String email) throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		login.enterLoginDetails(userName, userPassword);
		login.clickLoginButton();
		create.clickCreateButton();
		create.enterEmployeeDetails(firstName, lastName, startDate, email);
		create.clickAddButton();
		softAssert.assertEquals(update.verifySucessfullUpdate(), true);
	
	}
	
	
	@Parameters({ "userName", "userPassword","updateFirstName"})
	@Test(description = "Verify if the employee details is updated successfully", priority = 4)
	public void verifyUpdateEmployeeDetails(String userName, String userPassword,String firstName) throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		login.enterLoginDetails(userName, userPassword);
		login.clickLoginButton();
		update.selectEmployee();
		update.clickEditButton();
		update.updateEmployeeDetails(firstName);
		update.clickUpdateButton();
		softAssert.assertEquals(update.verifySucessfullUpdate(), true);
		
	}
	
	

	@Parameters({ "userName", "userPassword"})
	@Test(description = "Verify if the employee details is deleted successfully", priority = 5)
	public void verifyDeleteEmployeeDetails(String userName, String userPassword) throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		login.enterLoginDetails(userName, userPassword);
		login.clickLoginButton();
		update.selectEmployee();
		delete.clickDeleteButton();
		delete.submitConfirmButton();
		login.clickLogoutButton();
		softAssert.assertEquals(login.verifySucessfullLogout(), true);
		
		
	
	}

	// Close browser
	@AfterMethod
	public void closeDriver() {
		driver.close();
	}

}

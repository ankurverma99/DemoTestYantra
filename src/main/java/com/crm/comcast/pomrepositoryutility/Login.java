package com.crm.comcast.pomrepositoryutility;

/**
 * 
 * @author Deepak
 *
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericutility.FileUtility;
import com.crm.comcast.genericutility.WebDriverUtlity;

public class Login extends WebDriverUtlity { // R-1

	WebDriver driver;

	public Login(WebDriver driver) { // R3
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "user_name") // R-2
	private WebElement userNameEdt;

	@FindBy(name = "user_password")
	private WebElement passwordEdt;

	@FindAll({ @FindBy(id = "submitButton"), @FindBy(xpath = "//input[@type='submit']") })
	private WebElement loginBtn;

	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	/**
	 * login to app
	 * 
	 * @param userName
	 * @param password
	 */
	public void loginToApp(String url, String userName, String password) {
		driver.get(url);
		waitForElementInDOM(driver);
		// driver.manage().window().maximize();
		waitForElement(driver, userNameEdt);
		userNameEdt.sendKeys(userName);
		passwordEdt.sendKeys(password);
		loginBtn.click();

	}

	public void loginToApp() throws Throwable {
		FileUtility flib = new FileUtility();
		driver.get(flib.getPropertyKeyValue("url"));
		waitForElementInDOM(driver);
		driver.manage().window().maximize();

		userNameEdt.sendKeys(flib.getPropertyKeyValue("username"));
		passwordEdt.sendKeys(flib.getPropertyKeyValue("password"));
		loginBtn.click();

	}

}

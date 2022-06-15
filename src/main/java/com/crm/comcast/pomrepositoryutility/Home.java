package com.crm.comcast.pomrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericutility.WebDriverUtlity;

/**
 * 
 * @author Deepak
 *
 */
public class Home extends WebDriverUtlity {
	WebDriver driver;

	public Home(WebDriver driver) { // R3
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Organizations")
	private WebElement orgLink;

	@FindBy(linkText = "More")
	private WebElement moreDropDownMenu;

	@FindBy(linkText = "Vendors")
	private WebElement vendorsLnk;

	@FindBy(linkText = "Products")
	private WebElement productLnk;

	public WebElement getProductLnk() {
		return productLnk;
	}

	@FindBy(linkText = "Contacts")
	private WebElement contactLnk;

	@FindBy(linkText = "Campaigns")
	private WebElement campaginLnk;

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;

	@FindBy(linkText = "Sign Out")
	private WebElement signOutLnk;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getContactLnk() {
		return contactLnk;
	}

	public void clickContactLnk() {
		contactLnk.click();
	}

	public WebElement getMoreDropDownMenu() {
		return moreDropDownMenu;
	}

	public WebElement getCampaginLnk() {
		return campaginLnk;
	}

	public WebElement getAdminImg() {
		return adminImg;
	}

	public WebElement getSignOutLnk() {
		return signOutLnk;
	}

	/**
	 * used for app logout
	 */
	public void logout() {
		mouseOverOnElement(driver, adminImg);
		signOutLnk.click();
	}

	public void navigateToCampaginPage() {
		waitForElement(driver, moreDropDownMenu);
		mouseOverOnElement(driver, moreDropDownMenu);
		waitForElement(driver, campaginLnk);
		campaginLnk.click();
	}

	/**
	 *   
	 */

	public void navigateToVenderPage() {
		mouseOverOnElement(driver, moreDropDownMenu);
		waitForElement(driver, vendorsLnk);
		vendorsLnk.click();
	}

}

package com.crm.comcast.pomrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignsPage {
	WebDriver driver;

	public CampaignsPage(WebDriver driver) { // R3
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@alt='Create Campaign...']")
	private WebElement createnewCamapaignBtn;

	public WebElement getCreatenewCamapaignBtn() {
		return createnewCamapaignBtn;
	}

	public void createnewCamapaignBtnClick() {
		createnewCamapaignBtn.click();
	}

}

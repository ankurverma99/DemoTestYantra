package com.crm.comcast.pomrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignInformationPage {
	WebDriver driver;

	public CampaignInformationPage(WebDriver driver) { // R3
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "dvHeaderText")
	private WebElement campaginHeraderInfo;

	public WebElement getCampaginHeraderInfo() {
		return campaginHeraderInfo;
	}

	public String getcampaginHeraderInfo() {
		return campaginHeraderInfo.getText();
	}

}

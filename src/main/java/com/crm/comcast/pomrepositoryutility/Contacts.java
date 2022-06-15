package com.crm.comcast.pomrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericutility.WebDriverUtlity;
import com.mysql.cj.result.BufferedRowList;

public class Contacts extends WebDriverUtlity {
	WebDriver driver;

	public Contacts(WebDriver driver) { // R3
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "bas_searchfield")
	private WebElement searchDD;

	@FindBy(name = "search_text")
	private WebElement serachEdt;

	@FindBy(xpath = "//input[contains(@value,'Search Now')]")
	private WebElement serachNowBtn;

	@FindBy(xpath = "//input[@value='Delete']")
	private WebElement deleteBtn;

	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement createContactImg;

	public WebElement getCreateContactImg() {
		return createContactImg;
	}

	public WebElement getDeleteBtn() {
		return deleteBtn;
	}

	public void createConImgClick() {
		createContactImg.click();
	}

	public void searcContact(String contactName, String searchFor) {
		select(searchDD, searchFor);
		serachEdt.sendKeys(contactName);
		serachNowBtn.click();

	}

}

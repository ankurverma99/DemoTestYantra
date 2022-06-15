package com.crm.comcast.pomrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Products {
	WebDriver driver;
	
	   public Products(WebDriver driver) {             //R3
		   this.driver = driver;
		   PageFactory.initElements(driver, this);
	  }
	   
	   
	   @FindBy(id="search_txt")
	   private WebElement searchProductsEdt;
	   
	   @FindBy(name = "search")
	   private WebElement searchBtn;
	   
	   
	   public WebElement getSearchProductsEdt() {
		return searchProductsEdt;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}


	@FindBy(xpath = "//img[@title='Create Product...']")
	   private WebElement createProductImg;

	public WebElement getcreateProductImg() {
		return createProductImg;
	}
	   
	   

}

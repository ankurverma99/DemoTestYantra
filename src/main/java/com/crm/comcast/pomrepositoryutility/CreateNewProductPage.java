package com.crm.comcast.pomrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewProductPage {

	WebDriver driver;
	
	   public CreateNewProductPage(WebDriver driver) {             //R3
		   this.driver = driver;
		   PageFactory.initElements(driver, this);
	  }
	   
	   @FindBy(name = "productname")
	   private WebElement productNameEdt;
	   
	   @FindBy(xpath = "//input[@title='Save [Alt+S]']")
	   private WebElement saveBtn;
	   
	   
	   public void createNewProduct(String productName) {
		   productNameEdt.sendKeys(productName);
		   saveBtn.click();
	   }
	
}

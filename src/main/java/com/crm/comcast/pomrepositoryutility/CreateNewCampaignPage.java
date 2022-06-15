package com.crm.comcast.pomrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericutility.WebDriverUtlity;

public class CreateNewCampaignPage  extends WebDriverUtlity{

	WebDriver driver;
	
	   public CreateNewCampaignPage(WebDriver driver) {             //R3
		   this.driver = driver;
		   PageFactory.initElements(driver, this);
	  }
	   
	   @FindBy(name = "campaignname")
	   private WebElement campaignEdt;
	   
	   @FindBy(xpath = "//input[@title='Save [Alt+S]']")
	   private WebElement saveBtn;
	   
	   @FindBy(xpath = "//input[@name='product_name']/following-sibling::img")
	   private WebElement productLookUpImg;

	public WebElement getCampaignEdt() {
		return campaignEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getProductLookUpImg() {
		return productLookUpImg;
	}
	   
	   /**
	    *  create a campaign with mandatory field
	    * @param campaginName
	    */
	public void createNewCampaign(String campaginName) {
		campaignEdt.sendKeys(campaginName);
		saveBtn.click();
	}
	
	   /**
	    *  create a campaign with mandatory field
	    * @param campaginName
	    */
	public void createNewCampaign(String campaginName, String productName) {
		campaignEdt.sendKeys(campaginName);
		productLookUpImg.click();
		swithToWindow(driver, "Products&action");
		Products pp = new Products(driver);
		pp.getSearchProductsEdt().sendKeys(productName);
		pp.getSearchBtn().click();
		driver.findElement(By.xpath("//a[text()='"+productName+"']")).click();
		swithToWindow(driver, "Campaigns&action");
		saveBtn.click();
	}
}

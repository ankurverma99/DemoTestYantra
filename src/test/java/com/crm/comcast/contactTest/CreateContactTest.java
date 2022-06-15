package com.crm.comcast.contactTest;

import java.io.FileInputStream;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.crm.comcast.genericutility.BaseAnnoationClass;
import com.crm.comcast.pomrepositoryutility.Contacts;
import com.crm.comcast.pomrepositoryutility.CreateNewConatcts;
import com.crm.comcast.pomrepositoryutility.Home;

public class CreateContactTest extends BaseAnnoationClass {
	@Test(groups = "smokeTest")
	public void TC_01() throws Exception {

		// step d: Get random number to avoid duplicates
		Random ran = new Random();
		int randomNumber = ran.nextInt(1000);

		// step e: read test case data from excel file to achieve D.D.T
		FileInputStream fisx = new FileInputStream("./TestData/testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fisx);
		Sheet sh = wb.getSheet("Contacts");
		Row row = sh.getRow(1);
		Cell cell = row.getCell(0);
		String LastName = cell.getStringCellValue() + randomNumber;
		System.out.println(LastName);

		Home h = new Home(driver);
		// step2-----click on contacts
		h.clickContactLnk();
		Contacts c = new Contacts(driver);
		c.createConImgClick();
		CreateNewConatcts cnc = new CreateNewConatcts(driver);
		// step3----create contacts
		cnc.createConatct(LastName);

		String actData = driver.findElement(By.className("dvHeaderText")).getText();
		if (actData.contains(LastName)) {
			System.out.println("Contacts name is succesfully created::PASS");
		} else {
			System.out.println("Contacts name is not created::FAIL");
		}

	}

}

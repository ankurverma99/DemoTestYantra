package com.crm.comcast.campaignTest;

import java.io.FileInputStream;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import com.crm.comcast.genericutility.BaseAnnoationClass;
import com.crm.comcast.pomrepositoryutility.CampaignInformationPage;
import com.crm.comcast.pomrepositoryutility.CampaignsPage;
import com.crm.comcast.pomrepositoryutility.CreateNewCampaignPage;
import com.crm.comcast.pomrepositoryutility.Home;

public class CreateCampaign extends BaseAnnoationClass {
	@Test(groups = "regration")
	public void tc_01() throws Exception {

		Home h = new Home(driver);
		h.navigateToCampaginPage();
		Random ran = new Random();
		int randomNumber = ran.nextInt(1000);
		FileInputStream fisx = new FileInputStream("./Testdata/testData.xlsx");
		Workbook wb = WorkbookFactory.create(fisx);
		Sheet sh = wb.getSheet("Campaigns");
		Row row = sh.getRow(1);
		Cell cell = row.getCell(0);
		String CampaignName = cell.getStringCellValue() + randomNumber;
		System.out.println(CampaignName);
		CampaignsPage cp = new CampaignsPage(driver);
		cp.createnewCamapaignBtnClick();
		CreateNewCampaignPage cncp = new CreateNewCampaignPage(driver);
		cncp.createNewCampaign(CampaignName);
		CampaignInformationPage cip = new CampaignInformationPage(driver);
		String actualSuccesfulMsg = cip.getcampaginHeraderInfo();
		if (actualSuccesfulMsg.contains(CampaignName)) {
			System.out.println("Campaign  is succesfully created::PASS");
		} else {
			System.out.println("Campaign is not created::FAIL");
		}

	}

}

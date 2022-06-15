package practice;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class SampleTest {

	@Test(priority = 0)
	public void createContactTest() {
		Reporter.log("Contact created", true);
	}

	@Test(priority = -1)
	public void modifyContactTest() {
		Reporter.log("Contact modified", true);

	}

	@Test(priority = 3)
	public void deleteContactTest() {
		Reporter.log("Contact deleteed", true);

	}

}

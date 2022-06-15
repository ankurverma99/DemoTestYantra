package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoRetry {
	@Test(retryAnalyzer = practice.DemoReTryAnalyzer.class)
	public void tc_01() {
		Assert.assertEquals("A", "B");
	}
}

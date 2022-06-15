package practice;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DemoGride {
	@Parameters("browser")
	@Test
	public void sampleTest(String bname) throws MalformedURLException {
		URL url = new URL("http://localhost:5555/wd/hub");
		DesiredCapabilities cap = new DesiredCapabilities();
		if (bname.equalsIgnoreCase("chrome"))
			cap.setBrowserName("chrome");
		else if (bname.equalsIgnoreCase("firefox")) {
			cap.setBrowserName("firefox");
		}
		cap.setPlatform(Platform.WINDOWS);
		WebDriver driver = new RemoteWebDriver(url, cap);
		driver.get("http://www.google.com");
		driver.quit();
		//shivraj hii from branch
	}
}

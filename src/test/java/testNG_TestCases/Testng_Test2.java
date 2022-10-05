package testNG_TestCases;

import java.time.Duration;

import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.lambdatest.basetest.BaseTest;

public class Testng_Test2 extends BaseTest{
	
	@Parameters(value = { "url" })
	@Test
	public void pageTitleValidation(String url) {
		Reporter.log("Step 1:Open LambdaTest’s Selenium Playground from",true);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		Reporter.log("<--------Scenario 1: Page title validation Started-------->", true);
		String pageTitle=driver.getTitle();
		Reporter.log("Asserting wrong page Title", true);
		soft.assertNotEquals(pageTitle, "LambdaTest");
		soft.assertAll();
	}
	
}

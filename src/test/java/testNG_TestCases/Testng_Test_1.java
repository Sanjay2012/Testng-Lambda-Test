package testNG_TestCases;

import org.testng.annotations.Test;
import com.lambdatest.basetest.BaseTest;

public class Testng_Test_1 extends BaseTest{
	@Test
	public void pageTitleValidation() {
		
		String pageTitle=driver.getTitle();
		soft.assertNotEquals(pageTitle, "LambdaTest");
		soft.assertAll();
	}
	
}

package testNG_TestCases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.lambdatest.basetest.BaseTest;

public class Testng_Test3 extends BaseTest{
	@Test
	public void handlingJavaScriptAlertBox() {
		Reporter.log("<--------Scenario 3: Handling Java Script Alert Box Started-------->", true);
		
		try {
			Reporter.log("Click Javascript Alerts under Alerts and  Modals ",true);
			driver.findElement(By.xpath("//a[normalize-space()='Javascript Alerts']")).click();
			
			Reporter.log("Now click the Click Me button in the Java Script Alert Box section", true);
			driver.findElement(By.xpath("//p[@class=\"text-gray-900 ml-10 text-size-16 mt-10 text-black font-bold\"]//button")).click();
			Reporter.log("Validate the alert message Please enter your name! and click ok." , true);
			
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			String altText = alert.getText();
			
			soft.assertEquals(altText, "Please enter your name");
			alert.sendKeys("Sanjay Waware");
			alert.accept();
			
			String message = driver.findElement(By.xpath("//p[@id=\"prompt-demo\"]")).getText();
			soft.assertEquals(message, "You have entered 'Sanjay Waware' !");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		soft.assertAll();
	}
	
}

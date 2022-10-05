package testNG_TestCases;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.lambdatest.basetest.BaseTest;

public class Testng_Test3 extends BaseTest{
	@Parameters(value = { "url" })
	@Test
	public void handlingJavaScriptAlertBox(String url) {
		Reporter.log("Step 1:Open LambdaTest’s Selenium Playground from",true);
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		
		Reporter.log("<--------Scenario 3: Handling Java Script Alert Box Started-------->", true);
		
		try {
			Reporter.log("Click Javascript Alerts under Alerts and  Modals ",true);
			By jsLink = By.xpath("//a[contains(text(), 'Javascript')]");
			wait.until(ExpectedConditions.elementToBeClickable(jsLink));
			act.click((WebElement) jsLink).perform();
			Thread.sleep(2000);
			Reporter.log("Now click the Click Me button in the Java Script Alert Box section", true);
			driver.findElement(By.xpath("//p[@class=\"text-gray-900 ml-10 text-size-16 mt-10 text-black font-bold\"]//button")).click();
			Thread.sleep(2000);
			Reporter.log("Validate the alert message Please enter your name! and click ok." , true);
			
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			String altText = alert.getText();
			Thread.sleep(2000);
			soft.assertEquals(altText, "Please enter your name");
			alert.sendKeys("Sanjay Waware");
			Thread.sleep(2000);
			alert.accept();
			
			String message = driver.findElement(By.xpath("//p[@id=\"prompt-demo\"]")).getText();
			Thread.sleep(2000);
			soft.assertEquals(message, "You have entered 'Sanjay Waware' !");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		soft.assertAll();
	}
	
}

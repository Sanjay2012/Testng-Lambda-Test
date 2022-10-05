package testNG_TestCases;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.lambdatest.basetest.BaseTest;


public class Testng_Test1 extends BaseTest {
	// locators using By class
		By checkBoxLink= By.linkText("Checkbox Demo");
		By singleCheckBox= By.xpath("//input[@id=\"isAgeSelected\"]");
		
	@Parameters(value = { "url" })
	@Test
	public void checkBoxValidation(String url) throws InterruptedException {
		
		Reporter.log("Step 1:Open LambdaTest’s Selenium Playground from",true);
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

			Reporter.log("<--------Scenario 2: Check Box  validation Started-------->", true);
			Reporter.log("Click Checkbox Demo under Input Forms", true);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30), Duration.ofMillis(500));
			wait.until(ExpectedConditions.elementToBeClickable(checkBoxLink));
			driver.findElement(checkBoxLink).click();
			Thread.sleep(1000);
			Reporter.log("clicked on checkbox demo link", true);
			
			Reporter.log("Click the checkbox under the Single Checkbox Demo section", true);
			wait.until(ExpectedConditions.presenceOfElementLocated(singleCheckBox));
			WebElement checkBox = driver.findElement(singleCheckBox);
			checkBox.click();
			Thread.sleep(1000);
			Reporter.log("clicked on single checkbox", true);
			Reporter.log("Validate whether this checkbox is selected ", true);
			boolean checkedStatus = checkBox.isSelected();
			soft.assertTrue(checkedStatus);
			
			Reporter.log("Now click the checkbox again and validate whether the checkbox is unselected", true);
			//act.moveToElement(singleCheckBox).click().build().perform();
			checkBox.click();
			Thread.sleep(1000);
			boolean uncheckedStatus = checkBox.isSelected();
			soft.assertFalse(uncheckedStatus);
			soft.assertAll();
		
	}
}

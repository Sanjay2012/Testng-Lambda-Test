package testNG_TestCases;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.lambdatest.basetest.BaseTest;

public class Testng_Test2 extends BaseTest {

	// locators using By class
	@FindBy (xpath="//a[contains(text(),'Checkbox')]") WebElement checkBoxLink;
	@FindBy (xpath="//input[@id='isAgeSelected']") WebElement singleCheckBox;
	//By singleCheckBox = By.cssSelector("#isAgeSelected");

	@Test
	public void checkBoxValidation() throws InterruptedException {
		Reporter.log("<--------Scenario 2: Check Box  validation Started-------->", true);
		Reporter.log("Click Checkbox Demo under Input Forms", true);
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30), Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Checkbox Demo"))).click();
			Reporter.log("clicked on checkbox demo link", true);
			Reporter.log("Click the checkbox under the Single Checkbox Demo section", true);
			wait.until(ExpectedConditions.presenceOfElementLocated((By) singleCheckBox));
			WebElement checkBox = driver.findElement((By) singleCheckBox);
			checkBox.click();
			Reporter.log("clicked on single checkbox", true);
			Reporter.log("Validate whether this checkbox is selected ", true);
			soft.assertTrue(checkBox.isSelected());

			Reporter.log("Now click the checkbox again and validate whether the checkbox is unselected", true);
			checkBox.click();
			soft.assertFalse(checkBox.isSelected());
		} catch (Exception e) {
			e.printStackTrace();
		}
		soft.assertAll();

	}
}

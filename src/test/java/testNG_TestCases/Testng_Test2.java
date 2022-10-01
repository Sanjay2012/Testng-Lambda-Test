package testNG_TestCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.lambdatest.basetest.BaseTest;

public class Testng_Test2 extends BaseTest{
	@Test
	public void checkBoxValidation() {
		Reporter.log("<--------Scenario 2: Check Box  validation Started-------->", true);
		
		Reporter.log("Click Checkbox Demo under Input Forms", true); 
		try {
		    wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		    WebElement checkboxLink = driver.findElement(By.xpath("//a[normalize-space()='Checkbox Demo']"));
			wait.until(ExpectedConditions.elementToBeClickable(checkboxLink));
			checkboxLink.click();
			//act.moveToElement(checkboxLink).click(checkboxLink).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		Reporter.log("Click the checkbox under the Single Checkbox Demo section", true);
		

			try {
				WebElement singleCheckBox = driver.findElement(By.cssSelector("#isAgeSelected"));
				
				wait.until(ExpectedConditions.elementToBeClickable(singleCheckBox));
				singleCheckBox.click();
				Reporter.log("Validate whether this checkbox is selected ",true);
				boolean checkedStatus = singleCheckBox.isSelected();
				soft.assertTrue(checkedStatus);
				Reporter.log("Now click the checkbox again and validate whether the checkbox is unselected" , true);
				singleCheckBox.click();
				boolean uncheckedStatus = singleCheckBox.isSelected();
				soft.assertFalse(uncheckedStatus);
			} catch (Exception e) {

				e.printStackTrace();
			}
		soft.assertAll();
	}
	
}

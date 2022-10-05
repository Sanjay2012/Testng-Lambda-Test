package com.lambdatest.basetest;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

public class BaseTest {
	protected RemoteWebDriver driver=null;
	protected String Status = "passed";
	protected Actions act;
	protected SoftAssert soft = new SoftAssert();
	protected Select select;
	protected WebDriverWait wait;
	protected JavascriptExecutor js;

	
	@BeforeMethod
	@Parameters(value = { "browser", "version", "platform" })
	public void setup(Method m, ITestContext ctx, String browser, String version, String platform)
			throws MalformedURLException {
		Reporter.log("<===== Start of Test Method =====>");
		String username = "sanjaywaware04";
		String accesskey = "i6I2yqGQJTSjxYMwkhvy3LHTBHin6XJmTAOpAa729s18AqC5U3";
		String hub = "@hub.lambdatest.com/wd/hub";
		
		Reporter.log("Setting desired Capabilities", true);
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("browserName", browser);
		caps.setCapability("version", version);
		caps.setCapability("platform", platform);
		caps.setCapability("network", true); // To enable network logs
		caps.setCapability("visual", true); // To enable step by step screenshot
		caps.setCapability("video", true); // To enable video recording
		caps.setCapability("console", true); // To capture console logs
		caps.setCapability("build", "Lambda-Test-TESTNG");
		caps.setCapability("name", m.getName() + this.getClass().getName());
		caps.setCapability("plugin", "git-testng");
		
		Reporter.log("Connecting to hub/ Grid", true);
		try {
			driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + hub), caps);
		} catch (MalformedURLException e) {
			System.out.println("Invalid URL");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	@AfterMethod
	public void tearDown() {
		Reporter.log("<+======Ending the Test Method =====>", true);
		Reporter.log("Closing the browser session", true);
		driver.executeScript("lambda-status=" + Status);
		driver.quit();
	}
}

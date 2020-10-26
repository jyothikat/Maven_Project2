package com.testscenarios;

import static org.testng.Assert.assertEquals;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.objectrepository.Locators;
import com.utilities.CommonFunctions;
import com.utilities.StaticVariables;


public class Expedia extends StaticVariables {

	Locators obj = new Locators();
	CommonFunctions cfn = new CommonFunctions();
	
	
	@Parameters({ "browsername" })
	@BeforeClass
	public void setup(@Optional("chrome") String browsername) {
		if (browsername.equalsIgnoreCase("chrome")) {
			cfn.chromeBrowserLaunch();
		} else if (browsername.equalsIgnoreCase("firefox")) {
			cfn.firefoxBrowserLaunch();
		} else if (browsername.equalsIgnoreCase("edge")) {
			cfn.edgeBrowserLaunch();
		} else {
			System.out.println("Please enter the browser name between Chrome, Firefox or Edge");
		}

	}
	

	@Test
	public void f() throws InterruptedException, IOException {

		FileInputStream path = new FileInputStream(".\\TestData\\testdata.properties");
		Properties prop = new Properties();
		prop.load(path);

		driver.get(prop.getProperty("Expedia"));
		driver.manage().window().maximize();
		Thread.sleep(3000);

		cfn.clickByAnyLocator(obj.FLIGHTS_LINK);
		Thread.sleep(2000);

		// Select origin
		cfn.clickByAnyLocator(obj.LEAVINGFROM_BUTTON);
		Thread.sleep(2000);
		cfn.clickByAnyLocator(obj.ORIGIN_INPUT);
		cfn.sendKeysByAnyLocator(obj.ORIGIN_INPUT, prop.getProperty("Origin"));
		Thread.sleep(2000);
		cfn.clickByAnyLocator(obj.ORIGIN1_INPUT);
		Thread.sleep(2000);

		// Select Destination
		cfn.clickByAnyLocator(obj.GOINGTO_BUTTON);
		Thread.sleep(2000);
		cfn.clickByAnyLocator(obj.DESTINATION_INPUT);
		cfn.sendKeysByAnyLocator(obj.DESTINATION_INPUT, prop.getProperty("Destination"));
		Thread.sleep(2000);
		cfn.clickByAnyLocator(obj.DESTINATION1_INPUT);
		Thread.sleep(2000);

		// Select date
		cfn.clickByAnyLocator(obj.TRAVEL_DATE);
		Thread.sleep(2000);
		cfn.clickByAnyLocator(obj.DEPART_DATE);
		Thread.sleep(2000);
		cfn.clickByAnyLocator(obj.RETURN_DATE);
		Thread.sleep(2000);
		cfn.clickByAnyLocator(obj.DONE_BUTTON);
		Thread.sleep(3000);
		
		cfn.takescreenshotWithTimestamp("Expedia");
		
		cfn.clickByAnyLocator(obj.SEARCH_BUTTON);
		cfn.implicitWait(25);

		String actualtext1 = driver.findElement(obj.TEXTVALIDATION).getText();
		String expectedtext1 = "Hyderabad (HYD) - Delhi (DEL)";
		assertEquals(actualtext1, expectedtext1);

	}

	
	@AfterMethod
	public void takescreenshot() throws IOException {

		cfn.takescreenshotWithTimestamp("Expedia");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}

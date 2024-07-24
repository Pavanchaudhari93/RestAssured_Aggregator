package test;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import CommonLibs.Implementation.Base;
import CommonLibs.Implementation.DataReader;
import PageObject.SamplePageObject;

public class Google extends Base{
	
	@BeforeMethod
	public void beforeMethod() {
		startTest("Google", "Test");
		openDriver();
	}

	@DataProvider(name = "data-provider")
    public Object[][] dataProviderMethod() {
		return DataReader.getSheetTCData(".\\src\\main\\resources\\Test Data\\New Microsoft Excel Worksheet.xlsx", "DataReaderSheet", "Google");
    }    
	
	@Test (dataProvider = "data-provider")
    public void testMethod(String merID, String custID, String Amount, String dc, String date) throws IOException, InterruptedException {
		SamplePageObject.openGoogleURL();
		SamplePageObject.clickOnGoogleButton("Google Search");
		SamplePageObject.searchTest(merID);
	}
	
	@AfterMethod
	public void AfterMethod(ITestResult result) {
		endTest(result);
		quitDriver();
	}

}

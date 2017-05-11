package testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pages.HomePage;
import pages.LoginPage;
import utility.CaptureScreenShot;
import factory.BrowserFactory;
import factory.DataProviderFactory;

public class VerifyLoginPage {
	
WebDriver driver;
ExtentReports reports;
ExtentTest test;
	
	@BeforeMethod
	public void setUp() throws IOException
	{
		reports = new ExtentReports("./Reports/loginpageReports.html", true);
		test = reports.startTest("avactis.com login Page");
		driver = BrowserFactory.getBrowser("edge");
		driver.get(DataProviderFactory.getConfig().getURL());
		test.log(LogStatus.INFO, "Application is up and running.");
	}
	
	@Test
	public void testLoginPage() throws IOException
	//DataProviderFactory.getExcel().getCellData(sheetName, colNum, rowNum)
	{
		
		//Now because i am dealing with HomePage first so i will use Selenium's PageFactory class, invoke initElements method
		//on it which takes current driver and HomePage.class as parameters (wq:values we want to pass to HomePage to get HomePage working)
		HomePage home = PageFactory.initElements(driver, HomePage.class);//HomePage.class will return the object of HomePage.java class
		
		System.out.println("Home Page Title is: "+ home.getApplicationTitle());
		Assert.assertTrue(home.getApplicationTitle().contains("Avactis Demo"));
		test.log(LogStatus.PASS, "Home Page Title has been verified");
		home.clickLoginLink();
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.loginApplication(DataProviderFactory.getExcel().getData("LoginData", 0, 0),DataProviderFactory.getExcel().getData(0, 0, 1));
		System.out.println("LogOut Link Text is:" +login.getLogOutLinkText());
		Assert.assertTrue(login.getLogOutLinkText().contains("Log Out"));
		test.log(LogStatus.PASS, "Log Out Link Text is Log Out");
		
		
	}
	
	@AfterMethod
	public void screenShots(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(LogStatus.INFO, "This Test has Passed");
			test.log(LogStatus.PASS, test.addScreenCapture(CaptureScreenShot.getScreenshot(driver, result.getName())));
			
		}
		else
			test.log(LogStatus.FAIL, test.addScreenCapture(CaptureScreenShot.getScreenshot(driver, result.getName())));
					
	}
	
	
	@AfterClass
	public void tearDown()
	{
		BrowserFactory.closeBrowser(driver);
		reports.endTest(test);
		reports.flush();
	}
	

}




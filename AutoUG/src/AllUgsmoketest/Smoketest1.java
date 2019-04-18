package AllUgsmoketest;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.apache.commons.collections4.FactoryUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.mongodb.MapReduceCommand.OutputType;

import excelreaderutility.Xls_Reader;
import ugprofunctionality.logoutUG;
import ugprofunctionality.onlylogout;
//import com.utility.CaptureScreenShot;

import java.io.File;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class Smoketest1 
{
	public static Xls_Reader reader;
	static ExtentHtmlReporter htmlReporter;
	static ExtentReports extent;
	static ExtentTest test;
	public static String serverurl;
	public static WebDriver driver;
	static String str="Test executed on:";

	//public static void main(String[] args) throws InterruptedException {
	// TODO Auto-generated method stub
	//Code for test 1 and test 2 smoke test case.
	@BeforeSuite
	public static void setup() throws InterruptedException
	{
		reader = new Xls_Reader("E:\\Test.xlsx");
		Thread.sleep(2000);
		serverurl=reader.getCellData("ST1", "UGURL", 2);
		htmlReporter = new ExtentHtmlReporter("Smoketest1report.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);


		// creates a toggle for the given test, adds all log events under it    

		// log(Status, details)
		Thread.sleep(2000);

		System.setProperty("webdriver.chrome.driver", "C:\\sdriver\\chromedriver.exe");
		driver= new ChromeDriver();

	}
	@Test(priority=1)
	//public static void testloginuser(String[] args) throws InterruptedException
	public static void testloginuser() throws InterruptedException, IOException 
	{
		try
		{
			Thread.sleep(2000);
			

			test = extent.createTest("SmokeTest1", "THis test is to validate Logout and click on all setup menu options functionality");
			test.log(Status.INFO, str +" " +serverurl);
			test.log(Status.INFO, "This step shows User should be able to do login succcesfully");


			userlogin.login(driver);
			test.pass("User is able to do login succesfully");
		}
		catch(Exception e)
		{

			// log with snapshot
			//	test.fail("User is not able to do login succesfully", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
			test.fail("User is not able to do login succesfully");
			Assert.fail();

			// test with snapshot
			//test.addScreenCaptureFromPath("screenshot.png");
		}
	}
	@Test(priority=2)

	public static void ClickonCentralSetupandlogoutfunc() throws InterruptedException, IOException
	{

		try
		{
			// test = extent.createTest("SmokeTest1", "THis test is to validate Logout and clcik on all setup menu options functionality");
			test.log(Status.INFO, "This step shows User should be able to click on central setup or not");


			Thread.sleep(2000);

			driver.findElement(By.linkText("Central setup")).click();
			Thread.sleep(3000);
			onlylogout.outapp(driver);
			Thread.sleep(4000);
			test.pass("User is able to click on Central setup option");

		}

		catch(Exception e)
		{


			test.fail("User is not able to Click on the Central setup");

			Assert.fail();
		}
	}
	//Switched for parent frame=F0 because it was not able to come outside from F12 frame so i switched)


	@Test(priority=3)
	public static void ClickonDepartmentalsetupandlogout() throws InterruptedException, IOException
	{

		try
		{
			// test = extent.createTest("SmokeTest1", "THis test is to validate Logout and clcik on all setup menu options functionality");
			test.log(Status.INFO, "This step shows User is able to click on Departmental setup or not");


			userlogin.login(driver);
			Thread.sleep(2000);

			driver.findElement(By.xpath("//a[text()='Departmental setup']")).click();
			Thread.sleep(3000);

			//Switched for parent frame=F0 because it was not able to come outside from F12 frame so i switched)

			onlylogout.outapp(driver);
			test.pass("User is able to click on Departmental setup option");
		}

		catch(Exception e)
		{

			// log with snapshot
			test.fail("User is not able to Click on the Departmental setup");
			// test with snapshot
			//test.addScreenCaptureFromPath("screenshot.png");
			Assert.fail();
		}
	}
	@Test(priority=4)
	public static void Clickonschedule() throws InterruptedException, IOException
	{
		try
		{
			// test = extent.createTest("SmokeTest1", "THis test is to validate Logout and clcik on all setup menu options functionality");
			test.log(Status.INFO, "This step shows User is able to click on Schedule setup or not and able to do logout");


			Thread.sleep(3000);
			userlogin.login(driver);
			Thread.sleep(3000);

			driver.findElement(By.xpath("//div[@id='accountGroupDetail_0']//div[2]/a")).click(); // removed a
			Thread.sleep(10000);

			//Switched for parent frame=F0 because it was not able to come outside from F12 frame so i switched)

			driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f11']")));
			Thread.sleep(3000);
			//div[@class='tabbar1']//span[@title='F5 | Individual']
			
			driver.findElement(By.xpath("//div[@class='tabbar2']//span[@title='F5 | Individual']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//div[@class='but right']/img")).click();
			Thread.sleep(3000);

			test.pass("User is able to click on Schedule setup option and logout");
		}
		catch (NoAlertPresentException exception)
		{

			test.pass("User is able to click on the Schedule and logout");




		}

		
		catch(Exception e)
		{

			test.fail("User is not able to Click on the Schedule setup and logout");

			// test with snapshot
			//test.addScreenCaptureFromPath("screenshot.png");
			Assert.fail();
		}
	}




	@AfterSuite
	public static void teardown() throws InterruptedException
	{
		extent.flush();
		driver.quit();
		Thread.sleep(3000);
	}


}

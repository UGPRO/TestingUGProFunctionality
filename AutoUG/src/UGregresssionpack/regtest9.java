package UGregresssionpack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import AllUgsmoketest.framecheck;
import AllUgsmoketest.userlogin;
import excelreaderutility.Xls_Reader;
import ugprofunctionality.creatingnewloc;
import ugprofunctionality.sitecreation;

public class regtest9 {

	public	static WebDriver driver;

	public static Xls_Reader reader;

	static String CreateNSite	;
	static String CreateNewSiteAbrev;	
	static String CreateNewLoc	;
	static String CreateNewLocabrev;
	static String sitechangedname;

	public static String serverurl;
	static ExtentHtmlReporter htmlReporter19;
	static ExtentReports extent19;
	static ExtentTest test19;
	static String str="Test executed on:";

	@BeforeSuite
	public static void setup() throws InterruptedException
	{

		reader = new Xls_Reader("C:\\Users\\akhosla\\Documents\\regexcelsheet.xlsx");
		serverurl=reader.getCellData("reg1", "UGURL", 2);
		Thread.sleep(2000);

		CreateNSite	=reader.getCellData("reg9", "Create NewSite", 2);
		CreateNewSiteAbrev	=reader.getCellData("reg9", "Create NewSite Abrev", 2);
		CreateNewLoc	=reader.getCellData("reg9", "Create New Loc", 2);
		CreateNewLocabrev	=reader.getCellData("reg9", "Create New Loc abrev", 2);
		sitechangedname	=reader.getCellData("reg9", "ChangedSiteName", 2);



		htmlReporter19 = new ExtentHtmlReporter("Regressiontest9report.html");
		extent19 = new ExtentReports();
		extent19.attachReporter(htmlReporter19);

		/*	htmlReporter2 = new ExtentHtmlReporter("Smoketest3report.html");
		extent2 = new ExtentReports();
		extent2.attachReporter(htmlReporter2); */

		System.setProperty("webdriver.chrome.driver", "C:\\sdriver\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);


	}

	@Test(priority=1)
	public static void createnewsite() throws InterruptedException
	{
		try
		{
			test19 = extent19.createTest("Regressiontest9", "This test will verify Sites and Locations functionality ");

			test19.log(Status.INFO, str +" " +serverurl);
			test19.log(Status.INFO, "This step will Create a new site");
			
			
			userlogin.login(driver);
			driver.findElement(By.linkText("Central setup")).click();
			Thread.sleep(2000);




			driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f12']")));

			sitecreation.creatingnewsite(driver);
			Thread.sleep(7000);


			driver.switchTo().alert();
			Thread.sleep(6000);

			throw new Exception();
		}
		catch (NoAlertPresentException exception)
		{

			test19.pass("User is able to create a new site");




		}
		catch(Exception e)
		{
			test19.fail("User is not able to create a new site");	
			Assert.fail();
		}
	}



	//Creating new location.
	@Test(priority=2)
	public static void createnewloc() throws InterruptedException
	{
		try
		{
			test19.log(Status.INFO, "This step will Create a new location and will change the site of the location to [Select] and save");
			creatingnewloc.newloccreation(driver);


			Thread.sleep(1000);

			driver.switchTo().alert().accept();
			Thread.sleep(2000);

			Select la1=new Select(driver.findElement(By.xpath("//select[@id='txtLocSite']")));
			la1.selectByVisibleText(CreateNSite); 

			driver.findElement(By.xpath("//button[@id='butSave']")).click();


			driver.switchTo().alert();
			Thread.sleep(6000);

			throw new Exception();
		}
		catch (NoAlertPresentException exception)
		{

			test19.pass("User is able to create a new location and error popup is showing if no site of the location is selected. ");




		}
		catch(Exception e)
		{
			test19.fail("User is not able to create a new location and error poup is not showing if user is saving value aftee selecting [Select] from dropdown");	
			Assert.fail();
		}
	}
	@Test(priority=3)
	public static void deletingnewsite() throws InterruptedException
	{
		try
		{
			test19.log(Status.INFO, "This step will delete the new site to check error popup if the site has a relation with one or more locations");
			Thread.sleep(3000);

			//to check error after deleting site.
			framecheck.checkframe12(driver);
			driver.findElement(By.xpath("//div[@id='menuItem_28']")).click(); //click on Sites option
			Thread.sleep(5000);

			framecheck.checkframe11(driver);
			Thread.sleep(2000);

			driver.findElement(By.xpath("//td[text()='" +CreateNSite + "']//following::td[2]//img")).click();  //deleting site
			Thread.sleep(1000);
			driver.switchTo().alert().accept();
			Thread.sleep(1000);
			driver.switchTo().alert().accept();
			Thread.sleep(2000);

			test19.pass("User is able to see error poup while deleting site if the site has a relation with one or more locations ");	
		}
		catch(Exception e)
		{
			test19.fail("User is not able to see error poup  while deleting site if the site has a relation with one or more locations ");	
			Assert.fail();
		}
	}

	@Test(priority=4)
	public static void changethesiteoflocationanddeleteit() throws InterruptedException
	{
		try
		{
			test19.log(Status.INFO, "This step will Change the site of the location linked to the new site. Delete the new site and recreate it with the exact same parameters.");
			framecheck.checkframe12(driver);
			//Change the site of the location linked to the new site. Delete the new site and recreate it with the exact same parameters.
			//deleting the new site and creating with same parameters.


			driver.findElement(By.xpath("//div[@id='menuItem_9']")).click();  // changing the site of the location
			Thread.sleep(2000);
			framecheck.checkframe11(driver);
			driver.findElement(By.xpath("//td[text()='" +CreateNewLoc + "']")).click();
			Thread.sleep(2000);
			Select la2=new Select(driver.findElement(By.xpath("//select[@id='txtLocSite']")));
			la2.selectByVisibleText(sitechangedname); 
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@id='butSave']")).click();
			Thread.sleep(3000);
			driver.switchTo().alert();
			Thread.sleep(6000);

			throw new Exception();
		}
		catch (NoAlertPresentException exception)
		{

			test19.pass("User is able to chnage the site of the location and after deleting able to recreate with the same parameters");




		}
		catch(Exception e)
		{
			test19.fail("User is not able to chnage the site of the location and after deleting able to recreate with the same parameters");	
			Assert.fail();
		}
	}


	@Test(priority=5)
	public static void deletesiteandrecreatewithsameparameters()
	{
		try
		{
			test19.log(Status.INFO, "This step will Delete the new site and recreate it with the exact same parameters.");

			framecheck.checkframe12(driver);
			driver.findElement(By.xpath("//div[@id='menuItem_28']")).click(); //click on Sites option
			Thread.sleep(5000);

			framecheck.checkframe11(driver);
			Thread.sleep(2000);

			driver.findElement(By.xpath("//td[text()='" +CreateNSite + "']//following::td[2]//img")).click();  //deleting site
			Thread.sleep(1000);
			driver.switchTo().alert().accept();
			Thread.sleep(2000);



			framecheck.checkframe12(driver);

			//again creating site with the same name and param.

			sitecreation.creatingnewsite(driver);
			driver.switchTo().alert();
			Thread.sleep(6000);

			throw new Exception();
		}
		catch (NoAlertPresentException exception)
		{

			test19.pass("User is able to delete the site and able to recreate with the same parameters");




		}
		catch(Exception e)
		{
			test19.fail("User is not able to delete the site and able to recreate with the same parameters");	
			Assert.fail();
		}
	}

	@AfterSuite
	public static void teardown()
	{
		extent19.flush();
		driver.quit();			
	}
	//tr//td[text()='mayloc']//following::td[2]//img
}

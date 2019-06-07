package UGregresssionpack;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import AllUgsmoketest.framecheck;
import AllUgsmoketest.userlogin;
import excelreaderutility.Xls_Reader;
import org.testng.Assert;
import ugprofunctionality.FreemultiYN;
import ugprofunctionality.PracticesYN;
import ugprofunctionality.StaffRegYN;
import ugprofunctionality.bookstartpat;
import ugprofunctionality.logoutUG;
import ugprofunctionality.referrallistyn;
import ugprofunctionality.regpatientavailforapnt;
import ugprofunctionality.regpatinetavailforwaitinglist;
import ugprofunctionality.setupbtnandactdeactsetting;
import ugprofunctionality.waitinglistYN;
import ugprofunctionality.ugtrackproactdeact;

public class regtest3  {
	static String  Differentactions;
	static ExtentHtmlReporter htmlReporter13;
	static ExtentReports extent13;
	static ExtentTest test13;

	public static WebDriver driver;
	public  static Xls_Reader reader;
	static String str="Test executed on:";
	static String serverurl;

	@BeforeSuite
	public static void setup() throws InterruptedException 
	{
		reader = new Xls_Reader("C:\\Users\\akhosla\\Documents\\regexcelsheet.xlsx");
		serverurl=reader.getCellData("reg1", "UGURL", 2);

		
		Differentactions = reader.getCellData("reg3", "Actions-Session", 2);
		
		htmlReporter13 = new ExtentHtmlReporter("Regressiontest3report.html");
		extent13 = new ExtentReports();
		extent13.attachReporter(htmlReporter13);





		System.setProperty("webdriver.chrome.driver", "C:\\sdriver\\chromedriver.exe");
		 driver= new ChromeDriver();
	}
	
	@Test(priority=1)
	public static void practicesinuseyn() throws InterruptedException
	{
		try

		{

			test13 = extent13.createTest("RegressionTest3", "This test is to Validate System settings ACtivate-Deactivate Features");
			test13.log(Status.INFO, str +" " +serverurl);
			test13.log(Status.INFO, "This step will activate deactivate practices functionality");
			userlogin.login(driver);


			//Functionality practices on yes and no.
			//-----------------------------------------------------------------------------------------------------------------------------------------------------------
			PracticesYN.PractY(driver);


			//Thread.sleep(2000);



			Thread.sleep(6000);

			logoutUG.logoffug(driver);

			PracticesYN.PractN(driver);


			Thread.sleep(6000);

			logoutUG.logoffug(driver);



			driver.findElement(By.linkText("Central setup")).click();
			Thread.sleep(2000);

			driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f12']")));

			Thread.sleep(2000);
			driver.findElement(By.xpath("(//div[@class='menuButton'])[3]")).click();   // Clicking on the Central Administration.

			// Following Sleep to see , Practices is getting disappear or not.

			Thread.sleep(5000);

			test13.pass("Functionality related with practices is working fine");
			//---------------------------------------------------------------------------------------------------------------------------------------------------------
		}
		catch(Exception e)
		{
			test13.fail("Functionality related with practices is not working fine");
			
			
		Assert.fail();
		}
	}

	@Test(priority=2)
	public static void staafregYN() throws InterruptedException
	{

		try
		{

			test13.log(Status.INFO, "This step will activate and deactivate staff registration functionality");
			// Functionality Staff registration in use.

			StaffRegYN.staffregY(driver);
			framecheck.checkframe11(driver);

			driver.findElement(By.xpath("//table[@id='CalTable_menu']//tr[6]/td[2]")).click();  // clicking on the Particular slot

			framecheck.checkframe12(driver);

			Thread.sleep(4000);
			driver.findElement(By.xpath("//div[@class='actionsHyperlinkClass']")).click();  //clicking on the actions dropdown.
			Thread.sleep(3000);
			Actions act = new Actions(driver);
			act.moveToElement(driver.findElement(By.xpath("//td[text()='" +  Differentactions + "']"))).doubleClick().build().perform(); //Clicking on the actions dropdown options.

			Thread.sleep(4000);
			driver.findElement(By.xpath("//button[@class='ug-button'  and  text()='Cancel']")).click();   // Clicking on the Cancel button.
			Thread.sleep(3000);

			driver.switchTo().defaultContent();
			setupbtnandactdeactsetting.Activatesettings(driver);
			//--------------------------------------------------------------------------------------------------------------------------------------------------------
			// below line for staff registration on No
			Thread.sleep(3000);
			StaffRegYN.staffregN(driver);

			framecheck.checkframe11(driver);

			driver.findElement(By.xpath("//table[@id='CalTable_menu']//tr[6]/td[2]")).click();
			Thread.sleep(2000);
			framecheck.checkframe12(driver);

			driver.findElement(By.xpath("//div[@class='actionsHyperlinkClass']")).click();  //clicking on the actions dropdown.
			Thread.sleep(3000);
			Actions act1 = new Actions(driver);
			act1.moveToElement(driver.findElement(By.xpath("//td[text()='" +  Differentactions + "']"))).doubleClick().build().perform(); //Clicking on the actions dropdown options.
			Thread.sleep(4000);
			driver.findElement(By.xpath("//button[@class='ug-button'  and  text()='Cancel']")).click();   // Clicking on the Cancel button.
			Thread.sleep(6000);

			driver.switchTo().alert();
			Thread.sleep(6000);

			throw new Exception();
		}
		catch (NoAlertPresentException exception)
		{

			test13.pass("Functionality related with staff registration activation and deactivation is working fine");



		}



		catch(Exception e)
		{
			test13.fail("Functionality related with staff registration activation and deactivation is not working fine");
			Assert.fail();
		}
	}

	@Test(priority=3)
	public static void waitinglistyn() throws InterruptedException
	{
		try
		{

			test13.log(Status.INFO, "This step will activate deactivate waiting list in use functionality");
			driver.switchTo().defaultContent();

			//button[@class='ug-button'  and  text()='Cancel']
			setupbtnandactdeactsetting.Activatesettings(driver);

			//------------------------------------------------------------------------------------------------------------------------------------------------------
			//waiting list functionality.

			waitinglistYN.waitlistY(driver);

			setupbtnandactdeactsetting.Activatesettings(driver);

			waitinglistYN.waitlistN(driver);


			test13.pass("Activation and deactivation of waiting list functionality is in use is working fine ");




		}

		
		catch(Exception e)
		{
			test13.fail("Activation and deactivation of waiting list functionality is in use is not working fine ");
			Assert.fail();
		}
	}
	@Test(priority=4)
	public static void regpatavailforapntYN() throws InterruptedException
	{

		try
		{
			test13.log(Status.INFO, "This step will activate deactivate registration patient availablity for appointment  functionality");
			setupbtnandactdeactsetting.Activatesettings(driver);
			//-------------------------------------------------------------------------------------------------------------------------------------------------------


			//registration patient avail for appointment functionality
			//When booking an appointment an extra line with patient availability should appear during the last step.



			regpatientavailforapnt.rpaY(driver);

			setupbtnandactdeactsetting.Activatesettings(driver);

			regpatientavailforapnt.rpaN(driver);
			Thread.sleep(2000);


			driver.switchTo().alert();
			Thread.sleep(6000);

			throw new Exception();




		}

		catch (NoAlertPresentException exception)
		{

			test13.pass("Activation and deactivation of registration patient  availablity for appointment funtionality is working fine ");

		


		}
		catch(Exception e)
		{
			test13.fail("Activation and deactivation of registration patient  availablity for appointment funtionality is not working fine ");
			Assert.fail();
		}
	}

	@Test(priority=5)
	public static void freemultiuseyn() throws InterruptedException
	{

		try
		{


			test13.log(Status.INFO, "This step will activate deactivate Free multi use functionality");
			setupbtnandactdeactsetting.Activatesettings(driver);




			//--------------------------------------------------------------------------------------------------------------------------------------------------------
			// free multi use functionality

			FreemultiYN.freemultY(driver);

			setupbtnandactdeactsetting.Activatesettings(driver);

			FreemultiYN.freemultN(driver);

			setupbtnandactdeactsetting.Activatesettings(driver);
			Thread.sleep(2000);
			driver.switchTo().alert();
			Thread.sleep(6000);

			throw new Exception();
		}


		catch (NoAlertPresentException exception)
		{

			test13.pass("Activation and deactivation of Free multi use functionality is working fine ");




		}
		catch(Exception e)
		{
			test13.fail("Activation and deactivation of free multi use functionality iss not working fine ");
			Assert.fail();
		}
	}//---------------------------------------------------------------------------------------------------------------------------------------------------------
	@Test(priority=6)
	public static void bookingprocessstartwithpat() throws InterruptedException
	{
		try
		{
			test13.log(Status.INFO, "This step will activate deactivate booking procees start with patient functionality");
			//Functionality booking process start with patient.

			bookstartpat.startbookpatY(driver);

			driver.switchTo().defaultContent();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//span[@class='modal-close-button']")).click();
			Thread.sleep(3000);

			driver.switchTo().defaultContent();

			setupbtnandactdeactsetting.Activatesettings(driver);

			bookstartpat.startbookpatN(driver);

			Thread.sleep(2000);
			driver.switchTo().alert();
			Thread.sleep(6000);

			throw new Exception();
		}

		catch (NoAlertPresentException exception)
		{

			test13.pass("Activation and deactivation of booking process start with patient is working fine ");




		}

		catch(Exception e)
		{
			test13.fail("Activation and deactivation of booking process start with patient is not working fine");
			Assert.fail();
		}
	}

	@Test(priority=7)
	public static void UGtrackproinyn()
	{
		try
		{

			test13.log(Status.INFO, "This step will activate deactivate UG tack pro in use functionality");
			driver.switchTo().defaultContent();

			//---------------------------------------------------------------------------------------------------------------------------------------------------------------	 

			//Functionality UG track pro in use or not.

			setupbtnandactdeactsetting.Activatesettings(driver);

			ugtrackproactdeact.trackproactdeactY(driver);

			// setupbtnandactdeactsetting.Activatesettings(driver);

			ugtrackproactdeact.trackproactdeactN(driver);


			Thread.sleep(2000);
			driver.switchTo().alert();
			Thread.sleep(6000);

			throw new Exception();
		}

		catch (NoAlertPresentException exception)
		{

			test13.pass("Activation and deactivation of UG track pro in use functionality is working fine");




		}

		catch(Exception e)
		{
			test13.fail("Activation and deactivation of UG track pro in use functionality is not working fine ");
			Assert.fail();
		}
	}
	@Test(priority=8)
	public static void regpatientavailforwaitinglistentries()
	{
		try
		{
			test13.log(Status.INFO, "This step will activate deactivate Registration patient availability for waiting list entries functionality");
			//-------------------------------------------------------------------------------------------------------------------------------------------------------------	 
			//Functionality Registration patient availability for waiting list entries. 


			regpatinetavailforwaitinglist.rpaWY(driver);

			setupbtnandactdeactsetting.Activatesettings(driver);

			regpatinetavailforwaitinglist.rpaWN(driver);


			Thread.sleep(2000);	

			driver.switchTo().alert();
			Thread.sleep(6000);

			throw new Exception();
		}
		catch (NoAlertPresentException exception)
		{

			test13.pass("Activation and deactivation of registration availablilty for waitiing list entries functionality is working fine");




		}

		catch(Exception e)
		{
			test13.fail("Activation and deactivation of  registration availablilty for waitiing list entries functionality is not working fine");
			Assert.fail();
		}
	}

	@Test(priority=9)
	public static void referallistandactdeact()
	{


		try
		{
			test13.log(Status.INFO, "This step will activate deactivate referral list activation and deactivation functionality");

			// setupbtnandactdeactsetting.Activatesettings(driver);


			//-----------------------------------------------------------------------------------------------------------------------------------------------------------		 
			//Functionality referral list in use

			referrallistyn.listrefY(driver);

			setupbtnandactdeactsetting.Activatesettings(driver);

			referrallistyn.listrefN(driver);

			setupbtnandactdeactsetting.Activatesettings(driver);

			Thread.sleep(2000);
			driver.switchTo().alert();
			Thread.sleep(6000);

			throw new Exception();
		}

		catch (NoAlertPresentException exception)
		{

			test13.pass("Activation and deactivation of referral list in use functionality is working fine");




		}


		catch(Exception e)
		{
			test13.fail("Activation and deactivation of referral list in use functionality is not working fine");

			Assert.fail();
		}
	}
	//-------------------------------------------------------------------------------------------------------------------	 
	//Pending-Show appointment for other schedules.




	@AfterSuite
	public static void teardown()
	{
		extent13.flush();
		driver.quit();
	}










}



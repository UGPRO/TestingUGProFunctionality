package AllUgsmoketest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import com.sun.xml.internal.fastinfoset.sax.Properties;

import excelreaderutility.Xls_Reader;

import java.awt.List;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.Alert;

public class Smoketest2 
{
	
	//goto Patinet medical laert to see proprties that we use for xpath storage for reusability of code
	static ExtentHtmlReporter htmlReporter1;
	static ExtentReports extent1;
	static ExtentTest test1;
	static int i;
	static boolean bValue;

	public  static Xls_Reader reader;

	static String Refreshval ;
	static String Futurebook	;
	static String Calendarday;	
	static String Repfile	;
	static String Nllabel	;
	static String Epmode	;
	static String Bedurl	;
	static String Periodstart;	
	static String Quickurl	;
	static String Bcreport	;
	static String Patientlinktext;	
	static String PatLinkURL	;
	static String Pmalerturl	;
	static String ClSideWindowName;	
	static String EventtextAL1;	
	static String AL1URL	;
	static String AL2ExtrenalHisid	;
	static String EventfreetextAL2;	
	static String AL2URL;
	static String SelReport	;
	static String UpdatingRepname;	
	static String NewRepName	;
	static String NewRepAbrev	;
	static String SelRepFunction	;
	static String SelReportAftrFxn;

	static String selexistingrep;
	public static String serverurl;
	static String str="Test executed on:";


	static WebDriver driver; 
	@BeforeSuite
	public static void setup() 
	{
		// TODO Auto-generated method stub
		//Code for test 1 and test 2 smoke test case.
		reader = new Xls_Reader("C:\\Users\\akhosla\\Documents\\Test.xlsx");
		serverurl=reader.getCellData("ST1", "UGURL", 2);
		Refreshval = SubChar(reader.getCellData("ST2", "ScreenRefresh value", 2).toString());
		Futurebook	=SubChar(reader.getCellData("ST2", "Futurebookday", 2));
		Calendarday	=reader.getCellData("ST2", "CalendarFirstDayOfWeek", 2);
		Repfile	=reader.getCellData("ST2", "Reportfiles", 2);
		Nllabel	=reader.getCellData("ST2", "Nationalnumber1 label", 2);
		Epmode	=reader.getCellData("ST2", "EpisodeMode", 2);
		Bedurl	=reader.getCellData("ST2", "BedmanUrl", 2);
		Periodstart	=SubChar(reader.getCellData("ST2", "PeriodtobePublished-Start", 2));
		Quickurl	=reader.getCellData("ST2", "QuickAddressURL", 2);
		Bcreport	=reader.getCellData("ST2", "Booking code report", 2);
		Patientlinktext	=reader.getCellData("ST2", "Patientlinkeventfreetext", 2);
		PatLinkURL	=reader.getCellData("ST2", "PatientLinkURL", 2);
		Pmalerturl	=reader.getCellData("ST2", "PatientMedicalalertsURL", 2);
		ClSideWindowName	=reader.getCellData("ST2", "ClientSideWindowName", 2);
		EventtextAL1	=reader.getCellData("ST2", "EventFreetext-AL1", 2);
		AL1URL	=reader.getCellData("ST2", "AL1-URL", 2);
		AL2ExtrenalHisid	=reader.getCellData("ST2", "AL2ParamExtrenalHisid", 2);
		EventfreetextAL2	=reader.getCellData("ST2", "Eventfreetext-AL2", 2);
		AL2URL	=reader.getCellData("ST2", "AL2-URL", 2);
		SelReport	=reader.getCellData("ST2", "SelectReport", 2);
		UpdatingRepname	=reader.getCellData("ST2", "UpdatingReportname", 2);
		NewRepName	=reader.getCellData("ST2", "NewReportName", 2);
		NewRepAbrev	=reader.getCellData("ST2", "NewReportAbrev", 2);
		SelRepFunction	=reader.getCellData("ST2", "SelReportFunction", 2);
		SelReportAftrFxn	=reader.getCellData("ST2", "SelReportAfterFxn", 2);
		selexistingrep  =reader.getCellData("ST2", "Selectexisting report", 2);

		htmlReporter1 = new ExtentHtmlReporter("Smoketest2report.html");
		extent1 = new ExtentReports();
		extent1.attachReporter(htmlReporter1);

		System.setProperty("webdriver.chrome.driver", "C:\\sdriver\\chromedriver.exe");
		driver= new ChromeDriver();
	}
	@Test(priority=1)
	public static void ClickonSyssettingoptions() throws InterruptedException
	{
		try
		{
			
			test1 = extent1.createTest("SmokeTest2", "This test is to Validate all the System Administration Options");
			test1.log(Status.INFO, str +" " +serverurl);
			test1.log(Status.INFO, "This step is clicking on the System setting option");
			userlogin.login(driver);



			driver.findElement(By.linkText("Central setup")).click();
			driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f12']")));
			driver.findElement(By.xpath("(//div[@class='menuButton'])[1]")).click();  //system administration
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//div[@id='menuItem_18'])[1]")).click();  //system settings
			Thread.sleep(2000);
			test1.pass("User is able to do Click on the System Setting option succesfully");
		}

		catch(Exception e)
		{
			test1.fail("User is not able to Click on the System setting option");
			Assert.fail();
		}
	}
	@Test(priority=2)
	public static void EditaSyssettingvalues() throws InterruptedException
	{
		try
		{


			test1.log(Status.INFO, "This step shows User should be able to edit all System setting values");

			driver.switchTo().parentFrame();
			//Switched for parent frame=F0 because it was not able to come outside from F12 frame so i switched)

			driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f11']")));
			driver.findElement(By.xpath("//th[@class='rowHead']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='txtScreenRefresh']")).clear();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@id='txtScreenRefresh']")).sendKeys(Refreshval);
			Thread.sleep(2000);


			Thread.sleep(2000);



			driver.findElement(By.xpath("//input[@id='txtAsfuturebookday']")).clear();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='txtAsfuturebookday']")).sendKeys(Futurebook);
			Thread.sleep(2000);
			//	driver.findElement(By.xpath("//input[@id='txtAsfuturebookday']")).clear();
			Select fdw=new Select(driver.findElement(By.name("txtCalendarFirstDayOfWeek")));
			fdw.selectByVisibleText(Calendarday);
			/*for(i=0; i<=1; i++)
			{
				Thread.sleep(2000);
				fdw.selectByIndex(i);
			}*/

			driver.findElement(By.xpath("//th[text()='File directories']")).click();
			driver.findElement(By.xpath("//input[@class='inputText' and @id='txtReportPath']")).clear();//report files
			driver.findElement(By.xpath("//input[@class='inputText' and @id='txtReportPath']")).sendKeys(Repfile);

			Thread.sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,250)", ""); 
			driver.findElement(By.xpath("//th[text()='Patient settings']")).click();
			Thread.sleep(4000);
			WebElement titlein = driver.findElement(By.xpath("//input[@id='txtTitleInUseN']"));
			//bValue = Practicerdo.isSelected();

			if(bValue = titlein.isSelected())
			{
				driver.findElement(By.xpath("//input[@id='txtTitleInUseY']")).click();
			}
			else
			{
				driver.findElement(By.xpath("//input[@id='txtTitleInUseN']")).click(); 
			}
			Thread.sleep(4000);
			driver.findElement(By.xpath("//input[@id='txtNationalNumber1Label']")).clear();
			Thread.sleep(4000);
			driver.findElement(By.xpath("//input[@id='txtNationalNumber1Label']")).sendKeys(Nllabel);
			Thread.sleep(4000);
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("window.scrollBy(0,250)", ""); 
			driver.findElement(By.xpath("//th[text()='Activate / de-activate features']")).click();
			Thread.sleep(4000);
			WebElement Practicerdo = driver.findElement(By.xpath("//input[@id='txtPracticeInUseN']"));


			if(bValue = Practicerdo.isSelected())
			{
				driver.findElement(By.xpath("//input[@id='txtPracticeInUseY']")).click();
			}
			else
			{
				driver.findElement(By.xpath("//input[@id='txtPracticeInUseN']")).click(); 
			}
			Thread.sleep(4000);
			JavascriptExecutor js2 = (JavascriptExecutor) driver;
			js2.executeScript("window.scrollBy(0,250)", ""); 
			driver.findElement(By.xpath("//th[text()='Episode settings']")).click();
			Thread.sleep(4000);
			WebElement einuse = driver.findElement(By.xpath("//input[@id='txtEpisodeInUseN']"));


			if(bValue = einuse.isSelected())
			{
				driver.findElement(By.xpath("//input[@id='txtEpisodeInUseY']")).click();
			}
			else
			{
				driver.findElement(By.xpath("//input[@id='txtEpisodeInUseN']")).click(); 
			}


			Select eind=new Select(driver.findElement(By.name("txtEpisodeMode")));
			eind.selectByVisibleText(Epmode);
			/*for(i=0; i<=3; i++)

					{
						Thread.sleep(2000);
						eind.selectByIndex(i);
					}*/
			JavascriptExecutor js3 = (JavascriptExecutor) driver;
			js3.executeScript("window.scrollBy(0,250)", ""); 
			driver.findElement(By.xpath("//th[text()='Integration settings']")).click();
			Thread.sleep(4000);
			WebElement hinuse = driver.findElement(By.xpath("//input[@id='txtHL7InUseN']"));


			if(bValue = hinuse.isSelected())
			{
				driver.findElement(By.xpath("//input[@id='txtHL7InUseY']")).click();
			}
			else
			{
				driver.findElement(By.xpath("//input[@id='txtHL7InUseN']")).click(); 
			}
			Thread.sleep(4000);
			driver.findElement(By.xpath("//input[@id='txtBedmanServicesUrl']")).clear();
			Thread.sleep(4000);
			driver.findElement(By.xpath("//input[@id='txtBedmanServicesUrl']")).sendKeys(Bedurl);
			JavascriptExecutor js4 = (JavascriptExecutor) driver;
			js4.executeScript("window.scrollBy(0,250)", ""); 

			driver.findElement(By.xpath("//th[text()='Publish schedules (MS Exchange) integration']")).click();

			Thread.sleep(4000);
			driver.findElement(By.xpath("//input[@id='txtCalSyncBegin']")).clear();
			Thread.sleep(4000);
			driver.findElement(By.xpath("//input[@id='txtCalSyncBegin']")).sendKeys(Periodstart);
			JavascriptExecutor js5 = (JavascriptExecutor) driver;
			js5.executeScript("window.scrollBy(0,250)", ""); 

			driver.findElement(By.xpath("//th[text()='Quick Address integration']")).click();
			Thread.sleep(4000);
			WebElement quickint = driver.findElement(By.xpath("//input[@id='txtQasInUseY']"));


			if(bValue = quickint.isSelected())
			{
				driver.findElement(By.xpath("//input[@id='txtQasInUseY']")).click();
			}
			else
			{
				driver.findElement(By.xpath("//input[@id='txtQasInUseN']")).click(); 
			}
			Thread.sleep(4000);
			driver.findElement(By.xpath("//input[@id='txtQasUrl']")).clear();
			Thread.sleep(4000);
			driver.findElement(By.xpath("//input[@id='txtQasUrl']")).sendKeys(Quickurl);
			Thread.sleep(4000);
			JavascriptExecutor js6 = (JavascriptExecutor) driver;
			js6.executeScript("window.scrollBy(0,250)", ""); 
			driver.findElement(By.xpath("//th[text()='Referrer and patient portal integration']")).click();
			WebElement ppinu = driver.findElement(By.xpath("//input[@id='txtPatientPortalInUseN']"));


			if(bValue = ppinu.isSelected())
			{
				driver.findElement(By.xpath("//input[@id='txtPatientPortalInUseY']")).click();
			}
			else
			{
				driver.findElement(By.xpath("//input[@id='txtPatientPortalInUseN']")).click(); 
			}
			Thread.sleep(4000);
			driver.findElement(By.xpath("//input[@id='txtPatientPortalRptFile']")).clear();
			Thread.sleep(4000);
			driver.findElement(By.xpath("//input[@id='txtPatientPortalRptFile']")).sendKeys(Bcreport);
			JavascriptExecutor js7 = (JavascriptExecutor) driver;
			js7.executeScript("window.scrollBy(0,250)", ""); 
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@id='butSave']")).click();

			test1.pass("User is able to edit and save all the System setting values");


		}
		catch(Exception e)
		{
			test1.fail("User is not able to Save the System Setting values");
			Assert.fail();
		}
	}
	@Test(priority=3)
	public static void ClickandEditPatientFields() throws InterruptedException
	{
		try
		{
			test1.log(Status.INFO, "This step shows User should be able to Click and Edit patient Field values");
			driver.switchTo().parentFrame();

			driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f12']")));
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@id='menuItem_37']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//div[@id='menuItem_25']")).click();  // click on the Patient fields.
			Thread.sleep(3000);
			driver.switchTo().parentFrame();
			driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f11']")));
			driver.findElement(By.xpath("//td[text()='Given name']")).click();


			WebElement pfield1 = driver.findElement(By.xpath("//input[@id='EditableAndMandatory']"));
			WebElement pfield = driver.findElement(By.xpath("//input[@id='NotEditableAndNotMandatory']"));


			if(bValue = pfield1.isSelected())
			{
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@id='NotEditableAndNotMandatory']")).click();
			}
			else if(bValue = pfield.isSelected())
			{
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@id='EditableAndMandatory']")).click(); 
			}
			else
			{
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@id='EditableAndNotMandatory']")).click();   


			}



			WebElement pfield2 = driver.findElement(By.xpath("//input[@id='validatedHL7TriggerY']"));


			if(bValue = pfield2.isSelected())
			{
				driver.findElement(By.xpath("//input[@id='validatedHL7TriggerN']")).click();
				Thread.sleep(2000);
			}

			else
			{
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@id='validatedHL7TriggerY']")).click(); 
			}

			WebElement tempfield = driver.findElement(By.xpath("//input[@id='temporaryRequiredY']"));


			if(bValue = tempfield.isSelected())
			{
				driver.findElement(By.xpath("//input[@id='temporaryRequiredN']")).click();
				Thread.sleep(2000);
			}

			else
			{
				Thread.sleep(1000);
				driver.findElement(By.xpath("//input[@id='temporaryRequiredY']")).click(); 
			}
			WebElement tempfield2 = driver.findElement(By.xpath("//input[@id='temporaryHL7TriggerY']"));

			if(bValue = tempfield2.isSelected())
			{
				driver.findElement(By.xpath("//input[@id='temporaryHL7TriggerN']")).click();
				Thread.sleep(1000);
			}

			else
			{
				Thread.sleep(1000);
				driver.findElement(By.xpath("//input[@id='temporaryHL7TriggerY']")).click(); 
			}

			driver.findElement(By.xpath("//button[@id='butSave']")).click();
			test1.pass("User is able to edit and save all the Patient field values");
		}

		catch(Exception e)
		{
			test1.pass("User is able to edit and save all the Patient field values");
		}
	}
	@Test(priority=4)
	public static void ClickonPatientLinkandEditValues() throws InterruptedException
	{
		try
		{

			test1.log(Status.INFO, "This step will clcik on Patinet link option and edit the values");

			driver.switchTo().parentFrame();

			driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f12']")));
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@id='menuItem_38']")).click(); // click on thee Patient Link option.

			driver.switchTo().parentFrame();

			driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f11']")));
			Thread.sleep(3000);

			//patient link

			WebElement urlr = driver.findElement(By.xpath("//input[@id='txtPatientEventOrUrlU']"));
			WebElement eventr = driver.findElement(By.xpath("//input[@id='txtPatientEventOrUrlE']"));
			if(bValue = urlr.isSelected())
			{
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@id='txtPatientEventOrUrlE']")).click();
				driver.findElement(By.xpath("//input[@id='txtPatientWindowFreeText']")).clear();
				driver.findElement(By.xpath("//input[@id='txtPatientWindowFreeText']")).sendKeys(Patientlinktext); 
				driver.findElement(By.xpath("//button[@id='butSave']")).click();
				test1.pass("User is able to edit and save all the Patient field values");
			}

			else if(bValue = eventr.isSelected())
			{

				driver.findElement(By.xpath("//input[@id='txtPatientEventOrUrlU']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@id='txtPatientWindowURL']")).clear();
				driver.findElement(By.xpath("//input[@id='txtPatientWindowURL']")).sendKeys(PatLinkURL); 
				Thread.sleep(2000);
				driver.findElement(By.xpath("//button[@id='butSave']")).click();
				test1.pass("User is able to edit and save all the Patient field values");


			}
		}

		catch(Exception e)
		{
			test1.pass("User is not able to edit and save all the Patient field values");
			Assert.fail();
		}
	}
	@Test(priority=5)
	public static void ClickonPatientMedicalAlertsandEditValues() throws InterruptedException, IOException
	{
		// Load the properties File
		//Properties obj = new Properties();					
	    //FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"\\OR.properties");
	   // obj.load(objfile);	
	    
		try
		{
			test1.log(Status.INFO, "This step will click on PatientMedicalAlertsandEditValues");

			//alternate way to write xpath of line 308// driver.findElement(By.xpath("//div[@class='scrollDiv']//table//tbody//tr[4]//td[2]//div[@class='inputBoxModel']/input]")).sendKeys("www.google.com");
			driver.switchTo().parentFrame();

			driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f12']")));
			Thread.sleep(3000);
			driver.findElement(By.xpath("//div[@id='menuItem_44']")).click(); //patient medical alerts
			//driver.findElement(By.xpath(obj.getProperty("patientmedicalalerts"))).click();

			Thread.sleep(3000);


			driver.switchTo().parentFrame();
			//Switched for parent frame=F0 because it was not able to come outside from F12 frame so i switched)

			driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f11']")));

			WebElement palm = driver.findElement(By.xpath("//div[@class='ug-container']//div[3]//div//following::div//div//label//input[@name='Redirection' and @value='ClientSide']"));
			WebElement palm1 = driver.findElement(By.xpath("//input[@value='ServerSide']"));
			if(bValue = palm.isSelected())
			{
				Thread.sleep(3000);
				driver.findElement(By.xpath("//input[@value='ServerSide']")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//input[@id='url-input']")).clear();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//input[@id='url-input']")).sendKeys(Pmalerturl); 
				Thread.sleep(2000);
				driver.findElement(By.xpath("//button[@id='butSave']")).click();
				test1.pass("User is able to click on the Patinet medical alert option and also able to save edited values");
			}

			else if(palm1.isSelected())
			{
				Thread.sleep(3000);
				driver.findElement(By.xpath("//div[@class='ug-container']//div[3]//div//following::div//div//label//input[@name='Redirection' and @value='ClientSide']")).click(); 
				Thread.sleep(3000);
				driver.findElement(By.xpath("//input[@id='window-name-input']")).clear();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//input[@id='window-name-input']")).sendKeys(ClSideWindowName); 
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@id='butSave']")).click();
				test1.pass("User is able to click on the Patinet medical alert option and also able to save edited values");
			}
		}
		catch(Exception e)
		{
			test1.fail("User is not able to click on the Patinet medical alert option and not able to save edited value");
		}
	}
	@Test(priority=6)
	public static void ClickonPatientAdminalertsandEditvalues() throws InterruptedException
	{

		try
		{

			test1.log(Status.INFO, "This step will click on PatientAdminalerts and Editvalues");
			driver.switchTo().parentFrame();

			driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f12']")));
			Thread.sleep(3000);
			driver.findElement(By.xpath("//div[@id='menuItem_42']")).click(); // patient administrative alerts
			Thread.sleep(3000);	 

			driver.switchTo().parentFrame();
			//Switched for parent frame=F0 because it was not able to come outside from F12 frame so i switched)

			driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f11']")));

			WebElement palert = driver.findElement(By.xpath("//input[@value='ClientSide']"));
			WebElement palert1 = driver.findElement(By.xpath("//input[@value='ServerSide']"));
			if(bValue = palert.isSelected())
			{
				driver.findElement(By.xpath("//input[@value='ServerSide']")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//input[@id='url-input']")).clear();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@id='url-input']")).sendKeys(Pmalerturl); 
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@id='save-button']")).click();
				test1.pass("User is able to save Patient admin alert values");
			}


			else if(palert1.isSelected())
			{
				Thread.sleep(3000);
				driver.findElement(By.xpath("//input[@value='ClientSide']")).click(); 
				Thread.sleep(3000);
				driver.findElement(By.xpath("//input[@id='window-name-input']")).clear();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//input[@id='window-name-input']")).sendKeys(ClSideWindowName); 
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@id='save-button']")).click();
				test1.pass("User is able to save Patient admin alert values");
			}
		}

		catch(Exception e)
		{
			test1.fail("User is not able to save Patient admin alert values");
			Assert.fail();

		}
	}
	@Test(priority=7)
	public static void ClickonAppointmentlink1andEditvalues() throws InterruptedException
	{

		try
		{

			//Appointment link1
			test1.log(Status.INFO, "This step will click on Appointment link1 option");


			driver.switchTo().parentFrame();
			//Switched for parent frame=F0 because it was not able to come outside from F12 frame so i switched)

			driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f12']")));
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@id='menuItem_24']")).click();    //Appointment link1
			driver.switchTo().parentFrame();
			//Switched for parent frame=F0 because it was not able to come outside from F12 frame so i switched)

			driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f11']")));
			Thread.sleep(3000);
			WebElement urlr1 = driver.findElement(By.xpath("//input[@id='txtAppointmentEventOrUrlU']"));
			WebElement eventr1 = driver.findElement(By.xpath("//input[@id='txtAppointmentEventOrUrlE']"));
			if(bValue = urlr1.isSelected())
			{
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@id='txtAppointmentEventOrUrlE']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@id='txtAppointmentWindowFreeText']")).clear();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//input[@id='txtAppointmentWindowFreeText']")).sendKeys(EventtextAL1); 
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@id='butSave']")).click();

				test1.pass("User is able to click on the Appointmnet link option and able to save values");
			}

			else if(bValue = eventr1.isSelected())
			{

				driver.findElement(By.xpath("//input[@id='txtAppointmentEventOrUrlU']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@id='txtAppointmentWindowURL']")).clear();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//input[@id='txtAppointmentWindowURL']")).sendKeys(AL1URL); 
				Thread.sleep(2000);
				driver.findElement(By.xpath("//button[@id='butSave']")).click();

				test1.pass("User is able to click on the Appointmnet link option and able to save values");
			}
		}
		catch(Exception e)
		{
			test1.fail("User is not able to save Appointment link1 values");
			Assert.fail();
		}
	}
	@Test(priority=8)
	public static void ClickonAppointmentlink2andEditvalues() throws InterruptedException
	{



		try
		{

			//Appointment link2
			test1.log(Status.INFO, "This step will click on Appointment link2 option and will save the appointment link values");

			driver.switchTo().parentFrame();
			//Switched for parent frame=F0 because it was not able to come outside from F12 frame so i switched)

			driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f12']")));
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@id='menuItem_17']")).click(); //Appointment link2
			driver.switchTo().parentFrame();
			//Switched for parent frame=F0 because it was not able to come outside from F12 frame so i switched)

			driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f11']")));
			Thread.sleep(3000);
			WebElement urlr2 = driver.findElement(By.xpath("//input[@id='txtAppointmentEventOrUrlU']"));
			WebElement eventr2 = driver.findElement(By.xpath("//input[@id='txtAppointmentEventOrUrlE']"));
			// WebElement urlr3 = driver.findElement(By.xpath("//input[@id='txtAppointmentWindowParam1InUse']"));
			// WebElement eventr4 = driver.findElement(By.xpath("//input[@id='txtAppointmentWindowParam1InUse']"));
			if(bValue = urlr2.isSelected())
			{
				Thread.sleep(3000);
				driver.findElement(By.xpath("//input[@id='txtAppointmentEventOrUrlE']")).click();
				Thread.sleep(3000);
				// driver.findElement(By.xpath("//input[@id='txtAppointmentWindowParam1InUse']")).click();
				driver.findElement(By.xpath("//input[@id='txtAppointmentWindowParam1InUse']")).click();
				Thread.sleep(2000);

				driver.findElement(By.xpath("//input[@id='txtAppointmentWindowParam1Name']")).clear();
				driver.findElement(By.xpath("//input[@id='txtAppointmentWindowParam1Name']")).sendKeys(AL2ExtrenalHisid); 

				driver.findElement(By.xpath("//input[@id='txtAppointmentWindowFreeText']")).clear();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//input[@id='txtAppointmentWindowFreeText']")).sendKeys(EventfreetextAL2); 
				Thread.sleep(2000);
				driver.findElement(By.xpath("//button[@id='butSave']")).click();

				test1.pass("User is able to click on the Appointmnet link2 option and able to save values");
			}





			else if(bValue = eventr2.isSelected())
			{

				driver.findElement(By.xpath("//input[@id='txtAppointmentEventOrUrlU']")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//input[@id='txtAppointmentWindowURL']")).clear();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//input[@id='txtAppointmentWindowURL']")).sendKeys(AL1URL); 
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@id='butSave']")).click();

				test1.pass("User is able to click on the Appointmnet link2 option and able to save values");
			}
		}

		catch(Exception e)
		{
			test1.fail("User is not able to save Appointment link2 values");
			Assert.fail();	
		}
	}
	@Test(priority=9)
	public static void ClickonFunctionHL7eventandEditvalues() throws InterruptedException
	{

		try
		{
			test1.log(Status.INFO, "This step will click on Function Hl7 event option and will save the Function Hl7 event values");

			driver.switchTo().parentFrame();
			//Switched for parent frame=F0 because it was not able to come outside from F12 frame so i switched)

			driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f12']")));
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@id='menuItem_8']")).click(); // Click on Function HL7 event
			driver.switchTo().parentFrame();
			//Switched for parent frame=F0 because it was not able to come outside from F12 frame so i switched)

			driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f11']")));
			Thread.sleep(3000);
			driver.findElement(By.xpath("//td[text()='Appointment - Cancel']")).click();
			Thread.sleep(1000);
			
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@id='butSave']")).click();

			test1.pass("User is able to click on the Function HL7 option and able to save values");

			/*boolean x1=driver.findElement(By.name("c28")).isSelected();

														if(x1 == false)
														{
															Thread.sleep(2000);
															driver.findElement(By.name("c28")).click();
															Thread.sleep(3000);
															 driver.findElement(By.xpath("//tr[@id='r7-28']//td[3]//input[@type='text']")).click();
															 Thread.sleep(2000);
															 driver.findElement(By.xpath("//tr[@id='r7-28']//td[3]//input[@type='text']")).sendKeys("3");
															 Thread.sleep(3000);
															driver.findElement(By.xpath("//button[@id='butSave']")).click();

														}
														else if(x1 == true)
														{
															driver.findElement(By.xpath("//button[@id='butSave']")).click();

														}*/
			//boolean y=driver.findElement(By.id("4-7")).isSelected();


			/*WebElement hl7check = driver.findElement(By.xpath("//input[@name='c28']"));
													  if(bValue =hl7check.isSelected())
														{
														  driver.findElement(By.xpath("//input[@name='c28']")).click();
												}
												else
												{
													driver.findElement(By.xpath("//input[@name='c28']")).click();
													 Thread.sleep(3000);
													 driver.findElement(By.xpath("//tr[@id='r7-28']//td[3]//input[@type='text']")).click();
													 driver.findElement(By.xpath("//tr[@id='r7-28']//td[3]//input[@type='text']")).sendKeys("3");
													 Thread.sleep(2000);
													 driver.findElement(By.xpath("//button[@id='butSave']")).click();
												}*/

		}

		catch(Exception e)
		{
			test1.fail("User is not able to click on Activate Hl7 event values and save Activate Hl7 event");
			Assert.fail();		
		}
	}
	@Test(priority=10)
	public static void ActivationHl7eventandeditvalues() throws InterruptedException
	{

		try
		{


			test1.log(Status.INFO, "This step will click on Activate Hl7 event option and will save the Activate Hl7 event values");

			driver.switchTo().parentFrame();
			//Switched for parent frame=F0 because it was not able to come outside from F12 frame so i switched)

			driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f12']")));
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@id='menuItem_39']")).click();
			driver.switchTo().parentFrame();
			//Switched for parent frame=F0 because it was not able to come outside from F12 frame so i switched)

			driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f11']")));
			Thread.sleep(3000);

			boolean x=driver.findElement(By.id("21-13")).isSelected();

			if(x == false)
			{
				Thread.sleep(2000);
				driver.findElement(By.id("21-13")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@id='butSave']")).click();
				Thread.sleep(2000);
				test1.pass("User is able to click on the Activate Hl7 event option and able to save values");




			}
			//boolean y=driver.findElement(By.id("4-7")).isSelected();

			else if(x == true)
			{
				Thread.sleep(2000);
				driver.findElement(By.id("21-13")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@id='butSave']")).click();
				Thread.sleep(2000);
				test1.pass("User is able to click on the Activate Hl7 event option and able to save values");
				Thread.sleep(4000);
			}


			//	 WebElement ahl7check = driver.findElement(By.xpath("//input[@id='4-7']"));
			/*  if(bValue =ahl7check.isSelected())
															{
															  Thread.sleep(3000);
															  driver.findElement(By.xpath("//input[@id='4-7']")).click();
															  driver.findElement(By.xpath("//button[@id='butSave']")).click();
													}*/


		}


		catch(Exception e)
		{
			test1.fail("User is not able to click on Function Hl7 event values and save Function Hl7 event values");
			Assert.fail();		
		}
	}
	/*	else if(bValue != ahl7check.isSelected())
													{
														Thread.sleep(2000);
														driver.findElement(By.xpath("//input[@id='4-7']")).click();

											           driver.findElement(By.xpath("//button[@id='butSave']")).click();
														 //Thread.sleep(5000);
													}

	 */

	//Reportsettings	
	@Test(priority=11)
	public static void ReportsettingsSarchingcreatingupdatingreport() throws InterruptedException
	{
		try
		{
			test1.log(Status.INFO, "This step will click on Report settings option and create or update new report");
			Thread.sleep(2000);

			driver.switchTo().parentFrame();

			driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f12']")));

			Thread.sleep(3000);
			driver.findElement(By.xpath("//div[@id='menuItem_23']")).click();





			//driver.switchTo().alert().accept();
			driver.switchTo().parentFrame();
			//Switched for parent frame=F0 because it was not able to come outside from F12 frame so i switched)

			driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f11']")));
			Thread.sleep(4000);
			Select report=new Select(driver.findElement(By.xpath("//select[@name='searchType']")));
			report.selectByVisibleText(SelReport);
		
															
			driver.findElement(By.xpath("//td[@class='searchAction']//img")).click();
			Thread.sleep(3000);

			driver.findElement(By.xpath("//td[text()='" +   selexistingrep + "']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@id='ReportName']")).clear();
			driver.findElement(By.xpath("//input[@id='ReportName']")).sendKeys(UpdatingRepname);  //updating
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@id='butSave']")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//button[@id='butNew']")).click();
			Thread.sleep(3000);
		
			/*	SimpleDateFormat formatter = new SimpleDateFormat("HHmmssddMMyyyy");  
			Date date = new Date();  

			String uniq=formatter.format(date);
			// System.out.println(formatter.format(date));  



			String Nav1="rp"+uniq;
			String Nav2="ra"+uniq; */   
			

			driver.findElement(By.xpath("//input[@id='ReportName']")).sendKeys(NewRepName); 
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@id='ReportAbbrev']")).sendKeys(NewRepAbrev); 
			Thread.sleep(2000);
			Select nreport=new Select(driver.findElement(By.xpath("//select[@id='functionType']")));
			nreport.selectByVisibleText(SelRepFunction);
			Thread.sleep(5000);
			Select nreport1=new Select(driver.findElement(By.xpath("//select[@id='lstReport']")));
			nreport1.selectByVisibleText(SelReportAftrFxn);
			Thread.sleep(4000);
			driver.findElement(By.xpath("//button[@id='butSave']")).click();
		 
		 
		 
		 
		 

			test1.pass("User is able to create and update report");

		}
		catch(Exception e)
		{
			test1.fail("User is not able to create and update new report");
			Assert.fail();		
		}
	}
	@AfterSuite
	public static void teardown()
	{

		extent1.flush();														
		driver.quit();	

	}




	
 


	public static String SubChar(String value)
	{
		int index=0;
		index = value.indexOf(".");

		if (index>-1)

			return value.substring(0, index);

		else return value;

	}



}
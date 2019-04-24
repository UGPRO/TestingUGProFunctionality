package AllUgsmoketest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import excelreaderutility.Xls_Reader;

public class Smoketest7 
{
	public static WebDriver driver;
	public static Xls_Reader reader;


	static String SelectSchedule;
	static String  GeneralInfoVal;
	static String ProceesAfterDay;
	static String sessioname;
	static String sessionab;
	static String TemplatePrgStarttime;
	static String TemplatePrgEndtime;	
	static String UsergroupN;
	static String UpdSite	;
	static String CreateNewLoc;
	static String CreateNewApt;
	static String CreateNewPrgName;
	static String ScheduleNavn;


	static String NewTemplStartDate;

	public static ExtentHtmlReporter htmlReporter6;
	public static ExtentReports extent6;
	public static ExtentTest test6;
	public static String serverurl;
	static String str="Test executed on:";

	@BeforeSuite
	public static void setup() throws InterruptedException 
	{
		// TODO Auto-generated method stub
		//Code for test 1 and test 2 smoke test case.
		reader =new Xls_Reader("C:\\Users\\akhosla\\Documents\\Test.xlsx");
		serverurl=reader.getCellData("ST1", "UGURL", 2);
		SelectSchedule	=reader.getCellData("ST7", "Schedule Setup-Select Schedule", 2);
		GeneralInfoVal	=reader.getCellData("ST7", "General-Info field Value", 2);
		UpdSite	=reader.getCellData("ST4", "Update Site", 2);
		CreateNewLoc	=reader.getCellData("ST4", "Create New Loc", 2);
		ProceesAfterDay	=SubChar(reader.getCellData("ST7", "Procees After Days", 2));
		CreateNewApt	     =reader.getCellData("ST3", "Create NewAppointment", 2);
		UsergroupN	=reader.getCellData("ST4", "UsergroupName", 2);
		sessioname	=reader.getCellData("ST7", "Session Name-Templates", 2);
		sessionab	=reader.getCellData("ST7", "Session Abrev-Templates", 2);
		CreateNewPrgName	 =reader.getCellData("ST3", "Create New Program Name", 2);

		ScheduleNavn	 =reader.getCellData("ST6", "Schedule Name", 2);

		CreateNewPrgName	 =reader.getCellData("ST3", "Create New Program Name", 2);
		TemplatePrgStarttime =SubChar(reader.getCellData("ST7", "Template-Program Starttime", 2));
		TemplatePrgEndtime	 =SubChar(reader.getCellData("ST7", "Template-Program Endtime", 2));
		NewTemplStartDate	 =SubChar(reader.getCellData("ST7", "New Template-Start Date", 2));


		htmlReporter6 = new ExtentHtmlReporter("Smoketest7report.html");
		extent6 = new ExtentReports();
		extent6.attachReporter(htmlReporter6);
		// this below two line of code is just for FYI we need to update it.



		System.setProperty("webdriver.chrome.driver", "C:\\sdriver\\chromedriver.exe");


		driver= new ChromeDriver();
	}
	@Test(priority=1)
	public static void GotoSchedulesetupandselectschedule() throws InterruptedException
	{
		try
		{
			test6 = extent6.createTest("SmokeTest7", "This test is to Validate Schedule setup settings ");
			test6.log(Status.INFO, str +" " +serverurl);
			test6.log(Status.INFO, "This step will navigate to schedule setup and will select schedule");
			userlogin.login(driver);
			driver.findElement(By.linkText("Central setup")).click();
			Thread.sleep(6000);

			//div[@class='headerLinks']//span[2]

			//driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f0']")));

			driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f10']")));

			driver.findElement(By.xpath("//div[@class='headerLinks']//span[2]")).click();
			Thread.sleep(3000);
			//select[@id='rscIdDptId']
			framecheck.checkframe12(driver);
			driver.findElement(By.xpath("//select[@id='rscIdDptId']")).click();
			Thread.sleep(3000);
			Select sched=new Select(driver.findElement(By.xpath("//select[@id='rscIdDptId']"))); // for now as i was not able to save the schedule , so we will directly
			//fetch the schedule name from excel sheet. In future need to updating with new created schedule name.
			sched.selectByVisibleText(ScheduleNavn);
			Thread.sleep(4000);



			driver.switchTo().alert();
			Thread.sleep(6000);

			throw new Exception();
		}
		catch (NoAlertPresentException exception)
		{

			test6.pass("User is able to click on the Schedule");




		}

		catch(Exception e)
		{
			test6.fail("User is not able to select the schedule");
			Assert.fail();
		}

	}
	@Test(priority=2)
	public static void clickonGeneraloptionandsaveallvalues() throws InterruptedException
	{
		try
		{
			test6.log(Status.INFO, "This step will click on General option and will save all values");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@id='menuItem_7']")).click(); // click on General option
			framecheck.checkframe11(driver);
			Thread.sleep(7000);
			driver.findElement(By.xpath("//div[@class='uk-form-controls ug-row-content ug-column-padding']//textarea")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@class='uk-form-controls ug-row-content ug-column-padding']//textarea")).sendKeys(GeneralInfoVal);
			Thread.sleep(4000);
			driver.findElement(By.xpath("//select[@class='uk-width-1-1 uk-form-small' and @name='data.scheduleSettings.defaultLocationId']")).click();
			Select loca=new Select(driver.findElement(By.xpath("//select[@class='uk-width-1-1 uk-form-small' and @name='data.scheduleSettings.defaultLocationId']")));
			loca.selectByVisibleText(UpdSite+" "+"-"+" "+ CreateNewLoc);
			Thread.sleep(5000);
			//input[@name='data.scheduleSettings.sessionProcessingSettings.processAfterXDays']
			driver.findElement(By.xpath("//input[@name='data.scheduleSettings.sessionProcessingSettings.processAfterXDays']")).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
			//driver.findElement(By.xpath("//input[@name='data.scheduleSettings.sessionProcessingSettings.processAfterXDays']")).clear();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@name='data.scheduleSettings.sessionProcessingSettings.processAfterXDays']")).sendKeys( ProceesAfterDay);
			Thread.sleep(4000);
			//input[@type='button' and @value='Save']
			driver.findElement(By.xpath("//input[@type='button' and @value='Save']")).click(); //saving General details
			Thread.sleep(10000);

			driver.switchTo().alert();
			Thread.sleep(6000);

			throw new Exception();


		}
		catch (NoAlertPresentException exception)
		{

			test6.pass("User is able to save the General details without any error");




		}

		catch(Exception e)
		{
			test6.fail("User is not able save the general details");
			Assert.fail();
		}

	}
	@Test(priority=3)
	public static void ClickontheAccessRightsoptionSchedulesetup() throws InterruptedException
	{
		try
		{
			test6.log(Status.INFO, "This step will click on the acccess right option in schedule level");
			framecheck.checkframe12(driver);
			driver.findElement(By.xpath("//div[@id='menuItem_2']")).click(); // click on access right.
			Thread.sleep(5000);
			driver.switchTo().alert();
			Thread.sleep(6000);

			throw new Exception();
		}
		catch (NoAlertPresentException exception)
		{

			test6.pass("User is able to Click on the Access rights option");




		}
		catch(Exception e) 
		{
			test6.fail("User is not able to click on the Access rights option");	
		}
	}
	@Test(priority=4)
	public static void ClickontheAppointmnettype() 
	{
		try
		{
			test6.log(Status.INFO, "This step will click on the Appointmenttype option in schedule level");
			driver.findElement(By.xpath("//div[@id='menuItem_1']")).click(); // click on appointment type
			Thread.sleep(5000);

			driver.switchTo().alert();
			Thread.sleep(6000);

			throw new Exception();
		}

		catch (NoAlertPresentException exception)
		{

			test6.pass("User is able to Click on the Appointmnettype option");




		}
		catch(Exception e) 
		{
			test6.fail("User is not able to click on the Appointmnettype option");	
			Assert.fail();
		}
	}
	@Test(priority=5)
	public static void Deactivatingappointmentschedulesetup() throws InterruptedException
	{
		try

		{
			test6.log(Status.INFO, "This step will Deactivate the appointment in schedule level");
			framecheck.checkframe11(driver);
			//div[@class='txtAddApptype']
			//driver.findElement(By.xpath("//div[@class='txtAddApptype']")).click();  //activating appointment
			//driver.switchTo().defaultContent();

			// driver.switchTo().frame(driver.findElement(By.id("ultramodal1-modal-iframe")));
			//Thread.sleep(3000);

			//driver.findElement(By.xpath("//td[@rowspan='2'][2]/img")).click();
			//Thread.sleep(3000);
			//driver.findElement(By.xpath("//td[text()='" + CreateNewApt + "']")).click();
			//Actions action = new Actions(driver);
			// action.moveToElement(driver.findElement(By.xpath("//td[text()='" + CreateNewApt + "']"))).doubleClick().build().perform();

			// Thread.sleep(3000);
			// driver.findElement(By.xpath("//button[@id='butSave' and @onclick='fActivate();']")).click(); //saving
			//Thread.sleep(2000);
			// driver.switchTo().alert().accept();
			// Thread.sleep(5000);
			// driver.findElement(By.xpath("//iframe[@id='f0']/..")).click(); //to get back control on the div we used /.. 
			//driver.switchTo().frame(driver.findElement(By.id("f0")));
			//	driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='content-pane i-frame-legacy']")));
			Thread.sleep(3000);
			driver.findElement(By.xpath("//div[@class='txtDeactivateApptype']")).click();  //deactivating apt
			driver.switchTo().defaultContent();

			driver.switchTo().frame(driver.findElement(By.id("ultramodal1-modal-iframe")));
			Thread.sleep(3000);

			//driver.findElement(By.xpath("//td[@rowspan='2'][2]/img")).click();
			//Thread.sleep(3000);
			//driver.findElement(By.xpath("//td[text()='" + CreateNewApt + "']")).click();
			Actions actiond = new Actions(driver);
			actiond.moveToElement(driver.findElement(By.xpath("//td[text()='" + CreateNewApt + "']"))).doubleClick().build().perform(); //deactivating selected apt

			//button[@onclick='fDeActivate();']
			driver.findElement(By.xpath("//button[@onclick='fDeActivate();']")).click(); //saving
			// menuItem_3
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
			Thread.sleep(3000);
			test6.pass("User is able to deactivate the appointmnettype ");
		}

		catch(Exception e)
		{
			test6.fail("User is not able to deactivate the appointmentttype");
			Assert.fail();
		}
	}
	@Test(priority=6)
	public static void ActivatingAppointmmnettypeschedulesetup() throws InterruptedException
	{
		try
		{
			test6.log(Status.INFO, "This step will Activate the appointmnettype in schedule level");
			driver.findElement(By.xpath("//iframe[@id='f0']/..")).click(); //to get back control on the div we used /.. 
			driver.switchTo().frame(driver.findElement(By.id("f0")));
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='content-pane i-frame-legacy']")));
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@class='txtAddApptype']")).click(); //again activating appointmentype as we will use this appointment 
			//in Appointment for booking options
			driver.switchTo().defaultContent();

			driver.switchTo().frame(driver.findElement(By.id("ultramodal1-modal-iframe")));
			Thread.sleep(3000);

			driver.findElement(By.xpath("//td[@rowspan='2'][2]/img")).click();
			Thread.sleep(3000);
			//driver.findElement(By.xpath("//td[text()='" + CreateNewApt + "']")).click();
			Actions actione = new Actions(driver);
			actione.moveToElement(driver.findElement(By.xpath("//td[text()='" + CreateNewApt + "']"))).doubleClick().build().perform();

			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@id='butSave' and @onclick='fActivate();']")).click(); //saving //again saving activated appt
			Thread.sleep(2000);
			driver.switchTo().alert().accept();

			Thread.sleep(5000);

			test6.pass("User is able to activate appointmnettype");
		}
		catch(Exception e)
		{
			test6.fail("User is not able to activate appointmnettype-Schedule setup");
			Assert.fail();
		}

	}
	@Test(priority=7)
	public static void clickonthAppointmenttypeperprogramandactivateappointmnetforprogram()
	{
		try
		{
			test6.log(Status.INFO, "This step will click on the Appointment type per program option and will activate the appointment for the selected program");
			driver.findElement(By.xpath("//iframe[@id='f0']/..")).click(); //to get back control on the div we used /.. 
			driver.switchTo().frame(driver.findElement(By.id("f0")));
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='content-pane i-frame-legacy']")));
			driver.findElement(By.xpath("//div[@class='sourceBox docked']")).click();
			Thread.sleep(2000);

			//Below we need to activate the appointmnent in the appointment type per program option as we will use the activated appointment in schedule setup
			framecheck.checkframe12(driver);
			driver.findElement(By.xpath("//div[@id='menuItem_6']")).click();  // clicking on the appointmnettype per program
			Thread.sleep(4000);
			Actions actionea = new Actions(driver);
			framecheck.checkframe11(driver);
			actionea.moveToElement(driver.findElement(By.xpath("//td[text()='" + CreateNewApt + "']"))).doubleClick().build().perform();
			Thread.sleep(3000);

			driver.findElement(By.xpath("//button[@id='butSave' and @onclick='fSave();']")).click();//saving appointment perprogram.
			driver.switchTo().alert();
			Thread.sleep(6000);

			throw new Exception();
		}

		catch (NoAlertPresentException exception)
		{

			test6.pass("User is able to click on the Appoinment type per program option and able to save all details");




		}
		catch(Exception e) 
		{
			test6.fail("User is not able click on the Appoinment type per program option and not able to save details");
			Assert.fail();
		}
	}
	@Test(priority=8)
	public static void clickontheAppointmenttypeforbookingandactivateappointment() throws InterruptedException
	{
		try
		{
			test6.log(Status.INFO, "This step will click on the Appointmenttype for booking option and will activate the appointment");
			framecheck.checkframe12(driver);
			driver.findElement(By.xpath("//div[@id='menuItem_3']")).click(); //clicking on Appointment type for booking
			Thread.sleep(3000);

			driver.switchTo().alert();
			Thread.sleep(6000);

			throw new Exception();
		}

		catch (NoAlertPresentException exception)
		{

			test6.pass("User is able to click on the Appoinment type for booking option ");




		}
		catch(Exception e) 
		{
			test6.fail("User is not able click on the Appoinment type for booking option ");	
			Assert.fail();
		}
	}
	@Test(priority=9)
	public static void bookingentriessmakeuseprivandnonpriv() throws InterruptedException
	{
		try
		{
			test6.log(Status.INFO, "This step will make uses privilged and non priviliged after clicking on Appointmnet type for booking option");
			framecheck.checkframe11(driver);
			driver.findElement(By.xpath("//td[text()='" +  UsergroupN + "']")).click();
			Thread.sleep(3000);
			Actions actionf = new Actions(driver);
			actionf.moveToElement(driver.findElement(By.xpath("//table[@id='privUsr']//td[text()='" + CreateNewApt + "']"))).doubleClick().build().perform();//activating appointment in Appointment for booking.
			Thread.sleep(3000);
			Actions actiong = new Actions(driver);
			actiong.moveToElement(driver.findElement(By.xpath("//table[@id='nonPrivUsr']//td[text()='" + CreateNewApt + "']"))).doubleClick().build().perform();//activating appointment in Appointment for booking.
			Thread.sleep(2000);
			//button[@id='butSave' and @onclick='fSave();']
			driver.findElement(By.xpath("//button[@id='butSave' and @onclick='fSave();']")).click();//saving appointment for booking values.
			Thread.sleep(3000);

			driver.switchTo().alert();
			Thread.sleep(6000);

			throw new Exception();
		}

		catch (NoAlertPresentException exception)
		{

			test6.pass("User is able to make users priviliged and non priviliged ");




		}
		catch(Exception e) 
		{
			test6.fail("User is not able to make users priviliged and non priviliged");	
			Assert.fail();
		}
	}
	@Test(priority=10)
	public static void clickontheAppointmenttypeforwaitinglistentries() throws InterruptedException
	{	
		try
		{
			test6.log(Status.INFO, "This step will click on the Appointmnet type for waiting list entries option");
			framecheck.checkframe12(driver);
			driver.findElement(By.xpath("//div[@id='menuItem_8']")).click(); // Appointment type for waiting list entries
			Thread.sleep(3000);

			driver.switchTo().alert();
			Thread.sleep(6000);

			throw new Exception();
		}
		catch (NoAlertPresentException exception)
		{

			test6.pass("User is able to click on the Appointment type for waiting list entries option ");




		}
		catch(Exception e) 
		{
			test6.fail("User is not able to click on the Appointment type for waiting list entries option ");	
			Assert.fail();
		}
	}
	@Test(priority=11)
	public static void waitinglistmakeuseprivandnonpriv()throws InterruptedException
	{
		try
		{
			test6.log(Status.INFO, "This step will enable and disable the appointmnettype for Priviliged and Non Priviliged user in Appintme ");
			framecheck.checkframe11(driver);
			driver.findElement(By.xpath("//td[text()='" +  UsergroupN + "']")).click();
			Actions actionh = new Actions(driver);
			actionh.moveToElement(driver.findElement(By.xpath("//table[@class='streched']//td[text()='" + CreateNewApt + "']"))).doubleClick().build().perform();// switching priv users
			Thread.sleep(2000);
			Actions actioni = new Actions(driver);
			actioni.moveToElement(driver.findElement(By.xpath("//div[@class='target docked' and @ id='target']//tr//following::tbody//tr//td[text()='" + CreateNewApt + "']"))).doubleClick().build().perform();// switching npriv users
			//above switching priv users
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@id='butSave' and@onclick='fSave();']")).click();//saving appointment for waiting values.	
			Thread.sleep(3000);
			driver.switchTo().alert();
			Thread.sleep(6000);

			throw new Exception();
		}

		catch (NoAlertPresentException exception)
		{

			test6.pass("User is able to make users privilged and non priviliged after clicking on Appointment type for waiting list option");




		}
		catch(Exception e) 
		{
			test6.fail("User is not able to make users privilged and non priviliged after clicking on Appointment typr for waiting list option");	
			Assert.fail();
		}
	}
	@Test(priority=12)
	public static void clickonTemplatesoption() throws InterruptedException
	{
		try
		{
			test6.log(Status.INFO, "This step will Click on templates option ");
			framecheck.checkframe12(driver);
			driver.findElement(By.xpath("//div[@id='menuItem_5']")).click(); //template button click.
			Thread.sleep(5000);
			driver.switchTo().alert();
			Thread.sleep(6000);

			throw new Exception();
		}

		catch (NoAlertPresentException exception)
		{

			test6.pass("User is able to click on the templates option");




		}
		catch(Exception e) 
		{
			test6.fail("User is not able to click on the templates option");	
			Assert.fail();
		}
	}
	@Test(priority=13)
	public static void clickonnewbuttoncreatesessionandaddprogram() throws InterruptedException
	{
		try
		{
			test6.log(Status.INFO, "This step will create new template and will add new program in created session");
			framecheck.checkframe11(driver);
			driver.findElement(By.xpath("// button[@id='butNew' and@onclick='fNew();']")).click(); //cLCIKING ON NEW BUTTON-tEMPLATE
			//td[@onclick='editSession(1);']
			driver.findElement(By.xpath("//input[@id='txtStartDate']")).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='txtStartDate']")).click();
			Thread.sleep(2000);
			//NewTemplStartDate
			driver.findElement(By.xpath("//input[@id='txtStartDate']")).sendKeys(NewTemplStartDate);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//td[@onclick='editSession(1);']")).click();
			Thread.sleep(3000);
			driver.switchTo().defaultContent();

			driver.switchTo().frame(driver.findElement(By.id("ultramodal1-modal-iframe")));
			Thread.sleep(3000);
			//input[@id='sesName']
			driver.findElement(By.xpath("//input[@id='sesName']")).sendKeys(sessioname); 
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@id='sesAbbrev']")).sendKeys(sessionab); 
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@id='butSave' and@onclick='fSave();']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//iframe[@id='f0']/..")).click(); //to get back control on the div we used /.. 
			driver.switchTo().frame(driver.findElement(By.id("f0")));
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='content-pane i-frame-legacy']")));
			System.out.print("test");
			driver.switchTo().defaultContent();
			Thread.sleep(3000);
			driver.switchTo().frame(driver.findElement(By.id("ultramodal1-modal-iframe")));
			Thread.sleep(3000);
			Select prg=new Select(driver.findElement(By.xpath("//select[@id='prgId']")));
			prg.selectByVisibleText(CreateNewPrgName);
			Thread.sleep(3000);

			//Thread.sleep(3000);
			// driver.findElement(By.xpath("//tr[@class='addProgramRow']//td[@class='first rowIcon']")).click(); //click to insert program in session.
			// Thread.sleep(3000);
			// driver.switchTo().defaultContent();
			// Thread.sleep(3000);
			//iframe[@id='ultramodal1-modal-iframe' and@src='/UltraGendaPro/setup/iu/template/programblock.asp']
			// driver.switchTo().frame(driver.findElement(By.id("ultramodal1-modal-iframe")));
			//Thread.sleep(6000);
			// driver.findElement(By.xpath("//table[@id='fullTbl']//tbody//tr[2]//td[2]//select[@onchange='programChanged()']")).click();    //clicking on template-Program dropdown
			//	 Thread.sleep(5000);
			// Select prg=new Select(driver.findElement(By.xpath("//select[@id='prgId']")));
			//prg.selectByVisibleText(CreateNewPrgName);
			//input[@id='prgStart']
			driver.findElement(By.xpath("//input[@id='prgStart']")).click();
			driver.findElement(By.xpath("//input[@id='prgStart']")).clear(); 
			driver.findElement(By.xpath("//input[@id='prgStart']")).sendKeys("16:00"); 
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='prgStop']")).clear(); 
			driver.findElement(By.xpath("//input[@id='prgStop']")).sendKeys("21:00"); 
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@id='butSave' and@onclick='fSave();']")).click();
			/*driver.findElement(By.xpath("//iframe[@id='f0']/..")).click(); //to get back control on the div we used /.. 
			driver.switchTo().frame(driver.findElement(By.id("f0")));
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='content-pane i-frame-legacy']")));
			Thread.sleep(2000);
			 */
			Thread.sleep(5000);
			//td[@class='rowInputLocal']//div

			driver.switchTo().frame(driver.findElement(By.id("f0")));
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='content-pane i-frame-legacy']")));


			//button[@onclick='fSave(false);' and@id='butSave']
			driver.findElement(By.xpath("//button[@onclick='fSave(false);' and@id='butSave']")).click();  //saving programsession template value.
			Thread.sleep(3000);
			driver.switchTo().alert();
			Thread.sleep(6000);

			throw new Exception();

		}
		catch (NoAlertPresentException exception)
		{

			test6.pass("User is able to create new template and add program in created session");




		}

		catch(Exception e)
		{
			test6.fail("User is not able to create new template and add program in created session");
			Assert.fail();
		}
	}
	@AfterSuite
	public static void teardown()
	{
		extent6.flush();
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

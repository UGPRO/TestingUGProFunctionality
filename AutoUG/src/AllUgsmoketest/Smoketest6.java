package AllUgsmoketest;

import java.awt.List;
import java.io.IOException;

import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import excelreaderutility.Xls_Reader;
import ugprofunctionality.schedulecreation;

public class Smoketest6
{
	static WebDriver driver;
	public static Xls_Reader reader;

	public static String CreateNewAptd;	     
	public   static String  CreateNewAptAbre;
	public   static String CreateNewApt;
	public   static String  Ordername;
	public   static String  locname;
	public    static String  OrderStartdate;
	public   static String OrderAbrev;
	public  static String ScheduleNavn;
	public   static String ScheduleAbrev;
	public   static String Locname;
	public   static String UpdSite;
	public   static String  CreateNewLoc;
	public  static String  ScheduleAdminNavn;
	public  static String SelAppointmenttypeSt1;
	public  static String  SelDepartmentSt1;
	public  static String   CreateDepname;
	public  static String CreateNewPrgName;
	public  static String  SetFamofuserAuth;
	public static String UsergroupAb;
	public static String serverurl;


	static ExtentHtmlReporter htmlReporter5;
	static ExtentReports extent5;
	static ExtentTest test5;
	static String str="Test executed on:";

	@BeforeSuite
	public static void setup() throws InterruptedException 
	{
		// TODO Auto-generated method stub
		//Code for test 1 and test 2 smoke test case.
		reader =new Xls_Reader("C:\\Test.xlsx");
		serverurl=reader.getCellData("ST1", "UGURL", 2);
		

		// this below two line of code is just for FYI we need to update it.

		CreateNewApt	     =reader.getCellData("ST3", "Create NewAppointment", 2);
		CreateDepname	=reader.getCellData("ST4", "Create Dep name", 2);
		CreateNewAptd	     =reader.getCellData("ST6", "Create New Appointment-Depart level", 2);
		CreateNewAptAbre =reader.getCellData("ST6", "Create New Appointment Abrev-Depart level", 2);
		// CreateNewApt	     =reader.getCellData("ST3", "Create NewAppointment", 2);
		CreateNewPrgName	 =reader.getCellData("ST3", "Create New Program Name", 2);
		Ordername	 =reader.getCellData("ST6", "Ordersetname", 2);
		OrderAbrev	 =reader.getCellData("ST6", "Orderset Abrev", 2);
		OrderStartdate	 =reader.getCellData("ST6", "Orderset-Start date", 2);
		ScheduleNavn	 =reader.getCellData("ST6", "Schedule Name", 2);
		ScheduleAbrev	 =reader.getCellData("ST6", "Schedule Abrvn", 2);
		locname	 =reader.getCellData("ST6", "Schedule-Loc Name", 2);
		UpdSite	=reader.getCellData("ST4", "Update Site", 2);
		CreateNewLoc	=reader.getCellData("ST4", "Create New Loc", 2);
		// ScheduleAdminNavn	=reader.getCellData("ST4", "Schedule Admin Name", 2);
		SelAppointmenttypeSt1	=reader.getCellData("ST6", "Select Appointmenttype-St1", 2);
		SelDepartmentSt1	=reader.getCellData("ST6", "Select Department-St1", 2);
		SetFamofuserAuth	=reader.getCellData("ST4", "SetFamilynameofnewuserAuth", 2);
		UsergroupAb	=reader.getCellData("ST4", "UsergroupAbrev", 2);

		htmlReporter5 = new ExtentHtmlReporter("Smoketest6report.html");
		extent5 = new ExtentReports();
		extent5.attachReporter(htmlReporter5);


		System.setProperty("webdriver.chrome.driver", "C:\\sdriver\\chromedriver.exe");
		driver= new ChromeDriver();
		Thread.sleep(2000);
		System.out.print("Testamit");
	}
	@Test(priority=1)
	public static void ClickonDepartmentalsettingsandAppointmenttypeoption() throws InterruptedException 
	{
		try
		{
			test5 = extent5.createTest("SmokeTest6", "This test is to Validate Departmental settings ");
			test5.log(Status.INFO, str +" " +serverurl);
			test5.log(Status.INFO, "This step will click on Departmental settings and Appointmenttype option");
			Thread.sleep(4000);
			userlogin.login(driver);


			driver.findElement(By.xpath("//a[text()='Departmental setup']")).click();
			Thread.sleep(3000);

			//Switched for parent frame=F0 because it was not able to come outside from F12 frame so i switched)

			driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f12']")));
			Thread.sleep(3000);
			driver.findElement(By.xpath("//div[@class='menuButton']")).click();
			Thread.sleep(1000);


			driver.findElement(By.xpath("//div[@id='menuItem_5']")).click(); // click on Appointmnettype option
			Thread.sleep(3000);

			//test5.pass("User is  able to Click on Departmentalsettings and Appointmenttype option");

			driver.switchTo().alert();
			Thread.sleep(6000);

			throw new Exception();


		}

		catch (NoAlertPresentException exception)
		{
			Thread.sleep(2000);
			test5.pass("User is able to Click on Departmentalsettings and Appointmenttype option");




		}

		catch(Exception e)
		{
			Thread.sleep(2000);
			test5.fail("User is not able to Click on Departmentalsettings and Appointmenttype option");
			Assert.fail();
		}
	}
	@Test(priority=2)
	public static void SelecttheDepttandcheckappointmenttypelinkwithselecteddeptt() throws InterruptedException 
	{
		try
		{
			test5.log(Status.INFO, "This step will Select the department will check the linked appointmnet with the selected deptt");
			framecheck.checkframe11(driver);
			Select pro=new Select(driver.findElement(By.xpath("//select[@class='select']")));
			driver.findElement(By.xpath("//select[@class='select']")).click(); 
			Thread.sleep(500);
			pro.selectByVisibleText(CreateDepname);
			Thread.sleep(3000);
			test5.pass("User is able to select the Department");
		}
		catch(Exception e)
		{
			test5.fail("User is not  able to select the Department");
			Assert.fail();
		}

	}
	@Test(priority=3)
	public static void CreateNewAppointmenttypeandSaveit()
	{
		try
		{
			test5.log(Status.INFO, "This step will Create new appointmnettype in Departmentalsetup");
			driver.findElement(By.xpath("//button[@id='butNew']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@id='txtAppName']")).sendKeys(CreateNewAptd); //creating new appointment
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@id='txtAppAbbrev']")).sendKeys(CreateNewAptAbre);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@id='butSave']")).click();
			Thread.sleep(3000);

			driver.switchTo().alert();
			Thread.sleep(6000);

			throw new Exception();

		}
		catch (NoAlertPresentException exception)
		{

			test5.pass("User is  able to  Create Appointmenttype in Departmental Setup");




		}

		catch(Exception e)
		{
			test5.fail("User is not able to Create Appointmenttype in Departmental Setup");
			Assert.fail();
		}
	}
	//driver.findElement(By.xpath("//td[text()='"+CreateNewAptd+"']")).click();
	// Thread.sleep(2000);
	@Test(priority=4)
	public static void Deletenewcreatedappoinmenttype() throws InterruptedException
	{
		try
		{

			test5.log(Status.INFO, "This step will Delete new appointmnettype in Departmentalsetup");
			driver.findElement(By.xpath("//table[@id='tbl']//thead//tr//th[2]//following::tr//img")).click();  //deleting created appointment-Amendment Required
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			// driver.findElement(By.xpath("//td[text()='"+CreateNewApt+"']")).click();
			Thread.sleep(3000);
			driver.switchTo().alert();
			Thread.sleep(6000);

			throw new Exception();
		}
		catch (NoAlertPresentException exception)
		{

			test5.pass("User is  able to  delete Appointmenttype in Departmental Setup");

		}

		catch(Exception e)
		{
			test5.fail("User is not able to delete Appointmenttype in Departmental Setup");
			Assert.fail();
		}
	}
	@Test(priority=5)
	public static void ActivatingappoinmenttypecreatedatCentrallevel() throws InterruptedException
	{
		try
		{
			test5.log(Status.INFO, "This step will Activate  appointmnettype created at Central level");
			driver.findElement(By.xpath("//table[@id='tbl2']//td[2]/following::tr[6]//td[text()='"+CreateNewApt+"']//following::td")).click();  //activating new created appointment




			//activating appointment created at central level
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			Thread.sleep(4000);

			driver.switchTo().alert();
			Thread.sleep(6000);

			throw new Exception();

		}
		catch (NoAlertPresentException exception)
		{

			test5.pass("User is  able to Activate appointment type created at central level");




		}

		catch(Exception e)
		{
			test5.fail("User is not able to  Activate appointment type created at central level");
			Assert.fail();
		}
	}
	// driver.findElement(By.xpath("//tr[@id='r1000041']//td[2]//img")).click();

	// driver.switchTo().alert().accept();
	//Thread.sleep(2000);

	@Test(priority=6)
	public static void clickontheAppointmenttypeperprogramoption() throws InterruptedException
	{
		try
		{
			test5.log(Status.INFO, "This step will click on the Appointmentype per program option");
			framecheck.checkframe12(driver);
			driver.findElement(By.xpath("//div[@id='menuItem_10']")).click();  // clicking on the appointment type per program.
			Thread.sleep(3000);


			driver.switchTo().alert();
			Thread.sleep(6000);

			throw new Exception();

		}

		catch (NoAlertPresentException exception)
		{

			test5.pass("User is  able to click on the Appointmentype per program option");




		}
		catch(Exception e)
		{
			test5.fail("User is not able to click on the Appointmnettype per program option");
			Assert.fail();
		}
	}
	@Test(priority=7)
	public static void SelectDepartmenttoseelinkedProgramwithselecteddepartmnet() throws InterruptedException
	{
		try
		{
			test5.log(Status.INFO, "This step will Select department to see linked program with selected department");
			framecheck.checkframe11(driver);
			Select pro2=new Select(driver.findElement(By.xpath("//select[@class='select']")));
			driver.findElement(By.xpath("//select[@class='select']")).click();
			pro2.selectByVisibleText(CreateDepname);
			Thread.sleep(3000);
			test5.pass("User is able to Select department to see linked program with the selected departmnet");
		}
		catch(Exception e)
		{
			test5.fail("User is not able to Select department to see linked program with the selected departmnet");
			Assert.fail();
		}
	}
	@Test(priority=8)
	public static void Activateappointmenttypeforselectedprogram() throws InterruptedException
	{
		try
		{

			test5.log(Status.INFO, "This step will Activate appointmenttype for the selected program");


			driver.findElement(By.xpath("//td[text()='"+ CreateNewPrgName+"']")).click();
			Thread.sleep(3000);
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.xpath("//td[text()='"+ CreateNewApt+"']"))).doubleClick().build().perform();
			// driver.findElement(By.xpath("//td[text()='"+ CreateNewApt+"']")).click();

			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@id='butSave']")).click();  //saving appointment type program values.
			Thread.sleep(3000);

			driver.switchTo().alert();
			Thread.sleep(6000);

			throw new Exception();
		}

		catch (NoAlertPresentException exception)
		{

			test5.pass("User is  able to Activate appointmenttype for the selected program");




		}

		catch(Exception e)
		{
			test5.fail("User is not able to Activate appointmenttype");
			Assert.fail();
		}
	}



	//below is creating schedule first, because we need a new schedule name to activate the appointment from schedule setuop
	@Test(priority=9)
	public static void creatingschedule() throws InterruptedException
	{
		try
		{

			test5.log(Status.INFO, "This step will create new schedule");

			schedulecreation.schedulecreate(driver);
			Thread.sleep(5000);

			driver.switchTo().alert();
			Thread.sleep(6000);

			throw new Exception();


		}


		catch (NoAlertPresentException exception)
		{

			test5.pass("User is  able to Create schedule");
		}

		catch(Exception e)
		{
			test5.fail("User is not able to create schedule");
			Assert.fail();
		}

	}

	// driver.switchTo().defaultContent();

	/*	 // here we are navigating to schedule setup to click on Appointment type to activating appointmenttype that we will use in orderset-depsetup
		 driver.findElement(By.xpath("//iframe[@id='f0']/..")).click(); //to get back control on the div we used /.. 
			driver.switchTo().frame(driver.findElement(By.id("f0")));
		 driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f10']")));

			driver.findElement(By.xpath("//div[@class='headerLinks']//span[2]")).click(); // clicking on scheule setup at top right of the screen
			Thread.sleep(3000);
		  framecheck.checkframe12(driver);

		driver.findElement(By.xpath("//select[@id='rscIdDptId']")).click();

		Thread.sleep(3000);
		Select sched=new Select(driver.findElement(By.xpath("//select[@id='rscIdDptId']"))); // for now as i was not able to save the schedule , so we will directly
		//fetch the schedule name from excel sheet. In future need to updating with new created schedule name.
			sched.selectByVisibleText(ScheduleNavn);


			//here i am navigating to click on appointment type to activate it in schedule setup.

			Thread.sleep(5000);
			driver.findElement(By.xpath("//div[@id='menuItem_1']")).click(); // click on appointment type
			Thread.sleep(5000);
			framecheck.checkframe11(driver);
			//div[@class='txtAddApptype']
			driver.findElement(By.xpath("//div[@class='txtAddApptype']")).click();  //activating appointment
			driver.switchTo().defaultContent();

			 driver.switchTo().frame(driver.findElement(By.id("ultramodal1-modal-iframe")));
			Thread.sleep(3000);

			driver.findElement(By.xpath("//td[@rowspan='2'][2]/img")).click();
			Thread.sleep(3000);
			//driver.findElement(By.xpath("//td[text()='" + CreateNewApt + "']")).click();
			Actions action11 = new Actions(driver);
			 action11.moveToElement(driver.findElement(By.xpath("//td[text()='" + CreateNewApt + "']"))).doubleClick().build().perform();

			 Thread.sleep(3000);
			 driver.findElement(By.xpath("//button[@id='butSave' and @onclick='fActivate();']")).click(); //saving
			Thread.sleep(2000);
			 driver.switchTo().alert().accept();
			 Thread.sleep(4000);

			 // switching again on ordert set to select activated appointmenttype from SS.
			 driver.findElement(By.xpath("//iframe[@id='f0']/..")).click(); //to get back control on the div we used /.. 
				driver.switchTo().frame(driver.findElement(By.id("f0")));
				driver.switchTo().frame(driver.findElement(By.id("f10")));

			 driver.findElement(By.xpath("//div[@class='headerLinks']//span[2]")).click();
				Thread.sleep(3000);



	 */



	@Test(priority=10)
	public static void clickonOrdersetoption() throws InterruptedException
	{
		try
		{
			test5.log(Status.INFO, "This step will click on the Orderset option");

			driver.switchTo().defaultContent();


			driver.findElement(By.xpath("//iframe[@id='f0']/..")).click(); //to get back control on the div we used /.. 
			driver.switchTo().frame(driver.findElement(By.id("f0")));
			driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f12']")));
			driver.findElement(By.xpath("//div[@id='menuItem_13']")).click(); //click on the ordersetoption
			Thread.sleep(3000);
			test5.pass("User is able to click on the Orderset option");
		}
		catch(Exception e)
		{
			test5.fail("User is not able to click on the Orderset option");
			Assert.fail();
		}
	}
	@Test(priority=11)
	public static void selectdepartmenttoseeordesetlinkedwithselecteddepartment() throws InterruptedException
	{
		try
		{
			test5.log(Status.INFO, "This step will select department to seeordeset linked with the selecteddepartment");

			framecheck.checkframe11(driver);
			Select pro3=new Select(driver.findElement(By.xpath("//select[@class='select']")));
			driver.findElement(By.xpath("//select[@class='select']")).click();
			pro3.selectByVisibleText(CreateDepname);  //department created on central level
			Thread.sleep(3000);
			test5.pass("User is able to select department");
		}
		catch(Exception e)
		{
			test5.fail("User is not able to select department");
			Assert.fail();
		}
	}
	@Test(priority=12)
	public static void CreateOrderset() throws InterruptedException
	{
		try
		{
			test5.log(Status.INFO, "This step will create new orderset");

			driver.findElement(By.xpath("//button[@id='butNew']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='txtBatName']")).sendKeys(Ordername);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='txtBatAbbrev']")).sendKeys(OrderAbrev);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='txtBatStartDate']")).sendKeys(OrderStartdate);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@id='tabBut1']")).click();
			//Select ro3=new Select(driver.findElement(By.xpath("//select[@class='selectSmall']")));
			driver.findElement(By.xpath("//select[@class='selectSmall']")).click();
			driver.findElement(By.xpath("//select[@class='selectSmall']")).sendKeys(CreateDepname); // selecting existing deptt that we created in last test.
			// ro3.selectByVisibleText(CreateDepname);
			//b[@role='presentation']
			Actions actions1 = new Actions(driver);
			Thread.sleep(2000);
			actions1.sendKeys(Keys.ENTER).build().perform();
			Thread.sleep(4000);
			//span[@id='select2-selApptype1-container']
			driver.findElement(By.xpath("//span[@class='select2-selection__rendered']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys(CreateNewApt);
			Thread.sleep(3000);
			Actions actions = new Actions(driver);
			Thread.sleep(2000);
			actions.sendKeys(Keys.DOWN).build().perform();
			Thread.sleep(2000);
			actions.sendKeys(Keys.ENTER).build().perform();
			Thread.sleep(2000);

			// driver.findElement(By.xpath("//input[@id='txtBatAbbrev']")).sendKeys( OrderStartdate);
			//Thread.sleep(2000);
			driver.findElement(By.xpath("//td[contains(text(), 'Schedules')]//div[@id='scheduleAllNone' and @class='grpSelectors ignored']//span[contains(text(), 'All')]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//td[contains(text(), 'Sites')]//div[@id='siteAllNone']//span[contains(text(), 'All')]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@id='butSave']")).click();
			Thread.sleep(4000);

			driver.switchTo().alert();
			Thread.sleep(6000);

			throw new Exception();
		}

		catch (NoAlertPresentException exception)
		{

			test5.pass("User is  able to Create a new orderset");




		}
		catch(Exception e)

		{

			test5.fail("User is not able to Create a new orderset");
			Assert.fail();
		}
	}



	@AfterSuite
	public static void teardown()
	{
		extent5.flush();

		driver.quit();	
	}
}


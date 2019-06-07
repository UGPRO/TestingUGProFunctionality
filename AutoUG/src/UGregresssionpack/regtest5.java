package UGregresssionpack;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import AllUgsmoketest.framecheck;
import AllUgsmoketest.userlogin;
import excelreaderutility.Xls_Reader;
import ugprofunctionality.Bookapntmntfreebtn;
import ugprofunctionality.bookapntmnetfreebtnforapl2;
import ugprofunctionality.changeallaccessright;
import ugprofunctionality.clickonAppointmentlinkcheckdatetime;
import ugprofunctionality.clickonappointmeentlink2windowresize;
import ugprofunctionality.navigatetoselectpat;
import ugprofunctionality.patadminalert;
import ugprofunctionality.setupbtnpatadminalert;
import ugprofunctionality.setupbtnpatmedalert;

public class regtest5 
{

	public static Xls_Reader reader;
	public static String paturl;
	static String UsergroupN;
	public static WebDriver driver;
	public static String serverurl;
	static ExtentHtmlReporter htmlReporter15;
	static ExtentReports extent15;
	static ExtentTest test15;
	static String str="Test executed on:";


	@BeforeSuite
	public static void setup()throws InterruptedException 
	{

		reader = new Xls_Reader("C:\\Users\\akhosla\\Documents\\regexcelsheet.xlsx");
		serverurl=reader.getCellData("reg1", "UGURL", 2);
		paturl = reader.getCellData("reg5", "PatientMedicalalertsURL", 2);

		UsergroupN	=reader.getCellData("reg5", "TosetAccessrightsselectusergroupname", 2);

		htmlReporter15 = new ExtentHtmlReporter("Regressiontest5report.html");
		extent15 = new ExtentReports();
		extent15.attachReporter(htmlReporter15);



		System.setProperty("webdriver.chrome.driver", "C:\\sdriver\\chromedriver.exe");
		driver= new ChromeDriver();
	}

	//System.setProperty("webdriver.chrome.driver", "C:\\selenium drivers\\chromedriver_win32\\chromedriver.exe");
	//	driver.get("https://vm64-its.ultragenda.com/UltraGendaPro?newwindow=0");



	@Test(priority=1)
	public static void clickonpatientlinkandfillurl() throws InterruptedException
	{
		try
		{


			test15 = extent15.createTest("RegressionTest5", "This test is to Validate all links functionality");
			test15.log(Status.INFO, str +" " +serverurl);
			test15.log(Status.INFO, "This step will Validate Patient link settings");

			userlogin.login(driver);

			driver.findElement(By.linkText("Central setup")).click();
			driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f12']")));
			driver.findElement(By.xpath("(//div[@class='menuButton'])[1]")).click();  //system administration
			Thread.sleep(2000);


			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@id='menuItem_38']")).click();  //click on the patient link

			driver.switchTo().parentFrame();

			driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f11']")));
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@id='txtPatientWindowURL']")).click();  //fill patient link values.
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='txtPatientWindowURL']")).clear();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='txtPatientWindowURL']")).sendKeys(paturl);  //fill patient link values.
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@id='butSave']")).click();
			Thread.sleep(2000);

			navigatetoselectpat.selpat(driver);

			driver.switchTo().alert();
			Thread.sleep(6000);

			throw new Exception();
		}
		catch (NoAlertPresentException exception)
		{

			test15.pass("Functionality related with patient link is working fine");



		}




		catch(Exception e)
		{
			test15.fail("Functionality related with patient link is not  working fine");
			Assert.fail();
		}
	}
	@Test(priority=2)
	public static void clickonpatinetmedicalalertandfillurlsetaccessright() throws InterruptedException
	{
		try
		{

			test15.log(Status.INFO, "This step will click on Patient medical alert option and will set access rights for Patinet medical alert option");

			//Check patient medical alert functionality.

			setupbtnpatmedalert.pmda(driver);

			Thread.sleep(2000);
			framecheck.checkframe12(driver);
			driver.findElement(By.xpath("(//div[@class='menuButton'])[3]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[@id='menuItem_3']")).click(); //click on the access rights
			Thread.sleep(3000);
			framecheck.checkframe11(driver);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//td[text()='" + UsergroupN + "']")).click();
			Thread.sleep(4000);

			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[@id='setAll']")).click();  ///click on change all option.
			Thread.sleep(2000);
			driver.switchTo().defaultContent();

			driver.switchTo().frame(driver.findElement(By.id("ultramodal1-modal-iframe")));
			Thread.sleep(3000);
			//here below i am selecting access rights for priv and non priv users because
			//if access right is not set or non priv user then i woul dnot be able to see new created schedule.
			driver.findElement(By.xpath("//body[@class='window-small']//form//table//tbody//tr[2]//td//div[2]//input[2]")).click(); //click on the all members have access for priviliged user
			Thread.sleep(3000);
			//	driver.findElement(By.xpath("//body[@class='window-small']//form//table//tbody//tr[3]//td//div[2]//input[2]")).click();//click on the all members have access for non priviliged user
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@id='butNext']")).click();//on click of confirm button ,control is getting out from the main div
			Thread.sleep(5000);
			driver.findElement(By.xpath("//iframe[@id='f0']/..")).click(); //to get back control on the div we used /.. 
			driver.switchTo().frame(driver.findElement(By.id("f0")));
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='content-pane i-frame-legacy']")));
			driver.findElement(By.xpath("//body[@class='window-large']//form//table//tbody//tr//td[3]//table//tbody//tr[3]//td//button[2]")).click();   // save button click
			Thread.sleep(3000);
			Thread.sleep(3000);

			Thread.sleep(2000);
			driver.findElement(By.xpath("//td[text()='Show - Patient medical alerts']//following-sibling::td//img")).click(); // click on the access rights(Patient med alerts)
			Thread.sleep(2000);
			driver.findElement(By.xpath("//td[text()='Show - Patient medical alerts']//following-sibling::td//img")).click();
			Thread.sleep(2000);

			driver.findElement(By.xpath("//button[@id='butSave']")).click();
			//button[@id='butSave']

			Thread.sleep(3000);
			navigatetoselectpat.selpat(driver);

			driver.switchTo().alert();
			Thread.sleep(6000);

			throw new Exception();
		}
		catch (NoAlertPresentException exception)
		{

			test15.pass("Functionality related with patient medical alerts is working fine");



		}


		catch(Exception e)
		{
			test15.fail("Functionality related with patient medical alerts is not working fine");
			Assert.fail();
		}

	}
	@Test(priority=3)
	public static void clickonpatientadminalertandsetaccessright() throws InterruptedException
	{
		try
		{
			test15.log(Status.INFO, "This step will click on Patient admin alert option and will set access rights for Patinet admin alert option");

			Thread.sleep(3000);
			//Clicking on the Setup btn and click on the Patient admin alert

			setupbtnpatadminalert.patientadminalert(driver);
			Thread.sleep(2000);
			framecheck.checkframe12(driver);
			driver.findElement(By.xpath("(//div[@class='menuButton'])[3]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[@id='menuItem_3']")).click(); //click on the access rights
			Thread.sleep(3000);
			framecheck.checkframe11(driver);
			driver.findElement(By.xpath("//td[text()='" + UsergroupN + "']")).click();
			Thread.sleep(5000);


			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[@id='setAll']")).click();  ///click on change all option.
			Thread.sleep(2000);
			driver.switchTo().defaultContent();

			driver.switchTo().frame(driver.findElement(By.id("ultramodal1-modal-iframe")));
			Thread.sleep(3000);
			//here below i am selecting access rights for priv and non priv users because
			//if access right is not set or non priv user then i woul dnot be able to see new created schedule.
			driver.findElement(By.xpath("//body[@class='window-small']//form//table//tbody//tr[2]//td//div[2]//input[2]")).click(); //click on the all members have access for priviliged user
			Thread.sleep(3000);
			//	driver.findElement(By.xpath("//body[@class='window-small']//form//table//tbody//tr[3]//td//div[2]//input[2]")).click();//click on the all members have access for non priviliged user
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@id='butNext']")).click();//on click of confirm button ,control is getting out from the main div
			Thread.sleep(5000);
			driver.findElement(By.xpath("//iframe[@id='f0']/..")).click(); //to get back control on the div we used /.. 
			driver.switchTo().frame(driver.findElement(By.id("f0")));
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='content-pane i-frame-legacy']")));
			driver.findElement(By.xpath("//body[@class='window-large']//form//table//tbody//tr//td[3]//table//tbody//tr[3]//td//button[2]")).click();   // save button click
			Thread.sleep(3000);
			Thread.sleep(3000);

			// Select any Usergroup to change the access of all rights.

			Thread.sleep(2000);
			driver.findElement(By.xpath("//td[text()='Show - Patient administrative alerts']//following-sibling::td//img")).click(); // click on the access rights(Patient med alerts)
			Thread.sleep(2000);
			driver.findElement(By.xpath("//td[text()='Show - Patient administrative alerts']//following-sibling::td//img")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@id='butSave']")).click();
			Thread.sleep(3000);

			Thread.sleep(2000);
			navigatetoselectpat.selpat(driver);
			Thread.sleep(4000);


			driver.switchTo().alert();
			Thread.sleep(6000);

			throw new Exception();
		}
		catch (NoAlertPresentException exception)
		{

			test15.pass("Functionality related with patient admin alerts is working fine");



		}



		catch(Exception e)
		{
			test15.fail("Functionality related with patient admin alerts is not working fine");
			Assert.fail();
		}
	}
	@Test(priority=4)
	public static void clickonAppointmnetlink1fillurlandclickonapntmntdatetime() throws InterruptedException
	{
		try
		{
			test15.log(Status.INFO, "This step will click on Appointmnet link1 and will fillurl then click on the appointment date and time after booking appointment ");
			clickonAppointmentlinkcheckdatetime.setupchecklinkcheckdatetime(driver);

			Thread.sleep(2000);


			Bookapntmntfreebtn.clickonfreebuttontobookappointment(driver);
			Thread.sleep(2000);

			driver.switchTo().alert();
			Thread.sleep(6000);

			throw new Exception();
		}
		catch (NoAlertPresentException exception)
		{

			test15.pass("Functionality related with Appointment link1 is working fine");



		}



		catch(Exception e)
		{
			test15.fail("Functionality related with Appointmnet link is not working fine");
			Assert.fail();
		}
	}

	@Test(priority=5)
	public static void clickonappointmentlink2()
	{
		try
		{


			test15.log(Status.INFO, "This step will click on Appointmnet link2 and will fillurl then click on the appointment date and time after booking appointment ");
			clickonappointmeentlink2windowresize.setupchecklinkcheckdatetime2(driver);

			Thread.sleep(2000);

			bookapntmnetfreebtnforapl2.clickonfreebuttontobookappointment2(driver);

			Thread.sleep(2000);
			driver.switchTo().alert();
			Thread.sleep(6000);

			throw new Exception();
		}
		catch (NoAlertPresentException exception)
		{

			test15.pass("Functionality related with Appointment link2 is working fine");



		}




		catch(Exception e)

		{
			test15.fail("Functionality related with Appointment link2 is not working fine");
			Assert.fail();
		}

	}

	@AfterSuite
	public static void teardown()
	{
		extent15.flush();
		driver.quit();
	}	






}

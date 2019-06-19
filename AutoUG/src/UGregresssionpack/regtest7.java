package UGregresssionpack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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

import AllUgsmoketest.framecheck;
import AllUgsmoketest.userlogin;
import excelreaderutility.Xls_Reader;

public class regtest7  {

	static ExtentHtmlReporter htmlReporter2;
	static ExtentReports extent2;
	static ExtentTest test2;

	static WebDriver driver;

	//static WebDriver driver= new ChromeDriver();	

	/*static SimpleDateFormat formatter = new SimpleDateFormat("HHmmssddMMyyyy");  
	    static Date date = new Date();  

	    static String uniq=formatter.format(date);

	    static String nav="np"+uniq;
	    static String nav5=nav;
	    static String nav1="nh"+uniq;

	    static String nav7="apn"+uniq;
	    static String nav3="abv"+uniq; */

	public static Xls_Reader reader;

	static String UpdateProgram	; 
	static String Updateprabrev;	 
	static String CreateNewPrgName;	 
	static String CreateNewPrgAbrev; 
	static String UpdatingAptName;	 
	static String UpdatingAptAbrev;	
	static String CreateNewApt;	     
	static String CreateNewAptAbrev;
	static String selprgupd;
	public static String serverurl;
	public static String Contacttypename;
	public static String epname;	
	public static String epabrev;	
	public static String Contactypeabrev; 
	public static String Unisystem; 
	public static String Unicode; 
	public static String UniName; 
	public static String selectorderset1;
	public static String selectorderset2;
	public static String ordersetgroupname;
	public static String ordersetgroupabrev;

	static String selapntmntupd;
	static ExtentHtmlReporter htmlReporter17;
	static ExtentReports extent17;
	static ExtentTest test17;
	static String str="Test executed on:";


	@BeforeSuite
	public static void setup() throws InterruptedException
	{
		reader = new Xls_Reader("C:\\Users\\akhosla\\Documents\\regexcelsheet.xlsx");

		serverurl=reader.getCellData("reg1", "UGURL", 2);
		UpdateProgram	 =reader.getCellData("reg7", "UpdateProgram name", 2);
		Updateprabrev	 =reader.getCellData("reg7", "Update Program Abrev", 2);
		CreateNewPrgName	 =reader.getCellData("reg7", "Create New Program Name", 2);
		CreateNewPrgAbrev =reader.getCellData("reg7", "Create New Program Abrev", 2);
		CreateNewApt	     =reader.getCellData("reg7", "Create NewAppointment", 2);
		CreateNewAptAbrev =reader.getCellData("reg7", "Create New Appointment Abrev", 2);
		Contacttypename     =reader.getCellData("reg7", "Contacttype name", 2);
		Contactypeabrev	     =reader.getCellData("reg7", "Contacttype Abrev", 2);
		epname	     =reader.getCellData("reg7", "Episode Name", 2);
		epabrev=reader.getCellData("reg7", "Episodeabrev", 2);
		Unisystem=reader.getCellData("reg7", "UniSystem", 2);
		Unicode=reader.getCellData("reg7", "UniCode", 2);
		UniName=reader.getCellData("reg7", "Name", 2);
		ordersetgroupname=reader.getCellData("reg7", "Ordersetgrpname", 2);
		ordersetgroupabrev=reader.getCellData("reg7", "Ordersetgrpabrev", 2);
		selectorderset1=reader.getCellData("reg7", "SelectCreatedOrderset1", 2);
		selectorderset2=reader.getCellData("reg7", "SelectCreatedOrderset2", 2);



		htmlReporter17 = new ExtentHtmlReporter("Regressiontest7report.html");
		extent17 = new ExtentReports();
		extent17.attachReporter(htmlReporter17);

		/*	htmlReporter2 = new ExtentHtmlReporter("Smoketest3report.html");
		extent2 = new ExtentReports();
		extent2.attachReporter(htmlReporter2); */

		System.setProperty("webdriver.chrome.driver", "C:\\sdriver\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	}
	@Test(priority=1)
	public static void createnewprogram() throws InterruptedException
	{
		try
		{
			test17 = extent17.createTest("Regressiontest7", "This test will verify the Definition tables settings ");

			test17.log(Status.INFO, str +" " +serverurl);
			test17.log(Status.INFO, "This step will Create a new program");
			userlogin.login(driver);

			driver.findElement(By.linkText("Central setup")).click();
			Thread.sleep(2000);

			//Switched for parent frame=F0 because it was not able to come outside from F12 frame so i switched)

			driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f12']")));
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//div[@class='menuButton'])[2]")).click(); //definition table
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@id='menuItem_11']")).click(); //program
			Thread.sleep(2000);



			driver.switchTo().parentFrame();
			driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f11']")));
			Thread.sleep(2000);

			//select program name to update. //below given program should match exactly exist in application.

			driver.findElement(By.xpath("//button[@id='butNew']")).click();
			Thread.sleep(3000);

			driver.findElement(By.xpath("//input[@id='txtPrggenName']")).sendKeys(CreateNewPrgName);  //creating new program
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@id='txtPrggenAbbrev']")).sendKeys(CreateNewPrgAbrev);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@id='butSave']")).click();
			Thread.sleep(3000);


			driver.switchTo().alert();
			Thread.sleep(6000);

			throw new Exception();
		}
		catch (NoAlertPresentException exception)
		{

			test17.pass("User is able to create a new program");




		}
		catch(Exception e)
		{
			test17.fail("User is not able to create a new program");	
			Assert.fail();
		}
	}
	@Test(priority=2)
	public static void deletenewprogram()throws InterruptedException
	{
		try
		{
			test17.log(Status.INFO, "This step will delete a new program");
			driver.findElement(By.xpath("//td[text()='"+ CreateNewPrgName+"']")).click(); 


			//td[text()='dgrg']//following::td[2]//img

			///Deleting program

			Thread.sleep(4000);

			driver.findElement(By.xpath("//td[text()='"+ CreateNewPrgName+"']//following::td[2]//img")).click(); // Clicking on cross icon to delete
			Thread.sleep(1000);

			driver.switchTo().alert().accept();
			Thread.sleep(3000);

			test17.pass("User is able to delete a new program");

		}
		catch(Exception e)
		{
			test17.fail("User is not able to delete a new program");	
			Assert.fail();
		}

	}

	//creating same appointment with same name and abrev.
	@Test(priority=3)
	public static void creatingappointmnettype() throws InterruptedException
	{
		try
		{
			test17.log(Status.INFO, "This step will create a new appointmnettype");

			driver.findElement(By.xpath("//button[@id='butNew']")).click();
			Thread.sleep(3000);

			driver.findElement(By.xpath("//input[@id='txtPrggenName']")).sendKeys(CreateNewPrgName);  //creating new program
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@id='txtPrggenAbbrev']")).sendKeys(CreateNewPrgAbrev);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@id='butSave']")).click();

			Thread.sleep(3000);
			driver.switchTo().alert();
			Thread.sleep(6000);

			throw new Exception();
		}
		catch (NoAlertPresentException exception)
		{

			test17.pass("User is able to create appointmenttype");




		}
		catch(Exception e)
		{
			test17.fail("User is not able to create appointmnettype");	
			Assert.fail();
		}

	}



	//creating new appointmnettype
	@Test(priority=4)
	public static void deleteappointmenttypeandcreatewithsamenameandabrev() throws InterruptedException
	{
		try
		{
			test17.log(Status.INFO, "This step will delete and create a new appointmnettype withw same name and abrev");

			Thread.sleep(2000);
			//	driver.findElement(By.xpath("(//div[@class='menuButton'])[2]")).click(); //definition table
			//Thread.sleep(2000);
			framecheck.checkframe12(driver);
			driver.findElement(By.xpath("//div[@id='menuItem_12']")).click(); //central setup-apntmnt type
			Thread.sleep(2000);
			driver.switchTo().parentFrame();
			driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f11']")));

			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@id='butNew']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@id='txtApptgenName']")).sendKeys(CreateNewApt); //creating new appointment
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@id='txtApptgenAbbrev']")).sendKeys(CreateNewAptAbrev);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@id='butSave']")).click();
			Thread.sleep(4000);
			driver.findElement(By.xpath("//td[text()='"+ CreateNewApt+"']//following::td//following::td//img")).click(); // Deleting appointment.
			Thread.sleep(1000);
			driver.switchTo().alert().accept();

			//Again creating new appointment with same param.

			driver.findElement(By.xpath("//button[@id='butNew']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@id='txtApptgenName']")).sendKeys(CreateNewApt); //creating new appointment
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@id='txtApptgenAbbrev']")).sendKeys(CreateNewAptAbrev);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@id='butSave']")).click();
			Thread.sleep(4000);
			driver.switchTo().alert();
			Thread.sleep(6000);

			throw new Exception();
		}
		catch (NoAlertPresentException exception)
		{

			test17.pass("User is able to delete and create a new appointmnet with same name and abrev");




		}
		catch(Exception e)
		{
			test17.fail("User is not able to click on the Schedule icon");	
			Assert.fail();
		}

	}
	@Test(priority=5)
	public static void createappointmnettypewithsamenameandabrev()throws InterruptedException
	{
		try
		{

			test17.log(Status.INFO, "This step will  and create a new appointmnettype withw same name and abrev that already exist to check error");

			// again creating appointment to see error if apntmnt already exist..
			driver.findElement(By.xpath("//button[@id='butNew']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@id='txtApptgenName']")).sendKeys(CreateNewApt); //Creating new appointment
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@id='txtApptgenAbbrev']")).sendKeys(CreateNewAptAbrev);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@id='butSave']")).click();
			Thread.sleep(1000);
			driver.switchTo().alert().accept();
			Thread.sleep(2000);
			test17.pass("User is not able to see error if the appointment already exist");	
		}
		catch(Exception e)
		{
			test17.fail("User is not able to see error even if the appointmnet already exist");	
			Assert.fail();
		}

	}
	@Test(priority=6)
	public static void createcontacttype()throws InterruptedException
	{
		try
		{

			test17.log(Status.INFO, "This step will  and create a new contact type");

			framecheck.checkframe12(driver);
			driver.findElement(By.xpath("//div[@id='menuItem_6']")).click(); //click on contact type.
			Thread.sleep(1000);
			framecheck.checkframe11(driver);
			driver.findElement(By.xpath("//button[@id='butNew']")).click();
			Thread.sleep(2000);
			//input[@id='txtName']
			driver.findElement(By.xpath("//input[@id='txtName']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='txtName']")).sendKeys(Contacttypename);  // creating contact type.
			Thread.sleep(2000);
			//input[@id='txtAbbrev']
			driver.findElement(By.xpath("//input[@id='txtAbbrev']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='txtAbbrev']")).sendKeys(Contactypeabrev);
			Thread.sleep(2000);

			driver.findElement(By.xpath("//select[@id='selCategory']")).click();

			Select nreport=new Select(driver.findElement(By.xpath("//select[@id='selCategory']")));
			nreport.selectByVisibleText("Attended");
			Thread.sleep(2000);
			//button[@id='butSave']
			driver.findElement(By.xpath("//button[@id='butSave']")).click();
			Thread.sleep(4000);
			driver.switchTo().alert();
			Thread.sleep(6000);

			throw new Exception();
		}
		catch (NoAlertPresentException exception)
		{

			test17.pass("User is able to create a new contact-type");




		}
		catch(Exception e)
		{
			test17.fail("User is not able to create a contact type");	
			Assert.fail();
		}

	}

	//creating episode type

	//episode type should be in use in the episode settings.
	@Test(priority=7)
	public static void createepisodetype()throws InterruptedException
	{
		try
		{

			test17.log(Status.INFO, "This step will  and create a new episode type");


			framecheck.checkframe12(driver);
			driver.findElement(By.xpath("//div[@id='menuItem_27']")).click(); // creating episodetype.
			Thread.sleep(2000);
			framecheck.checkframe11(driver);
			driver.findElement(By.xpath("//button[@id='butNew']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='txtEpsName']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='txtEpsName']")).sendKeys(epname);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='txtEpsAbbrev']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='txtEpsAbbrev']")).sendKeys(epabrev);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@id='butSave']")).click();
			Thread.sleep(2000);
			Thread.sleep(4000);
			driver.switchTo().alert();
			Thread.sleep(6000);

			throw new Exception();
		}
		catch (NoAlertPresentException exception)
		{

			test17.pass("User is able to create a new episode-type");




		}
		catch(Exception e)
		{
			test17.fail("User is not able to create a episode type");	
			Assert.fail();
		}

	}
	@Test(priority=8)
	public static void createuniversalcode() throws InterruptedException
	{
		try
		{
			test17.log(Status.INFO, "This step will  and create a new universal code");
			framecheck.checkframe12(driver);

			driver.findElement(By.xpath("//div[@id='menuItem_33']")).click(); // creating Universal code.
			Thread.sleep(2000);
			framecheck.checkframe11(driver);
			driver.findElement(By.xpath("//button[@id='butNew']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='txtUncoCodSys']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='txtUncoCodSys']")).sendKeys(Unisystem);
			Thread.sleep(2000);
			//input[@id='txtUncoCode']
			driver.findElement(By.xpath("//input[@id='txtUncoCode']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='txtUncoCode']")).sendKeys(Unicode);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='txtUncoShortDescr']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='txtUncoShortDescr']")).sendKeys(UniName);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@id='butSave']")).click();
			Thread.sleep(2000);
			driver.switchTo().alert();
			Thread.sleep(6000);

			throw new Exception();
		}
		catch (NoAlertPresentException exception)
		{

			test17.pass("User is able to create a universalcode");




		}
		catch(Exception e)
		{
			test17.fail("User is not able to create universlacode");	
			Assert.fail();
		}

	}

	@Test(priority=9)
	public static void createordersetgroupoption()
	{
		try
		{
			test17.log(Status.INFO, "This step will Create Orderset group");

			framecheck.checkframe12(driver);
			driver.findElement(By.xpath("//div[@id='menuItem_20']")).click(); // clicking on the orderset group option.
			framecheck.checkframe11(driver);
			driver.findElement(By.xpath("//button[@id='butNew']")).click();

			Thread.sleep(2000);

			//Creating Ordersetgroup.
			driver.findElement(By.xpath("//input[@id='txtName']")).click();  /// ordersetgroupname
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='txtName']")).sendKeys(ordersetgroupname);
			//input[@id='txtAbbrev']
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='txtName']")).sendKeys(ordersetgroupname);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='txtAbbrev']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='txtAbbrev']")).sendKeys(ordersetgroupabrev);
			Thread.sleep(2000);

			Thread.sleep(2000);
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.xpath("//td[text()='"+selectorderset1+"']"))).doubleClick().build().perform();

			Thread.sleep(2000);

			Actions action1 = new Actions(driver);
			action1.moveToElement(driver.findElement(By.xpath("//td[text()='"+selectorderset2+"']"))).doubleClick().build().perform();

			Thread.sleep(2000);

			driver.findElement(By.xpath("//button[@id='butSave']")).click();

			driver.switchTo().alert();
			Thread.sleep(6000);

			throw new Exception();
		}
		catch (NoAlertPresentException exception)
		{

			test17.pass("User is able to create ordersetgroup");




		}
		catch(Exception e)
		{
			test17.fail("User is not able to create ordersetgroup");	
			Assert.fail();
		}

	}


	@AfterSuite
	public static void teardown()
	{
		extent17.flush();
		driver.quit();			
	}


}















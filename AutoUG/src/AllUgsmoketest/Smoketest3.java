package AllUgsmoketest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import excelreaderutility.Xls_Reader;

public class Smoketest3  {

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
	static String selapntmntupd;
	static String str="Test executed on:";
	@BeforeSuite
	public static void setup() throws InterruptedException 
	{
		// TODO Auto-generated method stub
		//Code for test 1 and test 2 smoke test case.
		reader =new Xls_Reader("C:\\Test.xlsx");
		serverurl=reader.getCellData("ST1", "UGURL", 2);
		//	userlogin.login(driver);
		//	String Username	=reader.getCellData("ST1", "Username", 2);
		//String Password	=reader.getCellData("ST1", "Password", 2);


		UpdateProgram	 =reader.getCellData("ST3", "UpdateProgram name", 2);
		Updateprabrev	 =reader.getCellData("ST3", "Update Program Abrev", 2);
		CreateNewPrgName	 =reader.getCellData("ST3", "Create New Program Name", 2);
		CreateNewPrgAbrev =reader.getCellData("ST3", "Create New Program Abrev", 2);
		UpdatingAptName	 =reader.getCellData("ST3", "Updating Appointment Name", 2);
		UpdatingAptAbrev	 =reader.getCellData("ST3", "Updating Appointment Abrev", 2);
		CreateNewApt	     =reader.getCellData("ST3", "Create NewAppointment", 2);
		CreateNewAptAbrev =reader.getCellData("ST3", "Create New Appointment Abrev", 2);
		selprgupd =reader.getCellData("ST3", "SelectProgramNametoUpdate", 2);
		selapntmntupd =reader.getCellData("ST3", "Selectapntmntnametoupdate", 2);

		htmlReporter2 = new ExtentHtmlReporter("Smoketest3report.html");
		extent2 = new ExtentReports();
		extent2.attachReporter(htmlReporter2);

		System.setProperty("webdriver.chrome.driver", "C:\\sdriver\\chromedriver.exe");
		driver= new ChromeDriver();

	}
	@Test(priority=1)
	public static void ClickonDefinitionTableandClickonProgram() throws InterruptedException

	{
		try
		{
			test2 = extent2.createTest("SmokeTest3", "This test is to Validate Create and Update new Program and Appointmenttype");
			test2.log(Status.INFO, str +" " +serverurl);
			test2.log(Status.INFO, "This step will click on Definition table option and will click on Program Option");
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
			test2.pass("User is able to do Click on definition table and program option");
		}
		catch(Exception e)
		{
			test2.fail("User is not able to Click on the Definition table and Program option");
			Assert.fail();
		}

	}
	@Test(priority=2)
	public static void CreateNewProgramandUpdateProgram() throws InterruptedException
	{
		try
		{
			test2.log(Status.INFO, "This step will Create New program and update program");
			driver.switchTo().parentFrame();
			driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f11']")));
			Thread.sleep(2000);

			//select program name to update. //below given program should match exactly exist in application.
			driver.findElement(By.xpath("//td[text()='"+ selprgupd+"']")).click(); // clicking on the program name to update it
			Thread.sleep(2000);

			driver.findElement(By.xpath("//input[@id='txtPrggenName']")).clear();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='txtPrggenName']")).sendKeys(UpdateProgram); //updating program
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@id='txtPrggenAbbrev']")).clear();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@id='txtPrggenAbbrev']")).sendKeys(Updateprabrev);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@id='butSave']")).click();
			Thread.sleep(4000);
			driver.findElement(By.xpath("//button[@id='butNew']")).click();
			Thread.sleep(3000);

			driver.findElement(By.xpath("//input[@id='txtPrggenName']")).sendKeys(CreateNewPrgName);  //creating new program
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@id='txtPrggenAbbrev']")).sendKeys(CreateNewPrgAbrev);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@id='butSave']")).click();
			Thread.sleep(3000);

			test2.pass("User is able to create and update new program");


		}

		catch(Exception e) 
		{
			test2.fail("User is not able to Create and Update new program");
			Assert.fail();

		}

	}

	@Test(priority=3)
	public static void CreateNewAppointmenttypeandUpdateAppointmenttype() throws InterruptedException
	{

		try
		{

			test2.log(Status.INFO, "This step will Create New Appointmenttype and Update new Appointmenttype");
			driver.switchTo().parentFrame();
			driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f12']")));
			driver.findElement(By.xpath("//div[@id='menuItem_12']")).click(); //central setup-apntmnt type
			Thread.sleep(2000);
			driver.switchTo().parentFrame();
			driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f11']")));
			Thread.sleep(2000);


			//select appointment name to update.

			driver.findElement(By.xpath("//td[text()='"+  selapntmntupd+"']")).click();  // clicking on appointment type to update apntmnttype
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='txtApptgenName']")).clear();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='txtApptgenName']")).sendKeys(UpdatingAptName); //updating appointment
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='txtApptgenAbbrev']")).clear();
			driver.findElement(By.xpath("//input[@id='txtApptgenAbbrev']")).sendKeys(UpdatingAptAbrev);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@id='butSave']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@id='butNew']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@id='txtApptgenName']")).sendKeys(CreateNewApt); //creating new appointment
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@id='txtApptgenAbbrev']")).sendKeys(CreateNewAptAbrev);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@id='butSave']")).click();
			Thread.sleep(4000);
			test2.pass("User is able to create and Update new Appointmnet type");
		}
			//if(checkALert())
			//{
			//	Assert.fail();

				
		//	}
			



		//}

		catch(Exception e) 
		{
			test2.fail("User is not able to Create and Update new Appointmenttype");
			Assert.fail();


		}
	}

	@AfterSuite
	public static void tearDown()
	{
		extent2.flush();
		driver.quit();

	}
	/* if(checkALert())
				 {
					 driver.switchTo().frame("f12");

				 }


}*/

	public static boolean checkALert ( )
	{


		driver.switchTo().alert().accept();
		Assert.fail();
		return false;




	}











}


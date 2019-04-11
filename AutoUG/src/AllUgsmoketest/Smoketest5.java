package AllUgsmoketest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

import excelreaderutility.Xls_Reader;

public class Smoketest5 extends Smoketest4 {
	static WebDriver driver;
	public static  Xls_Reader reader ;
	static String generalval	 ;
	static String Stagemarkval	 ;
	static String LoadBalanceValue;
	static String CreateNewPrgName;
	static String GenralSelectDepartment;
	static String PrivilegedUsersSelectDept;
	static String AccessRightsSelectDept;
	static String ProgramsSelectDeptt;

	static ExtentHtmlReporter htmlReporter4;
	static ExtentReports extent4;
	static ExtentTest test4;

	@BeforeSuite
	public static void setup() 
	{
		// TODO Auto-generated method stub
		//Code for test 1 and test 2 smoke test case.

		reader =new Xls_Reader("E:\\Test.xlsx");

		// this below two line of code is just for FYI we need to update it.

		CreateDepname	=reader.getCellData("ST4", "Create Dep name", 2);
		PrivilegedUsersSelectDept =reader.getCellData("ST5", "Privileged Users-Select Department", 2);
		AccessRightsSelectDept	 =reader.getCellData("ST5", "AccessRights-Select Department", 2);
		ProgramsSelectDeptt	 =reader.getCellData("ST5", "Programs-Select Department", 2);
		generalval	 =reader.getCellData("ST5", "General settings-Info value", 2);
		Stagemarkval	 =reader.getCellData("ST5", "Stage Marker-Stage1 Value", 2);
		LoadBalanceValue	 =SubChar(reader.getCellData("ST5", "Load Balance setting Value", 2));
		SetuserAuth	=reader.getCellData("ST4", "SetFamilynameofnewuserAuth", 2);
		UsergroupAb	=reader.getCellData("ST4", "UsergroupAbrev", 2);
		UsergroupN	=reader.getCellData("ST4", "UsergroupName", 2);
		CreateNewPrgName	 =reader.getCellData("ST3", "Create New Program Name", 2);


		htmlReporter4 = new ExtentHtmlReporter("Smoketest4report.html");
		extent4 = new ExtentReports();
		extent4.attachReporter(htmlReporter3);


		System.setProperty("webdriver.chrome.driver", "C:\\sdriver\\chromedriver.exe");
		driver= new ChromeDriver();
	}
	@Test(priority=1)
	public static void clickondepartmentalsetupGeneraloption() throws InterruptedException
	{
		try
		{
			test4 = extent4.createTest("SmokeTest5", "This test is to Validate Departmental settings");
			test4.log(Status.INFO, "This step will click on Departmental Setup - General Option");

			userlogin.login(driver);


			driver.findElement(By.xpath("//a[text()='Departmental setup']")).click();
			Thread.sleep(3000);

			//Switched for parent frame=F0 because it was not able to come outside from F12 frame so i switched)

			driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f12']")));
			Thread.sleep(3000);
			driver.findElement(By.xpath("//div[@class='menuButton']")).click();
			Thread.sleep(1000);


			driver.findElement(By.xpath("//div[@id='menuItem_11']")).click(); //clicking on Departmentalsetup-General Option

		}
		catch(Exception e)
		{
			test4.fail("User is not able to Click on Departmental Steup-General Option");
			Assert.fail();
		}
	}
	//following needs to be done-pending.


	@Test(priority=2)
	public static void SavealldetailsinGeneral() throws InterruptedException
	{
		try
		{
			test4.log(Status.INFO, "This step will click on Departmental Setup - General Option");
			Thread.sleep(3000);
			framecheck.checkframe11(driver);
			Select profile=new Select(driver.findElement(By.xpath("//select[@class='uk-width-1-1']")));
			driver.findElement(By.xpath("//select[@class='uk-width-1-1']")).click(); 
			Thread.sleep(500);
			profile.selectByVisibleText(CreateDepname);

			/*	for(int i=1; i<=2; i++)
			{
				Thread.sleep(2000);
				profile.selectByIndex(i);
			} */
			driver.findElement(By.xpath("//textarea[@class='uk-width-1-1']")).click(); 
			Thread.sleep(2000);
			driver.findElement(By.xpath("//textarea[@class='uk-width-1-1']")).sendKeys(generalval);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@type='submit']")).click();

			boolean x=driver.findElement(By.xpath("//div[@class='uk-width-1-6']//input[@type='checkbox']")).isSelected();

			if(x == false)
			{

				Thread.sleep(3000);
				driver.findElement(By.xpath("//div[@class='uk-width-1-6']//input[@type='checkbox']")).click();
				Thread.sleep(2000);

				driver.findElement(By.xpath("//div[@class='uk-width-4-6']//input")).clear();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[@class='uk-width-4-6']//input")).sendKeys(Stagemarkval);
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				Thread.sleep(3000);




			}
			//boolean y=driver.findElement(By.id("4-7")).isSelected();

			else if(x == true)
			{

				Thread.sleep(3000);
				driver.findElement(By.xpath("//div[@class='uk-width-4-6']//input")).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
				Thread.sleep(3000);
				driver.findElement(By.xpath("//div[@class='uk-width-4-6']//input")).sendKeys(Stagemarkval);
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				Thread.sleep(3000);
			}
			driver.findElement(By.xpath("//a[@label='Load balancing settings']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@class='uk-button uk-button-small uk-margin-right']")).click();
			driver.findElement(By.xpath("//input[@class='uk-form-width-mini uk-form-small uk-text-right'][2]")).click();
			driver.findElement(By.xpath("//input[@class='uk-form-width-mini uk-form-small uk-text-right'][2]")).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@class='uk-form-width-mini uk-form-small uk-text-right'][2]")).sendKeys(LoadBalanceValue);
			Thread.sleep(3000);
			//button[@type='submit']
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//a[@label='Session info updates']")).click();
			Thread.sleep(3000);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@type='submit']")).click(); //saving
			test4.pass("User is able to save all Generel details");
		}
		catch(Exception e)
		{
			test4.fail("User is not able to save General details");
			Assert.fail();
		}

	}

	@Test(priority=3)
	public static void clickonPrivilegedUsersoption() throws InterruptedException
	{
		try
		{
			test4.log(Status.INFO, "This step will click on Priviliged users option");

			framecheck.checkframe12(driver);
			driver.findElement(By.xpath("//div[@id='menuItem_1']")).click(); //privileged users
			Thread.sleep(3000);
			test4.pass("User is able to Click on Priviliged Users Option");
		}

		catch(Exception e)
		{
			test4.fail("User is  not able to Click on Priviliged Users Option");
			Assert.fail();
		}
	}
	@Test(priority=4)
	public static void SelectdepartmentforPriviligeuserandclickonsearchicon() throws InterruptedException
	{
		try
		{
			test4.log(Status.INFO, "This step will will Select department for priviliged users will click on search icon");

			framecheck.checkframe11(driver);
			Select profile0=new Select(driver.findElement(By.xpath("//select[@class='select']")));
			driver.findElement(By.xpath("//select[@class='select']")).click(); 
			Thread.sleep(2000);
			profile0.selectByVisibleText(CreateDepname);
			Thread.sleep(2000);
			//excel read
			//SimpleExcelReaderExample.Readfile();
			//excel read	 
			driver.findElement(By.id("searchName")).sendKeys(SetuserAuth);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//td[@class='searchAction']//img")).click();
			Thread.sleep(3000);
			test4.pass("User is able to select department and click on the Search icon");
		}

		catch(Exception e)
		{
			test4.fail("This step is not working as expected");
			Assert.fail();
		}
	}
	@Test(priority=5)
	public static void selectuserandmakethemprivilgeduserandsave() throws InterruptedException
	{
		try
		{
			test4.log(Status.INFO, "This step will select the user make them Priviliged");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//td[text()='" + SetuserAuth+" "+" "+"-"+" "+UsergroupAb+ "']")).click(); //nav7 is user family name so it will select the user by fam name
			Thread.sleep(2000);
			driver.findElement(By.xpath("//td[@class='boxcontrols']//div//img")).click();
			//td[@class='boxcontrols']//div//img
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@id='butSave']")).click();
			test4.pass("User is able to select user and make them priviliged");
		}
		catch(Exception e)
		{
			test4.fail("User is not able to select user and make them priviliged");
			Assert.fail();
		}
	}
	@Test(priority=6)
	public static void clickonDepartmentalsetupaccessrightoption() throws InterruptedException
	{
		try
		{

			test4.log(Status.INFO, "This step will Click on the Departmental setup-Access rights option");

			framecheck.checkframe12(driver);

			driver.findElement(By.xpath("//div[@id='menuItem_3']")).click(); // access rights
			Thread.sleep(3000);
			framecheck.checkframe11(driver);
			Select profile1=new Select(driver.findElement(By.xpath("//select[@class='select']")));
			driver.findElement(By.xpath("//select[@class='select']")).click(); 
			Thread.sleep(500);
			profile1.selectByVisibleText(CreateDepname);
			driver.findElement(By.xpath("//td[text()='"+UsergroupN+"']")).click();
			Thread.sleep(3000);
			test4.pass("User is able to Click on Access rights option");
		}

		catch(Exception e)
		{
			test4.fail("User is not able to click on the Departmental setup- Access rights option");
			Assert.fail();
		}
	}
	@Test(priority=7)
	public static void clickonchangealloption() throws InterruptedException
	{

		try
		{

			test4.log(Status.INFO, "This step will Click on the Change all to change the rights access");


			driver.findElement(By.xpath("//span[@id='setAll']")).click();  ///click on change all option.
			// Thread.sleep(3000);
			driver.switchTo().defaultContent();
			// driver.switchTo().frame(driver.findElement(By.xpath("//div[@class='modal-dialog']//iframe[@id='ultramodal1-modal-iframe']")));
			//driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='ultramodal1-modal-iframe']")));
			//body[@class='window-small']//form//table//tbody//tr[2]//td//div[2]//input[2]
			//need to handle i frame
			driver.switchTo().frame(driver.findElement(By.id("ultramodal1-modal-iframe")));
			Thread.sleep(3000);
			driver.findElement(By.xpath("//body[@class='window-small']//form//table//tbody//tr[2]//td//div[2]//input[2]")).click(); 
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@id='butNext']")).click();//on click of confirm button ,control is getting out from the main div
			Thread.sleep(5000);
			driver.findElement(By.xpath("//iframe[@id='f0']/..")).click(); //to get back control on the div we used /.. 
			driver.switchTo().frame(driver.findElement(By.id("f0")));
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='content-pane i-frame-legacy']")));
			driver.findElement(By.xpath("//body[@class='window-large']//form//table//tbody//tr//td[3]//table//tbody//tr[3]//td//button[2]")).click();   // save button click
			Thread.sleep(3000);
			test4.pass("User is able to Click on Access rights option");

		}
		catch(Exception e)
		{
			test4.fail("User is not able to click on the Change all Option to change the rights access");
			Assert.fail();
		}
	}

	/* driver.switchTo().defaultContent();
		//not saving values
			 //driver.switchTo().parentFrame();
			// driver.findElement(By.xpath("//body[@class='window-large']//form//table//tbody//tr//td[3]//table//tbody//tr[3]//td//button[2]"));

			 driver.findElement(By.xpath("//button[@id='butSave']")).click();
			//button[@id='butSave']
			// driver.switchTo().defaultContent();
			 Thread.sleep(3000); */
	@Test(priority=8)
	public static void clickontheProgramoption() throws InterruptedException
	{

		try
		{
			test4.log(Status.INFO, "This step will Click on the Program option");



			framecheck.checkframe12(driver);

			driver.findElement(By.xpath("//div[@id='menuItem_4']")).click(); // program
			Thread.sleep(2000);
			test4.pass("User is able to Click on Program option");
		}

		catch(Exception e)
		{
			test4.fail("User is not able to click on the Program Option to change the rights access");
			Assert.fail();
		}
	}
	@Test(priority=9)
	public static void ActivatetheProgramCreatedoCentralevel() throws InterruptedException
	{

		try

		{

			test4.log(Status.INFO, "This step will activate the Program created on the Central level");

			framecheck.checkframe11(driver);
			Select profile2=new Select(driver.findElement(By.xpath("//select[@class='select']")));
			driver.findElement(By.xpath("//select[@class='select']")).click(); 
			Thread.sleep(500);
			profile2.selectByVisibleText(CreateDepname);

			//	 driver.findElement(By.xpath("//td[text()='" + nav5 + "']")).click();
			driver.findElement(By.xpath("//td[text()='" + CreateNewPrgName + "']")).click();
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//img[@class='color-picker-dropdown']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//td[@class='colorBox' and @bgcolor='#000099']")).click();
			Thread.sleep(2000);
			//td[@class='colorBox' and @bgcolor='#000099']
			driver.findElement(By.xpath("//button[@id='butSave']")).click();
			Thread.sleep(2000);

			test4.pass("User is able to Activate the Program created on the Central level");
		}

		catch(Exception e)
		{

			test4.fail("User is not able to Activate the Program");
			Assert.fail();
		}
	}
	@AfterSuite
	public static void teardown()
	{
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
package AllUgsmoketest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import excelreaderutility.Xls_Reader;

public class Smoketest4 
{

public	static WebDriver driver;
	//static SimpleDateFormat formatter = new SimpleDateFormat("HHmmssddMMyyyy");  
	//	static Date date = new Date();  

	public static Xls_Reader reader;

	//useful variables below


	static String UsergroupN;
	static String UsergroupAb;
	static String SelectUserProfile;	
	static String UsegroupExpDate;	
	static String AuthUsername	;
	static String AuthPassword	;
	static String SetuserAuth	;
	static String SetFamofuserAuth	;
	static String SetPaswdofnewuserAuth;	
	//	String Select User IU-Created Usergroup	=reader.getCellData("ST4", "Select User IU-Created Usergroup", 2);
	static String CreateNSite	;
	static String CreateNewSiteAbrev;	
	static	String UpdSite	;
	static String UpdSiteabrev	;
	static String UpdaLocname	;
	static String UpdLocAbrev	;
	static String CreateNewLoc	;
	static String CreateNewLocabrev;	
	static String CreateDepname	;
	static String CreateDeptAbrev;	
	static String SelectHisdeptt;	
	static String SelDA;

	static ExtentHtmlReporter htmlReporter3;
	static ExtentReports extent3;
	static ExtentTest test3;
	public static String serverurl;


	//public static void main(String[] args) throws InterruptedException, IOException {
	// TODO Auto-generated method stub
	//Code for test 1 and test 2 smoke test case.
	//framecheck frm1=new framecheck();


	// userlogin.login(driver);

	//String Username	=reader.getCellData("ST1", "Username", 2);
	// String Password=reader.getCellData("ST1", "Password", 2);
	static String str="Test executed on:";

	@BeforeSuite
	public static void setup() throws InterruptedException
	{
		reader = new Xls_Reader("C:\\Users\\akhosla\\Documents\\Test.xlsx");
		Thread.sleep(2000);
		serverurl=reader.getCellData("ST1", "UGURL", 2);
		
		UsergroupN	=reader.getCellData("ST4", "UsergroupName", 2);
		UsergroupAb	=reader.getCellData("ST4", "UsergroupAbrev", 2);
		SelectUserProfile	=reader.getCellData("ST4", "SelectUsergroupProfile", 2);
		UsegroupExpDate	=reader.getCellData("ST4", "UsegroupExpireDate", 2);
		AuthUsername	=reader.getCellData("ST4", "Authentication Username", 2);
		AuthPassword	=reader.getCellData("ST4", "Authentication Password", 2);
		SetuserAuth	=reader.getCellData("ST4", "Set Username of newuser-Auth", 2);
		SetFamofuserAuth	=reader.getCellData("ST4", "SetFamilynameofnewuserAuth", 2);
		SetPaswdofnewuserAuth	=reader.getCellData("ST4", "Set Password of new user-Auth", 2);
		//	String Select User IU-Created Usergroup	=reader.getCellData("ST4", "Select User IU-Created Usergroup", 2);
		CreateNSite	=reader.getCellData("ST4", "Create NewSite", 2);
		CreateNewSiteAbrev	=reader.getCellData("ST4", "Create NewSite Abrev", 2);
		UpdSite	=reader.getCellData("ST4", "Update Site", 2);
		UpdSiteabrev	=reader.getCellData("ST4", "Update Site abrev", 2);
		UpdaLocname	=reader.getCellData("ST4", "Update Loc name", 2);
		UpdLocAbrev	=reader.getCellData("ST4", "Update Loc Abrev", 2);
		CreateNewLoc	=reader.getCellData("ST4", "Create New Loc", 2);
		CreateNewLocabrev	=reader.getCellData("ST4", "Create New Loc abrev", 2);
		CreateDepname	=reader.getCellData("ST4", "Create Dep name", 2);
		CreateDeptAbrev	=reader.getCellData("ST4", "Create Dept Abrev", 2);
		SelectHisdeptt	=reader.getCellData("ST4", "Select His deptt", 2);
		SelDA	=reader.getCellData("ST4", "Select DA", 2);

		htmlReporter3 = new ExtentHtmlReporter("Smoketest4report.html");
		extent3 = new ExtentReports();
		extent3.attachReporter(htmlReporter3);


		System.setProperty("webdriver.chrome.driver", "C:\\sdriver\\chromedriver.exe");
		driver= new ChromeDriver();
	}
	@Test(priority=1)
	public static void clickonCentralAdminandclickonUsergroup() throws InterruptedException
	{
		try
		{
			
			test3 = extent3.createTest("SmokeTest4", "This test is to Validate Central Administration options");
			test3.log(Status.INFO, str +" " +serverurl);
			test3.log(Status.INFO, "This step will click on Central Administration option and will click on Usergroup Option");

			userlogin.login(driver);

			driver.findElement(By.linkText("Central setup")).click();
			Thread.sleep(2000);

			//Switched for parent frame=F0 because it was not able to come outside from F12 frame so i switched)

			driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f12']")));
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//div[@class='menuButton'])[3]")).click(); // clicking on the Central Admin
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[@id='menuItem_1']")).click(); //usergroups
			Thread.sleep(3000);
			test3.pass("User is able to do Click on the Central Administration option and Usergroup Option");
		}

		catch(Exception e)
		{
			test3.fail("User is not able to Click on the Central Administration option and Usergroup Option");
			Assert.fail();
		}
	}
	@Test(priority=2)
	public static void clickonNewbtnandcreatenewusergrp() throws InterruptedException
	{


		try
		{
			test3.log(Status.INFO, "This step will Create a new user group");
			framecheck.checkframe11(driver);
			driver.findElement(By.xpath("//button[@id='butNew']")).click();
			Thread.sleep(3000);



			driver.findElement(By.xpath("//input[@id='txtAccountgrpName']")).sendKeys(UsergroupN); 

			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@id='txtAccountgrpAbbrev']")).sendKeys(UsergroupAb); 
			Thread.sleep(3000);
			Select profile=new Select(driver.findElement(By.xpath("//select[@id='selRoleId']")));
			profile.selectByVisibleText(SelectUserProfile);
			/*for(int i=0; i<=1; i++)
			{
				Thread.sleep(2000);
				profile.selectByIndex(i);
			}*/
			driver.findElement(By.xpath("//input[@id='txtExpDate']")).clear();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@id='txtExpDate']")).sendKeys(UsegroupExpDate); 
			Thread.sleep(3000);

			driver.findElement(By.xpath("//button[@id='butSave']")).click();  //new usergroup should get created
			Thread.sleep(3000);

			// If value is not getting saved then error we can expect so i am writing below code

			driver.switchTo().alert();
			Thread.sleep(6000);

			throw new Exception();


		}



		catch (NoAlertPresentException exception)
		{

			test3.pass("User is  able to Create a new usergroup");




		}
		catch(Exception e)

		{

			test3.fail("User is not able to Create a new usergorup");
			Assert.fail();
		}

	}

	// Above multiple catch is used for id data is getting saved or not.

	@Test(priority=3)
	public static void CreatingnewuserfromAuthenticationlink() throws InterruptedException
	{
		try
		{

			test3.log(Status.INFO, "This step will Create a new user from Authentication link");
			framecheck.checkframe12(driver);


			driver.findElement(By.xpath("//img[@id='logoutButton']")).click();
			Thread.sleep(5000);
			//create new user form authentication.
			driver.get("https://vm64-its.ultragenda.com/ultragenda.authentication/admin/login");
			driver.manage().window().maximize();
			Thread.sleep(3000);
			driver.findElement(By.id("Form_Username")).sendKeys(AuthUsername);
			Thread.sleep(3000);
			driver.findElement(By.id("Form_Password")).sendKeys(AuthPassword);
			driver.findElement(By.xpath("//*[@type='submit']")).click();
			// frm1.checkframe1();

			// String uniq=formatter.format(date);


			driver.findElement(By.xpath("//div[@class='ui icon center aligned header']//i")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//a[@class='ui icon positive left labeled button']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@type='text' and @name='username']")).sendKeys(SetuserAuth); 

			//check excel this code will write the user name in excel

			// SimpleExcelReaderExample.writefile();

			//check excel


			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@name='familyName']")).sendKeys(SetFamofuserAuth); 
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@type='password' and @name='password']")).sendKeys(SetPaswdofnewuserAuth); 
			Thread.sleep(3000);
			driver.findElement(By.xpath("//div[@class='ui fitted toggle checkbox']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//label[contains(text(), \"Is an administrator\")]/following-sibling::div")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@class='ui primary button']")).click();
			Thread.sleep(6000);

			test3.pass("User is able to Create a new user");


		}

		catch(Exception e)

		{
			test3.fail("User is not able to Create a new User");
			Assert.fail();
		}
	}
	@Test(priority=4)
	public static void Selectnewcreateduserandsearch() throws InterruptedException
	{
		try
		{

			test3.log(Status.INFO, "This step will Select a new user and will search");

			userlogin.login(driver);

			driver.findElement(By.linkText("Central setup")).click();
			Thread.sleep(3000);

			driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f12']")));
			Thread.sleep(3000);
			driver.findElement(By.xpath("//div[@id='menuItem_2']")).click(); //clicking on the Users option in central admin

			framecheck.checkframe11(driver);//frame11 switched
			Thread.sleep(3000);
			//searchinh family of user created in auth
			driver.findElement(By.id("searchLogin")).sendKeys(SetuserAuth);
			//Thread.sleep(2000);
			/* Select nreport=new Select(driver.findElement(By.xpath("//select[@id='searchAccountgrpId']")));

		 driver.findElement(By.xpath("//select[@id='searchAccountgrpId']")).click();
		 Thread.sleep(3000);

		nreport.selectByVisibleText("  "+nav2); 
			 */
			driver.findElement(By.xpath("//td[@class='searchAction']//img")).click();
			Thread.sleep(4000);

			test3.pass("User is able to Select a new created user and search it");

		}
		catch(Exception e)
		{

			test3.fail("User is not able to search new created user ");
			Assert.fail();
		}
	}
	//startfrom driver.findElement(By.xpath("//td[@onclick='showDetails(660);']")).click();
	//some steps required nikki support so now starting from 8th step

	@Test(priority=5)
	public static void ChangeRoleofnewcreatedusergrpandsaveit() throws InterruptedException, IOException
	{

		test3.log(Status.INFO, "This step will change the role of new created usergroup and will save all values");
		try
		{
			Thread.sleep(3000);
			if (driver.findElement(By.xpath("//input[@id='txtCaa']")).isEnabled())
			{
				driver.findElement(By.xpath("//input[@id='txtCaa']")).click();

				Thread.sleep(3000);
				driver.findElement(By.xpath("//input[@id='txtDaa']")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//input[@id='txtIu_1']")).click();

				Select nreport=new Select(driver.findElement(By.xpath("//select[@id='txtIuAccountGrp_1']")));

				driver.findElement(By.xpath("//select[@id='txtIuAccountGrp_1']")).click();
				Thread.sleep(2000);

				nreport.selectByVisibleText(UsergroupN); 
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@id='butSave']")).click();

				test3.pass("This step is working as define expected");

				Thread.sleep(3000);
			}	
			else
			{
				throw new Exception() ;  // here in case if we are not able to search usergroup then throw exception

			}
		}
		catch(Exception e)
		{
			test3.fail("This step is not working as define expected");
			Assert.fail();

		}

	}


	@Test(priority=6)
	public static void ClickonAccessRightsoption() throws InterruptedException
	{
		try
		{
			test3.log(Status.INFO, "This step will Click on the Access rights option");


			framecheck.checkframe12(driver);
			driver.findElement(By.xpath("//div[@id='menuItem_3']")).click(); //click on the access rights
			Thread.sleep(4000);
			test3.pass("User is able to click on the Access rights option");
		}
		catch(Exception e)
		{
			test3.fail("User is not able to click on access rights option ");
			Assert.fail();

		}


	}
	@Test(priority=7)
	public static void ClickonNewUsergroupandclickonchangealltochangeaccessofrighst() throws InterruptedException

	{

		try

		{
			test3.log(Status.INFO, "This step will Click on the the new created usergroup and change all option to change the access of rights");

			framecheck.checkframe11(driver);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//td[text()='" + UsergroupN + "']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//span[@id='setAll']")).click();
			// Thread.sleep(3000);
			driver.switchTo().defaultContent();

			driver.switchTo().frame(driver.findElement(By.id("ultramodal1-modal-iframe")));
			Thread.sleep(3000);
			driver.findElement(By.xpath("//body[@class='window-small']//form//table//tbody//tr[2]//td//div[2]//input[4]")).click();  //delegating all access rights
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@id='butNext']")).click();//on click of confirm button ,control is getting out from the main div
			Thread.sleep(5000);
			driver.findElement(By.xpath("//iframe[@id='f0']/..")).click(); //to get back control on the div we used /.. 
			driver.switchTo().frame(driver.findElement(By.id("f0")));
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='content-pane i-frame-legacy']")));
			driver.findElement(By.xpath("//body[@class='window-large']//form//table//tbody//tr//td[3]//table//tbody//tr[3]//td//button[2]")).click();   // save button click
			Thread.sleep(4000);
			test3.pass("User is able to click on the New created Usregorup and change all option");
		}
		catch(Exception e)
		{
			Thread.sleep(3000);
			test3.fail("User is not able to click on the New created Usergroup and change all option");
			Assert.fail();
		}

	}
	@Test(priority=8)
	public static void Createnewsites() throws InterruptedException
	{
		try
		{

			test3.log(Status.INFO, "This step will Create new Site  ");

			framecheck.checkframe12(driver);

			driver.findElement(By.xpath("//div[@id='menuItem_28']")).click(); //click on Sites option
			Thread.sleep(15000);

			framecheck.checkframe11(driver);
			Thread.sleep(4000);
			driver.findElement(By.xpath("//button[@id='butNew']")).click();
			Thread.sleep(4000);

			//String sitn = "sn"+uniq;

			//	String sitab="sa"+uniq;;


			driver.findElement(By.xpath("//input[@id='txtSiteName']")).sendKeys(CreateNSite); 

			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@id='txtSiteAbbrev']")).sendKeys(CreateNewSiteAbrev); //creating new site
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@id='butSave']")).click();
			Thread.sleep(7000);

			driver.switchTo().alert();
			Thread.sleep(6000);

			throw new Exception();

		}

		catch (NoAlertPresentException exception)
		{

			test3.pass("User is able to Create a new site");



		}
		catch(Exception e)
		{
			test3.fail("User is not able to create new site");
			Assert.fail();
		}
	}		

	@Test(priority=9)
	public static void Updatenewsites() throws InterruptedException
	{
		try
		{
			test3.log(Status.INFO, "This step will Update new Site  ");

			driver.findElement(By.xpath("//td[text()='" + CreateNSite + "']")).click();
			// driver.findElement(By.xpath("//td[@onclick='showDetails(910);']")).click();//updating new site we can enter the same site name in the excel sheet
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@id='txtSiteName']")).clear();
			driver.findElement(By.xpath("//input[@id='txtSiteName']")).sendKeys(UpdSite); 
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@id='txtSiteAbbrev']")).clear();
			driver.findElement(By.xpath("//input[@id='txtSiteAbbrev']")).sendKeys(UpdSiteabrev); 
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@id='butSave']")).click();
			Thread.sleep(3000);


			driver.switchTo().alert();
			Thread.sleep(6000);

			throw new Exception();



			//	test3.pass("User is able to Create a new site");


			//above creating new site
		}


		catch (NoAlertPresentException exception)
		{

			test3.pass("User is able to Update a new site");



		}
		catch(Exception e)
		{
			test3.fail("User is not able to  update site");
			Assert.fail();
		}
	}
	@Test(priority=10)
	public static void updatingloc() throws InterruptedException
	{

		try

		{
			test3.log(Status.INFO, "This step will update the Location ");

			framecheck.checkframe12(driver);
			driver.findElement(By.xpath("//div[@id='menuItem_9']")).click(); //Clicking on loc option
			Thread.sleep(3000);
			framecheck.checkframe11(driver);
			driver.findElement(By.xpath("//td[@onclick='showDetails(108);']")).click();  //updating loc -Newcloc // here need to select location first value will get retriever from excel
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@id='txtLocName']")).clear();
			driver.findElement(By.xpath("//input[@id='txtLocName']")).sendKeys(UpdaLocname); 
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@id='txtLocAbbrev']")).clear();
			driver.findElement(By.xpath("//input[@id='txtLocAbbrev']")).sendKeys(UpdLocAbrev);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@id='butSave']")).click();
			Thread.sleep(3000);

			driver.switchTo().alert();
			Thread.sleep(6000);

			throw new Exception();

		}	

		catch (NoAlertPresentException exception)
		{

			test3.pass("User is able to Update a new Location");



		}
		catch(Exception e)
		{
			test3.fail("User is not able to Update new Location");
			Assert.fail();
		}

	}
	@Test(priority=11)
	public static void CreatingNewLoc() throws InterruptedException
	{
		try
		{
			test3.log(Status.INFO, "This step will Create New Location ");
			driver.findElement(By.xpath("//button[@id='butNew']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@id='txtLocName']")).sendKeys(CreateNewLoc);  //creatin new loc
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@id='txtLocAbbrev']")).sendKeys(CreateNewLocabrev);

			Thread.sleep(3000);
			Select la=new Select(driver.findElement(By.xpath("//select[@id='txtLocSite']")));
			la.selectByVisibleText(UpdSite); 
			/* for(int i=0; i<=1; i++)
			{
				Thread.sleep(2000);
				la.selectByIndex(i);
			}*/
			driver.findElement(By.xpath("//button[@id='butSave']")).click();
			Thread.sleep(3000);


			driver.switchTo().alert();
			Thread.sleep(6000);

			throw new Exception();
			//test3.pass("User is able to Create and update new location");

			//above creating and updating loc


		}
		catch (NoAlertPresentException exception)
		{

			test3.pass("User is able to Create a new Location");



		}

		catch(Exception e)
		{
			test3.fail("User is not able to create  Location");
			Assert.fail();
		}
	}
	@Test(priority=12)
	public static void creatingdepartments()throws InterruptedException
	{
		try
		{
			test3.log(Status.INFO, "This step will Create new Department ");

			framecheck.checkframe12(driver);
			driver.findElement(By.xpath("//div[@id='menuItem_4']")).click(); // clicking on the department option
			framecheck.checkframe11(driver);
			Thread.sleep(7000);
			driver.findElement(By.xpath("//button[@id='butNew' and @class='b7522 btn-hover']")).click();
			Thread.sleep(7000);
			// driver.findElement(By.xpath("//input[@id='name-input']")).clear();

			driver.findElement(By.xpath("//input[@id='name-input']")).sendKeys(CreateDepname); 
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@id='abbreviation-input']")).clear();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@id='abbreviation-input']")).sendKeys(CreateDeptAbrev);
			Thread.sleep(3000);
			Select deptt=new Select(driver.findElement(By.xpath("//select[@id='his-department-input']")));
			deptt.selectByVisibleText(SelectHisdeptt);
			/*	for(int i=1; i<=2; i++)
			{
				Thread.sleep(2000);
				deptt.selectByIndex(i);
			}*/
			Thread.sleep(2000);
			driver.findElement(By.xpath("//span[@class='Select-arrow']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@style='width:5px;box-sizing:content-box;']")).sendKeys(SelDA); 
			Actions actions = new Actions(driver);
			Thread.sleep(2000);
			actions.sendKeys(Keys.DOWN).build().perform();
			Thread.sleep(2000);
			actions.sendKeys(Keys.ENTER).build().perform();
			Thread.sleep(2000);
			/*	 for(int i=0; i<=3; i++)
			 {
			 Actions actions = new Actions(driver);
			 Thread.sleep(2000);
			 actions.sendKeys(Keys.DOWN).build().perform();
			 Thread.sleep(2000);
			 actions.sendKeys(Keys.ENTER).build().perform();
			 Thread.sleep(2000);
			 }	*/
			Thread.sleep(5000);
			driver.findElement(By.xpath("//button[@class='ug-button' and @id='save-button']")).click();

			Thread.sleep(3000);

			driver.switchTo().alert();
			Thread.sleep(6000);

			throw new Exception();

		}


		catch (NoAlertPresentException exception)
		{

			test3.pass("User is able to Create a new Department");



		}
		catch(Exception e)
		{
			test3.fail("User is not able to Create new Department");
			Assert.fail();

		}

	}
	@AfterSuite
	public static void teardown()
	{
		extent3.flush();
		driver.quit();
	}









}


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
import ugprofunctionality.referrallistyn;
import ugprofunctionality.setupbtnandactdeactsetting;
import ugprofunctionality.waitinglistYN;

public class regtest8 
{
	public static WebDriver driver;
	static String UsergroupName;
	static String UsergroupAbre;
	static String SelectingUserProfile;
	static String Ugexpirydate;
	static String AuthUsername;
	static String AuthPassword;
	static String SetuserAuth;
	static String SetFamofuserAuth;
	static String SetPaswdofnewuserAuth;
	static String selectdepttfortheuseraccountpriv;
	public static Xls_Reader reader;
	static ExtentHtmlReporter htmlReporter18;
	static ExtentReports extent18;
	static ExtentTest test18;
	static String serverurl;

	static String str="Test executed on:";



	@BeforeSuite
	public static void setup() throws InterruptedException 
	{


		reader = new Xls_Reader("C:\\Users\\akhosla\\Documents\\regexcelsheet.xlsx");
		Thread.sleep(2000);
		UsergroupName =reader.getCellData("reg8", "UsergroupName", 2);
		UsergroupAbre=reader.getCellData("reg8", "UsergroupAbrev", 2);
		SelectingUserProfile=reader.getCellData("reg8", "SelectingUserProfile", 2);
		Ugexpirydate=reader.getCellData("reg8", "ExpiredateUsergroup", 2);
		AuthUsername	=reader.getCellData("reg8", "Authentication Username", 2);
		AuthPassword	=reader.getCellData("reg8", "Authentication Password", 2);
		SetuserAuth	=reader.getCellData("reg8", "Set Username of newuser-Auth", 2);
		SetFamofuserAuth	=reader.getCellData("reg8", "SetFamilynameofnewuserAuth", 2);
		SetPaswdofnewuserAuth	=reader.getCellData("reg8", "Set Password of new user-Auth", 2);
		selectdepttfortheuseraccountpriv=reader.getCellData("reg8", "SelecttheDepartmentfortheuseraccountispriviliged", 2);


		htmlReporter18 = new ExtentHtmlReporter("Regressiontest8report.html");
		extent18 = new ExtentReports();
		extent18.attachReporter(htmlReporter18);


		System.setProperty("webdriver.chrome.driver", "C:\\sdriver\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	}

	@Test(priority=1)
	public static void createnewusergroup() throws InterruptedException
	{
		try
		{

			test18 = extent18.createTest("Regressiontest8", "This test will validate usergroups,users and accessrights functionality");
			test18.log(Status.INFO, str +" " +serverurl);
			test18.log(Status.INFO, "This step will Create new usergorup");


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
			framecheck.checkframe11(driver);
			driver.findElement(By.xpath("//button[@id='butNew']")).click();
			Thread.sleep(3000);



			driver.findElement(By.xpath("//input[@id='txtAccountgrpName']")).sendKeys(UsergroupName ); 

			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@id='txtAccountgrpAbbrev']")).sendKeys(UsergroupAbre); 
			Thread.sleep(3000);
			Select profile=new Select(driver.findElement(By.xpath("//select[@id='selRoleId']")));
			profile.selectByVisibleText(SelectingUserProfile);
			/*for(int i=0; i<=1; i++)
		{
			Thread.sleep(2000);
			profile.selectByIndex(i);
		}*/
			driver.findElement(By.xpath("//input[@id='txtExpDate']")).clear();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@id='txtExpDate']")).sendKeys("23-12-2010"); 
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@id='butSave']")).click(); 
			Thread.sleep(1000);
			driver.switchTo().alert().accept();

			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='txtExpDate']")).click(); 
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='txtExpDate']")).clear();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='txtExpDate']")).sendKeys(Ugexpirydate); 
			Thread.sleep(3000);

			driver.findElement(By.xpath("//button[@id='butSave']")).click();  //new usergroup should get created
			Thread.sleep(3000);
			Thread.sleep(2000);
			driver.switchTo().alert();
			Thread.sleep(6000);

			throw new Exception();



		}
		catch (NoAlertPresentException exception)
		{

			test18.pass("User is able to create new user group");




		}
		catch(Exception e)

		{

			test18.fail("User is not able to create new user group");
			Assert.fail();
		}
	}
	@Test(priority=2)
	public static void createnewuser() throws InterruptedException
	{
		try
		{
			test18.log(Status.INFO, "This step will Create new user");

			//Creating new user.
			framecheck.checkframe12(driver);

			driver.findElement(By.xpath("//img[@id='logoutButton']")).click();
			Thread.sleep(6000);
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


			//here searching user to click on the advancec button.

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

			driver.findElement(By.xpath("//input[@id='txtCaa']")).click();

			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@id='txtDaa']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@id='txtIu_1']")).click();

			Select nreport=new Select(driver.findElement(By.xpath("//select[@id='txtIuAccountGrp_1']")));

			driver.findElement(By.xpath("//select[@id='txtIuAccountGrp_1']")).click();
			Thread.sleep(2000);

			nreport.selectByVisibleText(UsergroupName); 
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@id='butSave']")).click();
			Thread.sleep(5000);
			Thread.sleep(2000);
			driver.switchTo().alert();
			Thread.sleep(6000);

			throw new Exception();



		}
		catch (NoAlertPresentException exception)
		{

			test18.pass("User is able to create a new user and link them each to a new usergroup");




		}
		catch(Exception e)

		{

			test18.fail("User is not able to create a new user and link them each to a new usergroupp");
			Assert.fail();
		}
	}
	@Test(priority=3)
	public static void useadvancebuttontoselectadepartment()
	{
		try
		{

			test18.log(Status.INFO, "This step will click on the Advanced button to select department");
			//button[@id='butAdvanced']
			driver.findElement(By.xpath("//button[@id='butAdvanced']")).click();
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			Thread.sleep(3000);
			driver.switchTo().frame(driver.findElement(By.id("ultramodal1-modal-iframe")));
			Thread.sleep(3000);
			//searching departments.
			//img[@onclick='searchDepartments();']
			driver.findElement(By.xpath("//img[@onclick='searchDepartments();']")).click();  // click on the search icon.

			//td[text()='Cardio surgery']


			driver.findElement(By.xpath("//td[text()='" + selectdepttfortheuseraccountpriv + "']")).click();
			Thread.sleep(2000);
			//click on the arrow icon
			driver.findElement(By.xpath("//td//div//img[@style='cursor:pointer']")).click(); 

			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@id='butSave' and text()='Save and close']")).click();  // clicking on the save and close button.
			Thread.sleep(3000);
			Thread.sleep(2000);
			driver.switchTo().parentFrame();
			driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f10']")));
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@class='headerLinks']//span[2]")).click(); // clicking on the DS
			Thread.sleep(6000);




			//Departmental setup-General Option.


			framecheck.checkframe12(driver);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//div[@class='menuButton']")).click();
			Thread.sleep(1000);

			driver.findElement(By.xpath("//div[@id='menuItem_1']")).click(); // clciking on the priviliged users options
			Thread.sleep(3000);
			framecheck.checkframe11(driver);
			Select pro3=new Select(driver.findElement(By.xpath("//select[@class='select']")));
			driver.findElement(By.xpath("//select[@class='select']")).click();
			pro3.selectByVisibleText(selectdepttfortheuseraccountpriv);  //department created on central level
			//user should be available in the Priviliged settings.

			driver.switchTo().parentFrame();
			driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f10']")));
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@class='headerLinks']//span[1]")).click(); // clicking on the Central Setup.
			Thread.sleep(6000);
			framecheck.checkframe12(driver);

			driver.findElement(By.xpath("//div[@id='menuItem_2']")).click(); //clicking on the Users option in central admin

			framecheck.checkframe11(driver);//frame11 switched
			Thread.sleep(3000);

			driver.findElement(By.id("searchLogin")).sendKeys(SetuserAuth);


			driver.findElement(By.xpath("//td[@class='searchAction']//img")).click();
			driver.findElement(By.xpath("//button[@id='butAdvanced']")).click();
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			Thread.sleep(3000);
			driver.switchTo().frame(driver.findElement(By.id("ultramodal1-modal-iframe")));
			Thread.sleep(3000);
			//searching departments.
			//img[@onclick='searchDepartments();']
			driver.findElement(By.xpath("//img[@onclick='searchDepartments();']")).click();  // click on the search icon.

			driver.findElement(By.xpath("//table[@id='targetSelectionTable']//td[text()='" + selectdepttfortheuseraccountpriv + "']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//td//div//img[@style='cursor:pointer;']")).click(); 

			Thread.sleep(2000);
			driver.switchTo().parentFrame();
			driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f10']")));
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@class='headerLinks']//span[2]")).click(); // clicking on the DS
			Thread.sleep(6000);




			//Departmental setup-General Option.


			framecheck.checkframe12(driver);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//div[@class='menuButton']")).click();
			Thread.sleep(1000);

			driver.findElement(By.xpath("//div[@id='menuItem_1']")).click(); // clciking on the priviliged users options
			Thread.sleep(3000);
			framecheck.checkframe11(driver);
			Select pro4=new Select(driver.findElement(By.xpath("//select[@class='select']")));
			driver.findElement(By.xpath("//select[@class='select']")).click();
			pro4.selectByVisibleText(selectdepttfortheuseraccountpriv);  //department created on central level

			driver.switchTo().parentFrame();
			driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f10']")));
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@class='headerLinks']//span[1]")).click(); // clicking on the Central Setup.
			Thread.sleep(6000);

			//table[@id='targetSelectionTable']//td[text()='Cardio surgery']
			//td//div//img[@style='cursor:pointer;']


			driver.switchTo().alert();
			Thread.sleep(6000);

			throw new Exception();



		}
		catch (NoAlertPresentException exception)
		{

			test18.pass("User is able to select a department using advanced button");




		}
		catch(Exception e)

		{

			test18.fail("User is not able to select a department using advanced button");
			Assert.fail();
		}
	}
	//one step pending make the user unpriviliged.

	@Test(priority=4)
	public static void grantaccessrighttonewusergorup() throws InterruptedException
	{
		try
		{
			test18.log(Status.INFO, "This step will Grant access rights to a new user group");

			// Granting access 
			//		driver.findElement(By.xpath("//iframe[@id='f0']/..")).click(); //to get back control on the div we used /.. 
			driver.switchTo().frame(driver.findElement(By.id("f0")));

			driver.switchTo().frame(driver.findElement(By.id("f12")));
			driver.findElement(By.xpath("//div[@id='menuItem_3']")).click(); //click on the access rights
			Thread.sleep(4000);
			framecheck.checkframe11(driver);
			driver.findElement(By.xpath("//td[text()='" +UsergroupName + "']")).click();
			Thread.sleep(2000);

			//clicking three times because i need to put it on green.
			driver.findElement(By.xpath("//td[text()='Show - Free slots']")).click();
			driver.findElement(By.xpath("//td[text()='Show - Free slots']")).click();
			driver.findElement(By.xpath("//td[text()='Show - Free slots']")).click();

			Thread.sleep(2000);
			driver.findElement(By.xpath("//td[text()='Show - Booked slots']")).click();
			driver.findElement(By.xpath("//td[text()='Show - Booked slots']")).click();
			driver.findElement(By.xpath("//td[text()='Show - Booked slots']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@id='butSave']")).click();
			Thread.sleep(4000);
			Thread.sleep(2000);
			driver.switchTo().alert();
			Thread.sleep(6000);

			throw new Exception();



		}
		catch (NoAlertPresentException exception)
		{

			test18.pass("User is able to grant access rights");




		}
		catch(Exception e)

		{

			test18.fail("User is not able to grant access rights");
			Assert.fail();
		}
	}
	//functionality waiting list and referral list in use or not.

	//		driver.switchTo().defaultContent();

	//button[@class='ug-button'  and  text()='Cancel']
	@Test(priority=5)
	public static void setaccessrightsforwaitinglist() throws InterruptedException
	{
		try
		{
			test18.log(Status.INFO, "This step will set waiting list in use or not or will check the access rights for the same");
			framecheck.checkframe12(driver);

			driver.findElement(By.xpath("(//div[@class='menuButton'])[1]")).click(); //System administration
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//div[@id='menuItem_18'])[1]")).click();  //System Settings
			Thread.sleep(2000);


			driver.switchTo().parentFrame();
			//Switched for parent frame=F0 because it was not able to come outside from F12 frame so i switched)

			driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f11']")));
			driver.findElement(By.xpath("//th[text()='Activate / de-activate features']")).click(); // clicking on Activate / de-activate features option.
			Thread.sleep(4000);

			//------------------------------------------------------------------------------------------------------------------------------------------------------
			//waiting list functionality.

			waitinglistYN.waitlistY(driver);

			setupbtnandactdeactsetting.Activatesettings(driver);

			waitinglistYN.waitlistN(driver);
			Thread.sleep(2000);
			driver.switchTo().alert();
			Thread.sleep(6000);

			throw new Exception();



		}
		catch (NoAlertPresentException exception)
		{

			test18.pass("User is able to see access rights as per waiting list settings");




		}
		catch(Exception e)

		{

			test18.fail("User is not able to see access rights as per waiting list settings");
			Assert.fail();
		}
	}
	@Test(priority=6)
	public static void setaccessrightsforreferrallist() throws InterruptedException
	{

		try
		{
			test18.log(Status.INFO, "This step will set referral list in use or not or will check the access rights for the same");
			setupbtnandactdeactsetting.Activatesettings(driver);

			referrallistyn.listrefY(driver);

			setupbtnandactdeactsetting.Activatesettings(driver);

			referrallistyn.listrefN(driver);

			Thread.sleep(3000);


			Thread.sleep(2000);
			driver.switchTo().alert();
			Thread.sleep(6000);

			throw new Exception();



		}
		catch (NoAlertPresentException exception)
		{

			test18.pass("User is able to see access rights as per referral list settings");




		}
		catch(Exception e)

		{

			test18.fail("User is not able to see access rights as per referral list settings");
			Assert.fail();
		}
	}

	@Test(priority=7)
	public static void delegatingacccessrightsforthenewusergorup()
	{
		try
		{
			test18.log(Status.INFO, "This step will delegate access rights for the new user group");
			driver.switchTo().frame(driver.findElement(By.id("f0")));

			driver.switchTo().frame(driver.findElement(By.id("f11")));


			driver.findElement(By.xpath("//img[@id='setupButton']")).click();  // click on the setup button.
			Thread.sleep(7000);

			//one point not covered as not able to see error if saving values in maximum future book days larger than central setup.
			driver.switchTo().parentFrame();
			driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f10']")));
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@class='headerLinks']//span[1]")).click(); // clicking on the Central Setup.
			Thread.sleep(6000);
			framecheck.checkframe12(driver);



			//delegating all access rights. 


			driver.findElement(By.xpath("//div[@id='menuItem_3']")).click(); //click on the access rights
			Thread.sleep(4000);
			framecheck.checkframe11(driver);
			driver.findElement(By.xpath("//td[text()='" +UsergroupName + "']")).click();


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
			Thread.sleep(2000);
			driver.switchTo().alert();
			Thread.sleep(6000);

			throw new Exception();



		}
		catch (NoAlertPresentException exception)
		{

			test18.pass("User is able to delegate acccess rights for th new user group");




		}
		catch(Exception e)

		{

			test18.fail("User is not able to delegate access rights for the new user group");
			Assert.fail();
		}
	}
	@AfterSuite
	public static void teardown()
	{
		extent18.flush();
		driver.quit();			
	}





}


package UGregresssionpack;

import java.util.concurrent.TimeUnit;

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

import AllUgsmoketest.framecheck;
import AllUgsmoketest.userlogin;
import excelreaderutility.Xls_Reader;
import ugprofunctionality.creatinghisdeptt;

public class regtest10 {
	public	static WebDriver driver;

	public static Xls_Reader reader;
	public static String Hisdeptname;
	public static String codehisdept;
	public static String CreateDepname;
	public static String serverurl;
	public static String CreateDeptAbrev;
	public static String SelectHisdeptt;
	public static String SelDA;
	public static String Authorityfamname;
	public static String Authorityabrev;
	public static ExtentHtmlReporter  htmlReporter20;
	static ExtentReports extent20;
	static ExtentTest test20;
	static String str="Test executed on:";

	public static String selectexistingdeptt;

	@BeforeSuite
	public static void setup()throws InterruptedException 
	{

		reader = new Xls_Reader("C:\\Users\\akhosla\\Documents\\regexcelsheet.xlsx");
		serverurl=reader.getCellData("reg1", "UGURL", 2);
		Thread.sleep(2000);

		Hisdeptname	=reader.getCellData("reg10", "Hisdeptname", 2);
		codehisdept	=reader.getCellData("reg10", "Hisdeptcode", 2);
		CreateDepname	=reader.getCellData("reg10", "Create Dep name", 2);
		CreateDeptAbrev	=reader.getCellData("reg10", "Create Dept Abrev", 2);
		SelectHisdeptt	=reader.getCellData("reg10", "Select His deptt", 2);
		SelDA	=reader.getCellData("reg10", "Select DA", 2);
		selectexistingdeptt = reader.getCellData("reg10", "SelectExistingDepartment", 2);
		Authorityfamname= reader.getCellData("reg10", "Authorityfamnaame", 2);
		Authorityabrev =reader.getCellData("reg10", "Authorityabrev", 2);
		htmlReporter20 = new ExtentHtmlReporter("Regressiontest10report.html");
		extent20 = new ExtentReports();
		extent20.attachReporter(htmlReporter20);


		System.setProperty("webdriver.chrome.driver", "C:\\sdriver\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	}



	@Test(priority=1)
	public static void creatinghisdepartment() throws InterruptedException
	{

		try
		{
			test20 = extent20.createTest("Regressiontest9", "This test will verify Sites and Locations functionality ");

			test20.log(Status.INFO, str +" " +serverurl);
			test20.log(Status.INFO, "This step will Create his department");
			
			
			userlogin.login(driver);
			driver.findElement(By.linkText("Central setup")).click();
			driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f12']")));

			creatinghisdeptt.hisdeptcreation(driver);
			Thread.sleep(3000);

			driver.switchTo().alert();
			Thread.sleep(6000);

			throw new Exception();
		}
		catch (NoAlertPresentException exception)
		{

			test20.pass("User is able to create a his department");

		}
		catch(Exception e)
		{
			test20.fail("User is not able to create a his department");	
			Assert.fail();
		}
	}
	@Test(priority=2)
	public static void creatingnewdepartment() throws InterruptedException
	{
		try
		{
			test20.log(Status.INFO, "This step will Create new department");
			framecheck.checkframe12(driver);
			driver.findElement(By.xpath("//div[@id='menuItem_4']")).click(); // clicking on the departments option.
			Thread.sleep(2000);
			framecheck.checkframe11(driver);
			Thread.sleep(2000);
			//creating department

			//button[@id='butNew']
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

			Thread.sleep(5000);

			driver.switchTo().alert();
			Thread.sleep(6000);

			throw new Exception();
		}
		catch (NoAlertPresentException exception)
		{

			test20.pass("User is able to create a new department");




		}
		catch(Exception e)
		{
			test20.fail("User is not able to create a new department");	
			Assert.fail();
		}
	}


	//doing Log on as the DA of the new department. 

	//	System.setProperty("webdriver.chrome.driver", "C:\\selenium drivers\\chromedriver_win32\\chromedriver.exe");
	//https://vm64-its.ultragenda.com/UltraGendaPro?newwindow=0


	/*

		userlogin.login(driver); // change the passowrd in the excel file

		driver.findElement(By.linkText("Central setup")).click();
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f12']")));
		driver.findElement(By.xpath("(//div[@class='menuButton'])[3]")).click();  //Central administration
		Thread.sleep(2000);

		framecheck.checkframe11(driver);
		Thread.sleep(2000);
	 */
	
	@Test(priority=3)
	public static void checkerrormeessageifabrvempty() throws InterruptedException
	{
		try

		{
			test20.log(Status.INFO, "This step will check error message if abbreviation filed is empty");
			driver.findElement(By.xpath("//td[text()='"+CreateDepname +"']")).click(); //selecting new created department."
			Thread.sleep(2000);

			driver.findElement(By.xpath("//input[@id='abbreviation-input']")).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));  //checking error if the abbreviation is empty.
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@class='ug-button' and @id='save-button']")).click();

			Thread.sleep(3000);
			driver.switchTo().alert();
			Thread.sleep(6000);

			throw new Exception();
		}
		catch (NoAlertPresentException exception)
		{

			test20.pass("User is able to see error message");




		}
		catch(Exception e)
		{
			test20.fail("User is not able to see error message");	
			Assert.fail();
		}
	}
	@Test(priority=4)
	public static void createnewauthority() throws InterruptedException
	{
		try
		{
			test20.log(Status.INFO, "This step will Create new authority");
			framecheck.checkframe12(driver);
			driver.findElement(By.xpath("//div[@id='menuItem_7']")).click();  // clicking on the authorities option.
			Thread.sleep(2000);
			framecheck.checkframe11(driver);

			driver.findElement(By.xpath("//button[@id='butNew']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='txtCpsFamilyName']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='txtCpsFamilyName']")).sendKeys(Authorityfamname);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='txtCpsAbbrev']")).sendKeys(Authorityabrev);
			Thread.sleep(2000);

			driver.findElement(By.xpath("//button[@id='butSave']")).click();
			Thread.sleep(4000);





			driver.switchTo().alert();
			Thread.sleep(6000);

			throw new Exception();
		}
		catch (NoAlertPresentException exception)
		{

			test20.pass("User is able to create a new Authority");




		}
		catch(Exception e)
		{
			test20.fail("User is not able to create a new Authority");	
			Assert.fail();
		}
	}
	@AfterSuite
	public static void teardown()
	{
		extent20.flush();
		driver.quit();			
	}
}

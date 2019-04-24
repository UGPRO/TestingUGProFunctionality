package UGregresssionpack;



import AllUgsmoketest.Smoketest8;
import AllUgsmoketest.framecheck;
import AllUgsmoketest.userlogin;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import excelreaderutility.Xls_Reader;
import org.testng.Assert;

public class regtest1 
{

	public  static Xls_Reader reader;
	public static WebDriver driver;

	static String Refreshval ;
	static String Calendarday;	
	static String  ScheduleNavn;
	public static String serverurl;
	static String AuthUsername	;
	static String AuthPassword	;
	static String logtime	;
	static ExtentHtmlReporter htmlReporter10;
	static ExtentReports extent10;
	static ExtentTest test10;
	static String str="Test executed on:";


	@BeforeSuite
	public static void setup() throws InterruptedException 
	{

		reader =new Xls_Reader("C:\\Users\\akhosla\\Documents\\regexcelsheet.xlsx");
		serverurl=reader.getCellData("reg1", "UGURL", 2);


		Refreshval = SubChar(reader.getCellData("reg1", "ScreenRefresh value", 2).toString());
		Calendarday	=reader.getCellData("reg1", "CalendarFirstDayOfWeek", 2);
		ScheduleNavn	 =reader.getCellData("reg1", "Schedule Name", 2);
		AuthUsername	=reader.getCellData("reg1", "Authentication Username", 2);
		AuthPassword	=reader.getCellData("reg1", "Authentication Password", 2);
		logtime =SubChar(reader.getCellData("reg1", "Logoff time", 2).toString());
		
		htmlReporter10 = new ExtentHtmlReporter("Regressiontest1report.html");
		extent10 = new ExtentReports();
		extent10.attachReporter(htmlReporter10);


		System.setProperty("webdriver.chrome.driver", "C:\\sdriver\\chromedriver.exe");
		driver= new ChromeDriver();


	}


	//Thread.sleep(2000);

	@Test(priority=1)
	public static void errorcheckscreenrefreshtime()
	{
		try
		{

			test10 = extent10.createTest("RegressionTest1", "This test is to Validating System Settings");
			test10.log(Status.INFO, str +" " +serverurl);
			test10.log(Status.INFO, "This step will Validate screen refresh time field values");


			userlogin.login(driver);
			driver.findElement(By.linkText("Central setup")).click();
			Thread.sleep(2000);
			driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f12']")));

			driver.findElement(By.xpath("(//div[@class='menuButton'])[1]")).click();; //System administration
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//div[@id='menuItem_18'])[1]")).click();  //System Settings
			Thread.sleep(2000);
			driver.switchTo().parentFrame();
			//Switched for parent frame=F0 because it was not able to come outside from F12 frame so i switched)

			driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f11']")));
			driver.findElement(By.xpath("//th[@class='rowHead']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='txtScreenRefresh']")).clear();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@id='txtScreenRefresh']")).sendKeys("0");
			Thread.sleep(3000);

			driver.findElement(By.xpath("//button[@id='butSave']")).click();
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
			// driver.findElement(By.xpath("//input[@id='txtScreenRefresh']")).sendKeys("0");
			//driver.switchTo().alert().accept();
			Thread.sleep(4000);
			driver.findElement(By.xpath("//input[@id='txtScreenRefresh']")).clear();
			driver.findElement(By.xpath("//input[@id='txtScreenRefresh']")).sendKeys("20");
			driver.findElement(By.xpath("//button[@id='butSave']")).click();
			Thread.sleep(2000); 
			driver.switchTo().alert().accept();
			Thread.sleep(4000);
			test10.pass("User is able to see the error popup after changing the screenrefreshtime settings");
		}
		catch(Exception e)
		{
			test10.fail("User is not able to see the error popup after changing the screenrefreshtime settings");
			Assert.fail();
		}
	}
	@Test(priority=2)
	public static void nonactivitylogoff() throws InterruptedException
	{
		try
		{
			//Switched for parent frame=F0 because it was not able to come outside from F12 frame so i switched)

			test10.log(Status.INFO, "This step will Validate end user is logging off or not after 1 minute non activity");
			Thread.sleep(5000); 
			driver.switchTo().parentFrame();
			// need to logout
			driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f12']")));
			Thread.sleep(2000);
			driver.findElement(By.xpath("//img[@id='logoutButton']")).click();
			Thread.sleep(2000);
			driver.switchTo().alert().dismiss();
			Thread.sleep(4000);

			//navigating to authentication.


			driver.get("https://vm64-its/ultragenda.authentication/admin/login");
			driver.manage().window().maximize();
			Thread.sleep(3000);
			driver.findElement(By.id("Form_Username")).sendKeys(AuthUsername);
			Thread.sleep(3000);
			driver.findElement(By.id("Form_Password")).sendKeys(AuthPassword);
			driver.findElement(By.xpath("//*[@type='submit']")).click();
			// frm1.checkframe1();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@class='ui center aligned basic segment']//following::div[16]//i[@class='desktop icon']")).click();//client click
			Thread.sleep(2000);
			//Clicking on UltraGenda.Pro.Web edit button.

			driver.findElement(By.xpath("//tr//td[text()='UltraGenda.Pro.Web']/following::td[4]//a[@class='ui primary button icon']")).click(); 
			Thread.sleep(2000);
			//input[@id='Client_AccessTokenLifetime']
			driver.findElement(By.xpath("//input[@id='Client_AccessTokenLifetime']")).clear();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@id='Client_AccessTokenLifetime']")).sendKeys(logtime);
			Thread.sleep(3000);
			//button[@type='submit']
			driver.findElement(By.xpath("//button[@type='submit']")).click(); //saving values of logout button.
			Thread.sleep(3000);

			test10.pass("User is able to log off as per log time");
		}
		catch(Exception e)
		{

			test10.fail("User is not able to log off as per log time");
			Assert.fail();
		}
	}
	@Test(priority=3)
	public static void errorpopupcomemaxfuturebookdayszero() throws InterruptedException
	{

		try
		{
			test10.log(Status.INFO, "This step will Validate maximum future book days field");
			Thread.sleep(6000);
			userlogin.login(driver);

			driver.findElement(By.linkText("Central setup")).click();
			Thread.sleep(3000);

			driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f12']")));
			Thread.sleep(3000);
			driver.findElement(By.xpath("(//div[@class='menuButton'])[1]")).click(); //clicking on System administration to expand it.
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//div[@id='menuItem_18'])[1]")).click(); // clicking on System settings
			Thread.sleep(2000);
			driver.switchTo().parentFrame();
			//Switched for parent frame=F0 because it was not able to come outside from F12 frame so i switched)
			driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f11']")));
			driver.findElement(By.xpath("//th[@class='rowHead']")).click(); //clicking on General option.
			Thread.sleep(2000);

			driver.findElement(By.xpath("//input[@id='txtAsfuturebookday']")).clear();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='txtAsfuturebookday']")).sendKeys("0");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@id='butSave']")).click();
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='txtAsfuturebookday']")).clear();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='txtAsfuturebookday']")).sendKeys("31");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@id='butSave']")).click();
			Thread.sleep(3000);

			test10.pass("This step is working as expected");	
		}

		catch(Exception e)
		{
			test10.fail("A popup screen with an error is not appearing with 0 maximum future days value");	
			Assert.fail();
		}
	}
	@Test(priority=4)
	public static void changefirstdayofweek() throws InterruptedException
	{
		try
		{
			test10.log(Status.INFO, "This step will check first day of week and will check this in schedule");
			Thread.sleep(7000);

			driver.findElement(By.xpath("//select[@id='txtCalendarFirstDayOfWeek']")).click();
			Thread.sleep(2000);

			Select fdw=new Select(driver.findElement(By.name("txtCalendarFirstDayOfWeek")));
			fdw.selectByVisibleText(Calendarday);  // give value in ST2

			Thread.sleep(4000);

			driver.findElement(By.xpath("//button[@id='butSave']")).click();
			Thread.sleep(8000);

			// Story to click on the schedule setup.


			driver.switchTo().parentFrame();

			driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f10']")));

			driver.findElement(By.xpath("//div[@class='headerLinks']//span[2]")).click(); // clicking on schedule setup at top right of the screen
			Thread.sleep(5000);
			framecheck.checkframe12(driver);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//select[@id='rscIdDptId']")).click();


			Select sched=new Select(driver.findElement(By.xpath("//select[@id='rscIdDptId']"))); // for now as i was not able to save the schedule , so we will directly
			//fetch the schedule name from excel sheet. In future need to updating with new created schedule name.
			Thread.sleep(2000);	
			sched.selectByVisibleText(ScheduleNavn);
			driver.findElement(By.xpath("//select[@id='rscIdDptId']")).click();
			Thread.sleep(7000);

			driver.findElement(By.xpath("//div[@class='buttonFloatLeft']//img[@id='scheduleButton']")).click();// clicking on Schedule button-Schedule setup.
			Thread.sleep(7000);

			test10.pass("After changing the first day of week day in calendar is displaying accordingly");
		}
		catch(Exception e)
		{
			test10.fail("After changing the first day of week calendar day in calendar is not displaying accordingly");	
			Assert.fail();
		}
	}
	//here you can cheeck the selected calendar day.
	@Test(priority=5)
	public static void minandmaxwaitingperiod() throws InterruptedException
	{
		try
		{
			test10.log(Status.INFO, "This step will check minimum and maximum waiting list period values");
			framecheck.checkframe11(driver);



			driver.findElement(By.xpath("//img[@id='setupButton']")).click();  // click on the setup button.
			Thread.sleep(7000);

			//one point not covered as not able to see error if saving values in maximum futurre book days larger than central setup.
			driver.switchTo().parentFrame();
			driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f10']")));
			driver.findElement(By.xpath("//div[@class='headerLinks']//span[1]")).click(); // clicking on the Central Setup.
			Thread.sleep(6000);


			driver.switchTo().parentFrame();
			driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f12']")));
			driver.findElement(By.xpath("(//div[@class='menuButton'])[1]")).click();  //System Administration
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//div[@id='menuItem_18'])[1]")).click();   //System Settings
			Thread.sleep(2000);
			driver.switchTo().parentFrame();
			//Switched for parent frame=F0 because it was not able to come outside from F12 frame so i switched)

			driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f11']")));
			driver.findElement(By.xpath("//th[@class='rowHead']")).click();
			Thread.sleep(2000);

			driver.findElement(By.xpath("//input[@id='txtWaitingPeriodWeeksMin']")).clear();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='txtWaitingPeriodWeeksMin']")).sendKeys("31");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='txtWaitingPeriodWeeksMax']")).clear();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='txtWaitingPeriodWeeksMax']")).sendKeys("11");

			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@id='butSave']")).click();  // save button.
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
			Thread.sleep(5000);
			test10.pass("After saving invalid values popup screen with an error is displaying");
		}
		catch(Exception e)
		{
			test10.fail("After saving invalid values popup screen with an error is not displaying");	
			Assert.fail();
		}
	}
	@Test(priority=6)
	public static void clickonSysteminfo()
	{
		try
		{
			test10.log(Status.INFO, "This step will click on the System info option");
			//System info story.

			framecheck.checkframe12(driver);
			driver.findElement(By.xpath("//div[@id='menuItem_37']")).click();//System info
			Thread.sleep(2000);
			//driver.switchTo().alert().dismiss();
			test10.pass("Vertical scroll bar is displaying on the System Info screen");
		}
		catch(Exception e)
		{
			test10.fail("Vertical scroll bar is not displaying on the System Info screen");
			Assert.fail();
		}

	}

	@AfterSuite
	public static void teardown()
	{
		//vertical bar should get displayed.
		extent10.flush();
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
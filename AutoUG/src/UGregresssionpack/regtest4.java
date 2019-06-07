package UGregresssionpack;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import AllUgsmoketest.framecheck;
import AllUgsmoketest.userlogin;
import excelreaderutility.Xls_Reader;

import ugprofunctionality.Navigatepatientpportal;
import ugprofunctionality.navigatevalidpat;
import ugprofunctionality.setupbtnandpatfieldsetting;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class regtest4 
{
	static String Itempatfield;
	public static WebDriver driver;
	public  static Xls_Reader reader;

	public static String serverurl;
	static ExtentHtmlReporter htmlReporter14;
	static ExtentReports extent14;
	static ExtentTest test14;
	static String str="Test executed on:";
	@BeforeSuite
	public static void setup() throws InterruptedException
	{

		reader = new Xls_Reader("C:\\Users\\akhosla\\Documents\\regexcelsheet.xlsx");
		serverurl=reader.getCellData("reg1", "UGURL", 2);
		Itempatfield = reader.getCellData("reg4", "Patientfield-Item", 2);

		htmlReporter14 = new ExtentHtmlReporter("Regressiontest4report.html");
		extent14 = new ExtentReports();
		extent14.attachReporter(htmlReporter14);



		System.setProperty("webdriver.chrome.driver", "C:\\sdriver\\chromedriver.exe");
		driver= new ChromeDriver();
	}

	@Test(priority=1)
	public static void checkpatientfieldsettings() throws InterruptedException
	{
		try
		{


			test14 = extent14.createTest("RegressionTest4", "This test is to Validate patient field settings for temporary patient and validated patient");
			test14.log(Status.INFO, str +" " +serverurl);
			test14.log(Status.INFO, "This step will Validate setting for validated patient");

			userlogin.login(driver);


			//Thread.sleep(2000);

			driver.findElement(By.linkText("Central setup")).click();
			Thread.sleep(2000);

			driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f12']")));
			driver.findElement(By.xpath("(//div[@class='menuButton'])[1]")).click(); //System administration
			Thread.sleep(2000);

			//	driver.findElement(By.xpath("(//div[@id='menuItem_25']")).click();  //clicking on the Patient field

			driver.findElement(By.xpath("//div[@id='menuItem_25']")).click();  //
			//tr[@id='r3']//td[text()='Title']
			Thread.sleep(4000);

			// need to handle family name 

			framecheck.checkframe11(driver);

			driver.findElement(By.xpath("//tr[@class='tblRow']//td[text()='Family name']")).click();
			Thread.sleep(2000);


			driver.findElement(By.xpath("//input[@id='NotEditableAndNotMandatory']")).click();  //field cannot be modified
			Thread.sleep(2000);

			driver.findElement(By.xpath("//button[@id='butSave']")).click();  // clicking on the save button.

			navigatevalidpat.navigatepatientval(driver);  //navigating to valid patient.


			driver.switchTo().defaultContent();
			Thread.sleep(2000);

			driver.switchTo().frame(driver.findElement(By.id("ultramodal1-modal-iframe")));
			driver.switchTo().frame(driver.findElement(By.id("f11")));

			driver.findElement(By.xpath("//button[@id='butBack']")).click();   // clicking on the back button.
			Thread.sleep(4000);
			//span[@class='modal-close-button']
			driver.switchTo().defaultContent();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//span[@class='modal-close-button']")).click();    //clicking on close icon.
			Thread.sleep(3000);

			setupbtnandpatfieldsetting.setupbtnpatsetting(driver);   //navigating to central setup patient field.


			//Handling only family name above.	
			//--------------------------------------------------------------------------------------------	 
			//below again handling family name

			framecheck.checkframe11(driver);

			driver.findElement(By.xpath("//tr[@class='tblRow']//td[text()='Family name']")).click();
			Thread.sleep(2000);


			driver.findElement(By.xpath("//input[@id='EditableAndMandatory']")).click(); //  field can be modified and must be completed.
			Thread.sleep(2000);

			driver.findElement(By.xpath("//button[@id='butSave']")).click();  // clicking on the save button.

			navigatevalidpat.navigatepatientval(driver);  //navigating to valid patient.


			driver.switchTo().defaultContent();
			Thread.sleep(2000);

			driver.switchTo().frame(driver.findElement(By.id("ultramodal1-modal-iframe")));
			driver.switchTo().frame(driver.findElement(By.id("f11")));

			driver.findElement(By.xpath("//button[@id='butBack']")).click();   // clicking on the back button.
			Thread.sleep(4000);
			//span[@class='modal-close-button']
			driver.switchTo().defaultContent();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//span[@class='modal-close-button']")).click();    //clicking on close icon.
			Thread.sleep(3000);

			setupbtnandpatfieldsetting.setupbtnpatsetting(driver);   //navigating to central setup patient field.

			//		---------------------
			framecheck.checkframe11(driver);
			driver.findElement(By.xpath("//tr[@class='tblRow']//td[text()='"+Itempatfield+"']")).click();  //clicking on the title option.
			Thread.sleep(2000);

			//WebElement pfield1 = driver.findElement(By.xpath("//input[@id='EditableAndMandatory']"));



			//  Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='NotEditableAndNotMandatory']")).click();  //field cannot be modified
			Thread.sleep(2000);

			driver.findElement(By.xpath("//button[@id='butSave']")).click();  // clicking on the save button.

			navigatevalidpat.navigatepatientval(driver);  //navigating to valid patient.


			driver.switchTo().defaultContent();
			Thread.sleep(2000);

			driver.switchTo().frame(driver.findElement(By.id("ultramodal1-modal-iframe")));
			driver.switchTo().frame(driver.findElement(By.id("f11")));

			driver.findElement(By.xpath("//button[@id='butBack']")).click();   // clicking on the back button.
			Thread.sleep(4000);
			//span[@class='modal-close-button']
			driver.switchTo().defaultContent();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//span[@class='modal-close-button']")).click();    //clicking on close icon.
			Thread.sleep(3000);

			setupbtnandpatfieldsetting.setupbtnpatsetting(driver);   //navigating to central setup patient field.

			framecheck.checkframe11(driver);
			driver.findElement(By.xpath("//tr[@class='tblRow']//td[text()='"+Itempatfield+"']")).click();  //clicking on the title option.
			Thread.sleep(2000);

			driver.findElement(By.xpath("//input[@id='EditableAndNotMandatory']")).click(); //  field can be modified and leave blank
			Thread.sleep(2000);

			driver.findElement(By.xpath("//button[@id='butSave']")).click();  // clicking on the save button.

			navigatevalidpat.navigatepatientval(driver);  //navigating to valid patient.

			driver.switchTo().defaultContent();
			Thread.sleep(2000);

			driver.switchTo().frame(driver.findElement(By.id("ultramodal1-modal-iframe")));
			driver.switchTo().frame(driver.findElement(By.id("f11")));

			driver.findElement(By.xpath("//button[@id='butBack']")).click();   // clicking on the back btn.
			Thread.sleep(4000);
			//span[@class='modal-close-button']
			driver.switchTo().defaultContent();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//span[@class='modal-close-button']")).click();    //clicking on close icon.
			Thread.sleep(3000);

			setupbtnandpatfieldsetting.setupbtnpatsetting(driver);   //navigating to central setup patient field.

			framecheck.checkframe11(driver);
			driver.findElement(By.xpath("//tr[@class='tblRow']//td[text()='"+Itempatfield+"']")).click();  //clicking on the title option.
			Thread.sleep(2000);


			driver.findElement(By.xpath("//input[@id='EditableAndMandatory']")).click(); //  field can be modified and must be completed.
			Thread.sleep(2000);


			driver.findElement(By.xpath("//button[@id='butSave']")).click();  // clicking on the save button.

			navigatevalidpat.navigatepatientval(driver);  //navigating to valid patient.

			driver.switchTo().defaultContent();
			Thread.sleep(2000);

			driver.switchTo().frame(driver.findElement(By.id("ultramodal1-modal-iframe")));
			driver.switchTo().frame(driver.findElement(By.id("f11")));

			driver.findElement(By.xpath("//button[@id='butBack']")).click();   // clicking on the back btn.
			Thread.sleep(4000);
			//span[@class='modal-close-button']
			driver.switchTo().defaultContent();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//span[@class='modal-close-button']")).click();    //clicking on close icon.
			Thread.sleep(3000);
			test14.pass("Settings for validated patients is working fine");



		}
		catch(Exception e)
		{
			test14.fail("Settings for validated patients are not working fine");
			Assert.fail();
		}

	}
	@Test(priority=2)
	public static void checkpatientfieldsettingsfortemppatinet() throws InterruptedException
	{
		try
		{
			test14.log(Status.INFO, "This step will Validate setting for temporary patient");
			setupbtnandpatfieldsetting.setupbtnpatsetting(driver);   //navigating to central setup patient field.

			framecheck.checkframe11(driver);
			driver.findElement(By.xpath("//tr[@class='tblRow']//td[text()='"+Itempatfield+"']")).click();  //clicking on the title option.


			//Settings for temporary patient.

			driver.findElement(By.xpath("//input[@id='temporaryRequiredY']")).click();  // Temp patient field must be completed.
			Thread.sleep(2000);


			driver.findElement(By.xpath("//button[@id='butSave']")).click();  // clicking on the save button.




			Navigatepatientpportal.navigatepatient(driver); //navigation temp patient


			driver.switchTo().defaultContent();
			Thread.sleep(2000);

			driver.switchTo().frame(driver.findElement(By.id("ultramodal1-modal-iframe")));
			driver.switchTo().frame(driver.findElement(By.id("f11")));

			driver.findElement(By.xpath("//button[@id='butBack']")).click();   // clicking on the back btn.
			Thread.sleep(4000);
			//span[@class='modal-close-button']
			driver.switchTo().defaultContent();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//span[@class='modal-close-button']")).click();    //clicking on close icon.
			Thread.sleep(3000);

			setupbtnandpatfieldsetting.setupbtnpatsetting(driver);   //navigating to central setup patient field.



			framecheck.checkframe11(driver);
			driver.findElement(By.xpath("//tr[@class='tblRow']//td[text()='"+Itempatfield+"']")).click();  //clicking on the title option.


			//Settings for temporary patient.

			driver.findElement(By.xpath("//input[@id='temporaryRequiredN']")).click();  // Temmp patinetfield may be left blank.
			Thread.sleep(2000);


			driver.findElement(By.xpath("//button[@id='butSave']")).click();  // clicking on the save button.
			Navigatepatientpportal.navigatepatient(driver); //navigation temp patient


			driver.switchTo().defaultContent();
			Thread.sleep(2000);

			driver.switchTo().frame(driver.findElement(By.id("ultramodal1-modal-iframe")));
			driver.switchTo().frame(driver.findElement(By.id("f11")));

			driver.findElement(By.xpath("//button[@id='butBack']")).click();   // clicking on the back btn.
			Thread.sleep(4000);
			//span[@class='modal-close-button']
			driver.switchTo().defaultContent();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//span[@class='modal-close-button']")).click();    //clicking on close icon.
			Thread.sleep(3000);
			test14.pass("Settings for temporary patients are working fine");
		}
		catch(Exception e)
		{
			test14.fail("Settings for temporary patients are not working fine");
			Assert.fail();
		}
	}
	@AfterSuite
	public static void teardown()
	{
		extent14.flush();
		driver.quit();



	}
}

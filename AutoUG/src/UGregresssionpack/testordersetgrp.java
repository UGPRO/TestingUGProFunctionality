package UGregresssionpack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import AllUgsmoketest.framecheck;
import AllUgsmoketest.userlogin;
import excelreaderutility.Xls_Reader;

public class testordersetgrp {
	
	
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

	
	public static void main(String[] args) throws InterruptedException 
	{
		reader = new Xls_Reader("C:\\Users\\akhosla\\Documents\\regexcelsheet.xlsx");


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



		htmlReporter17 = new ExtentHtmlReporter("Smoketest4report.html");
		extent17 = new ExtentReports();
		extent17.attachReporter(htmlReporter17);

		/*	htmlReporter2 = new ExtentHtmlReporter("Smoketest3report.html");
		extent2 = new ExtentReports();
		extent2.attachReporter(htmlReporter2); */

		System.setProperty("webdriver.chrome.driver", "C:\\sdriver\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

		userlogin.login(driver);

		driver.findElement(By.linkText("Central setup")).click();
		Thread.sleep(2000);

		//Switched for parent frame=F0 because it was not able to come outside from F12 frame so i switched)

		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f12']")));
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='menuButton'])[2]")).click(); //definition table
		Thread.sleep(2000);
	
	
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

	driver.quit();



	}
	}

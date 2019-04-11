package AllUgsmoketest;

import static AllUgsmoketest.Smoketest5.CreateNewPrgName;

import java.awt.List;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import excelreaderutility.Xls_Reader;
import ugprofunctionality.schedulecreation;

public class Smoketest6 extends Smoketest5{

	public static String CreateNewAptd;	     
	public   static String  CreateNewAptAbre;
	public   static String CreateNewApt;
	public   static String  Ordername;
	public   static String  locname;
	public    static String  OrderStartdate;
	public   static String OrderAbrev;
	public  static String ScheduleNavn;
	public   static String ScheduleAbrev;
	public   static String Locname;
	public   static String UpdSite;
	public   static String  CreateNewLoc;
	public  static String  ScheduleAdminNavn;
	public  static String SelAppointmenttypeSt1;
	public  static String  SelDepartmentSt1;
	public  static String   CreateDepname;
	public  static String CreateNewPrgName;
	public  static String  SetFamofuserAuth;


	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		//Code for test 1 and test 2 smoke test case.

		reader =new Xls_Reader("E:\\Test.xlsx");

		// this below two line of code is just for FYI we need to update it.

		CreateNewApt	     =reader.getCellData("ST3", "Create NewAppointment", 2);
		CreateDepname	=reader.getCellData("ST4", "Create Dep name", 2);
		CreateNewAptd	     =reader.getCellData("ST6", "Create New Appointment-Depart level", 2);
		CreateNewAptAbre =reader.getCellData("ST6", "Create New Appointment Abrev-Depart level", 2);
		// CreateNewApt	     =reader.getCellData("ST3", "Create NewAppointment", 2);
		CreateNewPrgName	 =reader.getCellData("ST3", "Create New Program Name", 2);
		Ordername	 =reader.getCellData("ST6", "Ordersetname", 2);
		OrderAbrev	 =reader.getCellData("ST6", "Orderset Abrev", 2);
		OrderStartdate	 =reader.getCellData("ST6", "Orderset-Start date", 2);
		ScheduleNavn	 =reader.getCellData("ST6", "Schedule Name", 2);
		ScheduleAbrev	 =reader.getCellData("ST6", "Schedule Abrvn", 2);
		locname	 =reader.getCellData("ST6", "Schedule-Loc Name", 2);
		UpdSite	=reader.getCellData("ST4", "Update Site", 2);
		CreateNewLoc	=reader.getCellData("ST4", "Create New Loc", 2);
		// ScheduleAdminNavn	=reader.getCellData("ST4", "Schedule Admin Name", 2);
		SelAppointmenttypeSt1	=reader.getCellData("ST6", "Select Appointmenttype-St1", 2);
		SelDepartmentSt1	=reader.getCellData("ST6", "Select Department-St1", 2);
		SetFamofuserAuth	=reader.getCellData("ST4", "SetFamilynameofnewuserAuth", 2);
		UsergroupAb	=reader.getCellData("ST4", "UsergroupAbrev", 2);

		// Select Appointmenttype-St1


		System.setProperty("webdriver.chrome.driver", "C:\\sdriver\\chromedriver.exe");


		driver= new ChromeDriver();
		userlogin.login(driver);


		driver.findElement(By.xpath("//a[text()='Departmental setup']")).click();
		Thread.sleep(3000);

		//Switched for parent frame=F0 because it was not able to come outside from F12 frame so i switched)

		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f12']")));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='menuButton']")).click();
		Thread.sleep(1000);


		driver.findElement(By.xpath("//div[@id='menuItem_5']")).click();
		Thread.sleep(3000);
		framecheck.checkframe11(driver);
		Select pro=new Select(driver.findElement(By.xpath("//select[@class='select']")));
		driver.findElement(By.xpath("//select[@class='select']")).click(); 
		Thread.sleep(500);
		pro.selectByVisibleText(CreateDepname);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@id='butNew']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='txtAppName']")).sendKeys(CreateNewAptd); //creating new appointment
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='txtAppAbbrev']")).sendKeys(CreateNewAptAbre);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='butSave']")).click();
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//td[text()='"+CreateNewAptd+"']")).click();
		// Thread.sleep(2000);
		driver.findElement(By.xpath("//table[@id='tbl']//thead//tr//th[2]//following::tr//img")).click();  //deleting created appointment-Amendment Required
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		// driver.findElement(By.xpath("//td[text()='"+CreateNewApt+"']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//table[@id='tbl2']//td[2]/following::tr[6]//td[text()='"+CreateNewApt+"']//following::td")).click();  //activating new created appointment




		//activating appointment created at central level
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		// driver.findElement(By.xpath("//tr[@id='r1000041']//td[2]//img")).click();

		// driver.switchTo().alert().accept();
		//Thread.sleep(2000);
		framecheck.checkframe12(driver);
		driver.findElement(By.xpath("//div[@id='menuItem_10']")).click();  // clicking on the appointment type per program.
		Thread.sleep(3000);
		framecheck.checkframe11(driver);
		Select pro2=new Select(driver.findElement(By.xpath("//select[@class='select']")));
		driver.findElement(By.xpath("//select[@class='select']")).click();
		pro2.selectByVisibleText(CreateDepname);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//td[text()='"+ CreateNewPrgName+"']")).click();
		Thread.sleep(3000);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//td[text()='"+ CreateNewApt+"']"))).doubleClick().build().perform();
		// driver.findElement(By.xpath("//td[text()='"+ CreateNewApt+"']")).click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='butSave']")).click();  //saving appointment type program values.
		Thread.sleep(2000);

		//below is creating schedule first, becuase we need a new schedule name to activate the appointmnet from schedule setuop

		schedulecreation.schedulecreate(driver);

		// driver.switchTo().defaultContent();

		/*	 // here we are navigating to schedule setup to click on Appointment type to activating appointmenttype that we will use in orderset-depsetup
		 driver.findElement(By.xpath("//iframe[@id='f0']/..")).click(); //to get back control on the div we used /.. 
			driver.switchTo().frame(driver.findElement(By.id("f0")));
		 driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f10']")));

			driver.findElement(By.xpath("//div[@class='headerLinks']//span[2]")).click(); // clicking on scheule setup at top right of the screen
			Thread.sleep(3000);
		  framecheck.checkframe12(driver);

		driver.findElement(By.xpath("//select[@id='rscIdDptId']")).click();

		Thread.sleep(3000);
		Select sched=new Select(driver.findElement(By.xpath("//select[@id='rscIdDptId']"))); // for now as i was not able to save the schedule , so we will directly
		//fetch the schedule name from excel sheet. In future need to updating with new created schedule name.
			sched.selectByVisibleText(ScheduleNavn);


			//here i am navigating to click on appointment type to activate it in schedule setup.

			Thread.sleep(5000);
			driver.findElement(By.xpath("//div[@id='menuItem_1']")).click(); // click on appointment type
			Thread.sleep(5000);
			framecheck.checkframe11(driver);
			//div[@class='txtAddApptype']
			driver.findElement(By.xpath("//div[@class='txtAddApptype']")).click();  //activating appointment
			driver.switchTo().defaultContent();

			 driver.switchTo().frame(driver.findElement(By.id("ultramodal1-modal-iframe")));
			Thread.sleep(3000);

			driver.findElement(By.xpath("//td[@rowspan='2'][2]/img")).click();
			Thread.sleep(3000);
			//driver.findElement(By.xpath("//td[text()='" + CreateNewApt + "']")).click();
			Actions action11 = new Actions(driver);
			 action11.moveToElement(driver.findElement(By.xpath("//td[text()='" + CreateNewApt + "']"))).doubleClick().build().perform();

			 Thread.sleep(3000);
			 driver.findElement(By.xpath("//button[@id='butSave' and @onclick='fActivate();']")).click(); //saving
			Thread.sleep(2000);
			 driver.switchTo().alert().accept();
			 Thread.sleep(4000);

			 // switching again on ordert set to select activated appointmenttype from SS.
			 driver.findElement(By.xpath("//iframe[@id='f0']/..")).click(); //to get back control on the div we used /.. 
				driver.switchTo().frame(driver.findElement(By.id("f0")));
				driver.switchTo().frame(driver.findElement(By.id("f10")));

			 driver.findElement(By.xpath("//div[@class='headerLinks']//span[2]")).click();
				Thread.sleep(3000);



		 */





		driver.switchTo().defaultContent();


		driver.findElement(By.xpath("//iframe[@id='f0']/..")).click(); //to get back control on the div we used /.. 
		driver.switchTo().frame(driver.findElement(By.id("f0")));
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f12']")));
		driver.findElement(By.xpath("//div[@id='menuItem_13']")).click(); //click on the ordersetoption
		Thread.sleep(3000);



		framecheck.checkframe11(driver);
		Select pro3=new Select(driver.findElement(By.xpath("//select[@class='select']")));
		driver.findElement(By.xpath("//select[@class='select']")).click();
		pro3.selectByVisibleText(CreateDepname);  //department created on central level
		driver.findElement(By.xpath("//button[@id='butNew']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='txtBatName']")).sendKeys(Ordername);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='txtBatAbbrev']")).sendKeys(OrderAbrev);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='txtBatStartDate']")).sendKeys(OrderStartdate);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='tabBut1']")).click();
		//Select ro3=new Select(driver.findElement(By.xpath("//select[@class='selectSmall']")));
		driver.findElement(By.xpath("//select[@class='selectSmall']")).click();
		driver.findElement(By.xpath("//select[@class='selectSmall']")).sendKeys(CreateDepname); // selecting existing deptt that we created in last test.
		// ro3.selectByVisibleText(CreateDepname);
		//b[@role='presentation']
		Actions actions1 = new Actions(driver);
		Thread.sleep(2000);
		actions1.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(4000);
		//span[@id='select2-selApptype1-container']
		driver.findElement(By.xpath("//span[@class='select2-selection__rendered']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys(CreateNewApt);
		Thread.sleep(3000);
		Actions actions = new Actions(driver);
		Thread.sleep(2000);
		actions.sendKeys(Keys.DOWN).build().perform();
		Thread.sleep(2000);
		actions.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);

		// driver.findElement(By.xpath("//input[@id='txtBatAbbrev']")).sendKeys( OrderStartdate);
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//td[contains(text(), 'Schedules')]//div[@id='scheduleAllNone' and @class='grpSelectors ignored']//span[contains(text(), 'All')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//td[contains(text(), 'Sites')]//div[@id='siteAllNone']//span[contains(text(), 'All')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='butSave']")).click();
		Thread.sleep(2000);


		/*framecheck.checkframe12(driver);
		 driver.findElement(By.xpath("//div[@id='menuItem_2']")).click(); //schedules

		 framecheck.checkframe11(driver);



		 Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@class='department-selection']//div[2]//select")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//div[@class='department-selection']//div[2]//select")).sendKeys(CreateDepname);

		 Thread.sleep(3000);

		 driver.findElement(By.xpath("//input[@type='button' and @value='New']")).click();
		 Thread.sleep(3000);

		 driver.findElement(By.xpath("//input[@class='uk-width-1-1 uk-form-small' and@maxlength='40']")).sendKeys(ScheduleNavn);
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("//input[@class='uk-width-1-1 uk-form-small' and@maxlength='8']")).sendKeys(ScheduleAbrev);
		//div[@class='uk-form-controls ug-row-content ug-column-padding']//select[@class='uk-width-1-1 uk-form-small']/following::div[7]//select[@class='uk-width-1-1 uk-form-small']
		 Thread.sleep(3000);
		// Select ro7=new Select(driver.findElement(By.xpath("//select[@class='uk-width-1-1 uk-form-small']"))); //selecting schedule admin
		// driver.findElement(By.xpath("//select[@class='uk-width-1-1 uk-form-small']")).click();
		// ro7.selectByVisibleText(ScheduleAdminNavn);
		 driver.findElement(By.xpath("//select[@class='uk-width-1-1 uk-form-small']")).click(); //clicking on schedule admin
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("//select[@class='uk-width-1-1 uk-form-small']")).sendKeys(SetFamofuserAuth); 
		 Actions actions3 = new Actions(driver);
		 Thread.sleep(2000);
		 actions3.sendKeys(Keys.DOWN).build().perform();
		 Thread.sleep(2000);
		 actions3.sendKeys(Keys.ENTER).build().perform();
		 Thread.sleep(2000);
		 //below xpath is of location
		// driver.findElement(By.xpath("//div[@class='uk-form-controls ug-row-content ug-column-padding']//select[@class='uk-width-1-1 uk-form-small']/following::div[7]//select[@class='uk-width-1-1 uk-form-small']")).click();
		// Thread.sleep(3000);

		// Select ro5=new Select(driver.findElement(By.xpath("//select[@class='selectSmall']")));
		 driver.findElement(By.xpath("//div[@class='uk-form-controls ug-row-content ug-column-padding']//select[@class='uk-width-1-1 uk-form-small']/following::div[7]//select[@class='uk-width-1-1 uk-form-small']")).click();
		 Thread.sleep(2000);
		 Select ro5=new Select(driver.findElement(By.xpath("//div[@class='uk-form-controls ug-row-content ug-column-padding']//select[@class='uk-width-1-1 uk-form-small']/following::div[7]//select[@class='uk-width-1-1 uk-form-small']")));
		ro5.selectByVisibleText(UpdSite+" "+"-"+" "+ CreateNewLoc);

		// actions3.sendKeys(Keys.DOWN).build().perform();
	//	driver.findElement(By.xpath("//td[text()='" + UpdSite+" "+"-"+" "+ CreateNewLoc+ "']")).click();
		//input[@value='Save']
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("//input[@value='Save']")).click();
		 Thread.sleep(3000);
		 driver.switchTo().defaultContent();

			 driver.switchTo().frame(driver.findElement(By.id("ultramodal1-modal-iframe")));
			Thread.sleep(3000);
		 driver.findElement(By.xpath("//input[@id='rdNoAction']")).click();  //Do not activate appointment radion btn will appear after saving schedule values.
		 Thread.sleep(3000);
		//button[@id='butOK']
		 driver.findElement(By.xpath("//button[@id='butOK']")).click();  */
		driver.quit();					 
	}
}

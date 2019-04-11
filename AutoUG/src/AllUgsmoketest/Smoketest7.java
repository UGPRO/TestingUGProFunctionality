package AllUgsmoketest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import excelreaderutility.Xls_Reader;

public class Smoketest7 extends Smoketest6 {


	static String SelectSchedule;
	static String  GeneralInfoVal;
	static String ProceesAfterDay;
	static String sessioname;
	static String sessionab;
	static String TemplatePrgStarttime;
	static String TemplatePrgEndtime;	

	static String NewTemplStartDate;

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		//Code for test 1 and test 2 smoke test case.

		reader =new Xls_Reader("E:\\Test.xlsx");
		SelectSchedule	=reader.getCellData("ST7", "Schedule Setup-Select Schedule", 2);
		GeneralInfoVal	=reader.getCellData("ST7", "General-Info field Value", 2);
		UpdSite	=reader.getCellData("ST4", "Update Site", 2);
		CreateNewLoc	=reader.getCellData("ST4", "Create New Loc", 2);
		ProceesAfterDay	=SubChar(reader.getCellData("ST7", "Procees After Days", 2));
		CreateNewApt	     =reader.getCellData("ST3", "Create NewAppointment", 2);
		UsergroupN	=reader.getCellData("ST4", "UsergroupName", 2);
		sessioname	=reader.getCellData("ST7", "Session Name-Templates", 2);
		sessionab	=reader.getCellData("ST7", "Session Abrev-Templates", 2);
		CreateNewPrgName	 =reader.getCellData("ST3", "Create New Program Name", 2);

		ScheduleNavn	 =reader.getCellData("ST6", "Schedule Name", 2);
		CreateNewPrgName	 =reader.getCellData("ST3", "Create New Program Name", 2);
		TemplatePrgStarttime =SubChar(reader.getCellData("ST7", "Template-Program Starttime", 2));
		TemplatePrgEndtime	 =SubChar(reader.getCellData("ST7", "Template-Program Endtime", 2));
		NewTemplStartDate	 =SubChar(reader.getCellData("ST7", "New Template-Start Date", 2));


		// this below two line of code is just for FYI we need to update it.



		System.setProperty("webdriver.chrome.driver", "C:\\sdriver\\chromedriver.exe");


		driver= new ChromeDriver();
		userlogin.login(driver);
		driver.findElement(By.linkText("Central setup")).click();
		Thread.sleep(6000);

		//div[@class='headerLinks']//span[2]

		//driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f0']")));

		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f10']")));

		driver.findElement(By.xpath("//div[@class='headerLinks']//span[2]")).click();
		Thread.sleep(3000);
		//select[@id='rscIdDptId']
		framecheck.checkframe12(driver);
		driver.findElement(By.xpath("//select[@id='rscIdDptId']")).click();
		Thread.sleep(3000);
		Select sched=new Select(driver.findElement(By.xpath("//select[@id='rscIdDptId']"))); // for now as i was not able to save the schedule , so we will directly
		//fetch the schedule name from excel sheet. In future need to updating with new created schedule name.
		sched.selectByVisibleText(ScheduleNavn);
		Thread.sleep(4000);

		driver.findElement(By.xpath("//div[@id='menuItem_7']")).click(); // click on General option
		framecheck.checkframe11(driver);
		Thread.sleep(7000);
		driver.findElement(By.xpath("//div[@class='uk-form-controls ug-row-content ug-column-padding']//textarea")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='uk-form-controls ug-row-content ug-column-padding']//textarea")).sendKeys(GeneralInfoVal);
		Thread.sleep(4000);
		driver.findElement(By.xpath("//select[@class='uk-width-1-1 uk-form-small' and @name='data.scheduleSettings.defaultLocationId']")).click();
		Select loca=new Select(driver.findElement(By.xpath("//select[@class='uk-width-1-1 uk-form-small' and @name='data.scheduleSettings.defaultLocationId']")));
		loca.selectByVisibleText(UpdSite+" "+"-"+" "+ CreateNewLoc);
		Thread.sleep(5000);
		//input[@name='data.scheduleSettings.sessionProcessingSettings.processAfterXDays']
		driver.findElement(By.xpath("//input[@name='data.scheduleSettings.sessionProcessingSettings.processAfterXDays']")).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		//driver.findElement(By.xpath("//input[@name='data.scheduleSettings.sessionProcessingSettings.processAfterXDays']")).clear();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='data.scheduleSettings.sessionProcessingSettings.processAfterXDays']")).sendKeys( ProceesAfterDay);
		Thread.sleep(4000);
		//input[@type='button' and @value='Save']
		driver.findElement(By.xpath("//input[@type='button' and @value='Save']")).click(); //saving General details
		Thread.sleep(10000);

		framecheck.checkframe12(driver);
		driver.findElement(By.xpath("//div[@id='menuItem_2']")).click(); // click on access right.
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@id='menuItem_1']")).click(); // click on appointment type
		Thread.sleep(5000);
		framecheck.checkframe11(driver);
		//div[@class='txtAddApptype']
		//driver.findElement(By.xpath("//div[@class='txtAddApptype']")).click();  //activating appointment
		//driver.switchTo().defaultContent();

		// driver.switchTo().frame(driver.findElement(By.id("ultramodal1-modal-iframe")));
		//Thread.sleep(3000);

		//driver.findElement(By.xpath("//td[@rowspan='2'][2]/img")).click();
		//Thread.sleep(3000);
		//driver.findElement(By.xpath("//td[text()='" + CreateNewApt + "']")).click();
		//Actions action = new Actions(driver);
		// action.moveToElement(driver.findElement(By.xpath("//td[text()='" + CreateNewApt + "']"))).doubleClick().build().perform();

		// Thread.sleep(3000);
		// driver.findElement(By.xpath("//button[@id='butSave' and @onclick='fActivate();']")).click(); //saving
		//Thread.sleep(2000);
		// driver.switchTo().alert().accept();
		// Thread.sleep(5000);
		// driver.findElement(By.xpath("//iframe[@id='f0']/..")).click(); //to get back control on the div we used /.. 
		//driver.switchTo().frame(driver.findElement(By.id("f0")));
		//	driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='content-pane i-frame-legacy']")));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='txtDeactivateApptype']")).click();  //deactivating apt
		driver.switchTo().defaultContent();

		driver.switchTo().frame(driver.findElement(By.id("ultramodal1-modal-iframe")));
		Thread.sleep(3000);

		//driver.findElement(By.xpath("//td[@rowspan='2'][2]/img")).click();
		//Thread.sleep(3000);
		//driver.findElement(By.xpath("//td[text()='" + CreateNewApt + "']")).click();
		Actions actiond = new Actions(driver);
		actiond.moveToElement(driver.findElement(By.xpath("//td[text()='" + CreateNewApt + "']"))).doubleClick().build().perform(); //deactivating selected apt

		//button[@onclick='fDeActivate();']
		driver.findElement(By.xpath("//button[@onclick='fDeActivate();']")).click(); //saving
		// menuItem_3
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//iframe[@id='f0']/..")).click(); //to get back control on the div we used /.. 
		driver.switchTo().frame(driver.findElement(By.id("f0")));
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='content-pane i-frame-legacy']")));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='txtAddApptype']")).click(); //again activating appointmentype as we will use this appointment 
		//in Appointment for booking options
		driver.switchTo().defaultContent();

		driver.switchTo().frame(driver.findElement(By.id("ultramodal1-modal-iframe")));
		Thread.sleep(3000);

		driver.findElement(By.xpath("//td[@rowspan='2'][2]/img")).click();
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//td[text()='" + CreateNewApt + "']")).click();
		Actions actione = new Actions(driver);
		actione.moveToElement(driver.findElement(By.xpath("//td[text()='" + CreateNewApt + "']"))).doubleClick().build().perform();

		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@id='butSave' and @onclick='fActivate();']")).click(); //saving //again saving activated appt
		Thread.sleep(2000);
		driver.switchTo().alert().accept();

		Thread.sleep(5000);
		driver.findElement(By.xpath("//iframe[@id='f0']/..")).click(); //to get back control on the div we used /.. 
		driver.switchTo().frame(driver.findElement(By.id("f0")));
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='content-pane i-frame-legacy']")));
		driver.findElement(By.xpath("//div[@class='sourceBox docked']")).click();
		Thread.sleep(2000);

		framecheck.checkframe12(driver);
		driver.findElement(By.xpath("//div[@id='menuItem_6']")).click();  // clciking on the appointmnettype per prog
		Thread.sleep(4000);
		Actions actionea = new Actions(driver);
		framecheck.checkframe11(driver);
		actionea.moveToElement(driver.findElement(By.xpath("//td[text()='" + CreateNewApt + "']"))).doubleClick().build().perform();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//button[@id='butSave' and @onclick='fSave();']")).click();//saving appointment perprogram.

		framecheck.checkframe12(driver);
		driver.findElement(By.xpath("//div[@id='menuItem_3']")).click(); //clicking on Appointment type for booking
		Thread.sleep(3000);
		framecheck.checkframe11(driver);
		driver.findElement(By.xpath("//td[text()='" +  UsergroupN + "']")).click();
		Thread.sleep(3000);
		Actions actionf = new Actions(driver);
		actionf.moveToElement(driver.findElement(By.xpath("//table[@id='privUsr']//td[text()='" + CreateNewApt + "']"))).doubleClick().build().perform();//activating appointment in Appointment for booking.
		Thread.sleep(3000);
		Actions actiong = new Actions(driver);
		actiong.moveToElement(driver.findElement(By.xpath("//table[@id='nonPrivUsr']//td[text()='" + CreateNewApt + "']"))).doubleClick().build().perform();//activating appointment in Appointment for booking.
		Thread.sleep(2000);
		//button[@id='butSave' and @onclick='fSave();']
		driver.findElement(By.xpath("//button[@id='butSave' and @onclick='fSave();']")).click();//saving appointment for booking values.
		Thread.sleep(3000);
		framecheck.checkframe12(driver);
		driver.findElement(By.xpath("//div[@id='menuItem_8']")).click(); // Appointment type for waiting list entries
		Thread.sleep(3000);
		framecheck.checkframe11(driver);
		driver.findElement(By.xpath("//td[text()='" +  UsergroupN + "']")).click();
		Actions actionh = new Actions(driver);
		actionh.moveToElement(driver.findElement(By.xpath("//table[@class='streched']//td[text()='" + CreateNewApt + "']"))).doubleClick().build().perform();// switching priv users
		Thread.sleep(2000);
		Actions actioni = new Actions(driver);
		actioni.moveToElement(driver.findElement(By.xpath("//div[@class='target docked' and @ id='target']//tr//following::tbody//tr//td[text()='" + CreateNewApt + "']"))).doubleClick().build().perform();// switching npriv users
		//button[@id='butSave' and@onclick='fSave();']
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='butSave' and@onclick='fSave();']")).click();//saving appointment for waiting values.	
		Thread.sleep(3000);
		framecheck.checkframe12(driver);
		driver.findElement(By.xpath("//div[@id='menuItem_5']")).click(); //template button click.
		Thread.sleep(5000);
		framecheck.checkframe11(driver);
		driver.findElement(By.xpath("// button[@id='butNew' and@onclick='fNew();']")).click(); //cLCIKING ON NEW BUTTON-tEMPLATE
		//td[@onclick='editSession(1);']
		driver.findElement(By.xpath("//input[@id='txtStartDate']")).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='txtStartDate']")).click();
		Thread.sleep(2000);
		//NewTemplStartDate
		driver.findElement(By.xpath("//input[@id='txtStartDate']")).sendKeys(NewTemplStartDate);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//td[@onclick='editSession(1);']")).click();
		Thread.sleep(3000);
		driver.switchTo().defaultContent();

		driver.switchTo().frame(driver.findElement(By.id("ultramodal1-modal-iframe")));
		Thread.sleep(3000);
		//input[@id='sesName']
		driver.findElement(By.xpath("//input[@id='sesName']")).sendKeys(sessioname); 
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='sesAbbrev']")).sendKeys(sessionab); 
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='butSave' and@onclick='fSave();']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//iframe[@id='f0']/..")).click(); //to get back control on the div we used /.. 
		driver.switchTo().frame(driver.findElement(By.id("f0")));
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='content-pane i-frame-legacy']")));
		System.out.print("test");
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		driver.switchTo().frame(driver.findElement(By.id("ultramodal1-modal-iframe")));
		Thread.sleep(3000);
		Select prg=new Select(driver.findElement(By.xpath("//select[@id='prgId']")));
		prg.selectByVisibleText(CreateNewPrgName);
		Thread.sleep(3000);

		//Thread.sleep(3000);
		// driver.findElement(By.xpath("//tr[@class='addProgramRow']//td[@class='first rowIcon']")).click(); //click to insert program in session.
		// Thread.sleep(3000);
		// driver.switchTo().defaultContent();
		// Thread.sleep(3000);
		//iframe[@id='ultramodal1-modal-iframe' and@src='/UltraGendaPro/setup/iu/template/programblock.asp']
		// driver.switchTo().frame(driver.findElement(By.id("ultramodal1-modal-iframe")));
		//Thread.sleep(6000);
		// driver.findElement(By.xpath("//table[@id='fullTbl']//tbody//tr[2]//td[2]//select[@onchange='programChanged()']")).click();    //clicking on template-Program dropdown
		//	 Thread.sleep(5000);
		// Select prg=new Select(driver.findElement(By.xpath("//select[@id='prgId']")));
		//prg.selectByVisibleText(CreateNewPrgName);
		//input[@id='prgStart']
		driver.findElement(By.xpath("//input[@id='prgStart']")).click();
		driver.findElement(By.xpath("//input[@id='prgStart']")).clear(); 
		driver.findElement(By.xpath("//input[@id='prgStart']")).sendKeys("16:00"); 
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='prgStop']")).clear(); 
		driver.findElement(By.xpath("//input[@id='prgStop']")).sendKeys("21:00"); 
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='butSave' and@onclick='fSave();']")).click();
		/*driver.findElement(By.xpath("//iframe[@id='f0']/..")).click(); //to get back control on the div we used /.. 
			driver.switchTo().frame(driver.findElement(By.id("f0")));
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='content-pane i-frame-legacy']")));
			Thread.sleep(2000);
		 */
		Thread.sleep(5000);
		//td[@class='rowInputLocal']//div

		driver.switchTo().frame(driver.findElement(By.id("f0")));
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='content-pane i-frame-legacy']")));


		//button[@onclick='fSave(false);' and@id='butSave']
		driver.findElement(By.xpath("//button[@onclick='fSave(false);' and@id='butSave']")).click();  //saving programsession template value.
		Thread.sleep(6000);
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

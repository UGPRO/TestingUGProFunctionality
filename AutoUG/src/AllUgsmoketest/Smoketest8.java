package AllUgsmoketest;

import java.io.IOException;
import java.util.List;
//import java.awt.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import excelreaderutility.Xls_Reader;

public class Smoketest8 extends Smoketest7 {

	public  static Xls_Reader reader;
	static String Patintfamname;
	static String Patintgivname;

	static String Expmonth;
	static String month;
	static String CreateNewApt;
	static String NewTemplStartDate;

	static String ScheduleSelMonth;
	static String ScheduleSelyr;
	static String FreebtnPatfamname;
	static String FreebtnPatGivenName;
	static boolean bValue;
	static String OverbookPatienfamname;
	static String OverbookPatientGivenname;
	static String	WaitinglistPatfamName;
	static String	WaitinglistPatGivenName;
	static String BlockCat;

	static String TitleTepPatient;
	static String FamnameTepPatient;
	static String DOBTepPatient;

	static String TitlevalPatient;
	static String FamnamevalPatient;
	static String DOBvalPatient;
	static String Ordersetname;
	static String CreatDepname;
	public static void main(String[] args) throws InterruptedException {

		reader =new Xls_Reader("E:\\Test.xlsx");
		Patintfamname = reader.getCellData("ST8", "Patient Fam Name", 2);
		Patintgivname = reader.getCellData("ST8", "Patinet Given Name", 2);

		FreebtnPatfamname = reader.getCellData("ST8", "Freebtn-Patientfamname", 2);
		FreebtnPatGivenName  = reader.getCellData("ST8", "Freebtn-PatientGivenName ", 2);

		CreateNewApt=reader.getCellData("ST3", "Create NewAppointment", 2);

		NewTemplStartDate =SubChar(reader.getCellData("ST7", "New Template-Start Date", 2));
		ScheduleNavn	 =reader.getCellData("ST6", "Schedule Name", 2);
		ScheduleSelMonth = reader.getCellData("ST8", "Schedule-Select Month", 2);
		ScheduleSelyr = SubChar(reader.getCellData("ST8", "Schedule-Select Year", 2));
		CreateNewPrgName	 =reader.getCellData("ST3", "Create New Program Name", 2);
		OverbookPatienfamname = reader.getCellData("ST8", "Overbook-Patientfamname", 2);
		OverbookPatientGivenname = reader.getCellData("ST8", "Overbook-PatientGivenname", 2);
		WaitinglistPatfamName = reader.getCellData("ST8", "Waitinglist-PatientfamName", 2);
		WaitinglistPatGivenName = reader.getCellData("ST8", "Waitinglist-PatientGivenName", 2);
		BlockCat = reader.getCellData("ST8", "Block-Category", 2);

		TitleTepPatient = reader.getCellData("ST8", "Title-Temp Patient", 2);
		FamnameTepPatient = reader.getCellData("ST8", "Famname-Temp Patient", 2);
		DOBTepPatient = reader.getCellData("ST8", "DOB-Temp Patient", 2);

		TitlevalPatient = reader.getCellData("ST8", "Title-Valid Patient", 2);
		FamnamevalPatient = reader.getCellData("ST8", "Famname-Valid Patient", 2);
		DOBvalPatient = reader.getCellData("ST8", "DOB-Valid Patient", 2);
		Ordersetname = reader.getCellData("ST6", "Ordersetname", 2);
		CreatDepname= reader.getCellData("ST4", "Create Dep name", 2);



		System.setProperty("webdriver.chrome.driver", "C:\\sdriver\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();

		//driver= new ChromeDriver();
		userlogin.login(driver);
		driver.findElement(By.linkText("Central setup")).click();
		Thread.sleep(6000);



		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f10']")));

		driver.findElement(By.xpath("//div[@class='headerLinks']//span[2]")).click(); // clicking on scheule setup at top right of the screen
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
		//Select sched=new Select(driver.findElement(By.xpath("//select[@id='rscIdDptId']"))); // for now as i was not able to save the schedule , so we will directly
		//fetch the schedule name from excel sheet. In future its need to be updating with new created schedule name.
		//sched.selectByVisibleText( SelectSchedule);
		//	driver.findElement(By.xpath("//iframe[@id='f0']/..")).click(); //to get back control on the div we used /.. 
		//driver.switchTo().frame(driver.findElement(By.id("f0")));
		//driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f12']")));

		driver.findElement(By.xpath("//div[@class='buttonFloatLeft']//img[@id='scheduleButton']")).click();// clicking on Schedule button-Schedule setup.
		Thread.sleep(7000);
		framecheck.checkframe11(driver);

		/*   Expmonth  = ScheduleSelMonth;




	 //if(month == Expmonth)
	//// actions3.sendKeys(Keys.ENTER).build().perform();
	// }
    Actions actions3 = new Actions(driver);
	// 
	String CurrMonth = driver.findElement(By.xpath("//select[@id='month']")).getText();
	 System.out.print(CurrMonth);

	 if(Expmonth.equals(CurrMonth))
	 {

		 System.out.println("Monthh is already selected");
	 }

	 else
	 {
		 for(int i=1; i<12; i++)

		 {
		    actions3.sendKeys(Keys.DOWN).build().perform();
		    Thread.sleep(2000);
		    actions3.sendKeys(Keys.ENTER).build().perform();
		    Thread.sleep(1000);

		    CurrMonth = driver.findElement(By.xpath("//select[@id='month']")).getText();
		    if(Expmonth.equals(CurrMonth))
		    {

			 System.out.println("Monthh selected");
			 break;
		    }
		 }


	 }*/
		//naveen lab
		// Thread.sleep(1000);
		//String date= NewTemplStartDate;
		// String dateArr[]= date.split("-"); //eg. (0) 15-(1) 02-(2) 2019
		// String day=   dateArr[0];
		// int result = Integer.parseInt(day);
		//String month= dateArr[1];
		//String year=  dateArr[2];
		driver.findElement(By.xpath("//select[@id='month']")).click();
		Thread.sleep(4000);
		Select select= new Select(driver.findElement(By.xpath("//select[@id='month']"))); // for month
		select.selectByVisibleText(ScheduleSelMonth);
		//select[@id='year']
		driver.findElement(By.xpath("//select[@id='year']")).click();
		Thread.sleep(2000);
		Select select1= new Select(driver.findElement(By.xpath("//select[@id='year']"))); // for Year
		select1.selectByVisibleText(ScheduleSelyr);
		//*[@id='CalTable_menu']//tr[1]/td[7] 

		// String beforexpath =	"//table[@id='CalTable_menu']//tr[";
		//String afterxpath = "]/td[";       //table[@id='CalTable_menu']//tr//th[2]//following::tbody//tr[6]/td[2]



		//final int totalweekdays = 7;
		//1-1 1-2 1-3 1-4 1-5 1-6 1-7
		//2-3 2-2 
		//boolean flag= false;
		//for(int rownum=1; rownum<7; rownum++) {

		//for(int colnum= 1; colnum<=totalweekdays; colnum++) {

		//String dayval= driver.findElement(By.xpath(beforexpath+rownum+afterxpath+colnum+"]")).getText();


		//System.out.println(dayval);

		//	if(dayval.equals(day))
		//	{
		//	driver.findElement(By.xpath(beforexpath+rownum+afterxpath+colnum+"]")).click();

		//flag=true;
		//		break;

		//}
		//}
		//if(flag)
		// {
		// break;


		// }

		// } 
		//Thread.sleep(3000);
		driver.findElement(By.xpath("//table[@id='CalTable_menu']//tr[6]/td[2]")).click(); // clicking on particular slot
		Thread.sleep(3000);
		framecheck.checkframe12(driver);
		//td//div[2][text()='New Prg8']
		driver.findElement(By.xpath("//td//div[2][text()='"+CreateNewPrgName+"']")).click();
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		driver.switchTo().frame(driver.findElement(By.id("ultramodal1-modal-iframe")));
		//driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f11']")));
		//input[@title='Family name' and @id='sFamilyname']
		// driver.findElement(By.xpath("//iframe[@id='f0']/..")).click(); //to get back control on the div we used /.. 
		//driver.switchTo().frame(driver.findElement(By.id("f0")));
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f11']")));
		Thread.sleep(3000);

		driver.findElement(By.xpath("//input[@title='Family name' and @id='sFamilyname']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@title='Family name' and @id='sFamilyname']")).sendKeys(Patintfamname);

		// driver.findElement(By.xpath("//input[@title='Family name' and @id='sFamilyname']")).sendKeys(Patintfamname);

		driver.findElement(By.xpath("//td[@class='rowInput']//input[@name='sGivenname' and @id='sGivenname']")).sendKeys(Patintgivname);

		driver.findElement(By.xpath("//td[@class='rowButton']//button[@id='butSearch']")).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("//button[@id='butSelect']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//iframe[@id='f0']/..")).click(); //to get back control on the div we used /.. 
		driver.switchTo().frame(driver.findElement(By.id("f0")));

		driver.switchTo().frame(driver.findElement(By.id("f12")));
		Thread.sleep(3000);

		driver.findElement(By.xpath("//span[@id='select2-selAppId-container']")).click();//Schedule setup-Selecting appointment type.

		driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys(CreateNewApt);
		Actions actions1 = new Actions(driver);
		Thread.sleep(2000);
		actions1.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
		//button[@id='butSearch2']
		//button[@id='butBook']
		driver.findElement(By.xpath("//button[@id='butBook']")).click(); //booking appointment after clicking on slot/saving

		Thread.sleep(7000);



		//div[@id='btnEndBooking']
		driver.findElement(By.xpath("//div[@id='btnEndBooking']")).click(); //  clicking on continue without printing.
		Thread.sleep(2000);

		framecheck.checkframe11(driver);

		//functionality free button.


		driver.findElement(By.xpath("//button[@id='butSearch']")).click(); // clicking on free button
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		driver.switchTo().frame(driver.findElement(By.id("ultramodal1-modal-iframe")));

		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f11']")));
		Thread.sleep(2000);

		// for(int colnum= 1; colnum<=totalweekdays; colnum++) {
		driver.findElement(By.xpath("//input[@title='Family name' and @id='sFamilyname']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@title='Family name' and @id='sFamilyname']")).sendKeys(FreebtnPatfamname);

		// driver.findElement(By.xpath("//input[@title='Family name' and @id='sFamilyname']")).sendKeys(Patintfamname);

		driver.findElement(By.xpath("//td[@class='rowInput']//input[@name='sGivenname' and @id='sGivenname']")).sendKeys(FreebtnPatGivenName);



		Thread.sleep(2000);


		driver.findElement(By.xpath("//td[@class='rowButton']//button[@id='butSearch']")).click(); //searching patient.
		Thread.sleep(5000);

		driver.findElement(By.xpath("//button[@id='butSelect']")).click(); //selecting patient
		Thread.sleep(5000);
		driver.findElement(By.xpath("//iframe[@id='f0']/..")).click(); //to get back control on the div we used /.. 
		driver.switchTo().frame(driver.findElement(By.id("f0")));

		driver.switchTo().frame(driver.findElement(By.id("f12")));
		Thread.sleep(3000);
		//halt
		driver.findElement(By.xpath("//span[@id='select2-apptypeSelect-container']")).click();//Schedule setup-Selecting appointment type after free btn

		driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys(CreateNewApt); //selecting appointment in enter search criteria
		Actions actions2 = new Actions(driver);
		Thread.sleep(2000);
		actions2.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
		//button[@id='butSearch2']
		//button[@id='butBook']
		WebElement site = driver.findElement(By.xpath("//input[@id='site1']"));
		//bValue = Practicerdo.isSelected();

		if(bValue = site.isSelected())
		{
			Thread.sleep(2000);
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.xpath("//input[@id='site1']"))).doubleClick().build().perform();
			driver.findElement(By.xpath("//input[@id='site1']")).click();
		}
		else

		{
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='site1']")).click();
		}


		driver.findElement(By.xpath("//button[@id='butSearch2']")).click(); //clicking on the search icon to see slots to book appointment.
		Thread.sleep(2000);
		framecheck.checkframe12(driver);
		// searchResult
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='searchResult']")));
		if(driver.findElements(By.xpath("//table[@id='slots']//tbody//tr[3]//td[1]")).size()>0)
		{
			Thread.sleep(2000);
			//table[@id='slots']//tbody//tr[3]//td[1]
			//DO THE STUFF YOU NEED TO DO IF THE ELEMENT EXISTS
			driver.findElement(By.xpath("//table[@id='slots']//tbody//tr[3]//td[1]")).click(); //clicking on particular slot to book apntmnt. 
		}

		else
		{
			Thread.sleep(2000);
			//button[@id='Button2']
			driver.findElement(By.xpath("//button[text()='Next']")).click();  //clicking on the next button if the free slots not available.
			Thread.sleep(2000);
			driver.findElement(By.xpath("//table[@id='slots']//tbody//tr[3]//td[1]")).click();
		}

		Thread.sleep(7000);

		driver.findElement(By.xpath("//iframe[@id='f0']/..")).click(); //to get back control on the div we used /.. 
		driver.switchTo().frame(driver.findElement(By.id("f0")));

		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f12']")));

		//button[@id='butBook']
		driver.findElement(By.xpath("//button[@id='butBook']")).click(); // clicking on save button to book apntmnt via free btn


		Thread.sleep(7000);



		//div[@id='btnEndBooking']
		driver.findElement(By.xpath("//div[@id='btnEndBooking']")).click(); //  clicking on continue without printing via free btn
		Thread.sleep(3000);
		//button[@id='butAdd']
		framecheck.checkframe11(driver);


		//Functionality Overbook button.

		driver.findElement(By.xpath("	//button[@id='butAdd']")).click(); //overbook button.

		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		driver.switchTo().frame(driver.findElement(By.id("ultramodal1-modal-iframe")));
		//driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f11']")));
		//input[@title='Family name' and @id='sFamilyname']
		// driver.findElement(By.xpath("//iframe[@id='f0']/..")).click(); //to get back control on the div we used /.. 
		//driver.switchTo().frame(driver.findElement(By.id("f0")));
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f11']")));
		Thread.sleep(3000);

		driver.findElement(By.xpath("//input[@title='Family name' and @id='sFamilyname']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@title='Family name' and @id='sFamilyname']")).sendKeys(OverbookPatienfamname);

		// driver.findElement(By.xpath("//input[@title='Family name' and @id='sFamilyname']")).sendKeys(Patintfamname);

		driver.findElement(By.xpath("//td[@class='rowInput']//input[@name='sGivenname' and @id='sGivenname']")).sendKeys(OverbookPatientGivenname);

		driver.findElement(By.xpath("//td[@class='rowButton']//button[@id='butSearch']")).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("//button[@id='butSelect']")).click();  //selecting Patient for overbooking
		Thread.sleep(5000);
		//input[@id='btime']
		driver.switchTo().defaultContent();
		Thread.sleep(2000);

		driver.switchTo().frame(driver.findElement(By.id("ultramodal1-modal-iframe")));

		driver.findElement(By.xpath("//input[@id='btime']")).sendKeys("16:00"); //entering time in  overbooking dialogue box.
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[@id='select2-rscapptId-container']")).click(); 
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@class='select2-search__field']")).click(); 
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys(CreateNewApt) ;
		Thread.sleep(2000);
		Actions actions12 = new Actions(driver);
		Thread.sleep(2000);
		actions12.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@id='butBook']")).click();  //clicking on continue button.
		Thread.sleep(2000);
		driver.findElement(By.xpath("//iframe[@id='f0']/..")).click(); //to get back control on the div we used /.. 
		driver.switchTo().frame(driver.findElement(By.id("f0")));

		driver.switchTo().frame(driver.findElement(By.id("f12")));
		Thread.sleep(3000);

		driver.findElement(By.xpath("//button[@id='butBook']")).click(); //saving overbooking appointment
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@id='btnEndBooking']")).click(); // clicking on continue without print.




		//functionality editing appointment

		driver.switchTo().parentFrame();
		driver.switchTo().frame(driver.findElement(By.id("f13")));


		driver.findElement(By.xpath("//span[@title='Edit']//i")).click(); // editing apppointment.

		Thread.sleep(6000);

		framecheck.checkframe12(driver);




		driver.findElement(By.xpath("//textarea[@id='bNote']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//textarea[@id='bNote']")).sendKeys("Test Editing Appointment");
		Thread.sleep(2000);
		//select[@id='selCnttype']
		driver.findElement(By.xpath("//select[@id='selCnttype']")).click(); //selecting modification reason.
		Thread.sleep(2000);
		Select modif=new Select(driver.findElement(By.xpath("//select[@id='selCnttype']")));
		modif.selectByVisibleText("Testing by IT department");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[@id='butBook']")).click(); //saving edited appointment.

		driver.findElement(By.xpath("//div[@id='btnEndBooking']")).click(); //clicking on continue without printing.

		//Rescheduling book appointment details.


		driver.switchTo().parentFrame();
		driver.switchTo().frame(driver.findElement(By.id("f13")));


		driver.findElement(By.xpath("//span[@title='Reschedule']//i")).click(); // Reschedule apppointment.
		Thread.sleep(3000);
		framecheck.checkframe11(driver);

		//functionality free button to reschedule appointment.


		driver.findElement(By.xpath("//button[@id='butSearch']")).click(); // clicking on free button
		Thread.sleep(3000);
		framecheck.checkframe12(driver);

		driver.findElement(By.xpath("//button[@id='butSearch2']")).click(); //click on the search icon to see rescheduled slot
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='searchResult']")));
		if(driver.findElements(By.xpath("//table[@id='slots']//tbody//tr[3]//td[1]")).size()>0)
		{
			Thread.sleep(2000);
			//table[@id='slots']//tbody//tr[3]//td[1]
			//DO THE STUFF YOU NEED TO DO IF THE ELEMENT EXISTS
			driver.findElement(By.xpath("//table[@id='slots']//tbody//tr[3]//td[1]")).click(); //clicking on particular slot to book apntmnt. 
		}

		else
		{
			Thread.sleep(2000);
			//button[@id='Button2']
			driver.findElement(By.xpath("//button[text()='Next']")).click();  //clicking on the next button if the free slots not available.
			Thread.sleep(2000);
			driver.findElement(By.xpath("//table[@id='slots']//tbody//tr[3]//td[1]")).click();
		}

		Thread.sleep(3000);
		//select[@id='selCnttype']
		driver.findElement(By.xpath("//iframe[@id='f0']/..")).click(); //to get back control on the div we used /.. 
		driver.switchTo().frame(driver.findElement(By.id("f0")));
		driver.switchTo().frame(driver.findElement(By.id("f12")));
		Thread.sleep(1000);

		driver.findElement(By.xpath("//textarea[@id='bNote']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//textarea[@id='bNote']")).clear();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//textarea[@id='bNote']")).sendKeys("Test Rescheduled Appointment");
		Thread.sleep(2000);
		//select[@id='selCnttype']
		driver.findElement(By.xpath("//select[@id='selCnttype']")).click(); //selecting modification reason.
		Thread.sleep(2000);



		Select modif7=new Select(driver.findElement(By.xpath("//select[@id='selCnttype']"))); //selecting modification reason
		modif7.selectByVisibleText("Testing by IT department");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[@id='butBook']")).click(); //saving rescheduled appointment.
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='btnEndBooking']")).click(); //clicking on continue without printing.




		//Functionality deleting appointment

		driver.switchTo().parentFrame();
		driver.switchTo().frame(driver.findElement(By.id("f13")));

		driver.findElement(By.xpath("//span[@title='Delete']//i")).click(); // Deleting Appointment.

		driver.switchTo().defaultContent();
		Thread.sleep(2000);

		driver.switchTo().frame(driver.findElement(By.id("ultramodal1-modal-iframe")));



		//select[@id='selCnttype']
		driver.findElement(By.xpath("//select[@id='cntTypeSelect']")).click(); //selecting modification reason.
		Thread.sleep(2000);
		Select modif2=new Select(driver.findElement(By.xpath("//select[@id='cntTypeSelect']")));
		modif2.selectByVisibleText("Doctor deceased");
		driver.findElement(By.xpath("//button[@id='butDelete']")).click(); // click on the confirm btn to delete apntmnt
		Thread.sleep(3000);
		driver.findElement(By.xpath("//iframe[@id='f0']/..")).click(); //to get back control on the div we used /.. 
		driver.switchTo().frame(driver.findElement(By.id("f0")));
		driver.switchTo().frame(driver.findElement(By.id("f12")));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='printLink']")).click();

		Thread.sleep(2000);
		framecheck.checkframe11(driver);
		driver.findElement(By.xpath("//button[@id='butWaitinglist']")).click(); //clicking on the waiting list option.
		Thread.sleep(4000);

		driver.switchTo().defaultContent();
		Thread.sleep(2000);

		driver.switchTo().frame(driver.findElement(By.id("ultramodal1-modal-iframe")));
		driver.switchTo().frame(driver.findElement(By.id("f11")));

		//selecting patient for waiting list entries.

		driver.findElement(By.xpath("//input[@title='Family name' and @id='sFamilyname']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@title='Family name' and @id='sFamilyname']")).sendKeys(WaitinglistPatfamName);

		// driver.findElement(By.xpath("//input[@title='Family name' and @id='sFamilyname']")).sendKeys(Patintfamname);

		driver.findElement(By.xpath("//td[@class='rowInput']//input[@name='sGivenname' and @id='sGivenname']")).sendKeys(WaitinglistPatGivenName);

		driver.findElement(By.xpath("//td[@class='rowButton']//button[@id='butSearch']")).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("//button[@id='butSelect']")).click();  //selecting Patient for waiting list entry

		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);

		driver.switchTo().frame(driver.findElement(By.id("ultramodal1-modal-iframe")));

		driver.findElement(By.xpath("//span[@id='select2-appointment-type-input-container']")).click(); //selecting appointment for waiting list entry
		//input[@class='select2-search__field']


		driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys(CreateNewApt);

		Actions actions3 = new Actions(driver);
		//actions3.sendKeys(Keys.DOWN).build().perform();
		Thread.sleep(1000);
		actions3.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(5000);

		//input[@id='schedule-484-input']

		driver.findElement(By.xpath("//div[@class='ug-destination-waiting-list-item']//following::div//input")).click(); // clicking on the created schedule radio btn.
		Thread.sleep(2000);
		//click on the continue button of ad waiting list entry popup


		driver.findElement(By.xpath("//button[@class='uk-button'   and text()='Continue']")).click(); 

		Thread.sleep(3000);
		driver.findElement(By.xpath("//iframe[@id='f0']/..")).click(); //to get back control on the div we used /.. 
		driver.switchTo().frame(driver.findElement(By.id("f0")));
		driver.switchTo().frame(driver.findElement(By.id("f12")));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='butBook']")).click();  //clicking on the save button to book waiting list apntmnt.
		Thread.sleep(7000);
		//div[@id='btnEndBooking']
		// Thread.sleep(3000);
		// driver.findElement(By.xpath("//iframe[@id='f0']/..")).click(); //to get back control on the div we used /.. 
		//driver.switchTo().frame(driver.findElement(By.id("f0")));
		//	driver.switchTo().frame(driver.findElement(By.id("f12")));
		//Thread.sleep(2000);

		driver.findElement(By.xpath("//div[@id='btnEndBooking']")).click(); // click on continue without printing.

		framecheck.checkframe11(driver);
		//functionality block button.

		driver.findElement(By.xpath("//button[@id='butBlock']")).click(); //click on the block button.
		//input[@id='txtStartTime']
		framecheck.checkframe12(driver);
		driver.findElement(By.xpath("//input[@id='txtStartTime']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='txtStartTime']")).sendKeys("17:00");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='txtEndTime']")).sendKeys("18:00");
		//button[@id='butblock']

		Select blk=new Select(driver.findElement(By.xpath("//select[@id='selCnttype']"))); // for now as i was not able to save the schedule , so we will directly
		//fetch the schedule name from excel sheet. In future need to updating with new created schedule name.
		blk.selectByVisibleText(BlockCat);
		driver.findElement(By.xpath("//button[@id='butblock']")).click(); //clicking on the Block button.

		driver.switchTo().parentFrame();
		driver.switchTo().frame(driver.findElement(By.id("f13")));

		//functionality creating and searching patient.

		driver.findElement(By.xpath("//span[@id='selectPatButton']//i ")).click();


		//starts from-Yesterday pending work.
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);

		driver.switchTo().frame(driver.findElement(By.id("ultramodal1-modal-iframe")));
		driver.switchTo().frame(driver.findElement(By.id("f11")));


		//framecheck.checkframe11(driver);

		//Only Searching Patient

		driver.findElement(By.xpath("//input[@title='Family name' and @id='sFamilyname']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@title='Family name' and @id='sFamilyname']")).sendKeys(WaitinglistPatfamName);

		// driver.findElement(By.xpath("//input[@title='Family name' and @id='sFamilyname']")).sendKeys(Patintfamname);

		driver.findElement(By.xpath("//td[@class='rowInput']//input[@name='sGivenname' and @id='sGivenname']")).sendKeys(WaitinglistPatGivenName);

		driver.findElement(By.xpath("//td[@class='rowButton']//button[@id='butSearch']")).click();
		Thread.sleep(5000);

		//driver.switchTo().frame(driver.findElement(By.id("ultramodal1-modal-iframe")));

		// driver.switchTo().frame(driver.findElement(By.id("f11")));


		driver.findElement(By.xpath("//button[@id='butNew']")).click(); //Click on the New to create
		//temporary patient first.


		driver.findElement(By.xpath("//div[@id='newPatientMenu']//div[2]")).click(); //click on temp patient option.
		Thread.sleep(5000);

		//Creating temp patinet fetching values from excel sheet.

		driver.findElement(By.xpath("//select[@id='title']")).click();

		Select tit=new Select(driver.findElement(By.xpath("//select[@id='title']")));
		tit.selectByVisibleText(TitleTepPatient); 

		// driver.findElement(By.xpath("//input[@id='title']")).click(); //patient title
		//driver.findElement(By.xpath("//input[@id='title']")).sendKeys(TitleTepPatient);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='familyname']")).sendKeys(FamnameTepPatient);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("Given name");
		//click on radio button.
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='radio' and@id='male']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='birthdate']")).sendKeys(DOBTepPatient);

		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='butSaveClose']")).click();

		//creating Validated patient.


		//Orderset functionality.:20-2-2019

		driver.findElement(By.xpath("//iframe[@id='f0']/..")).click(); //to get back control on the div we used /.. 
		driver.switchTo().frame(driver.findElement(By.id("f0")));
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f11']")));

		driver.findElement(By.xpath("//button[@id='butBattery']")).click(); //clicking on orderset option.
		//	Thread.sleep(7000);



		//	driver.switchTo().defaultContent();
		//  Thread.sleep(5000);

		// driver.switchTo().frame(driver.findElement(By.id("ultramodal1-modal-iframe")));
		// driver.switchTo().frame(driver.findElement(By.id("f11")));

		// driver.findElement(By.xpath("//input[@title='Family name' and @id='sFamilyname']")).click();
		// Thread.sleep(3000);
		// driver.findElement(By.xpath("//input[@title='Family name' and @id='sFamilyname']")).sendKeys(WaitinglistPatfamName);

		// driver.findElement(By.xpath("//input[@title='Family name' and @id='sFamilyname']")).sendKeys(Patintfamname);

		// driver.findElement(By.xpath("//td[@class='rowInput']//input[@name='sGivenname' and @id='sGivenname']")).sendKeys(WaitinglistPatGivenName);

		// driver.findElement(By.xpath("//td[@class='rowButton']//button[@id='butSearch']")).click();
		// Thread.sleep(5000);

		// driver.findElement(By.xpath("//button[@id='butSelect']")).click();  //selecting Patient for Orderset.
		//select[@id='selBatGroup']
		// Thread.sleep(2000);
		framecheck.checkframe12(driver);
		driver.findElement(By.xpath("//select[@id='selBatGroup']")).click();
		Thread.sleep(2000);
		Select orderset=new Select(driver.findElement(By.xpath("//select[@id='selBatGroup']")));
		orderset.selectByVisibleText("[All order sets]");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//select[@id='selBat']")).click();

		Thread.sleep(3000);

		Select orderdep =new Select(driver.findElement(By.xpath("//select[@id='selBat']")));
		//+ "//option[text()='" + Ordersetname +" "+"("+CreatDepname+")" + "']")));
		orderdep.selectByVisibleText(Ordersetname +" "+"("+CreatDepname+")");
		Thread.sleep(5000);


		// Actions action = new Actions(driver);
		// action.moveToElement(driver.findElement(By.xpath("//select[@id='selBat']//option[text()='" + Ordersetname +" "+"("+CreatDepname+")" + "']"))).click().build().perform();
		//driver.findElement(By.xpath("//select[@id='selBat']//option[text()='" + Ordersetname +" "+(CreatDepname) + "']")).click();
		// Thread.sleep(3000);
		// framecheck.checkframe12(driver);
		//div[3]//span[@class='part last']//button[@class='butSearch']
		driver.findElement(By.xpath("//div[3]//span[@class='part last']//button[@class='butSearch']")).click(); // click on search icon to search orderset slots.
		Thread.sleep(5000);




		if(driver.findElements(By.xpath("//button[@id='butBook']")).size()>0)
		{
			Thread.sleep(2000);

			//DO THE STUFF YOU NEED TO DO IF THE ELEMENT EXISTS
			driver.findElement(By.xpath("//button[@id='butBook']")).click(); //clicking on particular slot to book apntmnt. 
		}

		else
		{
			Thread.sleep(2000);
			//button[@id='Button2']
			driver.findElement(By.xpath("//button[text()='Next']")).click();  //clicking on the next button if the free slots not available.
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@id='butBook']")).click(); // clicking on book button 
		}
		Thread.sleep(4000);

		driver.findElement(By.xpath("//button[@id='butBook']")).click(); // clicking on save btn


		//button[@id='butBlock']



		//button[@id='butDelete']
		/* WebElement datepicker= driver.findElement(By.xpath("//table[@id='CalTable_menu']//tbody"));

	     List<WebElement>dates =  datepicker.findElements(By.tagName("td"));

	     for(WebElement date : dates)
	     {
	    	 String caldate= date.getAttribute((Day||offday));

		 */
		/*driver.findElement(By.xpath("//button[@id='butSearch']")).click(); // clicking on 
 button
	Thread.sleep(4000);// clicking on free button
	 driver.switchTo().defaultContent();
	 Thread.sleep(3000);
	 driver.switchTo().frame(driver.findElement(By.id("ultramodal1-modal-iframe")));
	 Thread.sleep(3000);
	//input[@title='Family name' and @id='sFamilyname']
	 driver.findElement(By.xpath("//input[@title='Family name' and @id='sFamilyname']")).click();
	 Thread.sleep(2000);
	 driver.findElement(By.xpath("//input[@title='Family name' and @id='sFamilyname']")).sendKeys(Patintfamname);
	//td[@class='rowInput']//input[@name='sGivenname' and @id='sGivenname']
	 driver.findElement(By.xpath("//td[@class='rowInput']//input[@name='sGivenname' and @id='sGivenname']")).sendKeys(Patintgivname);

	 driver.findElement(By.xpath("//td[@class='rowButton']//button[@id='butSearch']")).click();
	 Thread.sleep(5000);
	//button[@id='butSelect']
	 driver.findElement(By.xpath("//button[@id='butSelect']")).click();
	 Thread.sleep(5000);

	 driver.findElement(By.xpath("//span[@id='select2-apptypeSelect-container']")).click();//Schedule setup-Selecting appointment type.

	 driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys(CreateNewApt);
	 Actions actions1 = new Actions(driver);
	 Thread.sleep(2000);
	 actions1.sendKeys(Keys.ENTER).build().perform();
	 Thread.sleep(2000);
	//button[@id='butSearch2']

	 driver.findElement(By.xpath("//button[@id='butSearch2']")).click();



		 */
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

package UGregresssionpack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import AllUgsmoketest.framecheck;
import AllUgsmoketest.userlogin;
import excelreaderutility.Xls_Reader;
import ugprofunctionality.Navigatepatientpportal;
import ugprofunctionality.logoutUG;
import ugprofunctionality.patientsearch;
import ugprofunctionality.setupbtnandsyssetting;

public class regtest2 extends regtest1 {
	static boolean bValue;
	static String Pattitname;
	static String ethname;
	static String ethcode;
	static String maritalname;
	static String maritalcode;
	static String relname;
	static String relcode;
	static String nokname;
	static String nokcode;
	static String defsearch;
	static String patoptcol1;
	static String patoptcol2;
	static String tpmacro;
	static String vlmacro;
	static String Notattethresh;
	static String npastm;
	static String FamnameTepPatient;
	static String DOBTepPatient;

	public static void main(String[] args) throws InterruptedException {

		reader = new Xls_Reader("C:\\Test.xlsx");


		Refreshval = SubChar(reader.getCellData("ST2", "ScreenRefresh value", 2).toString());
		Calendarday	=reader.getCellData("ST2", "CalendarFirstDayOfWeek", 2);
		ScheduleNavn	 =reader.getCellData("ST6", "Schedule Name", 2);
		AuthUsername	=reader.getCellData("ST4", "Authentication Username", 2);
		AuthPassword	=reader.getCellData("ST4", "Authentication Password", 2);
		logtime =reader.getCellData("reg2", "Logoff time", 2);
		Pattitname=reader.getCellData("reg2", "PatienttitleName", 2);
		ethname=reader.getCellData("reg2", "Ethnic originval", 2);
		ethcode=reader.getCellData("reg2", "ethnic code", 2);
		maritalname=reader.getCellData("reg2", "Marital name", 2);
		maritalcode=reader.getCellData("reg2", "Marital code", 2);
		relname=reader.getCellData("reg2", "religion name", 2);
		relcode=reader.getCellData("reg2", "religion code", 2);
		nokname=reader.getCellData("reg1", "nextofkin name", 2);
		nokcode=reader.getCellData("reg2", "nextofkin code", 2);
		defsearch=reader.getCellData("reg2", "Default Search field", 2);
		patoptcol1=reader.getCellData("reg2", "Patient opt col1", 2);
		patoptcol2=reader.getCellData("reg2", "Patient Opt col2", 2);
		tpmacro=reader.getCellData("reg2", "tempmacro", 2);
		vlmacro=reader.getCellData("reg2", "Validated Macro", 2);
		Notattethresh =reader.getCellData("reg2", "Not Attending Threshold", 2);
		npastm =reader.getCellData("reg2", "Number of past month to evaluate", 2);
		FamnameTepPatient = reader.getCellData("ST8", "Famname-Temp Patient", 2);
		DOBTepPatient = reader.getCellData("ST8", "DOB-Temp Patient", 2);


		System.setProperty("webdriver.chrome.driver", "C:\\sdriver\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();

		userlogin.login(driver);


		//Thread.sleep(2000);

		driver.findElement(By.linkText("Central setup")).click();
		Thread.sleep(2000);

		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f12']")));
		driver.findElement(By.xpath("(//div[@class='menuButton'])[1]")).click(); //System administration
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@id='menuItem_18'])[1]")).click();  //System Settings
		Thread.sleep(2000);
		driver.switchTo().parentFrame();
		//Switched for parent frame=F0 because it was not able to come outside from F12 frame so i switched)

		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f11']")));
		driver.findElement(By.xpath("//th[text()='Patient settings']")).click(); // clicking on Patient setting option.
		Thread.sleep(4000);
		WebElement titlein = driver.findElement(By.xpath("//input[@id='txtTitleInUseN']"));
		//bValue = Practicerdo.isSelected();

		//----------these all below commented lines  we will use later--------------

		if(bValue = titlein.isSelected())
		{
			driver.findElement(By.xpath("//input[@id='txtTitleInUseY']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@id='butSave']")).click();
			Thread.sleep(7000);

			logoutUG.logoffug(driver);   // function to logout ug and and login again

			//below all definition table options ethnic next of kin, religion type

			// driver.switchTo().parentFrame();
			//driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f12']")));

			driver.findElement(By.linkText("Central setup")).click();
			Thread.sleep(3000);

			driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f12']")));
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//div[@class='menuButton'])[2]")).click(); //definition table
			Thread.sleep(2000);


			driver.findElement(By.xpath("//div[@id='menuItem_34']")).click();  //Clicking on the Patient title option
			Thread.sleep(3000);
			//button[@id='butNew']
			framecheck.checkframe11(driver);
			driver.findElement(By.xpath("//button[@id='butNew']")).click(); // creating new patient title

			Thread.sleep(2000);

			driver.findElement(By.xpath("//input[@id='txttitleName']")).sendKeys(Pattitname);



			driver.findElement(By.xpath("//button[@id='butSave']")).click();  // saving new patient title value

			Thread.sleep(2000);

			framecheck.checkframe12(driver);

			driver.findElement(By.xpath("//div[@id='menuItem_30']")).click(); // ethnic origin.
			Thread.sleep(4000);

			framecheck.checkframe11(driver);

			driver.findElement(By.xpath("//button[@id='butNew']")).click(); // creating new ethnic origin

			Thread.sleep(2000);
			//input[@id='txtethorgName']


			driver.findElement(By.xpath("//input[@id='txtethorgName']")).sendKeys(ethname);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='txtethorgCode']")).sendKeys(ethcode);
			Thread.sleep(2000);

			driver.findElement(By.xpath("//button[@id='butSave']")).click();
			Thread.sleep(3000);


			//Marital status.

			framecheck.checkframe12(driver);
			driver.findElement(By.xpath("//div[@id='menuItem_31']")).click(); // marital ststaus
			Thread.sleep(2000);
			framecheck.checkframe11(driver);
			driver.findElement(By.xpath("//button[@id='butNew']")).click(); // creating new marital

			Thread.sleep(3000);
			//input[@id='txtethorgName']

			driver.findElement(By.xpath("//input[@id='txtmaristatName']")).sendKeys(maritalname);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='txtmaristatCode']")).sendKeys(maritalcode);
			Thread.sleep(2000);



			driver.findElement(By.xpath("//button[@id='butSave']")).click();  // saving new marital value
			Thread.sleep(3000);
			//Religion types
			framecheck.checkframe12(driver);
			driver.findElement(By.xpath("//div[@id='menuItem_32']")).click(); // religiontype
			Thread.sleep(4000);
			framecheck.checkframe11(driver);
			driver.findElement(By.xpath("//button[@id='butNew']")).click(); // creating new religion

			Thread.sleep(2000);
			//input[@id='txtethorgName']

			driver.findElement(By.xpath("//input[@id='txtRelName']")).sendKeys(relname);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='txtRelCode']")).sendKeys(relcode);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@id='butSave']")).click();   //saving religion values.
			Thread.sleep(3000);

			//next of kin
			framecheck.checkframe12(driver);
			driver.findElement(By.xpath("//div[@id='menuItem_29']")).click(); //next of kin
			Thread.sleep(4000);
			framecheck.checkframe11(driver);
			driver.findElement(By.xpath("//button[@id='butNew']")).click(); // creating new next of kin

			Thread.sleep(2000);
			//input[@id='txtethorgName']

			driver.findElement(By.xpath("//input[@id='txtNokRelName']")).sendKeys(nokname);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='txtNokRelCode']")).sendKeys(nokcode);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@id='butSave']")).click(); 
			Thread.sleep(2000);


			Navigatepatientpportal.navigatepatient(driver);

			driver.findElement(By.xpath("//select[@id='title']")).click();  // click on the Patient title.

			Thread.sleep(2000);

			driver.findElement(By.xpath("//select[@id='religId']")).click(); // click on the Religiontype poup in patient popup
			Thread.sleep(2000);
			driver.findElement(By.xpath("//select[@id='maristatId']")).click(); //click on the Marital status dropdown.
			Thread.sleep(2000);
			driver.findElement(By.xpath("//select[@id='ethorgId']")).click();  // click on the ethnic type.

			Thread.sleep(2000);


			// Pending next of kin funnctionality 

			Thread.sleep(7000);

			// driver.findElement(By.xpath("//div[@id='modal-container']//div[@id='ultramodal1']//div//div//span[2]")).click();

			//div[@id='outerRows']

			driver.switchTo().defaultContent();
			Thread.sleep(2000);

			driver.switchTo().frame(driver.findElement(By.id("ultramodal1-modal-iframe")));
			driver.switchTo().frame(driver.findElement(By.id("f11")));

			driver.findElement(By.xpath("//button[@id='butBack']")).click();
			Thread.sleep(4000);
			//span[@class='modal-close-button']
			driver.switchTo().defaultContent();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//span[@class='modal-close-button']")).click();
			Thread.sleep(3000);





		}
		else
		{
			driver.findElement(By.xpath("//input[@id='txtTitleInUseN']")).click(); 
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@id='butSave']")).click();
			Thread.sleep(7000);
			logoutUG.logoffug(driver); 

			driver.findElement(By.linkText("Central setup")).click();
			Thread.sleep(3000);

			driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f12']")));



			Thread.sleep(2000);
			driver.findElement(By.xpath("(//div[@class='menuButton'])[2]")).click(); //definition table
			Thread.sleep(2000);

			//Navigating to Patient portal.

			Navigatepatientpportal.navigatepatient(driver);

			Thread.sleep(7000);

			// driver.findElement(By.xpath("//div[@id='modal-container']//div[@id='ultramodal1']//div//div//span[2]")).click();

			//div[@id='outerRows']

			driver.switchTo().defaultContent();
			Thread.sleep(2000);

			driver.switchTo().frame(driver.findElement(By.id("ultramodal1-modal-iframe")));
			driver.switchTo().frame(driver.findElement(By.id("f11")));

			driver.findElement(By.xpath("//button[@id='butBack']")).click();
			Thread.sleep(4000);
			//span[@class='modal-close-button']
			driver.switchTo().defaultContent();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//span[@class='modal-close-button']")).click();
			Thread.sleep(3000);

			//here title field should be as free text after navigation and patient title should not be visible in definition table
		}  





		driver.findElement(By.xpath("//iframe[@id='f0']/..")).click(); //to get back control on the div we used /.. 
		driver.switchTo().frame(driver.findElement(By.id("f0")));

		driver.switchTo().frame(driver.findElement(By.id("f11")));



		driver.findElement(By.xpath("//img[@id='setupButton']")).click();  // click on the setup button.
		Thread.sleep(7000);

		driver.switchTo().parentFrame();



		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f10']")));

		driver.findElement(By.xpath("//div[@class='headerLinks']//span[1]")).click(); // clicking on the Central Setup.
		Thread.sleep(6000);

		framecheck.checkframe12(driver);
		driver.findElement(By.xpath("(//div[@class='menuButton'])[1]")).click();  //system administration
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@id='menuItem_18'])[1]")).click();  //System Settings
		Thread.sleep(2000);
		framecheck.checkframe11(driver);
		driver.findElement(By.xpath("//th[text()='Patient settings']")).click(); // clicking on Patient setting option.
		Thread.sleep(4000);
		//select[@id='txtDfltPatsearchfield']
		driver.findElement(By.xpath("//select[@id='txtDfltPatsearchfield']")).click(); //clicking on the default search field.
		Thread.sleep(2000);
		Select defsearcht=new Select(driver.findElement(By.xpath("//select[@id='txtDfltPatsearchfield']")));
		Thread.sleep(2000);
		defsearcht.selectByVisibleText(defsearch); // select default field.
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='butSave']")).click();  // saving default selected patient values.
		Thread.sleep(4000);
		//pending navigate to patient portal to see -now covered need to test
		Navigatepatientpportal.navigatepatient(driver);




		driver.switchTo().defaultContent();
		Thread.sleep(2000);

		driver.switchTo().frame(driver.findElement(By.id("ultramodal1-modal-iframe")));
		driver.switchTo().frame(driver.findElement(By.id("f11")));

		driver.findElement(By.xpath("//button[@id='butBack']")).click();
		Thread.sleep(4000);
		//span[@class='modal-close-button']
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='modal-close-button']")).click();
		Thread.sleep(3000);




		//navigating to setup button and central setup to move on the patient setting.
		setupbtnandsyssetting.setupbtnsyssetting(driver); 
		//select[@id='txtPatientSearchResultColumn1']
		Thread.sleep(2000);
		driver.findElement(By.xpath("//select[@id='txtPatientSearchResultColumn1']")).click(); //patient option column1.
		Thread.sleep(2000);


		Select patopt=new Select(driver.findElement(By.xpath("//select[@id='txtPatientSearchResultColumn1']")));
		Thread.sleep(1000);
		patopt.selectByVisibleText(patoptcol1); // select patient opt col1
		Thread.sleep(2000);
		driver.findElement(By.xpath("//select[@id='txtPatientSearchResultColumn2']")).click(); //patient option column2.

		Thread.sleep(2000);

		Select patopt2=new Select(driver.findElement(By.xpath("//select[@id='txtPatientSearchResultColumn2']")));
		Thread.sleep(3000);
		patopt2.selectByVisibleText(patoptcol2);    //select patient opt col2.


		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[@id='butSave']")).click();

		// clicking on the schedule setup.

		driver.switchTo().parentFrame();

		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f10']")));

		driver.findElement(By.xpath("//div[@class='headerLinks']//span[2]")).click(); // clicking on schedule setup.
		Thread.sleep(2000);

		framecheck.checkframe12(driver);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//select[@id='rscIdDptId']")).click();


		Select sched=new Select(driver.findElement(By.xpath("//select[@id='rscIdDptId']"))); // for now as i was not able to save the schedule , so we will directly
		//fetch the schedule name from excel sheet. In future need to updating with new created schedule name.
		Thread.sleep(2000);	
		sched.selectByVisibleText("NewsSchedule");

		Thread.sleep(7000);

		driver.findElement(By.xpath("//div[@class='buttonFloatLeft']//img[@id='scheduleButton']")).click();// clicking on Schedule button-Schedule setup.
		Thread.sleep(3000);

		// above is way to click on the schedule setup.


		patientsearch.lookpatient(driver);



		//Navigating to patient portal to see optional columns.
		// Navigatepatientpportal.navigatepatient(driver);

		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='modal-close-button']")).click();

		Thread.sleep(2000);

		setupbtnandsyssetting.setupbtnsyssetting(driver); 




		//Macro functionality for temp patient.

		//select[@id='txtTemporaryNumberMacro']
		Thread.sleep(2000);
		driver.findElement(By.xpath("//select[@id='txtTemporaryNumberMacro']")).click(); // click on temp patient dropdown.
		Select temmacro=new Select(driver.findElement(By.xpath("//select[@id='txtTemporaryNumberMacro']")));
		temmacro.selectByVisibleText(tpmacro); 
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[@id='butSave']")).click();

		Navigatepatientpportal.navigatepatient(driver);
		Thread.sleep(2000);

		//creating temporary patient to see macro id.
		// driver.switchTo().defaultContent();
		Thread.sleep(5000);

		driver.findElement(By.xpath("//input[@id='title']")).click(); // clicking on title of option if title in use on no.
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='title']")).sendKeys("Mr");


		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='familyname']")).sendKeys(FamnameTepPatient);
		Thread.sleep(2000);
		//click on radio button.
		//input[@id='firstname']
		driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("Given name");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='radio' and@id='male']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='birthdate']")).sendKeys(DOBTepPatient);

		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='butSaveClose']")).click();

		Thread.sleep(10000);



		driver.switchTo().frame(driver.findElement(By.id("f0")));


		driver.switchTo().frame(driver.findElement(By.id("f13")));
		Thread.sleep(2000);
		//span[@id='b12']
		driver.findElement(By.xpath("//span[@id='b12']")).click();   // clicking on the patient tab to see patinet macro id.
		Thread.sleep(10000);
		//above meanwhile you can see the see macro id.
		// I used again all lines code instead of using syssetting 
		// driver.switchTo().frame(driver.findElement(By.id("f0")));
		//	 driver.findElement(By.xpath("//body//iframe[@id='f0']/..")).click(); //to get back control on the div we used /.. 


		driver.findElement(By.xpath("//span[@title='Edit']//i")).click(); // editing apppointment to see macro id

		Thread.sleep(2000);
		// to click on save and close btn.

		driver.switchTo().defaultContent();
		Thread.sleep(2000);

		driver.switchTo().frame(driver.findElement(By.id("ultramodal1-modal-iframe")));
		driver.switchTo().frame(driver.findElement(By.id("f11")));

		driver.findElement(By.xpath("//button[@id='butSaveClose']")).click();
		Thread.sleep(4000);


		driver.findElement(By.xpath("//iframe[@id='f0']/..")).click();
		driver.switchTo().frame(driver.findElement(By.id("f0")));
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f11']")));
		Thread.sleep(2000);



		driver.findElement(By.xpath("//img[@id='setupButton']")).click();  // click on the setup button.
		Thread.sleep(7000);

		//one point not covered as not able to see error if saving values in maximum future book days larger than central setup.
		driver.switchTo().parentFrame();
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f10']")));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='headerLinks']//span[1]")).click(); // clicking on the Central Setup.
		Thread.sleep(6000);
		framecheck.checkframe12(driver);

		driver.findElement(By.xpath("(//div[@class='menuButton'])[1]")).click(); //System administration
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@id='menuItem_18'])[1]")).click();  //System Settings
		Thread.sleep(2000);


		driver.switchTo().parentFrame();
		//Switched for parent frame=F0 because it was not able to come outside from F12 frame so i switched)

		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f11']")));
		driver.findElement(By.xpath("//th[text()='Patient settings']")).click(); // clicking on Patient setting option.
		Thread.sleep(4000);

		/*	 //Macro functionality for validated patient.

			 driver.findElement(By.xpath("//select[@id='txtValidatedNumberMacro']")).click(); // click on validated patient dropdown.
			 Select valmacro=new Select(driver.findElement(By.xpath("//select[@id='txtValidatedNumberMacro']")));
			 valmacro.selectByVisibleText(vlmacro); 
			 Thread.sleep(2000);
			 //pending patinet macro test functionality.
		 */ 


		//not attending APPOINTMENT threshold.

		driver.findElement(By.xpath("//input[@id='txtPatientDNAWarningFrequency']")).click(); //not attended
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='txtPatientDNAWarningFrequency']")).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='txtPatientDNAWarningFrequency']")).sendKeys("0");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='butSave']")).click(); // saving values
		Thread.sleep(2000);
		driver.switchTo().alert().accept();


		//number of past month to evaluate.
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='txtPatientDNAWarningTimespanInMonths']")).click();  //number of past month to evaluate.
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='txtPatientDNAWarningTimespanInMonths']")).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='txtPatientDNAWarningTimespanInMonths']")).sendKeys("0");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='butSave']")).click(); // saving values.
		Thread.sleep(2000);
		driver.switchTo().alert().accept();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@id='txtPatientDNAWarningFrequency']")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='txtPatientDNAWarningFrequency']")).sendKeys(Notattethresh);
		Thread.sleep(2000);

		//pending to navigate to schedule setup to see not attending appointment threshold
		driver.findElement(By.xpath("//input[@id='txtPatientDNAWarningTimespanInMonths']")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='txtPatientDNAWarningTimespanInMonths']")).sendKeys(npastm);

		//pending to navigate to schedule setup to see number of past months to evaluate.



		// pending to visit patient portal.


		//framecheck.checkframe12(driver);

		//driver.findElement(By.xpath("(//div[@class='menuButton'])[1]")).click(); //System administration
		//Thread.sleep(2000);
		//driver.findElement(By.xpath("(//div[@id='menuItem_18'])[1]")).click();  //System Settings
		//Thread.sleep(2000);


		//Show future history Indication.

		Thread.sleep(2000);		

		WebElement futuhist = driver.findElement(By.xpath("//input[@id='txtFutureHistoryIndicationInUseN']"));
		//bValue = Practicerdo.isSelected();

		if(bValue = futuhist.isSelected())
		{
			driver.findElement(By.xpath("//input[@id='txtFutureHistoryIndicationInUseY']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@id='butSave']")).click();
			Thread.sleep(7000);

			// clicking on the schedule setup.

			driver.switchTo().parentFrame();

			driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f10']")));

			driver.findElement(By.xpath("//div[@class='headerLinks']//span[2]")).click(); // clicking on schedule setup.
			Thread.sleep(2000);

			framecheck.checkframe12(driver);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//select[@id='rscIdDptId']")).click();


			Select sched0=new Select(driver.findElement(By.xpath("//select[@id='rscIdDptId']"))); // for now as i was not able to save the schedule , so we will directly
			//fetch the schedule name from excel sheet. In future need to updating with new created schedule name.
			Thread.sleep(2000);	
			sched0.selectByVisibleText("NewsSchedule");

			Thread.sleep(7000);

			driver.findElement(By.xpath("//div[@class='buttonFloatLeft']//img[@id='scheduleButton']")).click();// clicking on Schedule button-Schedule setup.
			Thread.sleep(3000);
			// above clcking on schedule setup

			patientsearch.lookpatient(driver);
			// round arrow icon should be visible if the patient has already appointments 
		}
		else
		{
			driver.findElement(By.xpath("//input[@id='txtFutureHistoryIndicationInUseN']")).click(); 
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@id='butSave']")).click();
			Thread.sleep(7000);

			// clicking on the schedule setup.

			driver.switchTo().parentFrame();

			driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f10']")));

			driver.findElement(By.xpath("//div[@class='headerLinks']//span[2]")).click(); // clicking on schedule setup.
			Thread.sleep(2000);

			framecheck.checkframe12(driver);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//select[@id='rscIdDptId']")).click();


			Select sched1=new Select(driver.findElement(By.xpath("//select[@id='rscIdDptId']"))); // for now as i was not able to save the schedule , so we will directly
			//fetch the schedule name from excel sheet. In future need to updating with new created schedule name.
			Thread.sleep(2000);	
			sched1.selectByVisibleText("NewsSchedule");

			Thread.sleep(7000);

			driver.findElement(By.xpath("//div[@class='buttonFloatLeft']//img[@id='scheduleButton']")).click();// clicking on Schedule button-Schedule setup.
			Thread.sleep(3000);
			// above clcking on schedule setup

			patientsearch.lookpatient(driver);

			// round arrow icon should be visible if the patient has already appointments (In the patient search screen)
		}

		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='modal-close-button']")).click();

		Thread.sleep(2000);

		//Gender Preference
		setupbtnandsyssetting.setupbtnsyssetting(driver); 
		Thread.sleep(4000);

		WebElement Gpr = driver.findElement(By.xpath("//input[@id='txtGenderPreferenceInUseY']"));


		if(bValue = Gpr.isSelected())
		{
			//driver.findElement(By.xpath("//input[@id='txtFutureHistoryIndicationInUseY']")).click();

			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='txtGenderPreferenceInUseN']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@id='butSave']")).click();
			Thread.sleep(3000);
			//pending patient navigation story-covered need to test
			Navigatepatientpportal.navigatepatient(driver);

			driver.switchTo().defaultContent();
			Thread.sleep(2000);

			driver.switchTo().frame(driver.findElement(By.id("ultramodal1-modal-iframe")));
			driver.switchTo().frame(driver.findElement(By.id("f11")));

			driver.findElement(By.xpath("//button[@id='butBack']")).click();
			Thread.sleep(4000);
			//span[@class='modal-close-button']
			driver.switchTo().defaultContent();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//span[@class='modal-close-button']")).click();
			Thread.sleep(3000);

			//navigating to setup button to click on general to see sex


			Thread.sleep(2000);
			driver.findElement(By.xpath("//iframe[@id='f0']/..")).click();
			driver.switchTo().frame(driver.findElement(By.id("f0")));

			driver.switchTo().frame(driver.findElement(By.id("f11")));


			driver.findElement(By.xpath("//img[@id='setupButton']")).click();  // click on the setup button.
			Thread.sleep(7000);

			framecheck.checkframe12(driver);

			driver.findElement(By.xpath("//div[@id='menuItem_7']")).click(); // click on General option-schedule setup
			Thread.sleep(4000);

			//one point not covered as not able to see error if saving values in maximum future book days larger than central setup.
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


			driver.findElement(By.xpath("//div[@id='menuItem_2']")).click(); //Departmental setup-schedules
			Thread.sleep(3000);



		}

		else
		{
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='txtGenderPreferenceInUseY']")).click(); 
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@id='butSave']")).click();
			Thread.sleep(2000);
			//pending patient navigation story-covered need to test
			Navigatepatientpportal.navigatepatient(driver);



			driver.switchTo().defaultContent();
			Thread.sleep(2000);

			driver.switchTo().frame(driver.findElement(By.id("ultramodal1-modal-iframe")));
			driver.switchTo().frame(driver.findElement(By.id("f11")));

			driver.findElement(By.xpath("//button[@id='butBack']")).click();
			Thread.sleep(4000);
			//span[@class='modal-close-button']
			driver.switchTo().defaultContent();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//span[@class='modal-close-button']")).click();
			Thread.sleep(3000);

			//navigating to setup button to click on general to see sex
			//Clciking on Setup btn.

			Thread.sleep(2000);
			driver.findElement(By.xpath("//iframe[@id='f0']/..")).click();
			driver.switchTo().frame(driver.findElement(By.id("f0")));

			driver.switchTo().frame(driver.findElement(By.id("f11")));


			driver.findElement(By.xpath("//img[@id='setupButton']")).click();  // click on the setup button.
			Thread.sleep(7000);


			//Schedule setup-General Option.

			framecheck.checkframe12(driver);

			driver.findElement(By.xpath("//div[@id='menuItem_7']")).click(); // click on General option-schedule setup
			Thread.sleep(4000);

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



			driver.findElement(By.xpath("//div[@id='menuItem_2']")).click(); //Departmental setup-schedules
			Thread.sleep(3000);


			driver.quit();


			//input[@value='Cancel']

			//one point not covered as not able to see error if saving values in maximum future book days larger than central setup.


		}



	}
}

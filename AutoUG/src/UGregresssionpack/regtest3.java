package UGregresssionpack;

import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import AllUgsmoketest.framecheck;
import AllUgsmoketest.userlogin;
import excelreaderutility.Xls_Reader;
import ugprofunctionality.FreemultiYN;
import ugprofunctionality.PracticesYN;
import ugprofunctionality.StaffRegYN;
import ugprofunctionality.bookstartpat;
import ugprofunctionality.logoutUG;
import ugprofunctionality.referrallistyn;
import ugprofunctionality.regpatientavailforapnt;
import ugprofunctionality.regpatinetavailforwaitinglist;
import ugprofunctionality.setupbtnandactdeactsetting;
import ugprofunctionality.waitinglistYN;
import ugprofunctionality.ugtrackproactdeact;

public class regtest3 extends regtest2 {
	static String  Differentactions;

	public static void main(String[] args) throws InterruptedException {

		reader = new Xls_Reader("C:\\Users\\akhosla\\Documents\\regexcelsheet.xlsx");
		Differentactions = reader.getCellData("reg3", "Actions-Session", 2);





		System.setProperty("webdriver.chrome.driver", "C:\\sdriver\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();

		userlogin.login(driver);


		//Functionality practices on yes and no.
		//-----------------------------------------------------------------------------------------------------------------------------------------------------------
		PracticesYN.PractY(driver);


		//Thread.sleep(2000);



		Thread.sleep(6000);

		logoutUG.logoffug(driver);

		PracticesYN.PractN(driver);


		Thread.sleep(6000);

		logoutUG.logoffug(driver);



		driver.findElement(By.linkText("Central setup")).click();
		Thread.sleep(2000);

		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f12']")));

		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='menuButton'])[3]")).click();   // Clicking on the Central Administration.

		// Following Sleep to see , Practices is getting disappear or not.

		Thread.sleep(5000);
		//---------------------------------------------------------------------------------------------------------------------------------------------------------

		// Functionality Staff registration in use.

		StaffRegYN.staffregY(driver);
		framecheck.checkframe11(driver);

		driver.findElement(By.xpath("//table[@id='CalTable_menu']//tr[6]/td[2]")).click();  // clicking on the Particular slot

		framecheck.checkframe12(driver);

		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[@class='actionsHyperlinkClass']")).click();  //clicking on the actions dropdown.
		Thread.sleep(3000);
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//td[text()='" +  Differentactions + "']"))).doubleClick().build().perform(); //Clicking on the actions dropdown options.

		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[@class='ug-button'  and  text()='Cancel']")).click();   // Clicking on the Cancel button.
		Thread.sleep(3000);

		driver.switchTo().defaultContent();
		setupbtnandactdeactsetting.Activatesettings(driver);
		//--------------------------------------------------------------------------------------------------------------------------------------------------------
		// below line for staff registration on No

		StaffRegYN.staffregN(driver);

		framecheck.checkframe11(driver);

		driver.findElement(By.xpath("//table[@id='CalTable_menu']//tr[6]/td[2]")).click();
		Thread.sleep(2000);
		framecheck.checkframe12(driver);

		driver.findElement(By.xpath("//div[@class='actionsHyperlinkClass']")).click();  //clicking on the actions dropdown.
		Thread.sleep(3000);
		Actions act1 = new Actions(driver);
		act1.moveToElement(driver.findElement(By.xpath("//td[text()='" +  Differentactions + "']"))).doubleClick().build().perform(); //Clicking on the actions dropdown options.
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[@class='ug-button'  and  text()='Cancel']")).click();   // Clicking on the Cancel button.
		Thread.sleep(6000);
		driver.switchTo().defaultContent();

		//button[@class='ug-button'  and  text()='Cancel']
		setupbtnandactdeactsetting.Activatesettings(driver);

		//------------------------------------------------------------------------------------------------------------------------------------------------------
		//waiting list functionality.

		waitinglistYN.waitlistY(driver);

		setupbtnandactdeactsetting.Activatesettings(driver);

		waitinglistYN.waitlistN(driver);

		setupbtnandactdeactsetting.Activatesettings(driver);
		//-------------------------------------------------------------------------------------------------------------------------------------------------------


		//registration patient avail for appointment functionality
		//When booking an appointment an extra line with patient availability should appear during the last step.



		regpatientavailforapnt.rpaY(driver);

		setupbtnandactdeactsetting.Activatesettings(driver);

		regpatientavailforapnt.rpaN(driver);

		setupbtnandactdeactsetting.Activatesettings(driver);
		//--------------------------------------------------------------------------------------------------------------------------------------------------------
		// free multi use functionality

		FreemultiYN.freemultY(driver);

		setupbtnandactdeactsetting.Activatesettings(driver);

		FreemultiYN.freemultN(driver);

		setupbtnandactdeactsetting.Activatesettings(driver);

		//---------------------------------------------------------------------------------------------------------------------------------------------------------
		//Functionality booking process start with patient.

		bookstartpat.startbookpatY(driver);

		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class='modal-close-button']")).click();
		Thread.sleep(3000);

		driver.switchTo().defaultContent();

		setupbtnandactdeactsetting.Activatesettings(driver);

		bookstartpat.startbookpatN(driver);

		Thread.sleep(2000);

		driver.switchTo().defaultContent();

		//---------------------------------------------------------------------------------------------------------------------------------------------------------------	 

		//Functionality UG track pro in use or not.

		setupbtnandactdeactsetting.Activatesettings(driver);

		ugtrackproactdeact.trackproactdeactY(driver);

		// setupbtnandactdeactsetting.Activatesettings(driver);

		ugtrackproactdeact.trackproactdeactN(driver);

		//-------------------------------------------------------------------------------------------------------------------------------------------------------------	 
		//Functionality Registration patient availability for waiting list entries. 


		regpatinetavailforwaitinglist.rpaWY(driver);

		setupbtnandactdeactsetting.Activatesettings(driver);

		regpatinetavailforwaitinglist.rpaWN(driver);

		// setupbtnandactdeactsetting.Activatesettings(driver);


		//-----------------------------------------------------------------------------------------------------------------------------------------------------------		 
		//Functionality referral list in use

		referrallistyn.listrefY(driver);

		setupbtnandactdeactsetting.Activatesettings(driver);

		referrallistyn.listrefN(driver);

		setupbtnandactdeactsetting.Activatesettings(driver);

		//-------------------------------------------------------------------------------------------------------------------	 
		//Pending-Show appointment for other schedules.
















	}

}

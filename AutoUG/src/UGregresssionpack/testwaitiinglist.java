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

public class testwaitiinglist
{
	public static String FreebtnPatfamname;
	public static String FreebtnPatGivenName; 
	public static String selapntmnt;
	public static String Selschforwaitinglist;
	public  static Xls_Reader reader;
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException 
	{
		
		
		reader =new Xls_Reader("C:\\Users\\akhosla\\Documents\\regexcelsheet.xlsx");
		FreebtnPatfamname = reader.getCellData("reg3", "Freebtn-Patientfamname", 2);
		FreebtnPatGivenName  = reader.getCellData("reg3", "Freebtn-PatientGivenName", 2);
		Selschforwaitinglist = reader.getCellData("reg3", "Selschedforwaitinglist", 2);

		selapntmnt =reader.getCellData("reg3", "SelAppointmentnametobookappointment", 2); //here appointment name should already exist in the system.
		System.setProperty("webdriver.chrome.driver", "C:\\sdriver\\chromedriver.exe");
		 driver= new ChromeDriver();


		userlogin.login(driver);

		driver.findElement(By.linkText("Central setup")).click();
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f12']")));
		driver.findElement(By.xpath("(//div[@class='menuButton'])[1]")).click();  //system administration
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("(//div[@id='menuItem_18'])[1]")).click();  //system settings
		
		
		Thread.sleep(4000);

		driver.switchTo().parentFrame();
		//Switched for parent frame=F0 because it was not able to come outside from F12 frame so i switched)

		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f11']")));
		driver.findElement(By.xpath("//th[text()='Activate / de-activate features']")).click(); // clicking on Activate / de-activate features option.
		Thread.sleep(4000); 
		driver.findElement(By.xpath("//input[@id='txtEncuragePatientSelectionBeforeSearchInUseY']")).click(); 
		Thread.sleep(2000);//above i am selecting booking start for patient because i have written the code as per booking should always start from patinet. 
		driver.findElement(By.xpath("//input[@id='txtWaitingListInUseY']")).click(); //clicking on the yes waiting list radio btn
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='txtShowShortNoticeForWLY']")).click(); //clicking on the yes reg od patinet avail for appointment radio btn
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='butSave']")).click();  //saving all values

		Thread.sleep(5000);
		//navigating to schedule setup to book appointment.


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
		sched.selectByVisibleText("Dr Dementia");

		Thread.sleep(7000);

		driver.findElement(By.xpath("//div[@class='buttonFloatLeft']//img[@id='scheduleButton']")).click();// clicking on Schedule button-Schedule setup.
		Thread.sleep(3000);


		//Below booking appointment using waiting list button

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
		driver.findElement(By.xpath("//input[@title='Family name' and @id='sFamilyname']")).sendKeys(FreebtnPatfamname);

		// driver.findElement(By.xpath("//input[@title='Family name' and @id='sFamilyname']")).sendKeys(Patintfamname);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//td[@class='rowInput']//input[@name='sGivenname' and @id='sGivenname']")).sendKeys(FreebtnPatGivenName);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//td[@class='rowButton']//button[@id='butSearch']")).click();
		Thread.sleep(7000);

		driver.findElement(By.xpath("//button[@id='butSelect']")).click();  //selecting Patient for waiting list entry

		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);

		driver.switchTo().frame(driver.findElement(By.id("ultramodal1-modal-iframe")));

		driver.findElement(By.xpath("//span[@id='select2-appointment-type-input-container']")).click(); //selecting appointment for waiting list entry
		//input[@class='select2-search__field']


		driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys(selapntmnt);

		Actions actions3 = new Actions(driver);
		//actions3.sendKeys(Keys.DOWN).build().perform();
		Thread.sleep(1000);
		actions3.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(5000);

		//input[@id='schedule-484-input']

		driver.findElement(By.xpath("//input[@name='destinationwaitinglists']/following-sibling::label[text()= '" + Selschforwaitinglist+ "']")).click(); // clicking on the created schedule radio btn.

		//click on the continue button of ad waiting list entry popup

		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[@class='uk-button'   and text()='Continue']")).click(); 
		Thread.sleep(7000);

		//here you can see reg patinet availability option.
		
		
		driver.findElement(By.xpath("//iframe[@id='f0']/..")).click(); //to get back control on the div we used /.. 
		driver.switchTo().frame(driver.findElement(By.id("f0")));
		driver.switchTo().frame(driver.findElement(By.id("f12")));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@id='butCancel']")).click();
		Thread.sleep(7000);

		

		driver.switchTo().defaultContent();

		driver.findElement(By.xpath("//iframe[@id='f0']/..")).click();
		driver.switchTo().frame(driver.findElement(By.id("f0")));

		driver.switchTo().frame(driver.findElement(By.id("f11")));


		driver.findElement(By.xpath("//img[@id='setupButton']")).click();  // click on the setup button.
		Thread.sleep(6000);

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
		Thread.sleep(4000);

		driver.switchTo().parentFrame();
		//Switched for parent frame=F0 because it was not able to come outside from F12 frame so i switched)

		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f11']")));
		driver.findElement(By.xpath("//th[text()='Activate / de-activate features']")).click(); // clicking on Activate / de-activate features option.
		Thread.sleep(4000); 






	}

	
}

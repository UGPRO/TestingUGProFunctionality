package UGregresssionpack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import AllUgsmoketest.framecheck;
import AllUgsmoketest.userlogin;
import excelreaderutility.Xls_Reader;
import ugprofunctionality.Bookapntmntfreebtn;
import ugprofunctionality.Deletingreport;
import ugprofunctionality.Gotoscheduleinanotherdeptodelapnt;
import ugprofunctionality.bookapntmnetfreebtnforapl2;
import ugprofunctionality.cancellationlettertoseereport;
import ugprofunctionality.createnewreport;

import ugprofunctionality.updateexistingreport;
import ugprofunctionality.updateexistingreport2;
import ugprofunctionality.updateexistingrepwithdnaforoneschd;

public class regtest7 {
	
	public static Xls_Reader reader;
	public static String NewRepName;
	public static String SelRepFunction1;
	public static String SelReportAftrFxn1;
	
	
	public static void main(String[] args) throws InterruptedException 
	{

		reader = new Xls_Reader("C:\\Users\\akhosla\\Documents\\regexcelsheet.xlsx");
		
		NewRepName	=reader.getCellData("reg6", "NewReportName", 2);
		SelRepFunction1	=reader.getCellData("reg6", "SelReportFunction", 2);
		SelReportAftrFxn1	=reader.getCellData("reg6", "SelReportAfterFxn", 2);
	
		System.setProperty("webdriver.chrome.driver", "C:\\sdriver\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();


		userlogin.login(driver);

		driver.findElement(By.linkText("Central setup")).click();
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f12']")));
		driver.findElement(By.xpath("(//div[@class='menuButton'])[1]")).click();  //system administration
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("(//div[@id='menuItem_18'])[1]")).click();  //system settings
		Thread.sleep(3000);
		framecheck.checkframe11(driver);
		driver.findElement(By.xpath("//th[text()='File directories']")).click();
		
		
		
		createnewreport.newreportcreation(driver);
		
		Thread.sleep(2000);
		
		Bookapntmntfreebtn.clickonfreebuttontobookappointment(driver);  // booking appointment using free button to check new created report.
		
		Thread.sleep(5000);
		
	//Deleting appointment to avoid error.
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
        
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f12']")));
		driver.findElement(By.xpath("//span[@class='printLink']//u")).click(); //  clicking on continue without printing via free btn
		
		Thread.sleep(3000);
		//above deleting  appointment to overcome repetition.
		
		
		updateexistingreport.reportupdate(driver);
		
		Thread.sleep(3000);
		bookapntmnetfreebtnforapl2.clickonfreebuttontobookappointment2(driver); //booking appointment to see cancellation report with the selected department while creating report 
		
	
		
		
	//	updateexistingreport.reportupdate(driver);
	//	Thread.sleep(2000);
		
	//	cancellationlettertoseereport.cancellettertoseereport(driver);
		
		Thread.sleep(2000);
		
		Deletingreport.reportdeletion(driver);
		
		
		
		
	//	updateexistingreport2.reportupdate2(driver);
		
		//Gotoscheduleinanotherdeptodelapnt.anotherschdcancellettertoseereport(driver);
		
	//	Thread.sleep(2000);
		
	//	updateexistingrepwithdnaforoneschd.updatereportwithdnaletter(driver);
		
		
		
		
		
		

}
}

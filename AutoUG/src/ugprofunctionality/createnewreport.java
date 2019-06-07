package ugprofunctionality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import excelreaderutility.Xls_Reader;

public class createnewreport {
	
	public static WebDriver driver;
	public static Xls_Reader reader;
	
	public static String NewRepName;
	public static String NewRepAbrev;
	public static String SelRepFunction;
	public static String SelReportAftrFxn;
	
	
	public static void newreportcreation(WebDriver driver) throws InterruptedException
	{
		
		
		reader = new Xls_Reader("C:\\Users\\akhosla\\Documents\\regexcelsheet.xlsx");
		NewRepName	=reader.getCellData("reg6", "NewReportName", 2);
		NewRepAbrev	=reader.getCellData("reg6", "NewReportAbrev", 2);
		SelRepFunction	=reader.getCellData("reg6", "SelReportFunction", 2);
		SelReportAftrFxn	=reader.getCellData("reg6", "SelReportAfterFxn", 2);
		
		
		driver.switchTo().parentFrame();

		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f12']")));

		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='menuItem_23']")).click();  // clicking on report settings.
		
		driver.switchTo().parentFrame();
		//Switched for parent frame=F0 because it was not able to come outside from F12 frame so i switched)

		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f11']")));
		Thread.sleep(4000);
		
		
		driver.findElement(By.xpath("//button[@id='butNew']")).click();
		Thread.sleep(3000);
	
		   
		

		driver.findElement(By.xpath("//input[@id='ReportName']")).sendKeys(NewRepName); 
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='ReportAbbrev']")).sendKeys(NewRepAbrev); 
		Thread.sleep(2000);
		Select nreport=new Select(driver.findElement(By.xpath("//select[@id='functionType']")));
		nreport.selectByVisibleText(SelRepFunction);
		Thread.sleep(5000);
		Select nreport1=new Select(driver.findElement(By.xpath("//select[@id='lstReport']")));
		nreport1.selectByVisibleText(SelReportAftrFxn);
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[@id='butSave']")).click();
		Thread.sleep(4000);
	 
	 
	 
	 
		



	}

}

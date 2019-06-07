package ugprofunctionality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import AllUgsmoketest.framecheck;
import excelreaderutility.Xls_Reader;

public class clickonappointmeentlink2windowresize {

	
	
	public static WebDriver driver;
	public static String AL2URL;
	public  static Xls_Reader reader;
	
	
	public static void setupchecklinkcheckdatetime2(WebDriver driver) throws InterruptedException
	{
		reader = new Xls_Reader("C:\\Users\\akhosla\\Documents\\regexcelsheet.xlsx");
		AL2URL	=reader.getCellData("reg5", "AL1-URL", 2);
		Thread.sleep(3000);
		// driver.findElement(By.xpath("//iframe[@id='f0']/..")).click();
			 driver.switchTo().parentFrame();
			 
				driver.switchTo().frame(driver.findElement(By.id("f11")));

			  
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
			Thread.sleep(3000);
		
		
		driver.findElement(By.xpath("//div[@id='menuItem_17']")).click();    //Appointment link2
		driver.switchTo().parentFrame();
		//Switched for parent frame=F0 because it was not able to come outside from F12 frame so i switched)

		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f11']")));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='txtAppointmentEventOrUrlU']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='txtAppointmentWindowURL']")).clear();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='txtAppointmentWindowURL']")).sendKeys(AL2URL); 
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='txtAppointmentWindowResizableY']")).click(); //click on window resizable radio btn.
		//input[@id='txtAppointmentWindowResizableY']
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='txtAppointmentWindowHeight']")).sendKeys("50");   //click on the window height option.
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@id='txtAppointmentWindowWidth']")).sendKeys("60");
		Thread.sleep(2000);
		
		
		//input[@id='txtAppointmentWindowHeight']
		driver.findElement(By.xpath("//button[@id='butSave']")).click();
		Thread.sleep(5000);
		
		
		
		
		
		

	}
}

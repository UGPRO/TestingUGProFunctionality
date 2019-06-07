package ugprofunctionality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

import excelreaderutility.Xls_Reader;

public class patadminalert {
	public static WebDriver driver;
	static String Pmalerturl	;
	
	static boolean bValue;
	static String ClSideWindowName;	
	public static Xls_Reader reader;
	
	
	public static void ClickonPatientAdminalertsandEditvalues() throws InterruptedException
	{

		
		Pmalerturl	=reader.getCellData("ST2", "PatientMedicalalertsURL", 2);
		ClSideWindowName	=reader.getCellData("ST2", "ClientSideWindowName", 2);

			driver.switchTo().parentFrame();

			driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f12']")));
			Thread.sleep(3000);
			driver.findElement(By.xpath("//div[@id='menuItem_42']")).click(); // patient administrative alerts
			Thread.sleep(3000);	 

			driver.switchTo().parentFrame();
			//Switched for parent frame=F0 because it was not able to come outside from F12 frame so i switched)

			driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f11']")));

			WebElement palert = driver.findElement(By.xpath("//input[@value='ClientSide']"));
			WebElement palert1 = driver.findElement(By.xpath("//input[@value='ServerSide']"));
			if(bValue = palert.isSelected())
			{
				driver.findElement(By.xpath("//input[@value='ServerSide']")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//input[@id='url-input']")).clear();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@id='url-input']")).sendKeys(Pmalerturl); 
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@id='save-button']")).click();
				
			}


			else if(palert1.isSelected())
			{
				Thread.sleep(3000);
				driver.findElement(By.xpath("//input[@value='ClientSide']")).click(); 
				Thread.sleep(3000);
				driver.findElement(By.xpath("//input[@id='window-name-input']")).clear();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//input[@id='window-name-input']")).sendKeys(ClSideWindowName); 
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@id='save-button']")).click();
				
			}
		}


}

package ugprofunctionality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import AllUgsmoketest.framecheck;
import excelreaderutility.Xls_Reader;

public class setupbtnpatadminalert {



	public static boolean bValue;
	public static String Pmalerturl;
	public static String ClSideWindowName;
	public static  Xls_Reader reader ;


	public static void patientadminalert(WebDriver driver) throws InterruptedException
	{

		Thread.sleep(3000);
		reader = new Xls_Reader("C:\\Users\\akhosla\\Documents\\regexcelsheet.xlsx");
		Pmalerturl	=reader.getCellData("reg5", "PatientMedicalalertsURL", 2);
		ClSideWindowName	=reader.getCellData("reg5", "ClientSideWindowName", 2);

		Thread.sleep(5000);
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
		driver.findElement(By.xpath("(//div[@class='menuButton'])[1]")).click();  //system administration
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


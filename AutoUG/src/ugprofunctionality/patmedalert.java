package ugprofunctionality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import excelreaderutility.Xls_Reader;

public class patmedalert {
	
	
public static WebDriver driver;
public static boolean bValue;
public static String Pmalerturl;
public static String ClSideWindowName;
public static  Xls_Reader reader ;
	public static void patientmedicalalert() throws InterruptedException
	{
		Pmalerturl	=reader.getCellData("ST2", "PatientMedicalalertsURL", 2);
		ClSideWindowName	=reader.getCellData("ST2", "ClientSideWindowName", 2);

	
	
	driver.switchTo().parentFrame();

	driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f12']")));
	Thread.sleep(3000);
	driver.findElement(By.xpath("//div[@id='menuItem_44']")).click(); //patient medical alerts

	Thread.sleep(3000);


	driver.switchTo().parentFrame();
	//Switched for parent frame=F0 because it was not able to come outside from F12 frame so i switched)

	driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f11']")));

	WebElement palm = driver.findElement(By.xpath("//div[@class='ug-container']//div[3]//div//following::div//div//label//input[@name='Redirection' and @value='ClientSide']"));
	WebElement palm1 = driver.findElement(By.xpath("//input[@value='ServerSide']"));
	if(bValue = palm.isSelected())
	{
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='ServerSide']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='url-input']")).clear();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='url-input']")).sendKeys(Pmalerturl); 
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='butSave']")).click();
		
	}

	else if(palm1.isSelected())
	{
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='ug-container']//div[3]//div//following::div//div//label//input[@name='Redirection' and @value='ClientSide']")).click(); 
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='window-name-input']")).clear();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='window-name-input']")).sendKeys(ClSideWindowName); 
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@id='butSave']")).click();

}
}
}

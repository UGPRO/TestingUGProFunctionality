package ugprofunctionality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class patientsearch {
	
	public static void lookpatient(WebDriver driver) throws InterruptedException
	{
	
	
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
	 driver.findElement(By.xpath("//input[@title='Family name' and @id='sFamilyname']")).sendKeys("a");
	 
	// driver.findElement(By.xpath("//input[@title='Family name' and @id='sFamilyname']")).sendKeys(Patintfamname);
		
		// driver.findElement(By.xpath("//td[@class='rowInput']//input[@name='sGivenname' and @id='sGivenname']")).sendKeys(WaitinglistPatGivenName);
	 Thread.sleep(2000);
		 driver.findElement(By.xpath("//td[@class='rowButton']//button[@id='butSearch']")).click();
		 Thread.sleep(5000);
		 

}
}

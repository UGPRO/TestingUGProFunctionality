package ugprofunctionality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import AllUgsmoketest.framecheck;

public class navigatevalidpat {
	
	
	
	//static String ScheduleNavn;
	public static void navigatepatientval(WebDriver driver) throws InterruptedException
	{
	
		//Navigating to Schedule setup to see title of patient.
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
		  
		  /// Navigating on patient portal to see title of patient.
		  
		  driver.switchTo().parentFrame();
			driver.switchTo().frame(driver.findElement(By.id("f13")));
			
			//functionality creating and searching patient.
			
			driver.findElement(By.xpath("//span[@id='selectPatButton']//i ")).click(); // clicking on the Patient icon.
			Thread.sleep(4000);
			driver.switchTo().defaultContent();
			  Thread.sleep(2000);
			
			 driver.switchTo().frame(driver.findElement(By.id("ultramodal1-modal-iframe")));
			 driver.switchTo().frame(driver.findElement(By.id("f11")));
			  
			  
			
			 driver.findElement(By.xpath("//button[@id='butNew']")).click(); //Click on the New to create
	         //temporary patient first.


	driver.findElement(By.xpath("//div[@id='newPatientMenu']//div[1]")).click(); //click on temp patient option.
	//after clicking on the temp patient option then title should be visible if clicked on the yes
Thread.sleep(4000);
}
}




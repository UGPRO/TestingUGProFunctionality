package ugprofunctionality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import AllUgsmoketest.framecheck;

public class navigatetoselectpat {
	//driver.findElement(By.xpath("//button[@id='butSelect']")).click(); //selecting patient
	 //Thread.sleep(5000);
	
	
	public static void selpat(WebDriver driver) throws InterruptedException
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
		sched.selectByVisibleText("NewsSchedule");
		
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
				  
			
			//framecheck.checkframe11(driver);

			//Only Searching Patient
			
			driver.findElement(By.xpath("//input[@title='Family name' and @id='sFamilyname']")).click();
			 Thread.sleep(3000);
			 driver.findElement(By.xpath("//input[@title='Family name' and @id='sFamilyname']")).sendKeys("Ault");
			 Thread.sleep(3000);
			 driver.findElement(By.xpath("//input[@name='sGivenname' and @id='sGivenname']")).click();
			 Thread.sleep(3000);
			 driver.findElement(By.xpath("//input[@name='sGivenname' and @id='sGivenname']")).sendKeys("Joy");
			 
			// driver.findElement(By.xpath("//input[@title='Family name' and @id='sFamilyname']")).sendKeys(Patintfamname);
				
				// driver.findElement(By.xpath("//td[@class='rowInput']//input[@name='sGivenname' and @id='sGivenname']")).sendKeys(WaitinglistPatGivenName);
			 Thread.sleep(2000);
				 driver.findElement(By.xpath("//td[@class='rowButton']//button[@id='butSearch']")).click();
				 Thread.sleep(5000);
				 
				 driver.findElement(By.xpath("//button[@id='butSelect']")).click(); //selecting patient
				Thread.sleep(4000);
				 driver.switchTo().frame(driver.findElement(By.id("f0")));
				 
				 
					driver.switchTo().frame(driver.findElement(By.id("f13")));
					Thread.sleep(2000);
					//span[@id='b12']
					 driver.findElement(By.xpath("//span[@id='b12']")).click();   // clicking on the patient tab to see patinet macro id.
					 Thread.sleep(10000);
					 
					//span[@class='patlink']
					 driver.findElement(By.xpath("//span[@class='patlink']")).click();  //clciking on the patinet name link
				 
			  
}
}

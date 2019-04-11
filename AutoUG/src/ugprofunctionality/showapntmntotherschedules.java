package ugprofunctionality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import AllUgsmoketest.framecheck;

public class showapntmntotherschedules {
	
	
	
	
	public static void showapntmnetY(WebDriver driver) throws InterruptedException
	{
		
		
		
		
         Thread.sleep(2000);
		
		
		
		
		driver.findElement(By.xpath("//input[@id='txtAuthorityViewInUseY']")).click(); //clicking on the yes waiting list radio btn
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='butSave']")).click();  //saving all values
		
		
          Thread.sleep(5000);
		
		
		//navigating to schedule setup to book appointment and to see appointment in other schedules.
		
		
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
		  
		// clicking on the Advance function to select show appointmmet from other schedules.
		//div[text()='Advanced functions']
		
		driver.findElement(By.xpath("//div[text()='Advanced functions']")).click(); //click on the Adv fxns
		
		
		Actions action = new Actions(driver);
		 action.moveToElement(driver.findElement(By.xpath("//td[@id='mSetPreferencesRscDay']"))).click().build().perform();  // moving the control on the set pref
		 
		//input[@id='showOtherApp']
		 
		 Thread.sleep(5000);
			driver.switchTo().defaultContent();
		  Thread.sleep(2000);
			  
			 driver.switchTo().frame(driver.findElement(By.id("ultramodal1-modal-iframe")));
			 driver.switchTo().frame(driver.findElement(By.id("f11")));
		 // below clicking on the checkbox to show appointmnet from other schedules
		 boolean z=driver.findElement(By.id("showOtherApp")).isSelected();
		 
		 
		 if(z == false)
			{
				Thread.sleep(2000);
				driver.findElement(By.id("showOtherApp")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@id='butSave']")).click();
		
			}
		 
		 else if(z == true)
		 {
			 Thread.sleep(2000);
				driver.findElement(By.id("showOtherApp")).click();
				Thread.sleep(1000);
				driver.findElement(By.id("showOtherApp")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@id='butSave']")).click();
				
				Thread.sleep(3000);
		 }
		 
		 
}
	
	public static void showapntmnetN(WebDriver driver) throws InterruptedException
	{
		
		
		
		
         Thread.sleep(2000);
		
		
		
		
		driver.findElement(By.xpath("//input[@id='txtAuthorityViewInUseN']")).click(); //clicking on the yes waiting list radio btn
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='butSave']")).click();  //saving all values
		
		
          Thread.sleep(5000);
		
		
		//navigating to schedule setup to book appointment and to see appointment in other schedules.
		
		
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
		  
		// clicking on the Advance function to select show appointmmet from other schedules.
		//div[text()='Advanced functions']
		
		driver.findElement(By.xpath("//div[text()='Advanced functions']")).click(); //click on the Adv fxns
		
		
		Actions action = new Actions(driver);
		 action.moveToElement(driver.findElement(By.xpath("//td[@id='mSetPreferencesRscDay']"))).click().build().perform();  // moving the control on the set pref
		 
		//input[@id='showOtherApp']
		 
		 Thread.sleep(5000);
			driver.switchTo().defaultContent();
		  Thread.sleep(2000);
			  
			 driver.switchTo().frame(driver.findElement(By.id("ultramodal1-modal-iframe")));
			 driver.switchTo().frame(driver.findElement(By.id("f11")));
		 // below clicking on the checkbox to show appointmnet from other schedules
		 boolean z=driver.findElement(By.id("showOtherApp")).isSelected();
		 
		 
		 if(z == false)
			{
				Thread.sleep(2000);
				driver.findElement(By.id("showOtherApp")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@id='butSave']")).click();
		
			}
		 
		 else if(z == true)
		 {
			 Thread.sleep(2000);
				driver.findElement(By.id("showOtherApp")).click();
				Thread.sleep(1000);
				driver.findElement(By.id("showOtherApp")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@id='butSave']")).click();
				Thread.sleep(3000);
		 }
		 
	
}
}

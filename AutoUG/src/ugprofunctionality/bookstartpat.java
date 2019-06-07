package ugprofunctionality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import AllUgsmoketest.framecheck;

public class bookstartpat {
	
	
	public static void startbookpatY(WebDriver driver) throws InterruptedException
	{
		
		
		driver.findElement(By.xpath("//input[@id='txtEncuragePatientSelectionBeforeSearchInUseY']")).click(); 
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='butSave']")).click();  //saving all values
		
		
		Thread.sleep(5000);
		
		
		//navigating to schedule setup to book appointment via free btn and to see pat screen is first appearing or not.
		
		
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
		  
		  
		  //Below booking appointment using free
		  
		  framecheck.checkframe11(driver);
			 
			 //functionality free button.
			 
			 
			 driver.findElement(By.xpath("//button[@id='butSearch']")).click(); // clicking on free button
}
	
	public static void startbookpatN(WebDriver driver) throws InterruptedException
	{
		
		driver.findElement(By.xpath("//input[@id='txtEncuragePatientSelectionBeforeSearchInUseN']")).click(); 
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='butSave']")).click();  //saving all values
		
		
		Thread.sleep(5000);
		
		
		//navigating to schedule setup to book appointment via free btn and to see pat screen is first appearing or not.
		
		
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
		  
		  
		  //Below booking appointment using free
		  
		  framecheck.checkframe11(driver);
			 
			 //functionality free button.
			 
			 
			 driver.findElement(By.xpath("//button[@id='butSearch']")).click(); // clicking on free button
		
}
}

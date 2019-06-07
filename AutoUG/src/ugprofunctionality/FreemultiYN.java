package ugprofunctionality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import AllUgsmoketest.framecheck;

public class FreemultiYN {
	
	
	
	public static void freemultY(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='txtFreeMultiInUseY']")).click();  //clicking on free multi yes
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='butSave']")).click();  //saving all values
		
		
		//navigating to schedule setup to see free multi button 
		
		
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
		  Thread.sleep(5000);
		  
		// here free multi button should get enabled here
		  
		  
}
	
	public static void freemultN(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='txtFreeMultiInUseN']")).click();  //clicking on free multi yes
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='butSave']")).click();  //saving all values
		
		
		//navigating to schedule setup to see free multi button 
		
		
         driver.switchTo().parentFrame();
		
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f10']")));
		
		driver.findElement(By.xpath("//div[@class='headerLinks']//span[2]")).click(); // clicking on schedule setup.
		Thread.sleep(2000);
		
		framecheck.checkframe12(driver);
		  Thread.sleep(2000);
		driver.findElement(By.xpath("//select[@id='rscIdDptId']")).click();


		Select sched=new Select(driver.findElement(By.xpath("//select[@id='rscIdDptId']"))); // for now as i was not able to save the schedule , so we will directly
		//fetch the schedule name from excel sheet. In future need to updating with new created schedule name.
		Thread.sleep(3000);	
		sched.selectByVisibleText("Dr Dementia");
		
			Thread.sleep(7000);
		
		driver.findElement(By.xpath("//div[@class='buttonFloatLeft']//img[@id='scheduleButton']")).click();// clicking on Schedule button-Schedule setup.
		  Thread.sleep(5000);
		  
		  
		  // here free multi button should get disabled here shoiuld get grayed out.
	}
}

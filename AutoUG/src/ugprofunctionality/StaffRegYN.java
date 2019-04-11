package ugprofunctionality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import AllUgsmoketest.framecheck;

public class StaffRegYN {
	
	
	public static void staffregY(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		
		
		driver.findElement(By.xpath("(//div[@class='menuButton'])[1]")).click(); //System administration
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@id='menuItem_18'])[1]")).click();  //System Settings
		Thread.sleep(2000);
		
		framecheck.checkframe11(driver);
		//Clicking on the Activating / deactivating features
		driver.findElement(By.xpath("//th[text()='Activate / de-activate features']")).click();
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("//input[@id='txtOtherStaffInUseY']")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='butSave']")).click();    
		
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
		  Thread.sleep(5000);
		
		

}
	public static void staffregN(WebDriver driver) throws InterruptedException
	{
Thread.sleep(2000);
		
		
	//	driver.findElement(By.xpath("(//div[@class='menuButton'])[1]")).click(); //System administration
		//Thread.sleep(2000);
		//driver.findElement(By.xpath("(//div[@id='menuItem_18'])[1]")).click();  //System Settings
		//Thread.sleep(2000);
		
		framecheck.checkframe11(driver);
		//Clicking on the Activating / deactivating features
		//driver.findElement(By.xpath("//th[text()='Activate / de-activate features']")).click();
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("//input[@id='txtOtherStaffInUseN']")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='butSave']")).click();    
		
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
		  Thread.sleep(5000);
	}
	
}

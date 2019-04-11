package ugprofunctionality;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import ugprofunctionality.waitinglistYN;

import AllUgsmoketest.framecheck;
import UGregresssionpack.regtest3;

public class waitinglistYN extends regtest3 {
	
	static String UsergroupNa;
	
	public static void waitlistY(WebDriver driver) throws InterruptedException
	{
		
		
		 UsergroupNa	=reader.getCellData("reg3", "SelUsergroupNametoseerights", 2);
		
         Thread.sleep(2000);
		
		
		
		
		driver.findElement(By.xpath("//input[@id='txtWaitingListInUseY']")).click(); //clicking on the yes waiting list radio btn
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='butSave']")).click();  //saving all values
		
		Thread.sleep(7000);
		
		driver.switchTo().parentFrame();
		
		
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f12']")));
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='menuButton'])[3]")).click();  // clicking on the central administration
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[@id='menuItem_3']")).click(); //click on CS-Access rights.
		Thread.sleep(4000);
		
		
	
		 framecheck.checkframe11(driver);
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("//td[text()='" + UsergroupNa + "']")).click();
		 Thread.sleep(5000);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,1250)", "");    // scrolling down.
		// driver.findElement(By.xpath("//div[@id='targetBox']")).sendKeys(Keys.PAGE_DOWN);
		 
		// driver.findElement(By.xpath("//div[@id='targetBox']")).sendKeys(Keys.PAGE_DOWN); 
		 Thread.sleep(3000);
		//_________________________________________________________________
		    
			//Delegating all access rights..

		
			
			
			Delaccessrights.delrightschangeall(driver);
			
			
		//___________________________________________________________________
			//above delegating access rights.
			
			driver.switchTo().parentFrame();
			
			driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f10']")));
			
			driver.findElement(By.xpath("//div[@class='headerLinks']//span[1]")).click(); // clicking on departmental setup
			Thread.sleep(2000);
			
			framecheck.checkframe12(driver);
			
			driver.findElement(By.xpath("//div[@id='menuItem_3']")).click(); //click on access rights-DS
			Thread.sleep(3000);
			
			 framecheck.checkframe11(driver);
			 Thread.sleep(3000);
			 driver.findElement(By.xpath("//td[text()='" + UsergroupNa + "']")).click();
			 
			Thread.sleep(6000);
			JavascriptExecutor js2 = (JavascriptExecutor) driver;
			js2.executeScript("window.scrollBy(0,1250)", "");    // scrolling down.
			
			// clicking on the schedule setup.
			driver.switchTo().parentFrame();
			
			driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f10']")));
			
			driver.findElement(By.xpath("//div[@class='headerLinks']//span[2]")).click(); // clicking on schedule setup.
			Thread.sleep(5000);
			
			framecheck.checkframe12(driver);
			driver.findElement(By.xpath("//div[@id='menuItem_2']")).click();   //Click on schedule setup- access rights.
			
			 framecheck.checkframe11(driver);
			 Thread.sleep(3000);
			 driver.findElement(By.xpath("//td[text()='" + UsergroupNa + "']")).click();  // selecting usergroup
			 Thread.sleep(5000);
			 
			 
			 driver.findElement(By.xpath("//input[@id='allFunc']")).click();  //click on the Show all
			 
			 Thread.sleep(5000);
			 
			
			 JavascriptExecutor js3 = (JavascriptExecutor) driver;
			 js3.executeScript("window.scrollBy(0,432)", "");    // scrolling down.
				  
			// Clicking on the schedule setup icon to see waiting list request tab is disabled or not.
				
				
				framecheck.checkframe12(driver);
				  Thread.sleep(2000);
				driver.findElement(By.xpath("//select[@id='rscIdDptId']")).click();


				Select sched=new Select(driver.findElement(By.xpath("//select[@id='rscIdDptId']"))); 
				Thread.sleep(2000);	
				sched.selectByVisibleText("NewsSchedule");
				
					Thread.sleep(7000);
				
				driver.findElement(By.xpath("//div[@class='buttonFloatLeft']//img[@id='scheduleButton']")).click();// clicking on Schedule button-Schedule setup.
				  Thread.sleep(3000);
				  
				 // here waiting list button should be enable.
	}
				  
				  
				  public static void waitlistN(WebDriver driver) throws InterruptedException
					{
					  driver.findElement(By.xpath("//input[@id='txtWaitingListInUseN']")).click(); //clicking on the No waiting list radio btn.
					  
					  Thread.sleep(2000);
						driver.findElement(By.xpath("//button[@id='butSave']")).click();  //saving all values
						
						Thread.sleep(7000);
						driver.switchTo().parentFrame();
						driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f12']")));   
						Thread.sleep(2000);
						driver.findElement(By.xpath("(//div[@class='menuButton'])[3]")).click();  // clicking on the central administration
						Thread.sleep(1000);
						
						driver.findElement(By.xpath("//div[@id='menuItem_3']")).click(); //click on CS- access rights
						Thread.sleep(4000);
						
						
						
						
					
						 framecheck.checkframe11(driver);
						 Thread.sleep(3000);
						 driver.findElement(By.xpath("//td[text()='" + UsergroupNa + "']")).click();
						 Thread.sleep(5000);
						 JavascriptExecutor js1 = (JavascriptExecutor) driver;
							js1.executeScript("window.scrollBy(0,1250)", "");    // scrolling down.
							
							driver.switchTo().parentFrame();
							
							driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f10']")));
							
							driver.findElement(By.xpath("//div[@class='headerLinks']//span[1]")).click(); // clicking on departmental setup
							Thread.sleep(2000);
							
							framecheck.checkframe12(driver);
							
							driver.findElement(By.xpath("//div[@id='menuItem_3']")).click(); //click on DS- access rights
							Thread.sleep(3000);
							
							 framecheck.checkframe11(driver);
							 Thread.sleep(3000);
							 driver.findElement(By.xpath("//td[text()='" + UsergroupNa + "']")).click();
							 
							 Thread.sleep(6000);
							 
							 //above is halt to see access rights.
							 
							JavascriptExecutor js2 = (JavascriptExecutor) driver;
							js2.executeScript("window.scrollBy(0,1250)", "");    // scrolling down.
							
							// clicking on the schedule setup.
							driver.switchTo().parentFrame();
							
							driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f10']")));
							
							driver.findElement(By.xpath("//div[@class='headerLinks']//span[2]")).click(); // clicking on schedule setup.
							Thread.sleep(2000);
							
							framecheck.checkframe12(driver);
							
							driver.findElement(By.xpath("//div[@id='menuItem_2']")).click();   //Click on schedule setup- access rights.
							
							 framecheck.checkframe11(driver);
							 Thread.sleep(3000);
							 driver.findElement(By.xpath("//td[text()='" + UsergroupNa + "']")).click();  // selecting usergroup
							 Thread.sleep(5000);
							 driver.findElement(By.xpath("//input[@id='allFunc']")).click();  //click on the Show all
							 Thread.sleep(5000);
							JavascriptExecutor js3 = (JavascriptExecutor) driver;
								js3.executeScript("window.scrollBy(0,1250)", "");    // scrolling down.
							 
							// driver.findElement(By.xpath("//div[@id='targetBox']")).sendKeys(Keys.PAGE_DOWN);
							 
						//	 driver.findElement(By.xpath("//div[@id='targetBox']")).sendKeys(Keys.PAGE_DOWN); 
							 
								  
								// Clicking on the schedule setup icon to see waiting list request tab is disabled or not.
								
								
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
								  
								//Here waiting list button should be disable.
								  
					  
					}
			 
			

}
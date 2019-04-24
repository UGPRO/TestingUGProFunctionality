package ugprofunctionality;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import AllUgsmoketest.framecheck;
import UGregresssionpack.regtest2;



public class regpatientavailforapnt extends regtest2
{
	
static String FreebtnPatfamname;
static String FreebtnPatGivenName;

static String selapntmnt;

static boolean bValue;
	
	
	public static void rpaY(WebDriver driver) throws InterruptedException
	{
		FreebtnPatfamname = reader.getCellData("reg2", "Freebtn-Patientfamname", 2);
		FreebtnPatGivenName  = reader.getCellData("reg2", "Freebtn-PatientGivenName ", 2);
		
		selapntmnt =reader.getCellData("reg3", "SelAppointmentnametobookappointment", 2);
		
		driver.findElement(By.xpath("//input[@id='txtEncuragePatientSelectionBeforeSearchInUseY']")).click(); 
		Thread.sleep(2000);//above i am selecting booking start for patient because i have written the code as per booking should always start from patinet. 
		
		driver.findElement(By.xpath("//input[@id='txtShowShortNoticeForAppY']")).click(); //clicking on the yes reg od patinet avail for appointment radio btn
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='butSave']")).click();  //saving all values
		
		Thread.sleep(5000);
		//navigating to schedule setup to book appointment.
		
		
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
		  
		  
		  //Below booking appointment using free
		  
		  framecheck.checkframe11(driver);
			 
			 //functionality free button.
			 
			 
			 driver.findElement(By.xpath("//button[@id='butSearch']")).click(); // clicking on free button
			 Thread.sleep(3000);
			 driver.switchTo().defaultContent();
			  Thread.sleep(3000);
			  driver.switchTo().frame(driver.findElement(By.id("ultramodal1-modal-iframe")));
			 	
		       driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f11']")));
				 Thread.sleep(2000);
			  
			// for(int colnum= 1; colnum<=totalweekdays; colnum++) {
			 driver.findElement(By.xpath("//input[@title='Family name' and @id='sFamilyname']")).click();
			 Thread.sleep(3000);
			 driver.findElement(By.xpath("//input[@title='Family name' and @id='sFamilyname']")).sendKeys(FreebtnPatfamname);
			 
			// driver.findElement(By.xpath("//input[@title='Family name' and @id='sFamilyname']")).sendKeys(Patintfamname);
				
				 driver.findElement(By.xpath("//td[@class='rowInput']//input[@name='sGivenname' and @id='sGivenname']")).sendKeys(FreebtnPatGivenName);
				 
				
					
					Thread.sleep(2000);
			

				 driver.findElement(By.xpath("//td[@class='rowButton']//button[@id='butSearch']")).click(); //searching patient.
				 Thread.sleep(5000);
				
				 driver.findElement(By.xpath("//button[@id='butSelect']")).click(); //selecting patient
				 Thread.sleep(5000);
				 driver.findElement(By.xpath("//iframe[@id='f0']/..")).click(); //to get back control on the div we used /.. 
					driver.switchTo().frame(driver.findElement(By.id("f0")));
				 
					driver.switchTo().frame(driver.findElement(By.id("f12")));
					 Thread.sleep(3000);
				 //halt
				 driver.findElement(By.xpath("//span[@id='select2-apptypeSelect-container']")).click();//Schedule setup-Selecting appointment type after free btn
				 
				 driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys(selapntmnt); //selecting appointment in enter search criteria
				 Actions actions2 = new Actions(driver);
				 Thread.sleep(2000);
				 actions2.sendKeys(Keys.ENTER).build().perform();
				 Thread.sleep(6000);
				//button[@id='butSearch2']
				//button[@id='butBook']
				 WebElement site = driver.findElement(By.xpath("//input[@id='site1']"));
					//bValue = Practicerdo.isSelected();
					
					if(bValue = site.isSelected())
							{
						 Thread.sleep(3000);
						Actions action = new Actions(driver);
						 action.moveToElement(driver.findElement(By.xpath("//input[@id='site1']"))).doubleClick().build().perform();
						driver.findElement(By.xpath("//input[@id='site1']")).click();
					}
					else
						
					{
						 Thread.sleep(3000);
						 driver.findElement(By.xpath("//input[@id='site1']")).click();
					}
					
				 
				 driver.findElement(By.xpath("//button[@id='butSearch2']")).click(); //clicking on the search icon to see slots to book appointment.
				 Thread.sleep(2000);
				 framecheck.checkframe12(driver);
				// searchResult
				 driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='searchResult']")));
				 if(driver.findElements(By.xpath("//table[@id='slots']//tbody//tr[3]//td[1]")).size()>0)
				 {
					 Thread.sleep(2000);
					//table[@id='slots']//tbody//tr[3]//td[1]
				   //DO THE STUFF YOU NEED TO DO IF THE ELEMENT EXISTS
					 driver.findElement(By.xpath("//table[@id='slots']//tbody//tr[3]//td[1]")).click(); //clicking on particular slot to book apntmnt. 
				 }
				 
				 else
				 {
					 Thread.sleep(2000);
					//button[@id='Button2']
					 driver.findElement(By.xpath("//button[text()='Next']")).click();  //clicking on the next button if the free slots not available.
					 Thread.sleep(2000);
					 driver.findElement(By.xpath("//table[@id='slots']//tbody//tr[3]//td[1]")).click();
				 }
				 
				 //Here registration patient availability information should get display.
				 
		  
		
}

	public static void rpaN(WebDriver driver) throws InterruptedException
	{
		
		
		driver.findElement(By.xpath("//input[@id='txtShowShortNoticeForAppN']")).click(); //clicking on the yes reg od patinet avail for appointment radio btn
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='butSave']")).click();  //saving all values
		
		
		//navigating to schedule setup to book appointment.
		
		
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
		  
		  
		  //Below booking appointment using free
		  
		  framecheck.checkframe11(driver);
			 
			 //functionality free button.
			 
			 
			 driver.findElement(By.xpath("//button[@id='butSearch']")).click(); // clicking on free button
			 Thread.sleep(3000);
			 driver.switchTo().defaultContent();
			  Thread.sleep(3000);
			  driver.switchTo().frame(driver.findElement(By.id("ultramodal1-modal-iframe")));
			 	
		       driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f11']")));
				 Thread.sleep(2000);
			  
			// for(int colnum= 1; colnum<=totalweekdays; colnum++) {
			 driver.findElement(By.xpath("//input[@title='Family name' and @id='sFamilyname']")).click();
			 Thread.sleep(3000);
			 driver.findElement(By.xpath("//input[@title='Family name' and @id='sFamilyname']")).sendKeys(FreebtnPatfamname);
			 
			// driver.findElement(By.xpath("//input[@title='Family name' and @id='sFamilyname']")).sendKeys(Patintfamname);
				
				 driver.findElement(By.xpath("//td[@class='rowInput']//input[@name='sGivenname' and @id='sGivenname']")).sendKeys(FreebtnPatGivenName);
				 
				
					
					Thread.sleep(2000);
			

				 driver.findElement(By.xpath("//td[@class='rowButton']//button[@id='butSearch']")).click(); //searching patient.
				 Thread.sleep(5000);
				
				 driver.findElement(By.xpath("//button[@id='butSelect']")).click(); //selecting patient
				 Thread.sleep(5000);
				 driver.findElement(By.xpath("//iframe[@id='f0']/..")).click(); //to get back control on the div we used /.. 
					driver.switchTo().frame(driver.findElement(By.id("f0")));
				 
					driver.switchTo().frame(driver.findElement(By.id("f12")));
					 Thread.sleep(3000);
				 //halt
				 driver.findElement(By.xpath("//span[@id='select2-apptypeSelect-container']")).click();//Schedule setup-Selecting appointment type after free btn
				 
				 driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys(selapntmnt); //selecting appointment in enter search criteria
				 Actions actions2 = new Actions(driver);
				 Thread.sleep(2000);
				 actions2.sendKeys(Keys.ENTER).build().perform();
				 Thread.sleep(2000);
				//button[@id='butSearch2']
				//button[@id='butBook']
				 WebElement site = driver.findElement(By.xpath("//input[@id='site1']"));
					//bValue = Practicerdo.isSelected();
					
					if(bValue = site.isSelected())
							{
						 Thread.sleep(2000);
						Actions action = new Actions(driver);
						 action.moveToElement(driver.findElement(By.xpath("//input[@id='site1']"))).doubleClick().build().perform();
						driver.findElement(By.xpath("//input[@id='site1']")).click();
					}
					else
						
					{
						 Thread.sleep(2000);
						 driver.findElement(By.xpath("//input[@id='site1']")).click();
					}
					
				 
				 driver.findElement(By.xpath("//button[@id='butSearch2']")).click(); //clicking on the search icon to see slots to book appointment.
				 Thread.sleep(2000);
				 framecheck.checkframe12(driver);
				// searchResult
				 driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='searchResult']")));
				 if(driver.findElements(By.xpath("//table[@id='slots']//tbody//tr[3]//td[1]")).size()>0)
				 {
					 Thread.sleep(2000);
					//table[@id='slots']//tbody//tr[3]//td[1]
				   //DO THE STUFF YOU NEED TO DO IF THE ELEMENT EXISTS
					 driver.findElement(By.xpath("//table[@id='slots']//tbody//tr[3]//td[1]")).click(); //clicking on particular slot to book apntmnt. 
				 }
				 
				 else
				 {
					 Thread.sleep(2000);
					//button[@id='Button2']
					 driver.findElement(By.xpath("//button[text()='Next']")).click();  //clicking on the next button if the free slots not available.
					 Thread.sleep(2000);
					 driver.findElement(By.xpath("//table[@id='slots']//tbody//tr[3]//td[1]")).click();
				 }
				 
				 //Here registration patient availability information should get display.
				 

}
}



package ugprofunctionality;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import AllUgsmoketest.Smoketest6;
import AllUgsmoketest.framecheck;

public class schedulecreation extends Smoketest6 {
	
	
	public static void schedulecreate(WebDriver driver) throws InterruptedException
	{
		 CreateNewApt	     =reader.getCellData("ST3", "Create NewAppointment", 2);
		 CreateDepname	=reader.getCellData("ST4", "Create Dep name", 2);
		 CreateNewAptd	     =reader.getCellData("ST6", "Create New Appointment-Depart level", 2);
		 CreateNewAptAbre =reader.getCellData("ST6", "Create New Appointment Abrev-Depart level", 2);
		// CreateNewApt	     =reader.getCellData("ST3", "Create NewAppointment", 2);
		 CreateNewPrgName	 =reader.getCellData("ST3", "Create New Program Name", 2);
		 Ordername	 =reader.getCellData("ST6", "Ordersetname", 2);
		 OrderAbrev	 =reader.getCellData("ST6", "Orderset Abrev", 2);
		 OrderStartdate	 =reader.getCellData("ST6", "Orderset-Start date", 2);
		 ScheduleNavn	 =reader.getCellData("ST6", "Schedule Name", 2);
		 ScheduleAbrev	 =reader.getCellData("ST6", "Schedule Abrvn", 2);
		 locname	 =reader.getCellData("ST6", "Schedule-Loc Name", 2);
		 UpdSite	=reader.getCellData("ST4", "Update Site", 2);
		 CreateNewLoc	=reader.getCellData("ST4", "Create New Loc", 2);
		// ScheduleAdminNavn	=reader.getCellData("ST4", "Schedule Admin Name", 2);
		 SelAppointmenttypeSt1	=reader.getCellData("ST6", "Select Appointmenttype-St1", 2);
		 SelDepartmentSt1	=reader.getCellData("ST6", "Select Department-St1", 2);
		 
		Thread.sleep(2000);
		 framecheck.checkframe12(driver);
		 driver.findElement(By.xpath("//div[@id='menuItem_2']")).click(); //schedules
		 Thread.sleep(8000);
		 framecheck.checkframe11(driver);
		 
		 
		 
		 Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@class='department-selection']//div[2]//select")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//div[@class='department-selection']//div[2]//select")).sendKeys(CreateDepname);
		 
		 Thread.sleep(3000);
		
		 driver.findElement(By.xpath("//input[@type='button' and @value='New']")).click();
		 Thread.sleep(3000);
		
		 driver.findElement(By.xpath("//input[@class='uk-width-1-1 uk-form-small' and@maxlength='40']")).sendKeys(ScheduleNavn);
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("//input[@class='uk-width-1-1 uk-form-small' and@maxlength='8']")).sendKeys(ScheduleAbrev);
		//div[@class='uk-form-controls ug-row-content ug-column-padding']//select[@class='uk-width-1-1 uk-form-small']/following::div[7]//select[@class='uk-width-1-1 uk-form-small']
		 Thread.sleep(3000);
		// Select ro7=new Select(driver.findElement(By.xpath("//select[@class='uk-width-1-1 uk-form-small']"))); //selecting schedule admin
		// driver.findElement(By.xpath("//select[@class='uk-width-1-1 uk-form-small']")).click();
		// ro7.selectByVisibleText(ScheduleAdminNavn);
		 driver.findElement(By.xpath("//select[@class='uk-width-1-1 uk-form-small']")).click(); //clicking on schedule admin
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("//select[@class='uk-width-1-1 uk-form-small']")).sendKeys(SetFamofuserAuth); 
		 Actions actions3 = new Actions(driver);
		 Thread.sleep(2000);
		 actions3.sendKeys(Keys.DOWN).build().perform();
		 Thread.sleep(2000);
		 actions3.sendKeys(Keys.ENTER).build().perform();
		 Thread.sleep(2000);
		 //below xpath is of location
		// driver.findElement(By.xpath("//div[@class='uk-form-controls ug-row-content ug-column-padding']//select[@class='uk-width-1-1 uk-form-small']/following::div[7]//select[@class='uk-width-1-1 uk-form-small']")).click();
		// Thread.sleep(3000);
		 
		// Select ro5=new Select(driver.findElement(By.xpath("//select[@class='selectSmall']")));
		 driver.findElement(By.xpath("//div[@class='uk-form-controls ug-row-content ug-column-padding']//select[@class='uk-width-1-1 uk-form-small']/following::div[7]//select[@class='uk-width-1-1 uk-form-small']")).click();
		 Thread.sleep(2000);
		 Select ro5=new Select(driver.findElement(By.xpath("//div[@class='uk-form-controls ug-row-content ug-column-padding']//select[@class='uk-width-1-1 uk-form-small']/following::div[7]//select[@class='uk-width-1-1 uk-form-small']")));
		ro5.selectByVisibleText(UpdSite+" "+"-"+" "+ CreateNewLoc);
		 
		// actions3.sendKeys(Keys.DOWN).build().perform();
	//	driver.findElement(By.xpath("//td[text()='" + UpdSite+" "+"-"+" "+ CreateNewLoc+ "']")).click();
		//input[@value='Save']
		 Thread.sleep(4000);
		 driver.findElement(By.xpath("//input[@value='Save']")).click();
		 Thread.sleep(20000);
		 driver.switchTo().defaultContent();
			
			 driver.switchTo().frame(driver.findElement(By.id("ultramodal1-modal-iframe")));
			Thread.sleep(3000);
		 driver.findElement(By.xpath("//input[@id='rdActivateEnable']")).click();  //Activate all appointmnet type for all user groups
		 Thread.sleep(3000);
		//button[@id='butOK']
		 driver.findElement(By.xpath("//button[@id='butOK']")).click();
		 
		 Thread.sleep(9000);
	}

}

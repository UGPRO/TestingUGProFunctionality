package ugprofunctionality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class changeallaccessright {
	

	
	
	public static void clickonchangeallaccessrightandsave(WebDriver driver) throws InterruptedException
	{
		
		//// Thread.sleep(3000);
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(driver.findElement(By.id("ultramodal1-modal-iframe")));
		Thread.sleep(3000);
		//here below i am selecting access rights for priv and non priv users because
		//if access right is not set or non priv user then i woul dnot be able to see new created schedule.
		driver.findElement(By.xpath("//body[@class='window-small']//form//table//tbody//tr[2]//td//div[2]//input[2]")).click(); //click on the all members have access for priviliged user
		Thread.sleep(3000);
		driver.findElement(By.xpath("//body[@class='window-small']//form//table//tbody//tr[3]//td//div[2]//input[2]")).click();//click on the all members have access for non priviliged user
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@id='butNext']")).click();//on click of confirm button ,control is getting out from the main div
		Thread.sleep(5000);
		driver.findElement(By.xpath("//iframe[@id='f0']/..")).click(); //to get back control on the div we used /.. 
		driver.switchTo().frame(driver.findElement(By.id("f0")));
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='content-pane i-frame-legacy']")));
		driver.findElement(By.xpath("//body[@class='window-large']//form//table//tbody//tr//td[3]//table//tbody//tr[3]//td//button[2]")).click();   // save button click
		Thread.sleep(3000);

}
}

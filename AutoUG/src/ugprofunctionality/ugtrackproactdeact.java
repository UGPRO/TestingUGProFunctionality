package ugprofunctionality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import AllUgsmoketest.framecheck;

public class ugtrackproactdeact {
	
	public static void trackproactdeactY(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(3000);
		
		

		
		driver.findElement(By.xpath("//input[@id='txtTrackProInUseY']")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='butSave']")).click();    
		
	    driver.switchTo().parentFrame();
		
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f10']")));
		
		driver.findElement(By.xpath("//div[@class='headerLinks']//span[2]")).click(); // clicking on schedule setup.
		Thread.sleep(4000);
		framecheck.checkframe12(driver);
	    driver.findElement(By.xpath("//div[@id='menuItem_5']")).click(); //template button click.
        framecheck.checkframe11(driver);	
        Thread.sleep(5000);
	    driver.findElement(By.xpath("//tr[@rowid='sesRow1']//td[2]")).click();  //clicking on the templates-session.
		 Thread.sleep(4000);
		 driver.switchTo().defaultContent();
		 driver.switchTo().frame(driver.findElement(By.id("ultramodal1-modal-iframe")));
			Thread.sleep(3000);
		 
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//button[@id='butCancel' and@onclick='fCancel();']")).click();  // clicking on the cancel button 
		 Thread.sleep(3000);
		 
		 Thread.sleep(3000);
			driver.switchTo().defaultContent();
			 
			 
			 
			 driver.findElement(By.xpath("//iframe[@id='f0']/..")).click();
			 driver.switchTo().frame(driver.findElement(By.id("f0")));
			 
			  driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f10']")));
			  Thread.sleep(2000);
			  driver.findElement(By.xpath("//div[@class='headerLinks']//span[1]")).click(); // clicking on the Central Setup.
			  Thread.sleep(6000);
			framecheck.checkframe12(driver);
				
				driver.findElement(By.xpath("(//div[@class='menuButton'])[1]")).click(); //System administration
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//div[@id='menuItem_18'])[1]")).click();  //System Settings
				Thread.sleep(2000);
				
				
				 driver.switchTo().parentFrame();
				   //Switched for parent frame=F0 because it was not able to come outside from F12 frame so i switched)
					
					driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f11']")));
					driver.findElement(By.xpath("//th[text()='Activate / de-activate features']")).click(); // clicking on Activate / de-activate features option.
					Thread.sleep(4000);
}
	
	public static void trackproactdeactN(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(3000);
		
		

		
		driver.findElement(By.xpath("//input[@id='txtTrackProInUseN']")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='butSave']")).click();    
		
	   driver.switchTo().parentFrame();
		
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f10']")));
		
		driver.findElement(By.xpath("//div[@class='headerLinks']//span[2]")).click(); // clicking on schedule setup.
		Thread.sleep(4000);
		
		framecheck.checkframe12(driver);
	    driver.findElement(By.xpath("//div[@id='menuItem_5']")).click(); //template button click.
        framecheck.checkframe11(driver);
        
        Thread.sleep(5000);
        
	    driver.findElement(By.xpath("//tr[@rowid='sesRow1']//td[2]")).click();  //clicking on the templates-session.
		 Thread.sleep(4000);
		 driver.switchTo().defaultContent();
		 driver.switchTo().frame(driver.findElement(By.id("ultramodal1-modal-iframe")));
			Thread.sleep(3000);
		 
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//button[@id='butCancel' and@onclick='fCancel();']")).click();  // clicking on the cancel button 
		 Thread.sleep(3000);
		 driver.switchTo().defaultContent();
		 Thread.sleep(3000);
			//driver.switchTo().defaultContent();
			 
			 
			 
			 driver.findElement(By.xpath("//iframe[@id='f0']/..")).click();
			 driver.switchTo().frame(driver.findElement(By.id("f0")));
			 
			  driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f10']")));
			  Thread.sleep(2000);
			  driver.findElement(By.xpath("//div[@class='headerLinks']//span[1]")).click(); // clicking on the Central Setup.
			  Thread.sleep(6000);
			framecheck.checkframe12(driver);
				
				driver.findElement(By.xpath("(//div[@class='menuButton'])[1]")).click(); //System administration
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//div[@id='menuItem_18'])[1]")).click();  //System Settings
				Thread.sleep(2000);
				
				
				 driver.switchTo().parentFrame();
				   //Switched for parent frame=F0 because it was not able to come outside from F12 frame so i switched)
					
					driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f11']")));
					driver.findElement(By.xpath("//th[text()='Activate / de-activate features']")).click(); // clicking on Activate / de-activate features option.
					Thread.sleep(4000);
		
		 //here ug track pro checkbox should not be visible before cancel
		
}
	
}

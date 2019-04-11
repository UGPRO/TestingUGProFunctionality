package ugprofunctionality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import AllUgsmoketest.framecheck;

public class setupbtnandpatfieldsetting {
	
	
	
	
	public static void setupbtnpatsetting(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		 driver.findElement(By.xpath("//iframe[@id='f0']/..")).click();
		 driver.switchTo().frame(driver.findElement(By.id("f0")));
		 
			driver.switchTo().frame(driver.findElement(By.id("f11")));

		  
		  driver.findElement(By.xpath("//img[@id='setupButton']")).click();  // click on the setup button.
		  Thread.sleep(7000);
		  
		  //one point not covered as not able to see error if saving values in maximum future book days larger than central setup.
		 driver.switchTo().parentFrame();
		  driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f10']")));
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//div[@class='headerLinks']//span[1]")).click(); // clicking on the Central Setup.
		  Thread.sleep(5000);
		framecheck.checkframe12(driver);
			
			driver.findElement(By.xpath("(//div[@class='menuButton'])[1]")).click(); //System administration
			Thread.sleep(3000);
			driver.findElement(By.xpath("//div[@id='menuItem_25']")).click();  //clicking on the Patient field
			Thread.sleep(2000);
			
	}

}

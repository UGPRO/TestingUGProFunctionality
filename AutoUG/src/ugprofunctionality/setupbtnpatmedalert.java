package ugprofunctionality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import AllUgsmoketest.framecheck;

public class setupbtnpatmedalert {
	
	public static void pmda(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(3000);
	// driver.findElement(By.xpath("//iframe[@id='f0']/..")).click();
	//	driver.findElement(By.xpath("//iframe[@id='f0']/..")).click();
		// driver.switchTo().frame(driver.findElement(By.id("f0")));
		 driver.switchTo().parentFrame();
			driver.switchTo().frame(driver.findElement(By.id("f11")));

		  
		  driver.findElement(By.xpath("//img[@id='setupButton']")).click();  // click on the setup button.
		  Thread.sleep(7000);
		  
		  //one point not covered as not able to see error if saving values in maximum future book days larger than central setup.
		 driver.switchTo().parentFrame();
		  driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f10']")));
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//div[@class='headerLinks']//span[1]")).click(); // clicking on the Central Setup.
		  Thread.sleep(6000);
		framecheck.checkframe12(driver);
		driver.findElement(By.xpath("(//div[@class='menuButton'])[1]")).click();  //system administration
		 Thread.sleep(3000);
			driver.findElement(By.xpath("//div[@id='menuItem_44']")).click(); //patient medical alerts
			Thread.sleep(3000);
			framecheck.checkframe11(driver);
			driver.findElement(By.xpath("//div[@class='ug-container']//div[3]//div//following::div//div//label//input[@name='Redirection' and @value='ClientSide']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@id='window-name-input']")).clear();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@id='window-name-input']")).sendKeys("windowname"); 
			Thread.sleep(3000);
			
			//input[@id='free-text-input']
			driver.findElement(By.xpath("//input[@id='free-text-input']")).sendKeys("testfreetxt"); 
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@id='save-button']")).click();
			Thread.sleep(3000);
			
			
			

}
	
}

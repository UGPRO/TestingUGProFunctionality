package ugprofunctionality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import AllUgsmoketest.framecheck;

public class PracticesYN {
	
	
	public static void PractY(WebDriver driver) throws InterruptedException
	{
		driver.findElement(By.linkText("Central setup")).click();
		Thread.sleep(2000);
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f12']")));
		driver.findElement(By.xpath("(//div[@class='menuButton'])[1]")).click(); //System administration
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@id='menuItem_18'])[1]")).click();  //System Settings
		Thread.sleep(2000);
		
		framecheck.checkframe11(driver);
		//Clicking on the Activating / deactivating features
		driver.findElement(By.xpath("//th[text()='Activate / de-activate features']")).click();
		Thread.sleep(4000);
		
		
		driver.findElement(By.xpath("//input[@id='txtPracticeInUseY']")).click(); // clicking on radio btn
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='butSave']")).click();
		

}
	
	public static void PractN(WebDriver driver) throws InterruptedException
	{
		
		driver.findElement(By.linkText("Central setup")).click();
		Thread.sleep(2000);
		
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f12']")));
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='menuButton'])[3]")).click();   // Clicking on the Central Administration.
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//div[@id='menuItem_19']")).click();  // clicking on Practices.
		Thread.sleep(3000);
		
		 //Again navigating to Practices to put the practices on No.
		
		
		
		
		driver.findElement(By.xpath("(//div[@class='menuButton'])[1]")).click(); //System administration
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@id='menuItem_18'])[1]")).click();  //System Settings
		Thread.sleep(2000);
		
		framecheck.checkframe11(driver);
		//Clicking on the Activating / deactivating features
		driver.findElement(By.xpath("//th[text()='Activate / de-activate features']")).click();
		Thread.sleep(4000);
		

		
		
		driver.findElement(By.xpath("//input[@id='txtPracticeInUseN']")).click(); 
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='butSave']")).click();    
		
		

}
}

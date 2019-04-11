package ugprofunctionality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class onlylogout {
	
	@Test
	public static void outapp(WebDriver driver) throws InterruptedException
	{
		
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f12']")));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@id='logoutButton']")).click();

}

	
}

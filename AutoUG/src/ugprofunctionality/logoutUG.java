package ugprofunctionality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import AllUgsmoketest.userlogin;

public class logoutUG {
	
	public static void logoffug(WebDriver driver) throws InterruptedException
	{
	
		driver.switchTo().parentFrame();
	
	driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f12']")));
	Thread.sleep(2000);
	driver.findElement(By.xpath("//img[@id='logoutButton']")).click();
	Thread.sleep(4000);
	
	userlogin.login(driver);
	}

}

package AllUgsmoketest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class framecheck {
	
	public static void  checkframe11(WebDriver driver)
	{

		//System.setProperty("webdriver.chrome.driver", "C:\\selenium drivers\\chromedriver_win32\\chromedriver.exe");
		//WebDriver driver= new ChromeDriver();
	  
		driver.switchTo().parentFrame();
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f11']")));
		
	}
	public static void checkframe12(WebDriver driver)
	{

		driver.switchTo().parentFrame();
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f12']")));

	}

}
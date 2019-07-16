package UGregresssionpack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import AllUgsmoketest.framecheck;
import AllUgsmoketest.userlogin;
import excelreaderutility.Xls_Reader;

public class regtest11 {
	
	public	static WebDriver driver;

	public static Xls_Reader reader;
	
	
	public static void main(String args[]) throws InterruptedException
	{

		reader = new Xls_Reader("C:\\Users\\akhosla\\Documents\\regexcelsheet.xlsx");
		Thread.sleep(2000);
		
		System.setProperty("webdriver.chrome.driver", "C:\\sdriver\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		
		
		userlogin.login(driver);
		driver.findElement(By.linkText("Central setup")).click();
		Thread.sleep(2000);
		
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f12']")));
		driver.findElement(By.xpath("(//div[@class='menuButton'])[1]")).click();  //system administration
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@id='menuItem_18'])[1]")).click();  //system settings
		Thread.sleep(2000);
		framecheck.checkframe11(driver);
		driver.findElement(By.xpath("//th[text()='Activate / de-activate features']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='txtPracticeInUseY']")).click(); 
		Thread.sleep(2000);

		
	
	}
}
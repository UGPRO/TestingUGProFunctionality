package AllUgsmoketest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import excelreaderutility.Xls_Reader;

public class userlogin {
	
	public static Xls_Reader reader;
	public static String serverurl;
	
	
	
 public static void login(WebDriver driver) throws InterruptedException
 {
	reader = new Xls_Reader("E:\\Test.xlsx");
	serverurl=reader.getCellData("ST1", "UGURL", 2);
		
		String Username	=reader.getCellData("ST1", "Username", 2);
		String Password	=reader.getCellData("ST1", "Password", 2);
	//	System.setProperty("webdriver.chrome.driver", "C:\\selenium drivers\\chromedriver_win32\\chromedriver.exe");
		//https://vm64-its.ultragenda.com/UltraGendaPro?newwindow=0
		driver.get(serverurl);
		driver.manage().window().maximize();
		driver.findElement(By.id("Form_Username")).sendKeys(Username);
		Thread.sleep(3000);	
		driver.findElement(By.id("Form_Password")).sendKeys(Password);
		Thread.sleep(3000);	
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		Thread.sleep(3000);	
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f0']")));
		 Thread.sleep(2000);	
 }

}
package UGregresssionpack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import AllUgsmoketest.framecheck;
import AllUgsmoketest.userlogin;
import excelreaderutility.Xls_Reader;
import ugprofunctionality.navigatetoselectpat;
import ugprofunctionality.setupbtnpatmedalert;

public class regtest5 extends regtest4{

	public static Xls_Reader reader;
	public static String paturl;


	public static void main(String[] args) throws InterruptedException {

		reader = new Xls_Reader("C:\\Test.xlsx");
		paturl = reader.getCellData("reg5", "PatientLink URL", 2);



		System.setProperty("webdriver.chrome.driver", "C:\\sdriver\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();

		//System.setProperty("webdriver.chrome.driver", "C:\\selenium drivers\\chromedriver_win32\\chromedriver.exe");
		//	driver.get("https://vm64-its.ultragenda.com/UltraGendaPro?newwindow=0");

		userlogin.login(driver);

		driver.findElement(By.linkText("Central setup")).click();
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f12']")));
		driver.findElement(By.xpath("(//div[@class='menuButton'])[1]")).click();  //system administration
		Thread.sleep(2000);


		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='menuItem_38']")).click();  //click on the patient link

		driver.switchTo().parentFrame();

		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f11']")));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='txtPatientWindowURL']")).click();  //fill patient link values.
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='txtPatientWindowURL']")).sendKeys(paturl);  //fill patient link values.
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='butSave']")).click();
		Thread.sleep(2000);

		navigatetoselectpat.selpat(driver);

		setupbtnpatmedalert.pmda(driver);

		Thread.sleep(2000);
		framecheck.checkframe12(driver);
		driver.findElement(By.xpath("(//div[@class='menuButton'])[3]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='menuItem_3']")).click(); //click on the access rights
		Thread.sleep(2000);

	}
}
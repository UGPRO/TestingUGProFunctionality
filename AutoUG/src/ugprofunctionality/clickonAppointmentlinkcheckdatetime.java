package ugprofunctionality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import AllUgsmoketest.framecheck;
import excelreaderutility.Xls_Reader;

public class clickonAppointmentlinkcheckdatetime
{



	public static String AL1URL;
	public  static Xls_Reader reader;

	public static void setupchecklinkcheckdatetime(WebDriver driver) throws InterruptedException
	{

		Thread.sleep(3000);
		reader = new Xls_Reader("C:\\Users\\akhosla\\Documents\\regexcelsheet.xlsx");
		AL1URL	=reader.getCellData("reg5", "AL1-URL", 2);

		// driver.findElement(By.xpath("//iframe[@id='f0']/..")).click();
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


		driver.findElement(By.xpath("(//div[@class='menuButton'])[1]")).click(); //System administration
		Thread.sleep(3000);

		driver.findElement(By.xpath("//div[@id='menuItem_24']")).click();    //Appointment link1
		Thread.sleep(2000);

		driver.switchTo().parentFrame();
		//Switched for parent frame=F0 because it was not able to come outside from F12 frame so i switched)

		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f11']")));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='txtAppointmentEventOrUrlU']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='txtAppointmentWindowURL']")).clear();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='txtAppointmentWindowURL']")).sendKeys(AL1URL); 
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='butSave']")).click();
		Thread.sleep(3000);





	}

}

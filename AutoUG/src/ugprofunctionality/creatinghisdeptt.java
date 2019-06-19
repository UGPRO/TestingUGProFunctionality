package ugprofunctionality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import AllUgsmoketest.framecheck;
import excelreaderutility.Xls_Reader;

public class creatinghisdeptt 
{

	public static Xls_Reader reader;
	public static String Hisdeptname;
	public static String codehisdept;
	public static void hisdeptcreation(WebDriver driver) throws InterruptedException
	{

		reader = new Xls_Reader("C:\\Users\\akhosla\\Documents\\Test.xlsx");
		Thread.sleep(2000);

		Hisdeptname	=reader.getCellData("reg10", "Hisdeptname", 2);
		codehisdept	=reader.getCellData("reg10", "Hisdeptcode", 2);
		
		driver.findElement(By.linkText("Central setup")).click();
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f12']")));
		driver.findElement(By.xpath("(//div[@class='menuButton'])[3]")).click();  //Central administration
		Thread.sleep(2000);


		driver.findElement(By.xpath("//div[@id='menuItem_22']")).click(); //clicking on the HIS deptt
		Thread.sleep(2000);
		framecheck.checkframe11(driver);
		driver.findElement(By.xpath("//button[@id='butNew']")).click(); //clicking on the HIS deptt
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='hisdptName']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='hisdptName']")).sendKeys(Hisdeptname);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='hisdptKey']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='hisdptKey']")).sendKeys(codehisdept);
		Thread.sleep(2000);
		//button[@id='butSave']
		driver.findElement(By.xpath("//button[@id='butSave']")).click();
	}

}

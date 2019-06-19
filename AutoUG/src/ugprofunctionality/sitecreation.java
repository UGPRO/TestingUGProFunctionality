package ugprofunctionality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import AllUgsmoketest.framecheck;
import excelreaderutility.Xls_Reader;

public class sitecreation {
	public	static WebDriver driver;

	public static Xls_Reader reader;

	static String CreateNSite	;
	static String CreateNewSiteAbrev;	
	static String CreateNewLoc	;
	static String CreateNewLocabrev;


	public static void creatingnewsite(WebDriver driver) throws InterruptedException
	{
		reader = new Xls_Reader("C:\\Users\\akhosla\\Documents\\regexcelsheet.xlsx");
		CreateNSite	=reader.getCellData("reg9", "Create NewSite", 2);
		CreateNewSiteAbrev	=reader.getCellData("reg9", "Create NewSite Abrev", 2);
		CreateNewLoc	=reader.getCellData("reg9", "Create New Loc", 2);
		CreateNewLocabrev	=reader.getCellData("reg9", "Create New Loc abrev", 2);

		driver.findElement(By.xpath("//div[@id='menuItem_28']")).click(); //click on Sites option
		Thread.sleep(15000);

		framecheck.checkframe11(driver);
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[@id='butNew']")).click();
		Thread.sleep(4000);

		//String sitn = "sn"+uniq;

		//	String sitab="sa"+uniq;;
		driver.findElement(By.xpath("//input[@id='txtSiteName']")).click(); 
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='txtSiteName']")).sendKeys(CreateNSite); 

		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='txtSiteAbbrev']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='txtSiteAbbrev']")).sendKeys(CreateNewSiteAbrev); //creating new site
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@id='butSave']")).click();
		Thread.sleep(7000);


	}
}

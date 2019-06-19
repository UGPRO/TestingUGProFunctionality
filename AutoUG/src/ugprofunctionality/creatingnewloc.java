package ugprofunctionality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import AllUgsmoketest.framecheck;
import excelreaderutility.Xls_Reader;

public class creatingnewloc {
	public static Xls_Reader reader;

	static String CreateNewLoc	;
	static String CreateNewLocabrev;
	public static void newloccreation(WebDriver driver) throws InterruptedException
	{
		reader = new Xls_Reader("C:\\Users\\akhosla\\Documents\\regexcelsheet.xlsx");
		CreateNewLoc	=reader.getCellData("reg9", "Create New Loc", 2);
		CreateNewLocabrev	=reader.getCellData("reg9", "Create New Loc abrev", 2);
		
		framecheck.checkframe12(driver);

		driver.findElement(By.xpath("//div[@id='menuItem_9']")).click();
		Thread.sleep(2000);
		framecheck.checkframe11(driver);
		driver.findElement(By.xpath("//button[@id='butNew']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='txtLocName']")).sendKeys(CreateNewLoc);  //creatin new loc
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='txtLocAbbrev']")).sendKeys(CreateNewLocabrev);

		Thread.sleep(3000);
		Select la=new Select(driver.findElement(By.xpath("//select[@id='txtLocSite']")));
		la.selectByVisibleText("[Select]");  //

		driver.findElement(By.xpath("//button[@id='butSave']")).click();
		Thread.sleep(3000);
	}
}

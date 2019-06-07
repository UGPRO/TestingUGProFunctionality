package ugprofunctionality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import excelreaderutility.Xls_Reader;

public class updatereport2 {
	
	public static WebDriver driver;
	public static String SelRepFunction1;
	public static String SelReportAftrFxn1;
	public static Xls_Reader reader;
	public static String NewRepName;
	public static String Seldeptoseerep;
	
	public static void reportupdate(WebDriver driver) throws InterruptedException
	{
		reader = new Xls_Reader("C:\\Users\\akhosla\\Documents\\regexcelsheet.xlsx");
		NewRepName	=reader.getCellData("reg6", "NewReportName", 2);
		SelRepFunction1	=reader.getCellData("reg6", "SelReportFunction1", 2);
		SelReportAftrFxn1	=reader.getCellData("reg6", "SelReportAfterFxn1", 2);
		Seldeptoseerep	=reader.getCellData("reg6", "Select DepartmenttoseecancellationReport", 2);

		Thread.sleep(6000);

		driver.switchTo().parentFrame();

		driver.switchTo().frame(driver.findElement(By.id("f11")));


		driver.findElement(By.xpath("//img[@id='setupButton']")).click();  // click on the setup button.
		Thread.sleep(7000);

		//one point not covered as not able to see error if saving values in maximum future book days larger than central setup.
		driver.switchTo().parentFrame();
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f10']")));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='headerLinks']//span[1]")).click(); // clicking on the Central Setup.
		Thread.sleep(7000);
		
		
		driver.switchTo().parentFrame();
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f12']")));
		driver.findElement(By.xpath("(//div[@class='menuButton'])[1]")).click();  //system administration

		//framecheck.checkframe12(driver);
		//driver.findElement(By.xpath("//iframe[@id='f0']/..")).click(); //to get back control on the div we used /.. 
		//driver.switchTo().frame(driver.findElement(By.id("f0")));


		//driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f12']")));

		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='menuItem_23']")).click();  // clicking on the report settings.
         
		driver.switchTo().parentFrame();
		//Switched for parent frame=F0 because it was not able to come outside from F12 frame so i switched)

		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f11']")));
		Thread.sleep(4000);
		//input[@class='searchBox']
		driver.findElement(By.xpath("//input[@class='searchBox']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class='searchBox']")).sendKeys(NewRepName);
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//td[@class='searchAction']//img")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//td[text()='" + NewRepName + "']")).click();

		Thread.sleep(2000);
		Select nreport=new Select(driver.findElement(By.xpath("//select[@id='functionType']")));
		nreport.selectByVisibleText(SelRepFunction1); 
		Thread.sleep(5000);
		Select nreport1=new Select(driver.findElement(By.xpath("//select[@id='lstReport']")));
		nreport1.selectByVisibleText(SelReportAftrFxn1);
		Thread.sleep(4000);



		driver.findElement(By.xpath("//input[@id='SelectionDpt']")).click();  // click on the Department radio button.
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[@id='butDefineRelations']")).click(); //Clicking on the Define button
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		driver.switchTo().frame(driver.findElement(By.id("ultramodal1-modal-iframe")));
		Thread.sleep(2000);

		driver.findElement(By.xpath("//img[@onclick='searchDepartments();']")).click();  //clicking on the search icon.

		Thread.sleep(5000);
		Actions action = new Actions(driver);
		WebElement link =driver.findElement(By.xpath("//td[text()='" + Seldeptoseerep + "']"));
		action.doubleClick(link).perform();
		
		
		Thread.sleep(4000);

		driver.findElement(By.xpath("//button[@id='butSave' and text()='Confirm']")).click();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();


		driver.findElement(By.xpath("//iframe[@id='f0']/..")).click(); //to get back control on the div we used /.. 
		driver.switchTo().frame(driver.findElement(By.id("f0")));
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f11']")));

		driver.findElement(By.xpath("//button[@id='butSave']")).click();
		Thread.sleep(2000);

	}
	

}

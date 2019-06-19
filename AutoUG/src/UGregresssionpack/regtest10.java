package UGregresssionpack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import AllUgsmoketest.framecheck;
import AllUgsmoketest.userlogin;
import excelreaderutility.Xls_Reader;
import ugprofunctionality.creatinghisdeptt;

public class regtest10 {
	public	static WebDriver driver;

	public static Xls_Reader reader;
	public static String Hisdeptname;
	public static String codehisdept;
	public static String CreateDepname;
	public static String CreateDeptAbrev	;
	public static String SelectHisdeptt;
	public static String SelDA;

	public static String selexistingdeptt;

	public static void main(String[] args) throws InterruptedException 
	{

		reader = new Xls_Reader("C:\\Users\\akhosla\\Documents\\Test.xlsx");
		Thread.sleep(2000);
		
		Hisdeptname	=reader.getCellData("reg10", "Hisdeptname", 2);
		codehisdept	=reader.getCellData("reg10", "Hisdeptcode", 2);
		CreateDepname	=reader.getCellData("reg10", "Create Dep name", 2);
		CreateDeptAbrev	=reader.getCellData("reg10", "Create Dept Abrev", 2);
		SelectHisdeptt	=reader.getCellData("reg10", "Select His deptt", 2);
		SelDA	=reader.getCellData("reg10", "Select DA", 2);
		selexistingdeptt = reader.getCellData("reg10", "SelectExistingDepartment", 2);



		System.setProperty("webdriver.chrome.driver", "C:\\sdriver\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);




		userlogin.login(driver);
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f12']")));
		
		creatinghisdeptt.hisdeptcreation(driver);
		framecheck.checkframe12(driver);
		driver.findElement(By.xpath("//div[@id='menuItem_4']")).click(); // clicking on the departments option.
		Thread.sleep(2000);
		framecheck.checkframe11(driver);
		
		//creating departmnet
		
		//button[@id='butNew']
		driver.findElement(By.xpath("//button[@id='butNew' and @class='b7522 btn-hover']")).click();
		Thread.sleep(7000);
		// driver.findElement(By.xpath("//input[@id='name-input']")).clear();

		driver.findElement(By.xpath("//input[@id='name-input']")).sendKeys(CreateDepname); 
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='abbreviation-input']")).clear();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='abbreviation-input']")).sendKeys(CreateDeptAbrev);
		Thread.sleep(3000);
		Select deptt=new Select(driver.findElement(By.xpath("//select[@id='his-department-input']")));
		deptt.selectByVisibleText(SelectHisdeptt);
		/*	for(int i=1; i<=2; i++)
		{
			Thread.sleep(2000);
			deptt.selectByIndex(i);
		}*/
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='Select-arrow']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@style='width:5px;box-sizing:content-box;']")).sendKeys(SelDA); 
		Actions actions = new Actions(driver);
		Thread.sleep(2000);
		actions.sendKeys(Keys.DOWN).build().perform();
		Thread.sleep(2000);
		actions.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
		/*	 for(int i=0; i<=3; i++)
		 {
		 Actions actions = new Actions(driver);
		 Thread.sleep(2000);
		 actions.sendKeys(Keys.DOWN).build().perform();
		 Thread.sleep(2000);
		 actions.sendKeys(Keys.ENTER).build().perform();
		 Thread.sleep(2000);
		 }	*/
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@class='ug-button' and @id='save-button']")).click();

		Thread.sleep(3000);
		
		//doing Log on as the DA of the new department. 
		
		
		userlogin.login(driver); // change the passowrd in the excel file
		
		driver.findElement(By.linkText("Central setup")).click();
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f12']")));
		driver.findElement(By.xpath("(//div[@class='menuButton'])[3]")).click();  //Central administration
		Thread.sleep(2000);
		
		framecheck.checkframe11(driver);
		Thread.sleep(2000);

		driver.findElement(By.xpath("//td[text()='" +selexistingdeptt + "']")).click(); //selecting new created department."
		
		
		driver.findElement(By.xpath("//input[@id='abbreviation-input']")).clear();  //checking error if the abbreviation is empty.
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='ug-button' and @id='save-button']")).click();

		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//div[@id='menuItem_7']")).click();  // clicking on the authorities option.
		Thread.sleep(2000);
		
		//input[@id='txtCpsFamilyName']
		driver.findElement(By.xpath("//input[@id='txtCpsFamilyName']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='txtCpsFamilyName']")).sendKeys();

	
		
		

	}
}

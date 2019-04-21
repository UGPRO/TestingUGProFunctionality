package UGregresssionpack;

import java.io.IOException;

import AllUgsmoketest.framecheck;
import AllUgsmoketest.userlogin;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import excelreaderutility.Xls_Reader;

public class regtest1 {

	public  static Xls_Reader reader;

	static String Refreshval ;
	static String Calendarday;	
	static String  ScheduleNavn;
	static String AuthUsername	;
	static String AuthPassword	;
	static String logtime	;


	public static void main(String[] args) throws InterruptedException {

		reader = new Xls_Reader("C:\\Test.xlsx");


		Refreshval = SubChar(reader.getCellData("ST2", "ScreenRefresh value", 2).toString());
		Calendarday	=reader.getCellData("ST2", "CalendarFirstDayOfWeek", 2);
		ScheduleNavn	 =reader.getCellData("ST6", "Schedule Name", 2);
		AuthUsername	=reader.getCellData("ST4", "Authentication Username", 2);
		AuthPassword	=reader.getCellData("ST4", "Authentication Password", 2);
		logtime =SubChar(reader.getCellData("reg1", "Logoff time", 2).toString());


		System.setProperty("webdriver.chrome.driver", "C:\\sdriver\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();

		userlogin.login(driver);


		//Thread.sleep(2000);

		driver.findElement(By.linkText("Central setup")).click();
		Thread.sleep(2000);
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f12']")));

		driver.findElement(By.xpath("(//div[@class='menuButton'])[1]")).click();; //System administration
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@id='menuItem_18'])[1]")).click();  //System Settings
		Thread.sleep(2000);
		driver.switchTo().parentFrame();
		//Switched for parent frame=F0 because it was not able to come outside from F12 frame so i switched)

		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f11']")));
		driver.findElement(By.xpath("//th[@class='rowHead']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='txtScreenRefresh']")).clear();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='txtScreenRefresh']")).sendKeys("0");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//button[@id='butSave']")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		// driver.findElement(By.xpath("//input[@id='txtScreenRefresh']")).sendKeys("0");
		//driver.switchTo().alert().accept();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@id='txtScreenRefresh']")).clear();
		driver.findElement(By.xpath("//input[@id='txtScreenRefresh']")).sendKeys("20");
		driver.findElement(By.xpath("//button[@id='butSave']")).click();
		Thread.sleep(2000); 
		driver.switchTo().alert().accept();
		//Switched for parent frame=F0 because it was not able to come outside from F12 frame so i switched)


		Thread.sleep(5000); 
		driver.switchTo().parentFrame();
		// need to logout
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f12']")));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@id='logoutButton']")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().dismiss();
		Thread.sleep(4000);

		//navigating to authentication.


		driver.get("https://vm64-its/ultragenda.authentication/admin/login");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.id("Form_Username")).sendKeys(AuthUsername);
		Thread.sleep(3000);
		driver.findElement(By.id("Form_Password")).sendKeys(AuthPassword);
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		// frm1.checkframe1();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='ui center aligned basic segment']//following::div[16]//i[@class='desktop icon']")).click();//client click
		Thread.sleep(2000);
		//Clicking on UltraGenda.Pro.Web edit button.

		driver.findElement(By.xpath("//tr//td[text()='UltraGenda.Pro.Web']/following::td[4]//a[@class='ui primary button icon']")).click(); 
		Thread.sleep(2000);
		//input[@id='Client_AccessTokenLifetime']
		driver.findElement(By.xpath("//input[@id='Client_AccessTokenLifetime']")).clear();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='Client_AccessTokenLifetime']")).sendKeys(logtime);
		Thread.sleep(3000);
		//button[@type='submit']
		driver.findElement(By.xpath("//button[@type='submit']")).click(); //saving values of logout button.




		Thread.sleep(6000);
		userlogin.login(driver);

		driver.findElement(By.linkText("Central setup")).click();
		Thread.sleep(3000);

		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f12']")));
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[@class='menuButton'])[1]")).click(); //clicking on System administration to expand it.
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@id='menuItem_18'])[1]")).click(); // clicking on System settings
		Thread.sleep(2000);
		driver.switchTo().parentFrame();
		//Switched for parent frame=F0 because it was not able to come outside from F12 frame so i switched)
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f11']")));
		driver.findElement(By.xpath("//th[@class='rowHead']")).click(); //clicking on General option.
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@id='txtAsfuturebookday']")).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='txtAsfuturebookday']")).sendKeys("0");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@id='butSave']")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='txtAsfuturebookday']")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='txtAsfuturebookday']")).sendKeys("31");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='butSave']")).click();

		Thread.sleep(7000);

		driver.findElement(By.xpath("//select[@id='txtCalendarFirstDayOfWeek']")).click();
		Thread.sleep(2000);

		Select fdw=new Select(driver.findElement(By.name("txtCalendarFirstDayOfWeek")));
		fdw.selectByVisibleText(Calendarday);  // give value in ST2

		Thread.sleep(4000);

		driver.findElement(By.xpath("//button[@id='butSave']")).click();
		Thread.sleep(8000);

		// Story to click on the schedule setup.


		driver.switchTo().parentFrame();

		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f10']")));

		driver.findElement(By.xpath("//div[@class='headerLinks']//span[2]")).click(); // clicking on schedule setup at top right of the screen
		Thread.sleep(5000);
		framecheck.checkframe12(driver);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//select[@id='rscIdDptId']")).click();


		Select sched=new Select(driver.findElement(By.xpath("//select[@id='rscIdDptId']"))); // for now as i was not able to save the schedule , so we will directly
		//fetch the schedule name from excel sheet. In future need to updating with new created schedule name.
		Thread.sleep(2000);	
		sched.selectByVisibleText(ScheduleNavn);
		driver.findElement(By.xpath("//select[@id='rscIdDptId']")).click();
		Thread.sleep(7000);

		driver.findElement(By.xpath("//div[@class='buttonFloatLeft']//img[@id='scheduleButton']")).click();// clicking on Schedule button-Schedule setup.
		Thread.sleep(7000);

		//here you can cheeck the selected calendar day.

		framecheck.checkframe11(driver);



		driver.findElement(By.xpath("//img[@id='setupButton']")).click();  // click on the setup button.
		Thread.sleep(7000);

		//one point not covered as not able to see error if saving values in maximum futurre book days larger than central setup.
		driver.switchTo().parentFrame();
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f10']")));
		driver.findElement(By.xpath("//div[@class='headerLinks']//span[1]")).click(); // clicking on the Central Setup.
		Thread.sleep(6000);


		driver.switchTo().parentFrame();
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f12']")));
		driver.findElement(By.xpath("(//div[@class='menuButton'])[1]")).click();  //System Administration
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@id='menuItem_18'])[1]")).click();   //System Settings
		Thread.sleep(2000);
		driver.switchTo().parentFrame();
		//Switched for parent frame=F0 because it was not able to come outside from F12 frame so i switched)

		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f11']")));
		driver.findElement(By.xpath("//th[@class='rowHead']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@id='txtWaitingPeriodWeeksMin']")).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='txtWaitingPeriodWeeksMin']")).sendKeys("31");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='txtWaitingPeriodWeeksMax']")).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='txtWaitingPeriodWeeksMax']")).sendKeys("11");

		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='butSave']")).click();  // save button.
		Thread.sleep(2000);
		driver.switchTo().alert().accept();


		//System info story.

		framecheck.checkframe12(driver);
		driver.findElement(By.xpath("//div[@id='menuItem_37']")).click();//System info
		Thread.sleep(2000);
		driver.switchTo().alert().dismiss();

		//vertical bar should get displayed.
		driver.quit();

	}
	public static String SubChar(String value)
	{
		int index=0;
		index = value.indexOf(".");

		if (index>-1)

			return value.substring(0, index);

		else return value;

	}
}
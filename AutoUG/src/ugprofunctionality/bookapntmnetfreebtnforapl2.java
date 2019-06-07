package ugprofunctionality;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import AllUgsmoketest.framecheck;
import excelreaderutility.Xls_Reader;

public class bookapntmnetfreebtnforapl2 {

	public static WebDriver driver;
	public static boolean bValue;
	public static String FreebtnPatfamname2;
	public static String FreebtnPatGivenName2;
	public static String CreateNewApt;
	public static String selectapnttoseecancelrepafterbookapntmnt;
	public  static Xls_Reader reader;




	public static void clickonfreebuttontobookappointment2(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		reader = new Xls_Reader("C:\\Users\\akhosla\\Documents\\regexcelsheet.xlsx");
		FreebtnPatfamname2 = reader.getCellData("reg5", "Apl2Patient Fam Name", 2);
		FreebtnPatGivenName2  = reader.getCellData("reg5", "Apl2Patinet Given Name ", 2);
		CreateNewApt=reader.getCellData("reg5", "SelectExistingAppointment", 2);
		selectapnttoseecancelrepafterbookapntmnt=reader.getCellData("reg6", "SelectAppointmenttobookapntmtandtoseereport", 2);

		driver.switchTo().parentFrame();

		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f10']")));

		driver.findElement(By.xpath("//div[@class='headerLinks']//span[2]")).click(); // clicking on schedule setup.
		Thread.sleep(2000);

		framecheck.checkframe12(driver);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//select[@id='rscIdDptId']")).click();


		Select sched=new Select(driver.findElement(By.xpath("//select[@id='rscIdDptId']"))); // for now as i was not able to save the schedule , so we will directly
		//fetch the schedule name from excel sheet. In future need to updating with new created schedule name.
		Thread.sleep(2000);	
		sched.selectByVisibleText("Cardio surgery");
		Thread.sleep(2000);	
		driver.findElement(By.xpath("//div[@class='buttonFloatLeft']//img[@id='scheduleButton']")).click();// clicking on Schedule button-Schedule setup.
		
		Thread.sleep(9000);


		framecheck.checkframe11(driver);

		//functionality free button.
		Thread.sleep(2000);	

		driver.findElement(By.xpath("//button[@id='butSearch']")).click(); // clicking on free button
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		driver.switchTo().frame(driver.findElement(By.id("ultramodal1-modal-iframe")));

		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f11']")));
		Thread.sleep(2000);

		
		driver.findElement(By.xpath("//input[@title='Family name' and @id='sFamilyname']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@title='Family name' and @id='sFamilyname']")).sendKeys(FreebtnPatfamname2);

		// driver.findElement(By.xpath("//input[@title='Family name' and @id='sFamilyname']")).sendKeys(Patintfamname);

		driver.findElement(By.xpath("//td[@class='rowInput']//input[@name='sGivenname' and @id='sGivenname']")).sendKeys(FreebtnPatGivenName2);



		Thread.sleep(2000);


		driver.findElement(By.xpath("//td[@class='rowButton']//button[@id='butSearch']")).click(); //searching patient.
		Thread.sleep(5000);

		driver.findElement(By.xpath("//button[@id='butSelect']")).click(); //selecting patient
		Thread.sleep(5000);
		driver.findElement(By.xpath("//iframe[@id='f0']/..")).click(); //to get back control on the div we used /.. 
		driver.switchTo().frame(driver.findElement(By.id("f0")));

		driver.switchTo().frame(driver.findElement(By.id("f12")));
		Thread.sleep(3000);
		//halt
		driver.findElement(By.xpath("//span[@id='select2-apptypeSelect-container']")).click();//Schedule setup-Selecting appointment type after free btn

		driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys(selectapnttoseecancelrepafterbookapntmnt); //selecting appointment in enter search criteria
		Actions actions2 = new Actions(driver);
		Thread.sleep(2000);
		actions2.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
		//button[@id='butSearch2']
		//button[@id='butBook']
		WebElement site = driver.findElement(By.xpath("//input[@id='site1']"));
		//bValue = Practicerdo.isSelected();

		if(bValue = site.isSelected())
		{
			Thread.sleep(2000);
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.xpath("//input[@id='site1']"))).doubleClick().build().perform();
			driver.findElement(By.xpath("//input[@id='site1']")).click();
		}
		else

		{
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='site1']")).click();
		}


		driver.findElement(By.xpath("//button[@id='butSearch2']")).click(); //clicking on the search icon to see slots to book appointment.
		Thread.sleep(2000);
		framecheck.checkframe12(driver);
		// searchResult
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='searchResult']")));
		if(driver.findElements(By.xpath("//table[@id='slots']//tbody//tr[3]//td[1]")).size()>0)
		{
			Thread.sleep(2000);
			//table[@id='slots']//tbody//tr[3]//td[1]
			//DO THE STUFF YOU NEED TO DO IF THE ELEMENT EXISTS
			driver.findElement(By.xpath("//table[@id='slots']//tbody//tr[3]//td[1]")).click(); //clicking on particular slot to book apntmnt. 
		}

		else
		{
			Thread.sleep(2000);
			//button[@id='Button2']
			driver.findElement(By.xpath("//button[text()='Next']")).click();  //clicking on the next button if the free slots not available.
			Thread.sleep(2000);
			driver.findElement(By.xpath("//table[@id='slots']//tbody//tr[3]//td[1]")).click();
		}

		Thread.sleep(7000);

		driver.findElement(By.xpath("//iframe[@id='f0']/..")).click(); //to get back control on the div we used /.. 
		driver.switchTo().frame(driver.findElement(By.id("f0")));

		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f12']")));

		//button[@id='butBook']
		driver.findElement(By.xpath("//button[@id='butBook']")).click(); // clicking on save button to book apntmnt via free btn


		Thread.sleep(7000);



		//div[@id='btnEndBooking']
		driver.findElement(By.xpath("//div[@id='btnEndBooking']")).click(); //  clicking on continue without printing via free btn
		Thread.sleep(3000);


		driver.switchTo().parentFrame();
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f13']")));
		Thread.sleep(2000);

		driver.findElement(By.xpath("//div[@id='appointment']//div[2]//div//img/following-sibling::span")).click(); // clicking on th apointment date time link.
		Thread.sleep(5000);





	}
}
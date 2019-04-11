package UGregresssionpack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import AllUgsmoketest.framecheck;
import AllUgsmoketest.userlogin;
import excelreaderutility.Xls_Reader;
import ugprofunctionality.Navigatepatientpportal;
import ugprofunctionality.navigatevalidpat;
import ugprofunctionality.setupbtnandpatfieldsetting;

public class regtest4 extends regtest2
{
	static String Itempatfield;




	public static void main(String[] args) throws InterruptedException {

		reader = new Xls_Reader("E:\\Test.xlsx");
		Itempatfield = reader.getCellData("reg4", "Patientfield-Item", 2);



		System.setProperty("webdriver.chrome.driver", "C:\\sdriver\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();

		userlogin.login(driver);


		//Thread.sleep(2000);

		driver.findElement(By.linkText("Central setup")).click();
		Thread.sleep(2000);

		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='f12']")));
		driver.findElement(By.xpath("(//div[@class='menuButton'])[1]")).click(); //System administration
		Thread.sleep(2000);

		//	driver.findElement(By.xpath("(//div[@id='menuItem_25']")).click();  //clicking on the Patient field

		driver.findElement(By.xpath("//div[@id='menuItem_25']")).click();  //
		//tr[@id='r3']//td[text()='Title']
		Thread.sleep(4000);

		// need to handle family name 

		framecheck.checkframe11(driver);

		driver.findElement(By.xpath("//tr[@class='tblRow']//td[text()='Family name']")).click();
		Thread.sleep(2000);


		driver.findElement(By.xpath("//input[@id='NotEditableAndNotMandatory']")).click();  //field cannot be modified
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[@id='butSave']")).click();  // clicking on the save button.

		navigatevalidpat.navigatepatientval(driver);  //navigating to valid patient.


		driver.switchTo().defaultContent();
		Thread.sleep(2000);

		driver.switchTo().frame(driver.findElement(By.id("ultramodal1-modal-iframe")));
		driver.switchTo().frame(driver.findElement(By.id("f11")));

		driver.findElement(By.xpath("//button[@id='butBack']")).click();   // clicking on the back button.
		Thread.sleep(4000);
		//span[@class='modal-close-button']
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='modal-close-button']")).click();    //clicking on close icon.
		Thread.sleep(3000);

		setupbtnandpatfieldsetting.setupbtnpatsetting(driver);   //navigating to central setup patient field.


		//Handling only family name above.	
		//--------------------------------------------------------------------------------------------	 
		//below again handling family name

		framecheck.checkframe11(driver);

		driver.findElement(By.xpath("//tr[@class='tblRow']//td[text()='Family name']")).click();
		Thread.sleep(2000);


		driver.findElement(By.xpath("//input[@id='EditableAndMandatory']")).click(); //  field can be modified and must be completed.
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[@id='butSave']")).click();  // clicking on the save button.

		navigatevalidpat.navigatepatientval(driver);  //navigating to valid patient.


		driver.switchTo().defaultContent();
		Thread.sleep(2000);

		driver.switchTo().frame(driver.findElement(By.id("ultramodal1-modal-iframe")));
		driver.switchTo().frame(driver.findElement(By.id("f11")));

		driver.findElement(By.xpath("//button[@id='butBack']")).click();   // clicking on the back button.
		Thread.sleep(4000);
		//span[@class='modal-close-button']
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='modal-close-button']")).click();    //clicking on close icon.
		Thread.sleep(3000);

		setupbtnandpatfieldsetting.setupbtnpatsetting(driver);   //navigating to central setup patient field.

		//		---------------------
		framecheck.checkframe11(driver);
		driver.findElement(By.xpath("//tr[@class='tblRow']//td[text()='"+Itempatfield+"']")).click();  //clicking on the title option.
		Thread.sleep(2000);

		//WebElement pfield1 = driver.findElement(By.xpath("//input[@id='EditableAndMandatory']"));



		//  Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='NotEditableAndNotMandatory']")).click();  //field cannot be modified
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[@id='butSave']")).click();  // clicking on the save button.

		navigatevalidpat.navigatepatientval(driver);  //navigating to valid patient.


		driver.switchTo().defaultContent();
		Thread.sleep(2000);

		driver.switchTo().frame(driver.findElement(By.id("ultramodal1-modal-iframe")));
		driver.switchTo().frame(driver.findElement(By.id("f11")));

		driver.findElement(By.xpath("//button[@id='butBack']")).click();   // clicking on the back button.
		Thread.sleep(4000);
		//span[@class='modal-close-button']
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='modal-close-button']")).click();    //clicking on close icon.
		Thread.sleep(3000);

		setupbtnandpatfieldsetting.setupbtnpatsetting(driver);   //navigating to central setup patient field.

		framecheck.checkframe11(driver);
		driver.findElement(By.xpath("//tr[@class='tblRow']//td[text()='"+Itempatfield+"']")).click();  //clicking on the title option.
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@id='EditableAndNotMandatory']")).click(); //  field can be modified and leave blank
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[@id='butSave']")).click();  // clicking on the save button.

		navigatevalidpat.navigatepatientval(driver);  //navigating to valid patient.

		driver.switchTo().defaultContent();
		Thread.sleep(2000);

		driver.switchTo().frame(driver.findElement(By.id("ultramodal1-modal-iframe")));
		driver.switchTo().frame(driver.findElement(By.id("f11")));

		driver.findElement(By.xpath("//button[@id='butBack']")).click();   // clicking on the back btn.
		Thread.sleep(4000);
		//span[@class='modal-close-button']
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='modal-close-button']")).click();    //clicking on close icon.
		Thread.sleep(3000);

		setupbtnandpatfieldsetting.setupbtnpatsetting(driver);   //navigating to central setup patient field.

		framecheck.checkframe11(driver);
		driver.findElement(By.xpath("//tr[@class='tblRow']//td[text()='"+Itempatfield+"']")).click();  //clicking on the title option.
		Thread.sleep(2000);


		driver.findElement(By.xpath("//input[@id='EditableAndMandatory']")).click(); //  field can be modified and must be completed.
		Thread.sleep(2000);


		driver.findElement(By.xpath("//button[@id='butSave']")).click();  // clicking on the save button.

		navigatevalidpat.navigatepatientval(driver);  //navigating to valid patient.

		driver.switchTo().defaultContent();
		Thread.sleep(2000);

		driver.switchTo().frame(driver.findElement(By.id("ultramodal1-modal-iframe")));
		driver.switchTo().frame(driver.findElement(By.id("f11")));

		driver.findElement(By.xpath("//button[@id='butBack']")).click();   // clicking on the back btn.
		Thread.sleep(4000);
		//span[@class='modal-close-button']
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='modal-close-button']")).click();    //clicking on close icon.
		Thread.sleep(3000);

		setupbtnandpatfieldsetting.setupbtnpatsetting(driver);   //navigating to central setup patient field.

		framecheck.checkframe11(driver);
		driver.findElement(By.xpath("//tr[@class='tblRow']//td[text()='"+Itempatfield+"']")).click();  //clicking on the title option.


		//Settings for temporary patient.

		driver.findElement(By.xpath("//input[@id='temporaryRequiredY']")).click();  // Temp patient field must be completed.
		Thread.sleep(2000);


		driver.findElement(By.xpath("//button[@id='butSave']")).click();  // clicking on the save button.




		Navigatepatientpportal.navigatepatient(driver); //navigation temp patient


		driver.switchTo().defaultContent();
		Thread.sleep(2000);

		driver.switchTo().frame(driver.findElement(By.id("ultramodal1-modal-iframe")));
		driver.switchTo().frame(driver.findElement(By.id("f11")));

		driver.findElement(By.xpath("//button[@id='butBack']")).click();   // clicking on the back btn.
		Thread.sleep(4000);
		//span[@class='modal-close-button']
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='modal-close-button']")).click();    //clicking on close icon.
		Thread.sleep(3000);

		setupbtnandpatfieldsetting.setupbtnpatsetting(driver);   //navigating to central setup patient field.



		framecheck.checkframe11(driver);
		driver.findElement(By.xpath("//tr[@class='tblRow']//td[text()='"+Itempatfield+"']")).click();  //clicking on the title option.


		//Settings for temporary patient.

		driver.findElement(By.xpath("//input[@id='temporaryRequiredN']")).click();  // Temmp patinetfield may be left blank.
		Thread.sleep(2000);


		driver.findElement(By.xpath("//button[@id='butSave']")).click();  // clicking on the save button.
		Navigatepatientpportal.navigatepatient(driver); //navigation temp patient


		driver.switchTo().defaultContent();
		Thread.sleep(2000);

		driver.switchTo().frame(driver.findElement(By.id("ultramodal1-modal-iframe")));
		driver.switchTo().frame(driver.findElement(By.id("f11")));

		driver.findElement(By.xpath("//button[@id='butBack']")).click();   // clicking on the back btn.
		Thread.sleep(4000);
		//span[@class='modal-close-button']
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='modal-close-button']")).click();    //clicking on close icon.
		Thread.sleep(3000);


		driver.quit();



	}
}

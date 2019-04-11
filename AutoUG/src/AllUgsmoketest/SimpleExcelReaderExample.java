package AllUgsmoketest;
import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class SimpleExcelReaderExample extends Smoketest4{

	public static void Readfile() throws IOException
	{
		// TODO Auto-generated method stub


		File file =    new File("D:\\Test.xlsx");


		FileInputStream inputStream = new FileInputStream(file);

		Workbook guru99Workbook = null;

		guru99Workbook = new XSSFWorkbook(inputStream);

		Sheet guru99Sheet = guru99Workbook.getSheet("Sheet1");

		Cell val= guru99Sheet.getRow(0).getCell(2);
		//val.setCellValue(nav2);
		//System.out.print( guru99Sheet.getRow(0).getCell(1));

		guru99Workbook.close();



		//	SimpleExcelReaderExample ob = new SimpleExcelReaderExample();

		//	ob.writefile();
		// System.out.println( "Test");

	}




	public static void writefile() throws IOException
	{

		File file =  new File("D:\\Test.xlsx");


		FileInputStream inputStream = new FileInputStream(file);

		Workbook guru99Workbook1  = new XSSFWorkbook(inputStream);

		Sheet guru99Sheet = guru99Workbook1.getSheet("Sheet1");

		Row row = guru99Sheet.getRow(0);

		Cell cell = row.createCell(2);

	//	cell.setCellValue(nav2);

		inputStream.close();


		FileOutputStream outputStream = new FileOutputStream(file);

		guru99Workbook1.write(outputStream);

		outputStream.close();
		guru99Workbook1.close();




	}



}

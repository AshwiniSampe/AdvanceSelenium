package vtiger_practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel {
	public static void main(String[] args) throws Exception {
		//step1: Load the file in java readable formate
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		//step 2:create the workbook for the file loader
		Workbook wb=WorkbookFactory.create(fis);
		//step 3: Navigate to the required sheet
		Sheet sh=wb.getSheet("Sheet1");
		//step 4: Navigate to the required row
		Row r=sh.getRow(1);
		//step 5: Navigate to the required cell
		Cell ce=r.getCell(1);
		//step 6: capture the value inside the cell
		String value=ce.getStringCellValue();
		System.out.println(value);
		
	}

}

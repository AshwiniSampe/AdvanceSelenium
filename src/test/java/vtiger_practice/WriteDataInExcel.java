package vtiger_practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataInExcel {
	public static void main(String[] args) throws Exception, IOException {
		//step 1:Load the file in java readable formate
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		//step 2: create a workbook for the file loaded
		Workbook wb=WorkbookFactory.create(fis);
		//step 3: create sheet
		Sheet sh=wb.createSheet("Trial");
		//step 4: create row
		Row r=sh.createRow(2);
		//step 5:create cell
		Cell ce=r.createCell(2);
		//step 6: set the value in to cell
		ce.setCellValue("Spider man");
		//step 7:open the file in java write format
		FileOutputStream fio=new FileOutputStream(".\\\\src\\\\test\\\\resources\\\\TestData.xlsx");
		//step 8:call the write method
		wb.write(fio);
		//step 9:close the work book
		wb.close();
	}
	

}

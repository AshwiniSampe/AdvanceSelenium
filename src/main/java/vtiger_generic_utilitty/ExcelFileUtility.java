package vtiger_generic_utilitty;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class consists of generic related to excel file
 * 
 * @author Ashwini sampe
 *
 */
public class ExcelFileUtility {
	/**
	 * This method will used to get the data from the excel sheet 
	 * @param sheetName
	 * @param rowNo
	 * @param celNo
	 * @return
	 * @throws Exception
	 */
	public  String getDataFormExcel(String sheetName,int rowNo,int celNo) throws Exception
	{
		FileInputStream fis=new FileInputStream(IConstants.excelfilePath);
		Workbook wb=WorkbookFactory.create(fis);
		String value=wb.getSheet(sheetName).getRow(rowNo).getCell(celNo).getStringCellValue();
		return value;
		
	}
	/**
	 * This method will write data in excel
	 * @param sheetName
	 * @param rowNo
	 * @param celNo
	 * @throws Exception
	 */
	public void writeDataInExcel(String sheetName,int rowNo,int celNo,String data) throws Exception
	{
		FileInputStream fis=new FileInputStream(IConstants.excelfilePath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.createSheet(sheetName);
		Row r=sh.createRow(rowNo);
		Cell ce=r.createCell(celNo);
		ce.setCellValue(data);
		
		FileOutputStream fio=new FileOutputStream(IConstants.excelfilePath);
		wb.write(fio);//action
		wb.close();
		
	}
	

}

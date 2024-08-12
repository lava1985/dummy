package dataDriventesting;

import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadFromXlUsingDataFormatter {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./test/resources/testdata1.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
 DataFormatter df=new DataFormatter();
      String data=df.formatCellValue(wb.getSheet("Sheet1").getRow(1).getCell(1));;
	
	//System.out.println(wb.getSheet("Sheet1").getRow(1).getCell(1).getNumericCellValue());

}}

package mmp.pages;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class LoginExcelXlsxDataProvider {



	@DataProvider(name="excelxlsxRead")
	public String[][] readFromExcel() throws Exception{
		String[][] twodimArray;
		FileInputStream fis = new FileInputStream(new File("C:\\Users\\singh\\git\\Squardronmmp\\mmpproject\\test-data\\MMPLoginData.xlsx"));
		XSSFWorkbook myWorkbook= new XSSFWorkbook(fis);	
		XSSFSheet mySpreadsheet= myWorkbook.getSheetAt(0);	
		XSSFRow row;	

		int rowCount= mySpreadsheet.getPhysicalNumberOfRows();
		row= mySpreadsheet.getRow(0);
		System.out.println(row);	
		int columnCount= row.getPhysicalNumberOfCells();
		twodimArray= new String[rowCount][columnCount];
		System.out.println("rowCount:"+ rowCount);
		System.out.println("ColumnCount:"+ columnCount);

		//Read using For loop

		for(int i=0; i<rowCount; i++) {
			row= mySpreadsheet.getRow(i);	

			for(int j=0; j<columnCount;j++) {	
				String cellText=row.getCell(j).toString();
				System.out.println(cellText +"\t");
				twodimArray[i][j]= cellText;
			}
			System.out.println();
		}
		myWorkbook.close();
		return twodimArray;

	}
}

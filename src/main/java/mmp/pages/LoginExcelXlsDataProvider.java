package mmp.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.testng.annotations.DataProvider;

public class LoginExcelXlsDataProvider {


	@DataProvider(name="excelxlsRead")
	public String[][] readFromExcel() throws Exception{
		String[][] twodimArray;
		FileInputStream fis = new FileInputStream(new File("C:\\Users\\singh\\git\\Squardronmmp\\mmpproject\\test-data\\MMPLoginData.xls"));
		HSSFWorkbook myWorkbook= new HSSFWorkbook(fis);	
		HSSFSheet mySpreadsheet= myWorkbook.getSheetAt(0);	
		HSSFRow row;	

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

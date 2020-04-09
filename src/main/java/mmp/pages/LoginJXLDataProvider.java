package mmp.pages;

import java.io.File;
import org.testng.annotations.DataProvider;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class LoginJXLDataProvider {

	@DataProvider(name="jxlRead")
	public String[][] readFromJexcel() throws Exception{
		String[][] twodimArray;
		File f= new File("C:\\Users\\singh\\git\\Squardronmmp\\mmpproject\\test-data\\MMPLoginData.xls");
		Workbook wb= Workbook.getWorkbook(f);
		Sheet sheet=  wb.getSheet(0);    
		int rowCount = sheet.getRows();
		int colCount = sheet.getColumns();
		twodimArray= new String[rowCount][colCount];

		System.out.println("rowCount:"+ rowCount);
		System.out.println("ColumnCount:"+ colCount);

		//Read using For loop
		for(int i=0; i<rowCount; i++) {
			for(int j=0; j<colCount;j++) {	
				Cell cell = sheet.getCell(j, i);
				twodimArray[i][j]= cell.getContents();
				System.out.println(twodimArray[i][j]);
			}
			System.out.println();
		}
		wb.close();
		return twodimArray;

	}	

}


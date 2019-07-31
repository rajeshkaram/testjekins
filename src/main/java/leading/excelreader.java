package leading;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class excelreader {
	public static String testpath="C:\\Users\\rajesh.k\\Desktop\\login.xlsx";
	static Workbook book;
	static Sheet sheet;
	public static Object[][] gettestldata(String sheetname) throws IOException {
		
		FileInputStream file=null;
		
		try {
			file=new FileInputStream(testpath);
			
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		try {
			book=WorkbookFactory.create(file);
			
		} catch (InvalidFormatException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		sheet=book.getSheet(sheetname);
	
		 Object[][] data =new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		 System.out.println(sheet.getLastRowNum());
		 for(int i=0;i<sheet.getLastRowNum();i++) {
			 for(int j=0;j<sheet.getRow(0).getLastCellNum();j++) {
				 data[i][j]=sheet.getRow(i+1).getCell(j).toString();
			 }
		 }
		return data;
		
	
		
		}
	
	
	}


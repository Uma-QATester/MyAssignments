package week6.day1;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadXLData {
	
	public static String[][] readData() throws IOException {
		
		// XSSFWorkbook- Open the CreateLead Workbook
		//XSSFWorkbook wb=new XSSFWorkbook("./Data/CreateLead.xlsx");
	
		// XSSFWorkbook- Open the EditLead Workbook
		XSSFWorkbook wb=new XSSFWorkbook("./Data/EditLead.xlsx");
				
		//Open the worksheet
		//wb.getSheet("Sheet1");
		XSSFSheet ws = wb.getSheetAt(0);
		
		//To count the number of rows - excluding the header
		int rowCount = ws.getLastRowNum();
		System.out.println("The row count is: "+rowCount);
		
		//To count the number of rows - including the header
		int physicalNumberOfRows = ws.getPhysicalNumberOfRows();
		System.out.println("The row "+physicalNumberOfRows);
		
		//To count the number of columns
		int columnCount = ws.getRow(0).getLastCellNum();
		System.out.println("The column count is: "+columnCount);
		
		//To retrieve the data - Bhuvanesh
		
		String row1Cell1Data = ws.getRow(1).getCell(1).getStringCellValue();
		System.out.println("The data is: "+row1Cell1Data);
		
		String[][] data=new String[rowCount][columnCount];
		
		
		//To retrieve the entire data
		//        1     2   
		for(int i=1;i<=rowCount;i++) {
			
			XSSFRow row = ws.getRow(i);
			//XSSFRow row1 = ws.getRow(1);
			//XSSFRow row2 = ws.getRow(1);
			
			
			//        0   1   2   3
			for(int j=0;j<columnCount;j++) {
				String allData = row.getCell(j).getStringCellValue();
				
				data[i-1][j]=allData;     
				//data[0][0]=allData;     TestLeaf                  
				//data[0][1]=allData;     Bhuvanesh
				//data[0][2]=allData;     Moorthy 
				//data[0][3]=allData;     999
				//data[1][0]=allData;     Qeagle
				//data[1][1]=allData;     Vineeth
				//data[1][2]=allData;   Rajendran
				//data[1][3]=allData;     777
				
				//String allData = row1.getCell(0).getStringCellValue();//TestLeaf   0,0 
				//String allData = row1.getCell(1).getStringCellValue();//Bhuvanesh  0,1
				//String allData = row1.getCell(2).getStringCellValue();//Moorthy
				//String allData = row1.getCell(0).getStringCellValue();//999
				//String allData = row2.getCell(0).getStringCellValue();//Qeagle
				//String allData = row2.getCell(1).getStringCellValue();//Vineeth
				//String allData = row2.getCell(2).getStringCellValue();  //Rajendran
				//String allData = row2.getCell(3).getStringCellValue();  //777
				
				System.out.print(allData+" ");
			}
			
		}
		wb.close();
		return data;
	}

}



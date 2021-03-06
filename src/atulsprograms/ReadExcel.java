package atulsprograms;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel 
{
	public void readExcel(String filePath, String fileName, String sheetName) throws IOException
	{
		
		//Create an object of File class to open xlsx file
		File file = new File(filePath+"\\"+fileName);
		
		//create an object FileInputStream to read excel file.
		FileInputStream inputStream = new FileInputStream(file);
		Workbook demoWorkbook = null;
		//find the file extension by splitting file name in substring and getting only extension name
		String fileExtensionName = fileName.substring(fileName.indexOf("."));
	
		//check condition if the file is xlsx file
		if(fileExtensionName.equals(".xlsx"))
		{
			
			//if it is xlsx file then create object of XSSFWorkbook class
			demoWorkbook = new XSSFWorkbook(inputStream);
		
		}
		else if(fileExtensionName.equals(".xls"))
		{
			//if it is xls file then create object of HSSFWorkbook class
			demoWorkbook = new HSSFWorkbook(inputStream);
		}
		
		//read sheet inside the workbook by its name
		Sheet demoSheet = demoWorkbook.getSheet(sheetName);
		//find number of rows in excel file
		int rowCount = demoSheet.getLastRowNum()-demoSheet.getFirstRowNum();
	
		//create a loop over all the rows of excel file to read it
		for(int i=0; i<rowCount+1;i++)
		{
			Row row = demoSheet.getRow(i);
		
			//create a loop to print cell values in a row
			for(int j = 0; j<row.getLastCellNum();j++)
			{
				//print excel data in console
				System.out.print(row.getCell(j).getStringCellValue()+"|| ");
			}
			System.out.println();
		}
		
	}
	public static void main(String args[]) throws IOException
	{
		//create object of ReadExcel class
		
		ReadExcel objExcelFile = new ReadExcel();
				
				String filePath = System.getProperty("user.dir")+"//src";
				System.out.println(filePath);
				objExcelFile.readExcel(filePath, "ExportExcel.xlsx", "ExcelSheet");
				
		}
	

}
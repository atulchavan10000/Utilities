package atulsprograms;

import java.io.File;

import java.io.FileInputStream;

import java.io.FileOutputStream;

import java.io.IOException;

import java.io.OutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class WriteExcel

{

    public void writeExcel(String filePath, String fileName, String sheetName,    String[] dataToWrite) throws IOException

   {

       //create an object of file class to open xlsx file

       File file = new File(filePath+ "\\"+ fileName);

  

       //create an object of fileInputStream class to read excel file

       FileInputStream inputStream = new FileInputStream(file);

       Workbook writeWorkbook = null;

 

       //find the file extension by splitting file name

       //in substring and getting only extension name

       String fileExtensionName = fileName.substring(fileName.indexOf("."));

 

       //check condition if the file is xlsx file

       if(fileExtensionName.equals(".xlsx"))

       {

            //if it is xlsx file then create object of XSSFWorkbook class

            writeWorkbook = new XSSFWorkbook(inputStream);

       }

       else if(fileExtensionName.equals(".xls"))

       {

            //if its xls file then create boject of HSSFWorkbook class

            writeWorkbook = new HSSFWorkbook(inputStream);

       }

 

       //Read excel sheet by sheet name

       Sheet sheet = writeWorkbook.getSheet(sheetName);

       //get the current count of rows in excel file

       int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();

       //get the first row from the sheet

       Row row = sheet.getRow(0);

     

       //create a new row and append it at last of sheet

       Row newRow = sheet.createRow(rowCount+1);

       //create a loop over the cell of newly created Row

       for(int j=0; j<row.getLastCellNum();j++)

      {

           //create cell and fill data

           Cell cell = newRow.createCell(j);

           cell.setCellValue(dataToWrite[j]);

      }

 

      //close input stream

      inputStream.close();

      //create an object of FileOutputStream class to create write data in excel file

      FileOutputStream outputStream = new FileOutputStream(file);

      //write data in the excel file

      writeWorkbook.write(outputStream);

      outputStream.close();

}

public static void main(String args[]) throws IOException

{

     //create an array with the data in the same order

     //in which you expect to be filled in the excel file

     String[] valueToWrite = {"Mr. Von Braun", "Berlin"};

     WriteExcel objExcelFile = new WriteExcel();

     objExcelFile.writeExcel(System.getProperty("user.dir")   +\\src,"ExportExcel.xlsx","ExcelSheet", valueToWrite);

}

}
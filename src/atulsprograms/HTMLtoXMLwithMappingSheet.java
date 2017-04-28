package atulsprograms;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

public class HTMLtoXMLwithMappingSheet {
	public static String expression;
	public static String key;
	public static String field;
	public static HashMap <String, String> hmap;

	public static void main(String args[]){
		hmap= new HashMap<String, String>();
		try{
			String content = HTMLtoXMLwithMappingSheet.readFile("D:\\Notes\\source.txt", StandardCharsets.UTF_8);
			InputSource source = new InputSource(new StringReader(content));
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document document = db.parse(source);

			XPathFactory xpathFactory = XPathFactory.newInstance();
			XPath xpath = xpathFactory.newXPath();

			String excelFilePath = "D:\\Notes\\CoreShipmentMap.xlsx";
			FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet firstSheet = workbook.getSheetAt(0);
			Iterator<Row> iterator = firstSheet.iterator();

			while (iterator.hasNext()) {
				Row nextRow = iterator.next();
				Iterator<Cell> cellIterator = nextRow.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					if (cell.getStringCellValue().contains("//")) {
						expression = cell.getStringCellValue().trim();
						System.out.println(expression);
					} else {
						key = cell.getStringCellValue().trim();
						System.out.println(key);
					}
					if (expression != null && key != null) {
						field = xpath.evaluate(expression, document);
						hmap.put(key, field);
						expression = null;
						key = null;
					}
				}
			}
			inputStream.close();

			System.out.println(hmap.get("pieceIdNbr"));
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	static String readFile(String path, Charset encoding) throws IOException
	{
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded, encoding);
	}
}



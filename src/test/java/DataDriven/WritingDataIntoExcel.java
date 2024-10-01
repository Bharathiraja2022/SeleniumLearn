package DataDriven;


import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDataIntoExcel {
	public static void main(String[] args) throws IOException 
	{
		
		/*
		 * WebDriver driver=new ChromeDriver();
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 * driver.get("https://text-compare.com"); driver.manage().window().maximize();
		 */
		//Excel - > XSSfworkbook - > XSSFsheet - > XSSFrow - > XSSFCell
		FileOutputStream file=new FileOutputStream("D:\\NewData.xlsx");
XSSFWorkbook workbook=new XSSFWorkbook();
XSSFSheet sheet=workbook.createSheet("Data");
XSSFRow row1=sheet.createRow(0);
row1.createCell(0).setCellValue("java");
row1.createCell(1).setCellValue(1234);
row1.createCell(2).setCellValue("Automation");

XSSFRow row2=sheet.createRow(1);
row2.createCell(0).setCellValue("python");
row2.createCell(1).setCellValue(1234);
row2.createCell(2).setCellValue("language");

workbook.write(file);
workbook.close();
	}
}
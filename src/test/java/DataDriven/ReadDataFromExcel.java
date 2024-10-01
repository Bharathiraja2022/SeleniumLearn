package DataDriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ReadDataFromExcel {
	public static void main(String[] args) throws InterruptedException, IOException
	{
		
		/*
		 * WebDriver driver=new ChromeDriver();
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 * driver.get("https://text-compare.com"); driver.manage().window().maximize();
		 */
		//Excel - > XSSfworkbook - > XSSFsheet - > XSSFrow - > XSSFCell
FileInputStream file=new FileInputStream("D:\\data.xlsx");
XSSFWorkbook workbook=new XSSFWorkbook(file);
XSSFSheet sheet=workbook.getSheetAt(0);
int totalrows=sheet.getLastRowNum();
int totalcell=sheet.getRow(1).getLastCellNum();
System.out.println("number of rows" +totalrows);
System.out.println("number of colums" +totalcell);

for(int r=0;r<=totalrows;r++)
{
	XSSFRow currentrow=sheet.getRow(r);
	for(int c=0;c<totalcell;c++)
	{
		XSSFCell currentcell=currentrow.getCell(c);
		System.out.println(currentcell.toString());
	}
}

workbook.close();
file.close();
	}
}
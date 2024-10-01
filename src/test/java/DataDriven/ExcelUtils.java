package DataDriven;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow r;
	public static XSSFCell cell;
	public static CellStyle style;
	
	public static int getRowCount(String xlFile,String xlsheet) throws IOException
	{
		fi=new FileInputStream(xlFile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		int rowcount=ws.getLastRowNum();
		wb.close();
		fi.close();
		return rowcount;
	}
	
	public static int getCellCount(String xlFile,String xlsheet,int rownum) throws IOException
	{
		fi=new FileInputStream(xlFile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		r=ws.getRow(rownum);
		int cellcount=r.getLastCellNum();
		wb.close();
		fi.close();
		return cellcount;
	}
	public static String getCelldata(String xlfile,String xlsheet,int rownum,int column)throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		r=ws.getRow(rownum);
		cell=r.getCell(column);
		String data;
		//data=cell.toString();
		try {
		DataFormatter formatter=new DataFormatter();
		data=formatter.formatCellValue(cell);//retirns the formatted value of a cell as a string regulator
	}
	catch(Exception e)
	{
		data="";
		
	}
		wb.close();
		fi.close();
		return data;
	}
	public static void setCelldata(String xlFile,String xlsheet,int rownum,int column,String data) throws IOException
	{
		fi=new FileInputStream(xlFile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		r=ws.getRow(rownum);
		cell=r.createCell(column);
		cell.setCellValue(data);
		fo=new FileOutputStream(xlFile);
		wb.close();
		fi.close();
	}
	public static void fillGreenColor(String xlFile,String xlsheet,int rownum,int column) throws IOException
		{

		fi=new FileInputStream(xlFile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		r=ws.getRow(rownum);
		cell=r.getCell(column);
		style=wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cell.setCellStyle(style);
		fo=new FileOutputStream(xlFile);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
	}
	public static void fillRedColor(String xlFile,String xlsheet,int rownum,int column) throws IOException
	{

	fi=new FileInputStream(xlFile);
	wb=new XSSFWorkbook(fi);
	ws=wb.getSheet(xlsheet);
	r=ws.getRow(rownum);
	cell=r.getCell(column);
	style=wb.createCellStyle();
	style.setFillForegroundColor(IndexedColors.RED.getIndex());
	style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	cell.setCellStyle(style);
	fo=new FileOutputStream(xlFile);
	wb.write(fo);
	wb.close();
	fi.close();
	fo.close();
}
	
	
}

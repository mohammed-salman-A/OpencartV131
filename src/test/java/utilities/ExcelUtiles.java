package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtiles {
	
	
	public static FileOutputStream fo;
	public static FileInputStream fi;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static String path;
	
	public ExcelUtiles(String path) {
		this.path=path;
	}
	
	public static int getRowCount(String sheetName) throws IOException {
		fi=new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		ws=wb.getSheet(sheetName);
		int rowcount = ws.getLastRowNum();
		wb.close();
		fi.close();
		return rowcount;
		
	}
	public static int getCellCount(String sheeName,int rowcount) throws IOException {
		fi=new FileInputStream(path);
		wb= new XSSFWorkbook(fi);
		ws=wb.getSheet(sheeName);
		row=ws.getRow(rowcount);
		int cellcount = row.getLastCellNum();
		wb.close();
		fi.close();
		return cellcount;
		
	}
	public static String getCellData(String sheeName,int rowcount,int cellcount) throws IOException {
		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(sheeName);
		row =ws.getRow(rowcount);
		cell=row.getCell(cellcount);
		String data;
		try {
			data=cell.toString();
		}
		catch(Exception e) {
			data="";
		}
		wb.close();
		fi.close();
		return data;
	}
	public static void setCellData(String sheetName,int rowNum,int colNum, String data) throws IOException {
	
		File xfile = new File(path);
		if(!xfile.exists()) {
			wb=new XSSFWorkbook();
			fo=new FileOutputStream(path);	
			wb.write(fo);
		}

		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		
		if(wb.getSheetIndex(sheetName)==-1) {
			wb.createSheet(sheetName);
			ws=wb.getSheet(sheetName);
		}
        
        if (ws.getRow(rowNum)==null) {
            ws.createRow(rowNum);
            row=ws.getRow(rowNum);
        }
        
        cell = row.getCell(colNum);
        if (cell == null) {
            cell = row.createCell(colNum);
        }
        
        cell.setCellValue(data);
        
        fi.close(); // Close the input stream

        // Write the changes back to the file
        fo = new FileOutputStream(path);
        wb.write(fo);
        fo.close(); // Close the output stream
        wb.close(); 
		
	}
	
	
	

}

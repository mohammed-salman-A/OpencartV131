package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="loginData")
	public String [][] getData() throws IOException{
		String path = ".\\testData\\loginData.xlsx";
		
		ExcelUtiles xlUtil = new ExcelUtiles(path);
		int row = xlUtil.getRowCount("Sheet1");
		int col = xlUtil.getCellCount("Sheet1", 1);
		
		String loginData[][]= new String[row][col];	
		for(int i=1;i<=row;i++) {
			for(int j=0;j<col;j++) {
				loginData[i-1][j]=xlUtil.getCellData("Sheet1", i, j);
			}
		}
		
		return loginData;
	}
}

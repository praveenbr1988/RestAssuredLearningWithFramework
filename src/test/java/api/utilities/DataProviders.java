package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	
	@DataProvider(name="AllData")
	public String [][] getAllData() throws IOException
	{

		String path= System.getProperty("user.dir")+"//testData//UserData.xlsx";
		XLUtility xlutil=new XLUtility(path);
		
		int totalrows=xlutil.getRowCount("Sheet1");
		int totalcols=xlutil.getCellCount("Sheet1",1);	
				
		String apiData[][]=new String[totalrows][totalcols];
			
		
		for(int i=1;i<=totalrows;i++) //1
		{
			for(int j=0;j<totalcols;j++) //0
			{
				apiData[i-1][j]=xlutil.getCellData("Sheet1", i, j);
			}
				
		}
		
		return apiData;
	}
	
	
	
	@DataProvider(name="UserNames")
	public String[] getUserNames() throws IOException
	{

		String path= System.getProperty("user.dir")+"//testData//UserData.xlsx";
		XLUtility xlutil=new XLUtility(path);
		
		int totalRows=xlutil.getRowCount("Sheet1");
						
		String apiData[]=new String[totalRows];
			
		
		for(int i=1;i<=totalRows;i++)
		{
			apiData[i-1]=xlutil.getCellData("Sheet1", i, 1);
							
		}
		
		return apiData;
	}

}

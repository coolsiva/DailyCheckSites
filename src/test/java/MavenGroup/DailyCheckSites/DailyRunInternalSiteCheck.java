package MavenGroup.DailyCheckSites;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Helper.BrowserSelecter;
import Helper.ExcelConfig;

public class DailyRunInternalSiteCheck {
		
		WebDriver driver;
		
		@Test (dataProvider="EnvTest")
		public void Sampletest(String baseUrl,String uname, String password)
		{
			driver = BrowserSelecter.selectBrowser("chrome", baseUrl);
			System.out.println(baseUrl +" " + uname + " " + password);
		}

	
		
		@DataProvider(name = "EnvTest")
		public Object[][] DataInternal()
		{
			ExcelConfig config = new ExcelConfig("C:/Users/sivap5/workspace/DailyCheckSites/TestData/Test.xlsx");
			int rows = config.getlastRow(0);
			int colnum = config.getlastCol(0);
			Object[][] data = new Object[rows][colnum];
			
			for (int i =0 ; i<rows ; i++)
				{
					for(int j = 0 ; j<colnum; j++)
						{
						data [i][j] = config.getExcelDate(0, i, j);
						}
				}
			return data;
		}
		
}

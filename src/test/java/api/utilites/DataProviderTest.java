package api.utilites;

import org.testng.annotations.DataProvider;
 

public class DataProviderTest {

	@DataProvider(name = "loginData")
	public String[][] getDataFromExcel() {

		ExcelUtils utils = new ExcelUtils(System.getProperty("user.dir") + "/src/test/resources/UserModule_DDT.xlsx",
				"Sheet1");

		int rowCount = utils.getRowCount();
		int colCount = utils.getColumnCount();

		// Fix: Array size should be (rowCount - 1) to exclude the header row
		String[][] data = new String[rowCount - 1][colCount];

		// Start from row 1 (row 0 is header) and read data rows
		for (int i = 1; i < rowCount; i++) {

			for (int j = 0; j < colCount; j++) {
				data[i-1][j] = utils.getCellData(i, j);
			}
		}
		return data;
	}
	
	@DataProvider(name = "userName")
	public String[] getUserNameData() {

		ExcelUtils utils = new ExcelUtils(System.getProperty("user.dir") + "/src/test/resources/UserModule_DDT.xlsx",
				"Sheet1");

		int rowCount = utils.getRowCount();

		// Fix: Array size should be (rowCount - 1) to exclude the header row
		String[] data = new String[rowCount - 1];
		
		for(int i=1; i<rowCount; i++) {
			
			data[i-1]=utils.getCellData(i, 1);
		}
		
		return data;
	}

}

package resources;

import java.io.File;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class ReadExcelFile {

	public String getDataFromCell(String xlFilePath, String sheetName, int row, int coloumn) {

		Cell tableStart = null;
		try {
			Workbook workbook = Workbook.getWorkbook(new File(xlFilePath));
			Sheet sheet = workbook.getSheet(sheetName);
			tableStart = sheet.getCell(coloumn, row);

		} catch (Exception e) {
		}
		return tableStart.getContents();
	}

}
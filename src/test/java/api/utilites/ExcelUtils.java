package api.utilites;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelUtils {

    private Workbook workbook;
    private Sheet sheet;
    private String filePath;

    // Constructor
    public ExcelUtils(String filePath, String sheetName) {
        this.filePath = filePath;
        try {
            FileInputStream fis = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheet(sheetName);
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Get Row Count
    public int getRowCount() {
        return sheet.getPhysicalNumberOfRows();
    }

    // Get Cell Data
    public String getCellData(int rowNum, int colNum) {
        try {
            Row row = sheet.getRow(rowNum);
            if (row == null) {
                return "";
            }
            Cell cell = row.getCell(colNum);
            if (cell == null) {
                return "";
            }

            DataFormatter formatter = new DataFormatter();
            return formatter.formatCellValue(cell);

        } catch (Exception e) {
            return "";
        }
    }

    // Write Data to Cell
    public void setCellData(int rowNum, int colNum, String value) {
        try {
            Row row = sheet.getRow(rowNum);
            if (row == null) {
                row = sheet.createRow(rowNum);
            }

            Cell cell = row.getCell(colNum);
            if (cell == null) {
                cell = row.createCell(colNum);
            }

            cell.setCellValue(value);

            FileOutputStream fos = new FileOutputStream(filePath);
            workbook.write(fos);
            fos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Get Column Count
    public int getColumnCount() {
        return sheet.getRow(0).getPhysicalNumberOfCells();
    }
}

//package utility;
//
//import java.io.FileInputStream;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.apache.poi.sl.usermodel.Shape;
//import org.apache.poi.sl.usermodel.Sheet;
//import org.apache.poi.sl.usermodel.TextParagraph;
//import org.apache.poi.sl.usermodel.TextRun;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//public class ExcelUtils {
//	
//	private Workbook workbook;
//    private Sheet<Shape<S,P>, TextParagraph<S,P,? extends TextRun>> sheet;
//
//    // Constructor to initialize the Excel file
//    public ExcelUtils(String excelFilePath) {
//        try (FileInputStream fis = new FileInputStream(new File(excelFilePath))) {
//            workbook = new XSSFWorkbook(fis);
//        } catch (IOException e) {
//            e.printStackTrace();
//            throw new RuntimeException("Failed to open the Excel file: " + excelFilePath);
//        }
//    }
//
//    // Method to get the data from a specific sheet
//    public List<List<String>> getDataFromSheet(String sheetName) {
//        List <List<String>> data = new ArrayList<>();
//        sheet=workbook.getSheet(sheetName);
//        if (sheet == null) {
//            throw new RuntimeException("Sheet with name '" + sheetName + "' does not exist.");
//        }
//
//        for (Row row : sheet) {
//            List<String> rowData = new ArrayList();
//            for (Cell cell : row) {
//                rowData.add(getCellValue(cell));
//            }
//            data.add(rowData);
//        }
//        return data;
//    }
//
//    // Method to get the cell value as String
//    private String getCellValue(Cell cell) {
//        switch (cell.getCellType()) {
//            case STRING:
//                return cell.getStringCellValue();
//            case NUMERIC:
//                return String.valueOf(cell.getNumericCellValue());
//            case BOOLEAN:
//                return String.valueOf(cell.getBooleanCellValue());
//            case FORMULA:
//                return cell.getCellFormula();
//            default:
//                return "";
//        }
//    }
//
//    // Method to write data to a specific sheet
//    public void writeDataToSheet(String sheetName, int rowIndex, int columnIndex, String value) {
//        sheet = workbook.getSheet(sheetName);
//        if (sheet == null) {
//            sheet = workbook.createSheet(sheetName);
//        }
//
//        Row row = sheet.getRow(rowIndex);
//        if (row == null) {
//            row = sheet.createRow(rowIndex);
//        }
//
//        Cell cell = row.createCell(columnIndex);
//        cell.setCellValue(value);
//    }
//
//    // Method to save the workbook to a file
//    public void save(String outputFilePath) {
//        try (FileOutputStream fos = new FileOutputStream(new File(outputFilePath))) {
//            workbook.write(fos);
//        } catch (IOException e) {
//            e.printStackTrace();
//            throw new RuntimeException("Failed to save the Excel file: " + outputFilePath);
//        }
//    }
//
//    // Method to close the workbook
//    public void close() {
//        try {
//            if (workbook != null) {
//                workbook.close();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//}

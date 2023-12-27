
package compararexcel;

import java.io.*;
import java.util.ArrayList;
import org.apache.poi.ss.usermodel.*;


public class ArchivoExcel {
    
    public ArchivoExcel(String path, int sh) throws Exception {
        
        Workbook book = WorkbookFactory.create(new FileInputStream(new File(path)));
        sheet = book.getSheetAt(sh);
    }
    
    public String getText(int r, int c) {
        
        Row row = sheet.getRow(r-1);
        Cell cell = row.getCell(c-1);
        int code = cell.getCellType().getCode();
        
        if(code == 0) {
            
            return "" + cell.getNumericCellValue();
        }
        
        return cell.getStringCellValue();
    }
   
    public double getDouble(int r, int c) {
        
        Row row = sheet.getRow(r);
        Cell cell = row.getCell(c);
        int code = cell.getCellType().getCode();
        
        if(code == 0) {
            
            return cell.getNumericCellValue();
        }
        
        return 0;
    }
    
    public void printSentences(int a, int b, ArrayList<Integer> columns) {
        
        for(int i=a; i<=b; i++) {
            
            String e = "";
            
            for(Integer c: columns) {
                
                e += getText(i, c) + " ";
            }
            
            System.out.println(i + ". " + e);
        }
    }
    
    private Sheet sheet;
}

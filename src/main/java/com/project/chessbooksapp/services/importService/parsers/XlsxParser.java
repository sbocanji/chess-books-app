package com.project.chessbooksapp.services.importService.parsers;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XlsxParser<T> implements Parser<T>{
    @Override
    public List<T> readEntities(InputStream inputStream) {
        try {
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet sheet = workbook.getSheetAt(0);

            Map<Integer, List<String>> data = new HashMap<>();
            int i = 0;
            for (Row row : sheet) {
                data.put(i, new ArrayList<String>());
                for (Cell cell : row) {
                    switch (cell.getCellType()) {
                        case STRING:
                            System.out.println(cell.getStringCellValue()); break;
                        case NUMERIC:
                            System.out.println(cell.getNumericCellValue()); break;
                        case BOOLEAN:
                            System.out.println(cell.getBooleanCellValue()); break;
                        default: data.get(i).add(" ");
                    }
                }
                i++;
            }
            System.out.println(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

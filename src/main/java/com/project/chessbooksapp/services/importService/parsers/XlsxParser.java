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

public abstract class XlsxParser<T, C extends Column> implements Parser<T> {
    @Override
    public List<T> readEntities(InputStream inputStream) {
        List<T> entityList = new ArrayList<>();
        try {
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet sheet = workbook.getSheetAt(0);
            List<String> headers = new ArrayList<>();
            Map<C, Integer> headerMap = new HashMap<>();
            for (Row row : sheet) {
                if (row.getRowNum() == 0) {
                    for (Cell cell : row) headers.add(cell.getStringCellValue());
                    headerMap = getHeaderColumns(headers);
                } else {
                    entityList.add(readEntity(headerMap, row));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return entityList;
    }

    public abstract T readEntity(Map<C, Integer> headers, Row row);

    public abstract Map<C, Integer> getHeaderColumns(List<String> headers);
}

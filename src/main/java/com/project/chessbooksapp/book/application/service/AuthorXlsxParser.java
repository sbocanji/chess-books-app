package com.project.chessbooksapp.book.application.service;

import com.project.chessbooksapp.book.domain.AuthorColumns;
import com.project.chessbooksapp.book.application.port.in.AuthorDto;
import com.project.chessbooksapp.commons.XlsxParser;
import org.apache.poi.ss.usermodel.Row;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AuthorXlsxParser extends XlsxParser<AuthorDto, AuthorColumns> {
    @Override
    public AuthorDto readEntity(Map<AuthorColumns, Integer> headers, Row row) {
        AuthorDto author = new AuthorDto();
        author.setPlayerName(row.getCell(headers.get(AuthorColumns.PLAYER_NAME)).getStringCellValue());
        author.setNationality(row.getCell(headers.get(AuthorColumns.NATIONALITY)).getStringCellValue());
        author.setActive(row.getCell(headers.get(AuthorColumns.ACTIVE)).getStringCellValue().equals("y"));
        author.setWorldChampion(row.getCell(headers.get(AuthorColumns.WORLD_CHAMPION)).getStringCellValue().equals("y"));
        return author;
    }

    @Override
    public Map<AuthorColumns, Integer> getHeaderColumns(List<String> headers) {
        Map<AuthorColumns, Integer> map = new HashMap<>();
        for (int i = 0; i < headers.size(); i++) map.put(AuthorColumns.getByName(headers.get(i)), i);
        return map;
    }
}

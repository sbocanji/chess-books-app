package com.project.chessbooksapp.services.readers.authors;

import com.project.chessbooksapp.dto.AuthorEntityDto;
import com.project.chessbooksapp.dto.BookEntityDto;
import com.project.chessbooksapp.services.readers.CSVReader;
import com.project.chessbooksapp.services.readers.books.BookCSVColumns;

import java.util.HashMap;
import java.util.Map;

public class AuthorCSVReader extends CSVReader<AuthorEntityDto, AuthorCSVColumns> {
    @Override
    public AuthorEntityDto readEntity(Map<AuthorCSVColumns, Integer> headers, String[] values) {
        AuthorEntityDto author = new AuthorEntityDto();
        author.setPlayerName(values[headers.get(AuthorCSVColumns.PLAYER_NAME)]);
        author.setWorldChampion(values[headers.get(AuthorCSVColumns.WORLD_CHAMPION)].equals("y"));
        author.setActive(values[headers.get(AuthorCSVColumns.ACTIVE)].equals("y"));
        author.setNationality(values[headers.get(AuthorCSVColumns.NATIONALITY)]);
        return author;
    }

    @Override
    public Map<AuthorCSVColumns, Integer> getHeaderColumns(String[] headers) {
        Map<AuthorCSVColumns, Integer> map = new HashMap<>();
        for (int i = 0; i < headers.length; i++) map.put(AuthorCSVColumns.getByName(headers[i]), i);
        return map;
    }
}

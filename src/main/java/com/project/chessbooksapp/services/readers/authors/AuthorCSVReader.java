package com.project.chessbooksapp.services.readers.authors;

import com.project.chessbooksapp.dto.AuthorDto;
import com.project.chessbooksapp.services.readers.CSVReader;

import java.util.HashMap;
import java.util.Map;

public class AuthorCSVReader extends CSVReader<AuthorDto, AuthorColumns> {
    @Override
    public AuthorDto readEntity(Map<AuthorColumns, Integer> headers, String[] values) {
        AuthorDto author = new AuthorDto();
        author.setPlayerName(values[headers.get(AuthorColumns.PLAYER_NAME)]);
        author.setWorldChampion(values[headers.get(AuthorColumns.WORLD_CHAMPION)].equals("y"));
        author.setActive(values[headers.get(AuthorColumns.ACTIVE)].equals("y"));
        author.setNationality(values[headers.get(AuthorColumns.NATIONALITY)]);
        return author;
    }

    @Override
    public Map<AuthorColumns, Integer> getHeaderColumns(String[] headers) {
        Map<AuthorColumns, Integer> map = new HashMap<>();
        for (int i = 0; i < headers.length; i++) map.put(AuthorColumns.getByName(headers[i]), i);
        return map;
    }
}

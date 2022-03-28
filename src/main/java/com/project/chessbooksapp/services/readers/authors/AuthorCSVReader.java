package com.project.chessbooksapp.services.readers.authors;

import com.project.chessbooksapp.dto.AuthorEntityDto;
import com.project.chessbooksapp.services.readers.CSVReader;

import java.util.Map;

public class AuthorCSVReader extends CSVReader<AuthorEntityDto, AuthorCSVColumns> {
    @Override
    public AuthorEntityDto readEntity(Map<AuthorCSVColumns, Integer> headers, String[] values) {
        return null;
    }

//    @Override
//    public AuthorEntityDto readEntity(String[] headers, String[] values) {
//        AuthorEntityDto authorEntityDto = new AuthorEntityDto();
//        for (int i = 0; i < headers.length; i++) {
//            if (headers[i].equals("playerName")) authorEntityDto.setPlayerName(values[i]);
//            if (headers[i].equals("nationality")) authorEntityDto.setNationality(values[i]);
//            if (headers[i].equals("active")) authorEntityDto.setActive(values[i].equals("y"));
//            if (headers[i].equals("worldChampion")) authorEntityDto.setWorldChampionship(values[i].equals("y"));
//        }
//        return authorEntityDto;
//    }

    @Override
    public Map<AuthorCSVColumns, Integer> getHeaderColumns(String[] headers) {
        return null;
    }
}

package com.project.chessbooksapp.services.importService.parsers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class CSVParser<T, C extends Column> implements Parser<T> {

    @Override
    public List<T> readEntities(InputStream inputStream) {
        InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(streamReader);
        List<T> entityList = new ArrayList<>();
        try {
            String line;
            String headerLine = bufferedReader.readLine();
            String[] headers = headerLine.split(",");
            Map<C, Integer> headerMap = getHeaderColumns(headers);
            while ((line = bufferedReader.readLine()) != null) {
                if(line.equals("")) continue;
                String[] values = line.split(",");
                headerMap.forEach((key, value) -> {
                    if(key.isMandatory() && values[value].equals("")) throw new IllegalArgumentException("Invalid input.");
                });
                entityList.add(readEntity(headerMap, values));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return entityList;
    }

    public abstract T readEntity(Map<C, Integer> headers, String[] values);

    public abstract Map<C, Integer> getHeaderColumns(String[] headers);

}

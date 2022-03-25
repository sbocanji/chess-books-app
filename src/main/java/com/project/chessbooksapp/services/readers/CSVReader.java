package com.project.chessbooksapp.services.readers;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class CSVReader<T> extends Reader<T> {

    @Override
    List<T> readEntities(BufferedReader bufferedReader) {
        List<T> entityList = new ArrayList<>();
        try {
            String line;
            String headerLine = bufferedReader.readLine();
            String[] headers = headerLine.split(",");
            while ((line = bufferedReader.readLine()) != null) {
                if(line.equals("")) continue;;
                String[] values = line.split(",");
                entityList.add(readEntity(headers, values));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return entityList;
    }

    public abstract T readEntity(String[] headers, String[] values);
}

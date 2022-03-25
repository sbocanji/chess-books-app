package com.project.chessbooksapp.services.readers;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

public abstract class Reader<T> {

    public List<?> readFile(String filePath) {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream(filePath);
        InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(streamReader);
        return readEntities(bufferedReader);
    }

    abstract List<T> readEntities(BufferedReader bufferedReader);

}


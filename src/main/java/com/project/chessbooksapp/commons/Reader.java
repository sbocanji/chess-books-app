package com.project.chessbooksapp.commons;

import java.io.*;

public interface Reader {

    public InputStream readFile(String filePath);

//    public List<T> readFile(String filePath) {
//        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
//        InputStream is = classloader.getResourceAsStream(filePath);
//        InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
//        BufferedReader bufferedReader = new BufferedReader(streamReader);
//        return readEntities(bufferedReader);
//    }

//    abstract List<T> readEntities(BufferedReader bufferedReader);

}


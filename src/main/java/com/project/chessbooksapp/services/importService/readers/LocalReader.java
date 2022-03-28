package com.project.chessbooksapp.services.importService.readers;

import java.io.InputStream;

public class LocalReader implements Reader {
    @Override
    public InputStream readFile(String filePath) {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        return classloader.getResourceAsStream(filePath);
    }
}

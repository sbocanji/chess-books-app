package com.project.chessbooksapp.commons;

import java.io.InputStream;
import java.util.List;

public interface Parser<T> {
    List<T> readEntities(InputStream inputStream);
}

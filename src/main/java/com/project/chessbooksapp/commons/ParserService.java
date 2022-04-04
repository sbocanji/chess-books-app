package com.project.chessbooksapp.commons;

import java.io.InputStream;
import java.util.List;

public interface ParserService<T> {

    List<T> parse(InputStream inputStream);

}

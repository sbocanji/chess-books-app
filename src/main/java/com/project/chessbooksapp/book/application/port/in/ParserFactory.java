package com.project.chessbooksapp.book.application.port.in;

import com.project.chessbooksapp.commons.Parser;

public interface ParserFactory<T> {

    public Parser<T> getParser(String extension);

}

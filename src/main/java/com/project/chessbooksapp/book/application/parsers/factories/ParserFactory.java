package com.project.chessbooksapp.book.application.parsers.factories;

import com.project.chessbooksapp.commons.Parser;

public interface ParserFactory<T> {

    public Parser<T> getParser(FileType fileType);

}

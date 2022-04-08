package com.project.chessbooksapp.book.application.parsers.factories;

import com.project.chessbooksapp.commons.Parser;

public interface ParserFactory<T> {

    Parser<T> getParser(FileType fileType);

}

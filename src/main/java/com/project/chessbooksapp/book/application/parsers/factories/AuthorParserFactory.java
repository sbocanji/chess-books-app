package com.project.chessbooksapp.book.application.parsers.factories;

import com.project.chessbooksapp.book.application.parsers.AuthorCSVParser;
import com.project.chessbooksapp.book.application.parsers.AuthorJsonParser;
import com.project.chessbooksapp.book.application.parsers.AuthorXlsxParser;
import com.project.chessbooksapp.book.application.port.in.AuthorDto;
import com.project.chessbooksapp.commons.Parser;

public class AuthorParserFactory implements ParserFactory<AuthorDto>{
    @Override
    public Parser<AuthorDto> getParser(FileType fileType) {
        switch (fileType) {
            case JSON: return new AuthorJsonParser(AuthorDto.class);
            case XLSX: return new AuthorXlsxParser();
            case CSV: return new AuthorCSVParser();
            default: throw new IllegalArgumentException("Invalid file type provided.");
        }
    }
}

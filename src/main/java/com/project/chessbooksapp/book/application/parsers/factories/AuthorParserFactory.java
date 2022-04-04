package com.project.chessbooksapp.book.application.parsers.factories;

import com.project.chessbooksapp.book.application.parsers.AuthorCSVParser;
import com.project.chessbooksapp.book.application.parsers.AuthorJsonParser;
import com.project.chessbooksapp.book.application.parsers.AuthorXlsxParser;
import com.project.chessbooksapp.book.application.port.in.AuthorDto;
import com.project.chessbooksapp.commons.Parser;

public class AuthorParserFactory implements ParserFactory<AuthorDto>{
    @Override
    public Parser<AuthorDto> getParser(FileType fileType) {
        if(fileType == FileType.JSON) return new AuthorJsonParser(AuthorDto.class);
        if(fileType == FileType.XLSX) return new AuthorXlsxParser();
        return new AuthorCSVParser();
    }
}

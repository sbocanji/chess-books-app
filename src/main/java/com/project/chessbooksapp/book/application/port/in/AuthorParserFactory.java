package com.project.chessbooksapp.book.application.port.in;

import com.project.chessbooksapp.book.application.service.AuthorCSVParser;
import com.project.chessbooksapp.book.application.service.AuthorJsonParser;
import com.project.chessbooksapp.book.application.service.AuthorXlsxParser;
import com.project.chessbooksapp.commons.Parser;

public class AuthorParserFactory implements ParserFactory<AuthorDto>{
    @Override
    public Parser<AuthorDto> getParser(String extension) {
        if(extension.equals("json")) return new AuthorJsonParser(AuthorDto.class);
        if(extension.equals("xlsx")) return new AuthorXlsxParser();
        return new AuthorCSVParser();
    }
}

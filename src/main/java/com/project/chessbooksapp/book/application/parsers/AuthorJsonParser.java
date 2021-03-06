package com.project.chessbooksapp.book.application.parsers;

import com.project.chessbooksapp.commons.JsonParser;
import com.project.chessbooksapp.book.application.port.in.AuthorDto;

public class AuthorJsonParser extends JsonParser<AuthorDto> {
    public AuthorJsonParser(Class<AuthorDto> entityClass) {
        super(entityClass);
    }

    @Override
    protected boolean validate(AuthorDto object) {
        return !object.getNationality().equals("") && !object.getPlayerName().equals("") && !(object.getWorldChampion() == null) && !(object.getActive() == null);
    }
}

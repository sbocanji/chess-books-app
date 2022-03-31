package com.project.chessbooksapp.book.application.service;

import com.project.chessbooksapp.commons.JsonParser;
import com.project.chessbooksapp.dto.AuthorDto;

public class AuthorJsonParser extends JsonParser<AuthorDto> {
    public AuthorJsonParser(Class entityClass) {
        super(entityClass);
    }

    @Override
    protected boolean validate(AuthorDto object) {
        return !object.getNationality().equals("") && !object.getPlayerName().equals("") && !(object.getWorldChampion() == null) && !(object.getActive() == null);
    }
}
